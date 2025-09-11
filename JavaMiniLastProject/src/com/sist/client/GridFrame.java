package com.sist.client;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
public class GridFrame extends JPanel {
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.LIGHT_GRAY);
		for (int x=0; x<getWidth(); x+= 50)
		{
			g.drawLine(x,0,x,getHeight());
		}
		for (int y=0; y<getHeight(); y+= 50)
		{
			g.drawLine(0,y,getWidth(),y);
		}
		
	}
}
