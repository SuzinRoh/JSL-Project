package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import connect.Connect;
import vo.EmployeeVO;

public class UpdateEmp {
	public void updateUI() {
		EmployeeVO vo =null;
		Scanner sc =new Scanner(System.in);
		while(true) {
			System.out.println("검색할 사원번호를 입력하세요.");
			int eno = sc.nextInt();
			vo = searcheno(eno);
			if(vo ==null) {
				System.out.println("없는 사원입니다.");
				continue;
			}
			System.out.println("사원번호 :"+vo.getEno());
			System.out.print("사원이름 ("+vo.getEname()+") :");
			String ename =sc.nextLine();
			ename =sc.nextLine();
			if(ename==null||ename.equals("")) {
				ename=vo.getEname();
			}
			
			System.out.print("업 무 명 :");
			String job =sc.nextLine();
			if(job==null||job.equals("")) {
				job=vo.getJob();
			}
			
			System.out.print("상사번호 :");
			String mtmp =sc.nextLine();
			int manager;
			if(mtmp==null||mtmp.equals("")) {
				manager=vo.getManager();
			}else {
				manager=Integer.parseInt(mtmp);
			}
			
			System.out.print("입사일자 :");
			String hiredate =sc.nextLine();
			if(hiredate==null||hiredate.equals("")) {
				
				System.out.print(vo.getHiredate());
			    String now = vo.getHiredate().substring(0,9);
				hiredate=now;
			}
			
			System.out.print("급여 :");
			String tmps =sc.nextLine();
			int salary;
			if(tmps==null||tmps.equals("")) {
				salary=vo.getSalary();
			}else {
				salary = Integer.parseInt(tmps);
			}
			
			System.out.print("커미션 :");
			String tmpc =sc.nextLine();
			int commission;
			if(tmpc==null||tmpc.equals("")) {
				commission=vo.getCommission();
			}else {
				commission= Integer.parseInt(tmpc);
			}
			
			System.out.print("부서번호 :");
			String tmpd =sc.nextLine();
			int dno;
			if(tmpd==null||tmpd.equals("")) {
				//System.out.println(vo.getDno());
				dno=vo.getDno();
			}else {
				dno=Integer.parseInt(tmpd);
			}
			
			System.out.print("수정하시겠습니까?(y/n)");
			String tmp=sc.next();
			if(tmp.equalsIgnoreCase("y")) {
				updateEmp(eno,ename,job,manager,hiredate,salary,commission,dno);
				continue;
			}else if(tmp.equalsIgnoreCase("n")) {
				break;
			}
			
			
		}
	
	}
	public EmployeeVO searcheno(int eno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeVO vo=null;
		
		String sql="select * from employee where eno ="+eno;
		try {
			conn = Connect.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			if(pstmt!=null) {
				if(rs.next()) {
						vo=new EmployeeVO();
						vo.setEno(rs.getInt(1));
						vo.setEname(rs.getString(2));
						vo.setJob(rs.getString(3));
						vo.setManager(rs.getInt(4));
						vo.setHiredate(rs.getString(5));
						vo.setSalary(rs.getInt(6));
						vo.setCommission(rs.getInt(7));
						vo.setDno(rs.getInt(8));
					
				}
			}else {

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
		return vo;
	}
	public void updateEmp(int eno,String ename,String job,int manager,String hiredate,int salary,int commission,int dno) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		
		EmployeeVO vo =null;
		
		String sql = "update employee set "
				+ "ename="+"'"+ename+"'"
				+ ",job="+"'"+job+"'"
				+ ",manager="+manager
				+ ",hiredate="+"'"+hiredate+"'"
				+ ",salary="+salary
				+ ",commission="+commission
				+ ",dno="+dno
				+ "where eno ="+eno;
		
		try {
			conn = Connect.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			System.out.println("수정 성공.");
			
		}catch(NullPointerException e) {
			e.printStackTrace();
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
	}
}
