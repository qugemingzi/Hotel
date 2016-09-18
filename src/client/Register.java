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

		// ��¼����
		jf1 = new JFrame("��ӭ������ݹ�����Ϣϵͳ��");
		jf1.setTitle("��ӭ���ٷ����Ƶ꣡");
		jf1.getContentPane().setFont(new Font("SimSun", Font.PLAIN, 12));
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.getContentPane().setLayout(null);

		JLabel label = new JLabel("�û���:", new ImageIcon(
				Register.class.getResource("/pictures/yonghuming.jpg")),
				JLabel.LEFT);
		label.setBounds(x - 30, 214, 93, 31);
		jf1.getContentPane().add(label);

		JLabel label_1 = new JLabel("����:", new ImageIcon(
				Register.class.getResource("/pictures/mima.jpg")), JLabel.LEFT);
		label_1.setBounds(x - 30, 276, 93, 31);
		jf1.getContentPane().add(label_1);

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
		// ��¼��ť
		button_login = new JButton("��¼");
		button_login.setBounds(x - 20, 323, 93, 23);
		button_login.addActionListener(this);
		jf1.getContentPane().add(button_login);
		// �˳���ť������˳�����
		button_cancer = new JButton("�˳�");
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
		new Register();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		// ��������¼��ť
		if (obj == button_login) {
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
				JOptionPane.showMessageDialog(null, "�������޷�����.");
				e.printStackTrace();
			} catch (UnknownHostException e) {
				JOptionPane.showMessageDialog(null, "δ֪����.");
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "��������쳣.");
				e.printStackTrace();
			}

			if (str == null) {
				System.out.println("��ȡ�շ���");
				return;
			}

			if (str.equals("#s")) {
				JOptionPane.showMessageDialog(null, "���û��ѵ�¼��");
			}

			if (str.equals("$b")) {
				JOptionPane.showMessageDialog(null, "��½�ɹ���");
				jf1.dispose();
				data_register.Updaterstate_book();
				new MainFrame(username);
			}
			
			if (str.equals("$d")) {
				JOptionPane.showMessageDialog(null, "����Ա��½�ɹ���");
				jf1.dispose();
				new AdminFrame(username);
			}
			
			if (str.equals("$c")) {
				JOptionPane.showMessageDialog(null, "��½ʧ�ܣ������û����������Ƿ���ȷ��");
			}
		}
		// ȡ��
		if (obj == button_cancer) {
			int res = JOptionPane.showConfirmDialog(null, "ȷ���˳���¼��");
			if (res == JOptionPane.YES_OPTION) {
				jf1.dispose();
				System.exit(0);
			}
		}
	}
}
