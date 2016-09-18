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

		// ��¼����
		jf1 = new JFrame();
		jf1.setTitle("�����Ա����");
		jf1.getContentPane().setFont(new Font("SimSun", Font.PLAIN, 12));
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.getContentPane().setLayout(null);

		JLabel label_username = new JLabel("�û���:", new ImageIcon(
				Register.class.getResource("/pictures/yonghuming.jpg")),
				JLabel.LEFT);
		label_username.setBounds(x - 30, 214, 93, 31);
		jf1.getContentPane().add(label_username);

		JLabel label_password = new JLabel("����:", new ImageIcon(
				Register.class.getResource("/pictures/mima.jpg")), JLabel.LEFT);
		label_password.setBounds(x - 30, 276, 93, 31);
		jf1.getContentPane().add(label_password);

		// �ı���
		textField = new JTextField();
		textField.setFont(UIManager.getFont("TextField.font"));
		textField.setBounds(x + 73, 214, 146, 26);
		jf1.getContentPane().add(textField);
		textField.setColumns(10);
		// �����
		passwordField = new JPasswordField();
		passwordField.setBounds(x + 73, 276, 146, 26);
		jf1.getContentPane().add(passwordField);
		// ��Ӱ�ť
		button_add = new JButton("���");
		button_add.setBounds(x - 20, 323, 93, 23);
		button_add.addActionListener(this);
		jf1.getContentPane().add(button_add);
		// ȡ����ť������˳�����
		button_cancer = new JButton("ȡ��");
		button_cancer.setBounds(x + 90, 323, 93, 23);
		button_cancer.addActionListener(this);
		jf1.getContentPane().add(button_cancer);

		// ���뱳������
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
		// ��������¼��ť
		if (obj == button_add) {
			username = textField.getText();
			password = passwordField.getText();
			if (username.equals("") || password.equals("")) {
				JOptionPane.showMessageDialog(null, "�û��������벻��Ϊ�ա�");
				return;
			}
			for (int i = 0; i < username.length(); i++) {
				char cha1 = username.charAt(i);
				if (cha1 == '*' || cha1 == '/' || cha1 == '\\') {
					JOptionPane.showMessageDialog(null,
							"�û����в��ܺ��С�*����/����\\���ȷ��š�");
					return;
				}
			}
			for (int i = 0; i < password.length(); i++) {
				char cha2 = password.charAt(i);
				if (cha2 == '*' || cha2 == '/' || cha2 == '\\') {
					JOptionPane
							.showMessageDialog(null, "�����в��ܺ��С�*����/����\\���ȷ��š�");
					return;
				}
			}
			if (data_adduser.addUser(username, password, "false")) {
				JOptionPane.showMessageDialog(null, "��ӳɹ���");
			} else {
				JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
			}
		}
		// ȡ��
		if (obj == button_cancer) {
			int res = JOptionPane.showConfirmDialog(null, "ȷ��ȡ����ӣ�");
			if (res == JOptionPane.YES_OPTION) {
				jf1.dispose();
				System.exit(0);
			}
		}
	}
}
