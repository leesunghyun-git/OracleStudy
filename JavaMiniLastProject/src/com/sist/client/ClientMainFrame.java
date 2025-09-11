package com.sist.client;

import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class ClientMainFrame extends JFrame implements ActionListener{
	Join join=new Join();
	Login login=new Login();
	MenuForm menu = new MenuForm();
	GridFrame grid = new GridFrame();
	ControllerPanel cp =new ControllerPanel();
	ChatForm cf=new ChatForm();
	BoradList bl=new BoradList();
	
	
	public ClientMainFrame() {
		setLayout(null); // 고정적으로 설정인 위치 5가지 외의 사용자 정의 위치로 설정
		menu.setBounds(110,15,1000,50);
		cp.setBounds(20,85,1230,680);
		grid.setBounds(0, 0, 1280, 800);
		add(menu);
		
		add(cp);
		add(grid);
		setSize(1280, 800);
//		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		menu.b1.addActionListener(this);
		menu.b5.addActionListener(this);
		menu.b6.addActionListener(this);
		
		login.b1.addActionListener(this); //로그인
		login.b2.addActionListener(this); // 회원가입
		login.b3.addActionListener(this); // 취소
		
		join.b1.addActionListener(this); // 회원가입
		join.b2.addActionListener(this); // 취소
		join.b3.addActionListener(this); // 중복체크
	}
	
	// has-a => 포함 클래스
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception e) {
		}
		new ClientMainFrame(); // 생성자 호출 => 후에 따로 호출할 필요가 없기 때문

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==menu.b1)
		{
			cp.card.show(cp, "HF");
		}
		else if(e.getSource()==menu.b5)
		{
			cp.card.show(cp, "CF");
		}
		else if(e.getSource()==menu.b6)
		{
			cp.card.show(cp,"BL");
		}
		else if(e.getSource()==login.b1)
		{
			
		}
		else if(e.getSource()==login.b2)
		{
			login.setVisible(false);
			join.setVisible(true);
		}
		else if(e.getSource()==login.b3)
		{
			dispose();
			System.exit(0);
		}
		else if(e.getSource()==join.b1)
		{
			
		}
		else if(e.getSource()==join.b2)
		{
			join.setVisible(false);
			login.setVisible(true);
		}
		else if(e.getSource()==join.b3)
		{
			
		}
		
	}
	
}
