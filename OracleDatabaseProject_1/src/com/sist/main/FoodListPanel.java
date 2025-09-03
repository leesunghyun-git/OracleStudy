package com.sist.main;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import com.sist.dao.*;
import com.sist.vo.*;
import java.util.List;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.*;
public class FoodListPanel extends JPanel{
	JPanel pan=new JPanel();
	JButton b1,b2;
	JLabel la=new JLabel("0 page / 0 pages ");
	JLabel[] imgs=new JLabel[20];
	
	int curpage=1;
	int totalpage=0;
	
	FoodDAO dao=FoodDAO.newInstance();
	
	public FoodListPanel()
	{
		setLayout(null);
		pan.setLayout(new GridLayout(4,5,5,5));
		pan.setBounds(20, 15, 770, 580);
		add(pan);
		b1=new JButton("이전");
		b2=new JButton("다음");
		JPanel p=new JPanel();
		p.add(b1);
		p.add(la);
		p.add(b2);
		p.setBounds(20, 605, 770, 35);
		add(p);
		print();
	}
	public void init()
	{
		for(int i=0;i<imgs.length;i++)
		{
			imgs[i]=new JLabel("");
		}
		pan.removeAll(); //pan 에 있는 모든 컴포넌트 제거
		pan.validate(); // pan을 재배치
	}
	public void print()
	{
		totalpage=dao.foodTotalPage();
		List<FoodVO> list=dao.foodListData(curpage);
		int size=list.size();
		for(int i=0;i<size;i++)
		{
			FoodVO vo=list.get(i);
			try
			{
				URL url=new URL(vo.getPoster());
				Image img=ImageChange.getImage(new ImageIcon(url), 145, 145);
				imgs[i]=new JLabel(new ImageIcon(img));
				imgs[i].setToolTipText(vo.getName());
				pan.add(imgs[i]);
				
			}catch(Exception ex) {ex.printStackTrace();}
		}
		
		la.setText(curpage+" page / "+totalpage+" page");
	}

}
