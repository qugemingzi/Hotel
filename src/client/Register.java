package client;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import server.Database;

public class Register implements ActionListener {

	private JFrame jf1;
	private JTextField textField;
	private JButton button_login;
	private JButton button_cancer;
	private JPasswordField passwordField;
	Database data_register;
	private String username;
	private String password;

	public Register() {
		data_register = new Database();
		int x = 100;

		// 登录界面
		jf1 = new JFrame("欢迎进入宾馆管理信息系统！");
		jf1.setTitle("欢迎光临帆船酒店！");
		jf1.getContentPane().setFont(new Font("SimSun", Font.PLAIN, 12));
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.getContentPane().setLayout(null);

		JLabel label = new JLabel("用户名:", new ImageIcon(
				Register.class.getResource("/pictures/yonghuming.jpg")),
				JLabel.LEFT);
		label.setBounds(x - 30, 214, 93, 31);
		jf1.getContentPane().add(label);

		JLabel label_1 = new JLabel("密码:", new ImageIcon(
				Register.class.getResource("/pictures/mima.jpg")), JLabel.LEFT);
		label_1.setBounds(x - 30, 276, 93, 31);
		jf1.getContentPane().add(label_1);

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
		// 登录按钮
		button_login = new JButton("登录");
		button_login.setBounds(x - 20, 323, 93, 23);
		button_login.addActionListener(this);
		jf1.getContentPane().add(button_login);
		// 退出按钮，点击退出程序
		button_cancer = new JButton("退出");
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
		new Register();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		// 如果点击登录按钮
		if (obj == button_login) {
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
			Socket soc = null;
			String str = null;
			try {
				soc = new Socket(new IPRead().getIP(), new IPRead().getPort());
				DataOutputStream dos = new DataOutputStream(
						soc.getOutputStream());
				dos.writeUTF("$a" + username + "/" + password);
				DataInputStream dis = new DataInputStream(soc.getInputStream());
				str = dis.readUTF();
			} catch (ConnectException e) {
				JOptionPane.showMessageDialog(null, "服务器无法连接.");
				e.printStackTrace();
			} catch (UnknownHostException e) {
				JOptionPane.showMessageDialog(null, "未知主机.");
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "输入输出异常.");
				e.printStackTrace();
			}

			if (str == null) {
				System.out.println("读取空返回");
				return;
			}

			if (str.equals("#s")) {
				JOptionPane.showMessageDialog(null, "该用户已登录。");
			}

			if (str.equals("$b")) {
				JOptionPane.showMessageDialog(null, "登陆成功！");
				jf1.dispose();
				data_register.Updaterstate_book();
				new MainFrame(username);
			}
			
			if (str.equals("$d")) {
				JOptionPane.showMessageDialog(null, "管理员登陆成功！");
				jf1.dispose();
				new AdminFrame(username);
			}
			
			if (str.equals("$c")) {
				JOptionPane.showMessageDialog(null, "登陆失败！请检查用户名或密码是否正确。");
			}
		}
		// 取消
		if (obj == button_cancer) {
			int res = JOptionPane.showConfirmDialog(null, "确定退出登录？");
			if (res == JOptionPane.YES_OPTION) {
				jf1.dispose();
				System.exit(0);
			}
		}
	}
}
