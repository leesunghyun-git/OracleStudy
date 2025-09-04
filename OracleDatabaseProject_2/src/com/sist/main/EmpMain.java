package com.sist.main;

import java.util.List;
import java.util.Scanner;

import com.sist.dao.EmpDAO;
import com.sist.vo.EmpVO;

public class EmpMain {

	public static void main(String[] args) {
		EmpDAO dao=EmpDAO.newInstance();
		List<EmpVO> list=dao.empListData();
		
		list.forEach(vo ->{
			System.out.println(vo.getEmpno()+" "+
					vo.getEname()+" "+
					vo.getSal()+" "+
					vo.getHiredate()+" "+
					vo.getDvo().getDname()+" "+
					vo.getDvo().getLoc()+" "+
					vo.getSvo().getGrade());});
		Scanner scan=new Scanner(System.in);
		System.out.println("사번 입력:");
		EmpVO vo=dao.empDetailData(scan.nextInt());
		System.out.println(vo.getEmpno()+" "+
				vo.getEname()+" "+
				vo.getSal()+" "+
				vo.getHiredate()+" "+
				vo.getDvo().getDname()+" "+
				vo.getDvo().getLoc()+" "+
				vo.getSvo().getGrade());
	}
}
