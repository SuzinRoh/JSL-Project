package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ModifyCust {
	CustomerDAO dao =CustomerDAO.getInstance();
	
	
	//수정은  연락처직장명
	public void modifyUI() {
		CustomerVO vo=null;
		Scanner sc =new Scanner(System.in);
		System.out.println("\t\t*** 고객 정보 수정 ***");
		while(true) {
			System.out.print("수정을 원하는 고객번호 입력?_");
			int cnum=sc.nextInt();
			vo = searchNum(cnum);
			if(vo==null) {
				System.out.println("없는 번호 입니다.");
				continue;
			}
			System.out.println("고 객 명 :"+vo.getName());
			System.out.print("연 락 처 :");
			String tel =sc.next();
			
			System.out.print("직 장 명 :");
			String office =sc.next();
			
			System.out.print("수정하시겠습니까(y/n)?");
			String yn =sc.next();
			if(yn.equals("y")) {
				modifyCust(office,tel,cnum);
			}else if(yn.equals("n")){
				break;
			}
			System.out.print("메인으로 돌아가려면(Enter)더 수정하려면(y)");
			yn =sc.nextLine();
			yn =sc.nextLine();
			if(yn.equals("y")) {
				continue;
			}else if(yn.equals("")){
				break;
			}
			
		}
	}
	public CustomerVO searchNum(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustomerVO vo=null;
		
		String sql="select name from customer1124 where num ="+num;
		try {
			conn = dao.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				vo=new CustomerVO();
				vo.setName(rs.getString(1));
			}else if(pstmt==null) {
				vo.setName("no");
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
	public void modifyCust(String office, String tel,int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		String sql="update customer1124 set office="+"'"+office+"'"+
				",tel ="+"'"+tel+"' where num="+num;
		
		try {
			conn = dao.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			System.out.println("수정 성공.");
			
			
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
