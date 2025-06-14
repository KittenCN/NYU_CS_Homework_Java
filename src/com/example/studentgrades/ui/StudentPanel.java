package com.example.studentgrades.ui;

import com.example.studentgrades.dao.StudentDAO;
import com.example.studentgrades.dao.LogDAO;
import com.example.studentgrades.model.Student;
import com.example.studentgrades.model.LogEntry;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Timestamp;
import java.util.List;

public class StudentPanel extends JPanel {
    private StudentDAO dao = new StudentDAO();
    private LogDAO logDAO = new LogDAO();
    private JTable table;
    private DefaultTableModel model;

    public StudentPanel(){
        setLayout(new BorderLayout());
        JPanel top=new JPanel();
        JButton bAdd=new JButton("新增"), bEdit=new JButton("编辑"), bDel=new JButton("删除"), bRefresh=new JButton("刷新"), bSearch=new JButton("搜索");
        JTextField tfSearch = new JTextField(10);
        top.add(bAdd); 
        top.add(bEdit); 
        top.add(bDel); 
        top.add(bRefresh);
        top.add(tfSearch); // 搜索框
        top.add(bSearch); // 搜索按钮
        add(top,BorderLayout.NORTH);
        String[] tmp = {"学号","姓名","班级"};
        for(int i=1; i<=com.example.studentgrades.dao.Config.MAX_SUBJECT; i++){
            tmp = java.util.Arrays.copyOf(tmp, tmp.length + 1);
            tmp[tmp.length - 1] = "分" + i;
        }
        model=new DefaultTableModel(tmp,0){
            public boolean isCellEditable(int r,int c){return false;}
        };
        table=new JTable(model);
        add(new JScrollPane(table),BorderLayout.CENTER);

        bRefresh.addActionListener(e->loadData());
        bAdd.addActionListener(e->edit(null));
        bEdit.addActionListener(e->{
            int r=table.getSelectedRow(); if(r<0) return;
            String id=(String)model.getValueAt(r,0);
            try{ edit(dao.findById(id)); } catch(Exception ex){ ex.printStackTrace(); }
        });
        bDel.addActionListener(e->{
            int r=table.getSelectedRow(); if(r<0) return;
            String id=(String)model.getValueAt(r,0);
            if(JOptionPane.showConfirmDialog(this,"删除?","确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                try{ dao.delete(id);
                    logDAO.insert(new LogEntry(new Timestamp(System.currentTimeMillis()),"admin","删除学生",id));
                    loadData();
                }catch(Exception ex){ex.printStackTrace();}
            }
        });
        bSearch.addActionListener(e->{
            String keyword = tfSearch.getText().trim(); // 直接使用搜索框引用
            if(keyword.isEmpty()) {
                loadData();
            } else {
                try {
                    List<Student> list = dao.searchByName(keyword);
                    model.setRowCount(0);
                    for (Student s : list) {
                        Object[] row = new Object[model.getColumnCount()];
                        row[0] = s.getId();
                        row[1] = s.getName();
                        row[2] = s.getClassName();
                        double[] scores = s.getScores();
                        for (int i = 0; i < com.example.studentgrades.dao.Config.MAX_SUBJECT; i++) {
                            row[3 + i] = scores[i];
                        }
                        model.addRow(row);
                    }
                } catch (Exception ex) { ex.printStackTrace(); }
            }
        });
        loadData();
    }

    private void loadData(){
        try{
            List<Student> list=dao.findAll();
            model.setRowCount(0);
            for(Student s:list){
                Object[] row=new Object[model.getColumnCount()];
                row[0]=s.getId();
                row[1]=s.getName();
                row[2]=s.getClassName();
                double[] scores=s.getScores();
                for(int i=0;i<com.example.studentgrades.dao.Config.MAX_SUBJECT;i++){
                    row[3+i]=scores[i];
                }
                model.addRow(row);
            }
        } catch(Exception ex){ex.printStackTrace();}
    }

    private void edit(Student s){
        AddEditDialog d=new AddEditDialog(SwingUtilities.getWindowAncestor(this),s);
        d.setVisible(true);
        if(d.saved){
            Student st=d.getStudent();
            try{
                if(s==null){
                    dao.insert(st);
                    logDAO.insert(new LogEntry(new Timestamp(System.currentTimeMillis()),"admin","新增学生",st.getId()));
                } else {
                    dao.update(st);
                    logDAO.insert(new LogEntry(new Timestamp(System.currentTimeMillis()),"admin","编辑学生",st.getId()));
                }
                loadData();
            }catch(Exception ex){ex.printStackTrace();}
        }
    }
}
