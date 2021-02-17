package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import connect.Connect;
import vo.EmployeeVO;

public class DeleteEmp {
	public void deleteUI() {
		EmployeeVO vo= new EmployeeVO();
		Scanner sc =new Scanner(System.in);
		System.out.println("\t\t\t*** 사원 정보 검색 ***");
		while(true) {
			System.out.println("삭제할 사원번호를 입력하세요?");
			int eno = sc.nextInt();
			vo = searcheno(eno);
			if(vo==null) {
				System.out.println("사원이 없습니다.");
				continue;
			}else {
				int dno = vo.getDno();
				String dname ="";
				switch(dno) {
					case 10:
						dname = "accounting";
						break;
					case 20:
						dname = "research";
						break;
					case 30:
						dname = "sales";
						break;
					case 40:
						dname = "operations";
						break;
				}
				System.out.println(vo.getEno()+"\t"+
						   vo.getEname()+"\t"+
						   vo.getJob()+"\t"+
						   vo.getManager()+"\t"+
						   vo.getHiredate()+"\t"+
						   vo.getSalary()+"\t"+
						   vo.getCommission()+"\t"+
						   dname);
			}
			System.out.println("삭제할까요?.");
			String yn=sc.next();
			if(yn.equalsIgnoreCase("y")) {
				deleteEmp(eno);
				continue;
			}else if(yn.equalsIgnoreCase("n")) {
				break;
			}
			System.out.print("메인메뉴로 이동합니다(Enter) :");
			yn=sc.nextLine();
			yn=sc.nextLine();
			if(yn.equalsIgnoreCase("")) {
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
	public void deleteEmp(int eno) {
		Connection conn =null;
		PreparedStatement pstmt=null;
		
		String sql="delete from Employee where eno="+eno;
		try {
			conn = Connect.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			System.out.println("성공적으로 삭제되었습니.");
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(conn != null)conn.close();
				if(pstmt != null) pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
