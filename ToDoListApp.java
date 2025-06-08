import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoListApp extends JFrame implements ActionListener {
	private DefaultListModel<String> listModel;
	private JList<String> taskList;
	private JTextField taskInput;
	private JButton addButton, deleteButton, editButton, searchButton;

	public ToDoListApp() {
		// 设置窗口标题和关闭操作
		setTitle("To-Do List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 300);
		setLayout(new BorderLayout());

		// 顶部输入区域
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout());

		taskInput = new JTextField(20);
		addButton = new JButton("Add");
		addButton.addActionListener(this);
		editButton = new JButton("Edit");
		editButton.addActionListener(this);
		searchButton = new JButton("Search");
		searchButton.addActionListener(this);

		inputPanel.add(taskInput);
		inputPanel.add(addButton);
		inputPanel.add(editButton);
		inputPanel.add(searchButton);
		add(inputPanel, BorderLayout.NORTH);

		// 中部任务列表
		listModel = new DefaultListModel<>();
		taskList = new JList<>(listModel);
		add(new JScrollPane(taskList), BorderLayout.CENTER);

		// 底部删除按钮
		deleteButton = new JButton("I've done this work!");
		deleteButton.addActionListener(this);
		add(deleteButton, BorderLayout.SOUTH);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addButton) {		//增加数据
			String task = taskInput.getText().trim();
			if (!task.isEmpty()) {
				listModel.addElement(task);
				taskInput.setText(""); // 清空输入框
			}
		} else if (e.getSource() == deleteButton) {		//删除数据
			int selectedIndex = taskList.getSelectedIndex();
			if (selectedIndex != -1) {
				listModel.remove(selectedIndex);
			}
		} else if (e.getSource() == editButton){		//编辑数据
			// 切换编辑模式
			if (addButton.isEnabled() && deleteButton.isEnabled()) {
				addButton.setEnabled(false);
				deleteButton.setEnabled(false);
				int selectedIndex = taskList.getSelectedIndex();
				if (selectedIndex != -1) {
					taskInput.setText(listModel.getElementAt(selectedIndex));
				}
			// 如果当前是编辑模式，则保存编辑内容
			} else {
				addButton.setEnabled(true);
				deleteButton.setEnabled(true);
				String editedTask = taskInput.getText().trim();
				int selectedIndex = taskList.getSelectedIndex();
				if (selectedIndex != -1 && !editedTask.isEmpty()) {
					listModel.set(selectedIndex, editedTask);
					taskInput.setText(""); // 清空输入框
				}
			}
		} else if(e.getSource() == searchButton) {	//搜索数据
			String searchTerm = taskInput.getText().trim();
			if (!searchTerm.isEmpty()) {
				for (int i = 0; i < listModel.size(); i++) {
					if (listModel.getElementAt(i).contains(searchTerm)) {
						taskList.setSelectedIndex(i);
						taskList.ensureIndexIsVisible(i);
						return;
					}
				}
				JOptionPane.showMessageDialog(this, "Task not found!", "Search Result", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public static void main(String[] args) {
		new ToDoListApp();
	}
}