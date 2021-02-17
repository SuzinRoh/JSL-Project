package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InsertCus {
	CustomerDAO custDAO =CustomerDAO.getInstance();
	
	public void insertUI() {
		System.out.println("\t*** 신규 고객 정보 등록***");
		CustomerVO vo=new CustomerVO();
		Scanner sc =new Scanner(System.in);
		String name,tel,addr,office,birthday,sex,indate;
		//String now = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyymmdd"));
		Date date =new Date();
	    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	    String now = format.format(date);
		while(true) {
			int num = getSeq();
			System.out.println(num+"번 고객");
			System.out.print("고 객 명 :");
			name = sc.next();
			System.out.print("연 락 처 :");
			tel = sc.next();
			System.out.print("주   소 :");
			addr = sc.nextLine();
			addr = sc.nextLine();
			System.out.print("직 장 명 :");
			office =sc.nextLine();
			System.out.print("생년월일:");
			birthday =sc.nextLine();
			System.out.print("성   별 :");
			sex = sc.next();
			System.out.print("등 록 일 :");
			indate = sc.nextLine();
			indate = sc.nextLine();
			if(indate==null||indate.equals("")) {
				indate = now;
			}
			vo.setNum(num);
			vo.setName(name);
			vo.setTel(tel);
			vo.setAddr(addr);
			vo.setOffice(office);
			vo.setBirthday(birthday);
			vo.setSex(sex);
			vo.setIndate(indate);
			
			int row = insertCust(vo);
			if(row==0) {
				System.out.println("등록실패.");
			}else {
				System.out.println("성공적으로 등록되었습니다.");
			}
			System.out.print("다른 고객을 등록하시겠습니까(Y/N) ? ");
			String more =sc.next();
			if(more.equalsIgnoreCase("n")) {
				break;
			}else {
				continue;
			}
			
		}
		
	}
	public int getSeq() {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		CustomerVO vo=new CustomerVO();
		
		String sql = "select customernumber.nextval from dual";
		
		int seq =0;
		try {
			conn = custDAO.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				seq = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn !=null)conn.close();
				if(pstmt !=null)pstmt.close();
				if(rs != null)rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return seq;
	}
	public int insertCust(CustomerVO vo) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		
		int row =0;
		String sql="insert into customer1124("
					+ "num,name,tel,addr,office,birthday,sex,indate)"
					+ "values(?,?,?,?,?,?,?,?)";
		
		try {
			conn = custDAO.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getTel());
			pstmt.setString(4, vo.getAddr());
			pstmt.setString(5, vo.getOffice());
			pstmt.setString(6, vo.getBirthday());
			pstmt.setString(7, vo.getSex());
			pstmt.setString(8, vo.getIndate());
			
			row = pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn !=null)conn.close();
				if(pstmt !=null)pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
}
