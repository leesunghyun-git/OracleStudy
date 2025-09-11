package com.sist.client;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame{
	JButton login,exit;
	JTextField id_input;
	JPasswordField pwd_input;
	JLabel id,pwd;
	
	public LoginFrame()
	{
		login=new JButton();
		exit=new JButton();
		id_input=new JTextField();
		pwd_input=new JPasswordField();
		id=new JLabel("ID");
		pwd=new JLabel("Password");
		
		setLayout(null);
		
		id.setBounds(10, 20, WIDTH, HEIGHT);
		setSize(400,300);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new LoginFrame();
	}

}
