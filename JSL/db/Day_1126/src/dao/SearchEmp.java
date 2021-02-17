package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connect.Connect;
import vo.EmployeeVO;

public class SearchEmp {
	public void searchUI() {
		Scanner sc =new Scanner(System.in);
		System.out.println("\t\t\t*** 사원 정보 검색 ***");
		while(true) {
			System.out.println("검색할 사원이름을 입력하세요 ?");
			String ename =sc.next();
			List<EmployeeVO> list =searchEmp(ename);
			for(EmployeeVO tmp : list) {
				if(tmp.getEname().equals("99")) {
					System.out.println("등록된 사원이 없습니다.");
					break;
				}else {
					System.out.print("사원번호 :"+tmp.getDno()+"\t");
					System.out.println("사원이름 :"+tmp.getEname());
					System.out.print("업 무 명 :"+tmp.getJob()+"\t");
					System.out.println("상사이름 :"+tmp.getManagername());
					System.out.print("입사일자 :"+tmp.getHiredate()+"\t");
					System.out.println("급  여 :"+tmp.getSalary());
					System.out.print("커 미 션 :"+tmp.getCommission()+"\t");
					System.out.println("부서명 :"+tmp.getDname());
				}
			}
			System.out.println("검색을 계속할까요? (y/n).");
			String yn = sc.next();
			if(yn.equalsIgnoreCase("y")) {
				continue;
			}else if(yn.equalsIgnoreCase("n")) {
				break;
			}
		}
	}
	public List<EmployeeVO> searchEmp(String ename) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		List<EmployeeVO> list = new ArrayList<EmployeeVO>();
		EmployeeVO vo =null;
		
		String sql = "select e.eno,e.ename,e.job,ee.ename,e.hiredate,e.salary,e.commission,d.dname " + 
				"from employee e , department d ,employee ee " + 
				"where e.dno = d.dno and e.ename ="+"'"+ename+"'"
			   + "and e.manager = ee.eno (+)";
		
		try {
			conn = Connect.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(pstmt!=null) {
				while(rs.next()) {
					vo =new EmployeeVO();
					
					vo.setEno(rs.getInt(1));
					vo.setEname(rs.getString(2));
					vo.setJob(rs.getString(3));
					vo.setManagername(rs.getString(4));
					vo.setHiredate(rs.getString(5));
					vo.setSalary(rs.getInt(6));
					vo.setCommission(rs.getInt(7));
					vo.setDname(rs.getString(8));
					list.add(vo);
				}
			}else {
				vo.setEname("99");
				list.add(vo);
			}
		
		}catch(NullPointerException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)conn.close();
				if(pstmt!= null)pstmt.close();
				if(rs!= null)rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
