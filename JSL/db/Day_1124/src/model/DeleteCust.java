package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;



public class DeleteCust {
	CustomerDAO dao =CustomerDAO.getInstance();
	
	public void deleteUI() {
		Scanner sc =new Scanner(System.in);
		System.out.println("\t\t*** 고객 정보 수정 ***");
		System.out.println();
		while(true) {
			System.out.println("삭제를 원하는 고객의 번호를 입력하세요?_");
			int num = sc.nextInt();
			CustomerVO vo=searchNum(num);
			if(vo==null) {
				System.out.println("없는 번호 입니다.");
				continue;
			}else {
				System.out.println(
						   vo.getName()+"\n"+
						   vo.getTel()+"\n"+
						   vo.getAddr()+"\n"+
						   vo.getOffice()+"\n"+
						   vo.getBirthday()+"\n"+
						   vo.getSex()+"\n"+
						   vo.getIndate());
			}
			System.out.print("삭제하시겠습니까(y/n)");
			String yn =sc.next();
			if(yn.equals("y")) {
				deleteCust(num);
			}else if(yn.equals("n")){
				break;
			}
			System.out.print("메인으로 돌아가려면(Enter)더 삭제하려면(y)");
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
		
		String sql="select * from customer1124 where num ="+num;
		try {
			conn = dao.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				vo=new CustomerVO();
				vo.setName(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setTel(rs.getString(3));
				vo.setAddr(rs.getString(4));
				vo.setOffice(rs.getString(5));
				vo.setBirthday(rs.getString(6));
				vo.setSex(rs.getString(7));
				vo.setIndate(rs.getString(8));
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
	public void deleteCust(int num) {
		Connection conn =null;
		PreparedStatement pstmt=null;
		
		String sql="delete from customer1124 where num="+num;
		try {
			conn = dao.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
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
