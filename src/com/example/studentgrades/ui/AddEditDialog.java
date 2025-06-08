package com.example.studentgrades.ui;

import com.example.studentgrades.model.Student;

import javax.swing.*;
import java.awt.*;

public class AddEditDialog extends JDialog {
    private JTextField tfId,tfName,tfClass,tf1,tf2,tf3,tf4,tf5;
    boolean saved=false;
    private Student student;

    public AddEditDialog(Window owner, Student s){
        super(owner, (s==null?"新增学生":"编辑学生"), ModalityType.APPLICATION_MODAL);
        setSize(400,400);
        setLocationRelativeTo(owner);
        initUI(s);
    }

    private void initUI(Student s){
        JPanel p=new JPanel(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(5,5,5,5);
        gbc.anchor=GridBagConstraints.WEST;

        gbc.gridx=0; 
        gbc.gridy=0; 
        p.add(new JLabel("学号:"),gbc);
        tfId=new JTextField(15); 
        gbc.gridx=1; 
        p.add(tfId,gbc);

        gbc.gridx=0; 
        gbc.gridy=1; 
        p.add(new JLabel("姓名:"),gbc);
        tfName=new JTextField(15); 
        gbc.gridx=1; 
        p.add(tfName,gbc);

        gbc.gridx=0; 
        gbc.gridy=2; 
        p.add(new JLabel("班级:"),gbc);
        tfClass=new JTextField(15); 
        gbc.gridx=1; 
        p.add(tfClass,gbc);

        gbc.gridx=0; 
        gbc.gridy=3; 
        p.add(new JLabel("分1:"),gbc);
        tf1=new JTextField(5); 
        gbc.gridx=1; 
        p.add(tf1,gbc);

        gbc.gridx=0; 
        gbc.gridy=4; 
        p.add(new JLabel("分2:"),gbc);
        tf2=new JTextField(5); 
        gbc.gridx=1; 
        p.add(tf2,gbc);

        gbc.gridx=0; 
        gbc.gridy=5; 
        p.add(new JLabel("分3:"),gbc);
        tf3=new JTextField(5); 
        gbc.gridx=1; 
        p.add(tf3,gbc);

        gbc.gridx=0; 
        gbc.gridy=6; 
        p.add(new JLabel("分4:"),gbc);
        tf4=new JTextField(5); 
        gbc.gridx=1; 
        p.add(tf4,gbc);

        gbc.gridx=0; 
        gbc.gridy=7; 
        p.add(new JLabel("分5:"),gbc);
        tf5=new JTextField(5); 
        gbc.gridx=1; 
        p.add(tf5,gbc);

        if(s!=null){
            tfId.setText(s.getId()); tfId.setEditable(false);
            tfName.setText(s.getName());
            tfClass.setText(s.getClassName());
            tf1.setText(String.valueOf(s.getScore1()));
            tf2.setText(String.valueOf(s.getScore2()));
            tf3.setText(String.valueOf(s.getScore3()));
            tf4.setText(String.valueOf(s.getScore4()));
            tf5.setText(String.valueOf(s.getScore5()));
            student=s;
        }

        JPanel btns=new JPanel();
        JButton bSave=new JButton("保存");
        JButton bCancel=new JButton("取消");
        btns.add(bSave); btns.add(bCancel);

        bSave.addActionListener(e->{
            try{
                String id=tfId.getText().trim();
                String name=tfName.getText().trim();
                String cls=tfClass.getText().trim();
                double sc1=Double.parseDouble(tf1.getText().trim());
                double sc2=Double.parseDouble(tf2.getText().trim());
                double sc3=Double.parseDouble(tf3.getText().trim());
                double sc4=Double.parseDouble(tf4.getText().trim());
                double sc5=Double.parseDouble(tf5.getText().trim());
                if(student==null){
                    student=new Student(id,name,cls,sc1,sc2,sc3,sc4,sc5);
                } else {
                    student.setName(name);
                    student.setClassName(cls);
                    student.setScore1(sc1);
                    student.setScore2(sc2);
                    student.setScore3(sc3);
                    student.setScore4(sc4);
                    student.setScore5(sc5);
                }
                saved=true;
                dispose();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"输入错误","错误",JOptionPane.ERROR_MESSAGE);
            }
        });

        bCancel.addActionListener(e->dispose());

        getContentPane().add(p,BorderLayout.CENTER);
        getContentPane().add(btns,BorderLayout.SOUTH);
    }

    public Student getStudent(){ return student; }
}
