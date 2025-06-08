package com.example.studentgrades.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {
    private JTextField tfUser;
    private JPasswordField pfPwd;
    public LoginFrame() {
        setTitle("登录"); setSize(400,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }
    private void initUI(){
        getContentPane().setBackground(Color.decode("#F0F0F0"));
        setLayout(new BorderLayout());

        JLabel lblTitle = new JLabel("学生成绩管理系统登录", SwingConstants.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(lblTitle, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets=new Insets(10,10,10,10);
        gbc.gridx=0; 
        gbc.gridy=0; 
        panel.add(new JLabel("用户名:"), gbc);

        tfUser=new JTextField(15);
        gbc.gridx=1; 
        panel.add(tfUser,gbc);
        gbc.gridx=0; 
        gbc.gridy=1; 
        panel.add(new JLabel("密码:"), gbc);

        pfPwd=new JPasswordField(15);
        gbc.gridx=1; 
        panel.add(pfPwd,gbc);
        add(panel, BorderLayout.CENTER);

        JPanel btnPanel=new JPanel(); 
        btnPanel.setOpaque(false);
        JButton btnLogin=new JButton("登录"); 
        JButton btnCancel=new JButton("取消");
        btnPanel.add(btnLogin); 
        btnPanel.add(btnCancel);
        add(btnPanel, BorderLayout.SOUTH);

        btnLogin.addActionListener(e->{
            String u=tfUser.getText().trim();
            String p=new String(pfPwd.getPassword()).trim();
            if("admin".equals(u)&&"123456".equals(p)){
                new MainFrame().setVisible(true);
                dispose();
            } else JOptionPane.showMessageDialog(this,"用户或密码错误","错误",JOptionPane.ERROR_MESSAGE);
        });
        btnCancel.addActionListener((ActionEvent e)->System.exit(0));
    }
    public static void main(String[] args){ 
        SwingUtilities.invokeLater(()->new LoginFrame().setVisible(true)); 
    }
}
