package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connect.Connect;
import vo.EmployeeVO;

public class PrintAllEmp {
	
	
	public void printUI() {
		Scanner sc =new Scanner(System.in);
		System.out.println("\t\t\t*** 사원 전체 목록 ***");
		System.out.println("사원번호\t이름\t업무명\t상사번호\t입사일자\t급여\t커미션\t부서명");
		List<EmployeeVO> vo=printEmp();
		while(true) {
			for(EmployeeVO tmp : vo) {
				System.out.println(tmp.getEno()+"\t"+
								   tmp.getEname()+"\t"+
								   tmp.getJob()+"\t"+
								   tmp.getManager()+"\t"+
								   tmp.getHiredate()+"\t"+
								   tmp.getSalary()+"\t"+
								   tmp.getCommission()+"\t"+
								   tmp.getDname());
			}
	
			System.out.print("메인메뉴로 이동합니다(Enter) :");
			String yn=sc.nextLine();
			yn=sc.nextLine();
			if(yn.equalsIgnoreCase("")) {
				break;
			}
		}
	}
	public List<EmployeeVO> printEmp() {
		List<EmployeeVO> list =new ArrayList<EmployeeVO>();
		EmployeeVO vo=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select e.*,dname from employee e,department d "
				+ "where e.dno = d.dno";
		try {
			conn = Connect.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				vo=new EmployeeVO();
				
				vo.setEno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setManager(rs.getInt(4));
				vo.setHiredate(rs.getString(5));
				vo.setSalary(rs.getInt(6));
				vo.setCommission(rs.getInt(7));
				vo.setDname(rs.getString(8));
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
}
