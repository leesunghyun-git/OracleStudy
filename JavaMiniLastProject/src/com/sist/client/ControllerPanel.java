package com.sist.client;
import java.awt.CardLayout;

import javax.swing.JPanel;
public class ControllerPanel extends JPanel {
	HomeForm hf=new HomeForm();
	CardLayout card=new CardLayout();
	ChatForm cf=new ChatForm();
	BoradList bl=new BoradList();
	public ControllerPanel()
	{
		setLayout(card);
		add("HF",hf);
		add("CF",cf);
		add("BL",bl);
	}
}
