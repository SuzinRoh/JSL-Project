package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PrintCust {
	CustomerDAO dao =CustomerDAO.getInstance();
	public void printCust() {
		Scanner sc= new Scanner(System.in);
		List<CustomerVO> list =getAllCust();
		System.out.println("\t\t*** 고객 전체 목록 ***");
		System.out.println("고객번호\t이름\t연락처\t\t주소\t\t\t직장명\t생년월일\t성별\t등록일자");
		for(CustomerVO vo : list) {
			String addr = vo.getAddr();
			if(addr.length()<8) {
				addr += "\t\t";
			}
			String birth="";
			if(vo.getBirthday()!=null) {
				birth = vo.getBirthday().substring(0,10);
			}else {
				birth = "없음";
			}
			
			System.out.println(vo.getNum()+"\t"+
							   vo.getName()+"\t"+
							   vo.getTel()+"\t"+
							   addr+"\t"+
							   vo.getOffice()+"\t"+
							   birth+"\t"+
							   vo.getSex()+"\t"+
							   vo.getIndate());
		}
		while(true) {
			System.out.print("메인메뉴로 이동합니다(Enter)?_");
			String tmp = sc.nextLine();
			if(tmp.equals("")||tmp==null) {
				break;
			}
		}
		
	}
	public List<CustomerVO> getAllCust(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CustomerVO> list = new ArrayList<CustomerVO>();
		CustomerVO vo =new CustomerVO();
		String sql ="select * from customer1124";
		try {
			conn = dao.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo =new CustomerVO();
				vo.setNum(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setTel(rs.getString(3));
				vo.setAddr(rs.getString(4));
				vo.setOffice(rs.getString(5));
				vo.setBirthday(rs.getString(6));
				vo.setSex(rs.getString(7));
				vo.setIndate(rs.getString(8));
				
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
