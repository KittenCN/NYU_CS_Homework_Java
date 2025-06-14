package com.example.studentgrades.ui;

import com.example.studentgrades.dao.StudentDAO;
import com.example.studentgrades.model.Student;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.List;

public class IOPanel extends JPanel {
    private StudentDAO dao = new StudentDAO();
    private JTextField tfPath;
    private JProgressBar progress;

    public IOPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("文件路径:"), gbc);

        tfPath = new JTextField(20);
        tfPath.setEditable(false);
        gbc.gridx = 1;
        add(tfPath, gbc);

        JButton bBrowse = new JButton("浏览");
        gbc.gridx = 2;
        add(bBrowse, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        JButton bImp = new JButton("导入");
        add(bImp, gbc);

        gbc.gridx = 1;
        JButton bExp = new JButton("导出");
        add(bExp, gbc);

        progress = new JProgressBar(0, 100);
        progress.setStringPainted(true);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 3;
        add(progress, gbc);

        bBrowse.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                tfPath.setText(fc.getSelectedFile().getAbsolutePath());
            }
        });

        bImp.addActionListener(e -> {
            String path = tfPath.getText();
            if (path.isEmpty()) {
                JOptionPane.showMessageDialog(this, "请先选择 CSV 文件。", "提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            new Thread(() -> importCSV(new File(path))).start();
        });

        bExp.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                new Thread(() -> exportCSV(fc.getSelectedFile())).start();
            }
        });
    }

    private void importCSV(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int total = 0, success = 0, fail = 0; 

            while (br.readLine() != null) total++;
            br.close();

            BufferedReader br2 = new BufferedReader(new FileReader(file));
            int count = 0;
            while ((line = br2.readLine()) != null) {
                count++;
                progress.setValue(count * 100 / total);
                try {
                    String[] parts = line.split(",");
                    if (parts.length < 8) { fail++; continue; }
                    double[] scores = new double[com.example.studentgrades.dao.Config.MAX_SUBJECT];
                    for (int i = 0; i < com.example.studentgrades.dao.Config.MAX_SUBJECT; i++) {
                        scores[i] = Double.parseDouble(parts[3 + i].trim());
                    }
                    Student s = new Student(
                            parts[0].trim(), parts[1].trim(), parts[2].trim(),
                            scores
                    );
                    dao.insert(s);
                    success++;
                } catch (Exception ex) {
                    fail++;
                }
            }
            br2.close();
            JOptionPane.showMessageDialog(this, "导入完成：成功 " + success + " 条，失败 " + fail + " 条", "结果", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "读取文件失败：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exportCSV(File file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            List<Student> list = dao.findAll();
            int total = list.size(), count = 0;
            for (Student s : list) {
                count++;
                progress.setValue(count * 100 / total);
                double[] scores = s.getScores();
                String strScore = "";
                for (double score : scores) {
                    strScore += score + ",";
                }
                String line = String.join(",", s.getId(), s.getName(), s.getClassName(), strScore.substring(0, strScore.length() - 1));
                bw.write(line);
                bw.newLine();
            }
            JOptionPane.showMessageDialog(this, "导出成功，共 " + total + " 条记录", "完成", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "导出失败：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
