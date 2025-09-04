package com.sist.dao;
import java.sql.*;
import java.util.*;
import com.sist.db.CreateDataBase;
import com.sist.vo.EmpVO;
public class EmpDAO {

	private static EmpDAO dao;
	private CreateDataBase db=new CreateDataBase();
	
	public static EmpDAO newInstance()
	{
		if(dao==null)
			dao=new EmpDAO();
		return dao;
	}
	
	public List<EmpVO> empListData()
	{
		Connection conn=null;
		PreparedStatement ps=null;
		List<EmpVO> list=new ArrayList<>();
		try
		{
			conn=db.getConnection();
			
			String sql="SELECT empno, ename, job , sal ,hiredate, dname, loc, grade "
					+ "FROM emp,dept,salgrade "
					+ "WHERE emp.deptno=dept.deptno "
					+ "AND emp.sal BETWEEN losal AND hisal";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				EmpVO vo=new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setSal(rs.getInt(4));
				vo.setHiredate(rs.getDate(5));
				vo.getDvo().setDname(rs.getString(6));
				vo.getDvo().setLoc(rs.getString(7));
				vo.getSvo().setGrade(rs.getInt(8));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex)
		{ex.printStackTrace();
		}finally
		{
			db.disConnection();
		
		}
		return list;
	}
	/*
	 * 	1.목록 => List
	 * 	2.상세 => ~VO
	 * 	3.총페이지 => int
	 * 	4.로그인 : String
	 * 		=> 경우수 : 3이상
	 * 		=> 경우수 : 2 => boolean
	 * 
	 */
	public EmpVO empDetailData(int empno)
	{
		EmpVO vo=new EmpVO();
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="SELECT empno, ename, job , sal ,hiredate, dname, loc, grade "
				+ "FROM emp,dept,salgrade "
				+ "WHERE emp.deptno=dept.deptno "
				+ "AND emp.sal BETWEEN losal AND hisal "
				+ "AND empno=?";
		try
		{
			conn=db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, empno);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setSal(rs.getInt(4));
			vo.setHiredate(rs.getDate(5));
			vo.getDvo().setDname(rs.getString(6));
			vo.getDvo().setLoc(rs.getString(7));
			vo.getSvo().setGrade(rs.getInt(8));
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally
		{
			db.disConnection();
		}
		return vo;
	}
	
}
