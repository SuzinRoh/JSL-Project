package esDay_1223.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/*
 * 
 *  da0 (data access object)
 *  드라이버 로딩 - 커넥션 연결 - crud
 */
public class guestDAO {
	private static Connection getConnection() {
		String myDriver = "oracle.jdbc.driver.OracleDriver";
		String myURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String myID = "jslhrd46";
		String myPass = "1234";
		
		Connection conn = null;
		try{
			Class.forName(myDriver);
			conn = DriverManager.getConnection(myURL,myID,myPass);
			System.out.println("성공");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("error");
		}
		return conn;
	}
	
	//메소드 정e
	public int guestCount() {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		String query = "select count(*) from tbl_guest3 ";
		int row = 0;//return type
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return row;
	}
	
	//등록메소드
	public int guestWrite(guestVO tmp) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		
		String query = "insert into tbl_guest3(idx,name,pass,subject,contents) "
					+" values(tbl_guest_seq_idx3.nextval,?,?,?,?)";
		
		int row = 0;//return type
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, tmp.getName());
			pstmt.setString(2, tmp.getPass());
			pstmt.setString(3, tmp.getSubject());
			pstmt.setString(4, tmp.getContents());
			
			row = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return row;
	}
	//등록
	public guestVO guestSelect(int idx) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		String query = "select * from tbl_guest3 where idx=?";
		guestVO vo =new guestVO();//return type
		int row =0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return vo;
	}
	//수정메소드
		public int guestEdit(guestVO tmp) {
			Connection conn =null;
			PreparedStatement pstmt =null;
			
			String query = "update tbl_guest3 set subject=?,contents=? where idx=? and pass=?";
			
			int row = 0;//return type
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(query);
				
				
				pstmt.setString(1, tmp.getSubject());
				pstmt.setString(2, tmp.getContents());
				pstmt.setInt(3, tmp.getIdx());
				pstmt.setString(4, tmp.getPass());
				
				row = pstmt.executeUpdate();
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					conn.close();
					pstmt.close();
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			return row;
		}
		//삭제
		public int guestDelete(int idx, String pass) {
			Connection conn =null;
			PreparedStatement pstmt =null;
			
			String query = "delete from tbl_guest3  where idx=? and pass=?";
			
			int row = 0;//return type
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, idx);
				pstmt.setString(2, pass);
				
				row = pstmt.executeUpdate();
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					conn.close();
					pstmt.close();
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			return row;
		}
	//전체목록
	public List<guestVO> guestList() {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		String query = "select * from tbl_guest3 order by idx desc";
		List<guestVO> list =new ArrayList<>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				guestVO vo =new guestVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				
				
				list.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
	}
	//조회수
	public void guestHits(int idx) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		String query = "update tbl_guest3 set readcnt = readcnt +1 where idx =?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
