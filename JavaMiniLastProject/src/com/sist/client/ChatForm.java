package com.sist.client;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
public class ChatForm extends JPanel {
	JButton info,post;
	JTextArea listArea;
	JTextField chatField;
	JTable userList, roomList;
	DefaultTableModel ULmodel;
	JTextPane pane;
	
	public ChatForm()
	{
		info=new JButton();
		post=new JButton();
		listArea=new JTextArea();
		chatField=new JTextField();
		String[] ulmd= {"아이디","이름","성별"};
		String[][] rlmd= new String[0][3];
		userList=new JTable();
		
	}
}
