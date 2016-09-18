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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import server.Database;

public class Adduser implements ActionListener {

	private JFrame jf1;
	private JTextField textField;
	private JButton button_add;
	private JButton button_cancer;
	private JPasswordField passwordField;
	Database data_adduser;
	private String username;
	private String password;

	public Adduser() {
		data_adduser = new Database();
		int x = 100;

		// 登录界面
		jf1 = new JFrame();
		jf1.setTitle("添加新员工！");
		jf1.getContentPane().setFont(new Font("SimSun", Font.PLAIN, 12));
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.getContentPane().setLayout(null);

		JLabel label_username = new JLabel("用户名:", new ImageIcon(
				Register.class.getResource("/pictures/yonghuming.jpg")),
				JLabel.LEFT);
		label_username.setBounds(x - 30, 214, 93, 31);
		jf1.getContentPane().add(label_username);

		JLabel label_password = new JLabel("密码:", new ImageIcon(
				Register.class.getResource("/pictures/mima.jpg")), JLabel.LEFT);
		label_password.setBounds(x - 30, 276, 93, 31);
		jf1.getContentPane().add(label_password);

		// 文本框
		textField = new JTextField();
		textField.setFont(UIManager.getFont("TextField.font"));
		textField.setBounds(x + 73, 214, 146, 26);
		jf1.getContentPane().add(textField);
		textField.setColumns(10);
		// 密码框
		passwordField = new JPasswordField();
		passwordField.setBounds(x + 73, 276, 146, 26);
		jf1.getContentPane().add(passwordField);
		// 添加按钮
		button_add = new JButton("添加");
		button_add.setBounds(x - 20, 323, 93, 23);
		button_add.addActionListener(this);
		jf1.getContentPane().add(button_add);
		// 取消按钮，点击退出程序
		button_cancer = new JButton("取消");
		button_cancer.setBounds(x + 90, 323, 93, 23);
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
		new Adduser();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		// 如果点击登录按钮
		if (obj == button_add) {
			username = textField.getText();
			password = passwordField.getText();
			if (username.equals("") || password.equals("")) {
				JOptionPane.showMessageDialog(null, "用户名或密码不能为空。");
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
			for (int i = 0; i < password.length(); i++) {
				char cha2 = password.charAt(i);
				if (cha2 == '*' || cha2 == '/' || cha2 == '\\') {
					JOptionPane
							.showMessageDialog(null, "密码中不能含有“*”“/”“\\”等符号。");
					return;
				}
			}
			if (data_adduser.addUser(username, password, "false")) {
				JOptionPane.showMessageDialog(null, "添加成功！");
			} else {
				JOptionPane.showMessageDialog(null, "添加失败！");
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
