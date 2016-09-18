package client;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import server.Database;

public class Deleteuser implements ActionListener {

	private JFrame jf1;
	private JTextField textField;
	private JButton button_delete;
	private JButton button_cancer;
	Database data_deleteuser;
	private String username;

	public Deleteuser() {
		data_deleteuser = new Database();
		int x = 100;

		// 登录界面
		jf1 = new JFrame();
		jf1.setTitle("删除员工！");
		jf1.getContentPane().setFont(new Font("SimSun", Font.PLAIN, 12));
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.getContentPane().setLayout(null);

		JLabel label_username = new JLabel("用户名:", new ImageIcon(
				Register.class.getResource("/pictures/yonghuming.jpg")),
				JLabel.LEFT);
		label_username.setBounds(x - 30, 214, 93, 31);
		jf1.getContentPane().add(label_username);

		// 文本框
		textField = new JTextField();
		textField.setFont(UIManager.getFont("TextField.font"));
		textField.setBounds(x + 73, 214, 146, 26);
		jf1.getContentPane().add(textField);
		textField.setColumns(10);
		// 删除按钮
		button_delete = new JButton("删除");
		button_delete.setBounds(x - 20, 270, 93, 23);
		button_delete.addActionListener(this);
		jf1.getContentPane().add(button_delete);
		// 取消按钮，点击退出程序
		button_cancer = new JButton("取消");
		button_cancer.setBounds(x + 90, 270, 93, 23);
		button_cancer.addActionListener(this);
		jf1.getContentPane().add(button_cancer);

		// 登入背景界面
		JLabel lblNewLabel = new JLabel(new ImageIcon(
				Register.class.getResource("/pictures/register.jpg")));
		lblNewLabel.setBounds(0, 0, 683, 443);
		jf1.getContentPane().add(lblNewLabel);

		jf1.setSize(new Dimension(500, 409));
		jf1.setResizable(true);
		jf1.setLocation(new Point(300, 150));
		jf1.setVisible(true);
	}

	public static void main(String[] args) {
		new Deleteuser();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		// 如果点击登录按钮
		if (obj == button_delete) {
			username = textField.getText();
			if (username.equals("")) {
				JOptionPane.showMessageDialog(null, "用户名不能为空。");
				return;
			}
			for (int i = 0; i < username.length(); i++) {
				char cha1 = username.charAt(i);
				if (cha1 == '*' || cha1 == '/' || cha1 == '\\') {
					JOptionPane.showMessageDialog(null,
							"用户名中不能含有“*”“/”“\\”等符号。");
					return;
				}
			}
			if (data_deleteuser.deleteUser(username)) {
				JOptionPane.showMessageDialog(null, "刪除成功！");
			} else {
				JOptionPane.showMessageDialog(null, "刪除失败！");
			}
		}
		// 取消
		if (obj == button_cancer) {
			int res = JOptionPane.showConfirmDialog(null, "确定取消添加？");
			if (res == JOptionPane.YES_OPTION) {
				jf1.dispose();
				System.exit(0);
			}
		}
	}
}
