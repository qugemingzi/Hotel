package client;


import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

//��ȡ��ȡ����������
public class IPRead 
{
	private String IP="1";
	private int port=0;
	
	@SuppressWarnings("resource")
	IPRead(){
		try{
			Scanner file=new Scanner(new File("DNS.txt"));
			String str=file.nextLine();
			if(str.equals("")){
				return;
			}else{
				String line[] = str.split(":");
				IP=line[0];
				port=Integer.parseInt(line[1]);
				file.close();
			}
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"��������ַ��ʽ����");
		}catch (NoSuchElementException e) {
			JOptionPane.showMessageDialog(null,"��ȡ��������ַ����");
		}catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"DNS�ļ�λ�ó���");
		}
	}
	
	public String getIP(){
		return IP;
	}
	public int getPort(){
		return port;
	}
	
}

