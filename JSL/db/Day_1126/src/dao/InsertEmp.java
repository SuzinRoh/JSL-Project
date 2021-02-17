package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import connect.Connect;
import vo.EmployeeVO;

public class InsertEmp {
	public void insertUI() {
		Scanner sc =new Scanner(System.in);
		EmployeeVO vo =new EmployeeVO();
		String name,job,hiredate;
		int manager,salary,commission,dno;
		while(true) {
			System.out.println("*** 신규 사원 정보 등록 ***");
			
			int eno = getEno();
			System.out.println(eno+"번 째 사원");
			vo.setEno(eno);
			
			System.out.print("사원이름 :");
			name = sc.next();
			vo.setEname(name);
			
			System.out.print("업 무 명 :");
			job = sc.next();
			vo.setJob(job);
			
			System.out.print("상사번호 [");
			for(EmployeeVO tmp :getManager()) {
				System.out.print(tmp.getManager()+",");
			}
			System.out.println("] :");
			manager = sc.nextInt();
			vo.setManager(manager);
			
			
			System.out.print("입사일자(20201126) :");
			hiredate =sc.nextLine();
			hiredate =sc.nextLine();
			if(hiredate.equals("")||hiredate==null) {
				Date date =new Date();
			    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			    String now = format.format(date);
			    System.out.println(now);
				hiredate = now.substring(0,8);
				System.out.println(hiredate);
			}
			vo.setHiredate(hiredate);
			
			System.out.print("급   여 :");
			salary = sc.nextInt();
			vo.setSalary(salary);
			
			System.out.print("커 미 션 :");
			commission = sc.nextInt();
			vo.setCommission(commission);
			
			System.out.println("부서정보(10:xxx,20:yyyy,30:dddd,40:ssss :");
			System.out.print("부서번호 :");
			dno = sc.nextInt();
			dno =getDno(dno);
			if(dno==0) {
				System.out.println("없는 부서번호입니다.");
				continue;
			}else {
				vo.setDno(dno);
			}
			
			System.out.print("등록하시겠습니까(y/n) :");
			String yn=sc.next();
			if(yn.equalsIgnoreCase("y")) {
				int row = insertEmp(vo);
				if(row==1) {
					System.out.println("성공적으로 등록되었습니다.");
				}else {
					System.out.println("등록실패.");
					continue;
				}
			}
			
			System.out.print("추가 등록(y/n) :");
			yn=sc.next();
			if(yn.equalsIgnoreCase("n")) {
				break;
			}else if(yn.equalsIgnoreCase("y")){
				continue;
			}
		}
	}
	public List<EmployeeVO> getManager() {
		List<EmployeeVO> list =new ArrayList<EmployeeVO>();
		EmployeeVO vo=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select manager from employee ";
		try {
			conn = Connect.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				vo=new EmployeeVO();
				vo.setManager(rs.getInt(1));
				
				list.add(vo);
			}
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
	
	public int getDno(int dno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int no =0;
		String sql = "select dno from department where dno ="+dno;
		try {
			conn = Connect.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			if(pstmt!=null) {
				if(rs.next()) {
					no = rs.getInt(1);
				}
			}else {
				no =0;
			}
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
		return no;
	}
	public int getEno() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int eno =0;
		String sql = "select max(eno)+1 from employee";
		try {
			conn = Connect.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				eno = rs.getInt(1);
			}
			
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
		return eno;
	}
	public int insertEmp(EmployeeVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into employee"
				   + "(eno,ename,job,manager,hiredate,salary,commission,dno) "               
				   + "values(?,?,?,?,?,?,?,?) ";
		int row =0;
		try {
			conn = Connect.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,vo.getEno());
			pstmt.setString(2, vo.getEname());
			pstmt.setString(3, vo.getJob());
			pstmt.setInt(4,vo.getManager());
			pstmt.setString(5,vo.getHiredate());
			pstmt.setInt(6,vo.getSalary());
			pstmt.setInt(7,vo.getCommission());
			pstmt.setInt(8,vo.getDno());
			
			row= pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)conn.close();
				if(pstmt!= null)pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
}
