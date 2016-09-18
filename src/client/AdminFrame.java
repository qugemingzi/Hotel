package client;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import server.Database;

public class AdminFrame {
	private JFrame jf;
	private Database data_adminframe;

	public AdminFrame(String admin) {
		data_adminframe = new Database();

		jf = new JFrame();
		jf.setTitle("�Ƶ����ϵͳ����Ա��½");
		jf.setResizable(false);
		jf.setSize(new Dimension(500, 300));
		jf.setLocation(new Point(500, 225));
		jf.getContentPane().setLayout(null);

		JButton button_deletecheckin = new JButton("ɾ����ʷ��½��Ϣ");
		button_deletecheckin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (data_adminframe.deletecheckin()) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
				} else {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
				}
			}
		});
		button_deletecheckin.setBounds(25, 125, 140, 50);
		jf.getContentPane().add(button_deletecheckin);

		JButton button_adduser = new JButton("�����Ա��");
		button_adduser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Adduser();
			}
		});
		button_adduser.setBounds(200, 125, 120, 50);
		jf.getContentPane().add(button_adduser);

		JButton button_deleteuser = new JButton("ɾ��Ա��");
		button_deleteuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Deleteuser();
			}
		});
		button_deleteuser.setBounds(350, 125, 120, 50);
		jf.getContentPane().add(button_deleteuser);

		// ���뱳������
		JLabel lblNewLabel = new JLabel(new ImageIcon(
				Register.class.getResource("/pictures/register.jpg")));
		lblNewLabel.setBounds(0, 0, 500, 300);
		jf.getContentPane().add(lblNewLabel);

		jf.setVisible(true);
	}

	public static void main(String[] args) {
		new AdminFrame("zpy");
	}

}
