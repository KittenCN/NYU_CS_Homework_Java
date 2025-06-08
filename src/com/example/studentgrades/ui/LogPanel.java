package com.example.studentgrades.ui;

import com.example.studentgrades.dao.LogDAO;
import com.example.studentgrades.model.LogEntry;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LogPanel extends JPanel {
    private LogDAO dao = new LogDAO();
    private JTable table;
    private DefaultTableModel model;
    private JSpinner spFrom, spTo;

    public LogPanel() {
        setLayout(new BorderLayout());

        JPanel filterPanel = new JPanel();
        filterPanel.add(new JLabel("从:"));
        spFrom = new JSpinner(new SpinnerDateModel());
        spFrom.setEditor(new JSpinner.DateEditor(spFrom, "yyyy-MM-dd HH:mm:ss"));
        filterPanel.add(spFrom);

        filterPanel.add(new JLabel("到:"));
        spTo = new JSpinner(new SpinnerDateModel());
        spTo.setEditor(new JSpinner.DateEditor(spTo, "yyyy-MM-dd HH:mm:ss"));
        filterPanel.add(spTo);

        JButton btnQuery = new JButton("查询");
        JButton btnExport = new JButton("导出");
        filterPanel.add(btnQuery);
        filterPanel.add(btnExport);

        add(filterPanel, BorderLayout.NORTH);

        model = new DefaultTableModel(new String[]{"时间", "用户", "操作", "详情"}, 0) {
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        btnQuery.addActionListener(e -> {
            try {
                Date from = (Date) spFrom.getValue();
                Date to = (Date) spTo.getValue();
                List<LogEntry> list = dao.findByPeriod(new Timestamp(from.getTime()), new Timestamp(to.getTime()));
                model.setRowCount(0);
                SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                for (LogEntry log : list) {
                    model.addRow(new Object[]{
                            fmt.format(log.getTimestamp()),
                            log.getUser(),
                            log.getAction(),
                            log.getDetail()
                    });
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "查询失败：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnExport.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                    for (int i = 0; i < model.getRowCount(); i++) {
                        StringBuilder sb = new StringBuilder();
                        for (int j = 0; j < model.getColumnCount(); j++) {
                            sb.append(model.getValueAt(i, j));
                            if (j < model.getColumnCount() - 1) sb.append(",");
                        }
                        bw.write(sb.toString());
                        bw.newLine();
                    }
                    JOptionPane.showMessageDialog(this, "导出成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "导出失败：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        Date now = new Date();
        spTo.setValue(now);
        spFrom.setValue(new Date(now.getTime() - 24 * 60 * 60 * 1000));
    }
}
