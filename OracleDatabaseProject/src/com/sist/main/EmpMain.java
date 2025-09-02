package com.sist.main;

import java.util.List;
import java.util.Scanner;

import com.sist.dao.EmpDAO;
import com.sist.vo.EmpVO;

public class EmpMain {
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		EmpDAO dao=EmpDAO.newInstance();
		while(true)
		{
			System.out.println("========== 메뉴 ===========");
			System.out.println("1. 사원 목록");
			System.out.println("2. 사원 상세보기");
			System.out.println("3. 사원 검색");
			System.out.println("4. 종료");
			System.out.println("==========================");
			System.out.println("메뉴 선택:");
			int menu=scan.nextInt();
			if(menu==4)
			{
				System.out.println("프로그램 종료");
				break;
			}
			else if(menu==1)
			{	try {
				List<EmpVO> list=dao.empListData();
				for(EmpVO vo:list)
				{
					System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob()+" "+vo.getDbday()+" "+vo.getSal());	
				}
			}catch(Exception ex) {}
			}
			else if(menu==2)
			{
				System.out.println("상세볼 사원번호 입력");
				int empno=scan.nextInt();
				try
				{
					EmpVO vo=dao.defailInfo(empno);
					System.out.println("사번:"+vo.getEmpno()+" "+
							"이름:"+vo.getEname()+" "+
							"직위:"+vo.getJob()+" "+
							"사수:"+vo.getMgr()+" "+
							"입사일:"+vo.getDbday()+" "+
							"급여:"+vo.getSal()+" "+
							"성과금:"+vo.getComm()+" "+
							"부서번호:"+vo.getDeptno());
					
					
				}catch(Exception ex) {}
			}
			else if(menu==3)
			{
				System.out.println("검색어 입력");
				String ename=scan.next();
				try
				{
					List<EmpVO> list=dao.search(ename);
					for(EmpVO vo:list)
					{
						System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob()+" "+vo.getDbday()+" "+vo.getSal());
					}
				}catch(Exception ex) {}
			}
		}
	}
}
