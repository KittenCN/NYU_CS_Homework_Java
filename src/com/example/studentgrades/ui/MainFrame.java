package com.example.studentgrades.ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel(cardLayout);
    public MainFrame(){
        setTitle("主界面"); setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initUI();
    }
    private void initUI(){
        JMenuBar mb=new JMenuBar();
        JMenu mFile=new JMenu("文件");
        JMenuItem miExit=new JMenuItem("退出");
        miExit.addActionListener(e->System.exit(0));
        mFile.add(miExit);
        JMenu mHelp=new JMenu("帮助");
        JMenuItem miAbout=new JMenuItem("关于");
        mHelp.add(miAbout);
        mb.add(mFile); mb.add(mHelp);
        setJMenuBar(mb);

        JPanel side=new JPanel();
        side.setLayout(new BoxLayout(side,BoxLayout.Y_AXIS));
        JButton bStu=new JButton("学生管理");
        JButton bIO=new JButton("CSV I/O");
        JButton bLog=new JButton("操作日志");
        side.add(bStu); side.add(bIO); side.add(bLog);
        add(side,BorderLayout.WEST);

        cardPanel.add(new StudentPanel(),"stu");
        cardPanel.add(new IOPanel(),"io");
        cardPanel.add(new LogPanel(),"log");
        add(cardPanel,BorderLayout.CENTER);

        bStu.addActionListener(e->cardLayout.show(cardPanel,"stu"));
        bIO.addActionListener(e->cardLayout.show(cardPanel,"io"));
        bLog.addActionListener(e->cardLayout.show(cardPanel,"log"));
    }
}
