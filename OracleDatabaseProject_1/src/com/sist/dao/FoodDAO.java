package com.sist.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.sist.vo.FoodVO;
public class FoodDAO {
	private static Connection conn;
	private static PreparedStatement ps;
	private final static String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static FoodDAO dao;
	
	public FoodDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {ex.printStackTrace();}
	}
	public static FoodDAO newInstance()
	{
		if(dao==null)
			dao=new FoodDAO();
		return dao;
	}
	// 웹 => Connection pool
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex) {ex.printStackTrace();}
	}
	public void disConnection()
	{
		try {
		if(ps!=null) ps.close(); if(conn!=null) conn.close();
		}
		catch(Exception ex) {}
	}
	// --------------------------------------- 공통으로 적용
	// 기능 1. 목록출력
	public List<FoodVO> foodListData(int page)
	{
		List<FoodVO> temp = new ArrayList<FoodVO>();
		List<FoodVO> list = new ArrayList<FoodVO>();
		try
		{
			getConnection();
			String sql="SELECT fno,name,type,poster,score FROM food ORDER BY fno ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				FoodVO vo=new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setType(rs.getString(3));
				vo.setPoster("http://www.menupan.com"+rs.getString(4));
				vo.setScore(rs.getDouble(5));
				temp.add(vo);
			}
			rs.close();
			
			int rowSize=20;
			int start=(rowSize*page)-rowSize;
			int end=rowSize*page;
			if(end>temp.size())
				end=temp.size()-1;
			
			list=temp.subList(start,end);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return list;
	}
	// 총페이지
	public int foodTotalPage()
	{
		int total=0;
		try
		{
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/20.0) FROM food";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();  
		}catch(Exception ex)
		{
			
		}
		finally
		{
			disConnection();
		}
		return total;
	}
}
