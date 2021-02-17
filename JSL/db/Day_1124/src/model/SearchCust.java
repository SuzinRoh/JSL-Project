package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchCust {
	CustomerDAO dao =CustomerDAO.getInstance();
	
	
	public void searchUI() {
		Scanner sc =new Scanner(System.in);
		System.out.println("\t\t*** 고객 정보 검색 ***");
		System.out.println();
		
		while(true) {
			System.out.print("원하는 고객의 이름을 입력하세요?_");
			String name = sc.next();
				
			CustomerVO vo = searchName(name);
			if(vo!= null) {
				System.out.println("고 객 명 :"+vo.getName());
				System.out.println("연 락 처 :"+vo.getTel());
				System.out.println("주   소 :"+vo.getAddr());
				System.out.println("직 장 명 :"+vo.getOffice());
				System.out.println("생년월일 :"+vo.getBirthday());
				System.out.println("성  별 :"+vo.getSex());
				System.out.println("등록일자 :"+vo.getIndate());
			}else {
				
				System.out.println("등록된 고객이 없습니다.");
				continue;
			}
			
			System.out.print("메인메뉴로 이동합니다(Enter)?_\n다른 사람을 검색할시(n)");

			String tmp = sc.nextLine();
			tmp = sc.nextLine();
			if(tmp.equals("")||tmp==null) {
				break;
			}else if(tmp.equalsIgnoreCase("n")) {
				continue;
			}
		
		}
	}
	public CustomerVO searchName(String name) {
		
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		CustomerVO vo =null;
		String sql = "select * from customer1124 where name ='"+name+"'";
		
		try {
			conn = dao.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo =new CustomerVO();
				vo.setNum(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setTel(rs.getString(3));
				vo.setAddr(rs.getString(4));
				vo.setOffice(rs.getString(5));
				vo.setBirthday(rs.getString(6));
				vo.setSex(rs.getString(7));
				vo.setIndate(rs.getString(8));	
			}else if(pstmt==null){
				vo.setName("n");
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
		return vo;
	}
	
	
	
}
