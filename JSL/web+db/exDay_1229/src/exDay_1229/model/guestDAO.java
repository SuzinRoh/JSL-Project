package exDay_1229.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class guestDAO {
	private guestDAO() {}
	private static guestDAO instance = new guestDAO();
	public static guestDAO getInstance() {
		return instance;
	}
	
	
	
	//방명록 전체 게시글 총수
	public int guestCount() {
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		//리턴타입 정의 
		int row =0;
		
		//query 정
		String query="select count(*) from tbl_guest";
		
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return row;
	}
	//검색조건에 맞는 방명록 전체게시글 총수를 구하는 메소드 
	public int guestCount(String s_query) {//String search,String key
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		//리턴타입 정의 
		int row =0;
		
		//query 정의
		String query="select count(*) from tbl_guest where" + s_query;
		
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return row;
	}
	// 방명록 전체 게시글 목록를 구하는 메소드(페이지처리 없음)
	public List<GuestDTO> guestList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//리턴타입 정의	
		List<GuestDTO> list = new ArrayList<>();
		//query 정의
		String query="select * from tbl_guest order by idx desc";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GuestDTO guest = new GuestDTO();
				guest.setIdx(rs.getInt("idx"));
				guest.setName(rs.getString("name"));
				guest.setSubject(rs.getString("subject"));
				guest.setRegdate(rs.getString("regdate"));
				guest.setReadcnt(rs.getInt("readcnt"));
				
				list.add(guest);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		// 리턴타입이 있을 경우
		return list;
	}
	//검색조건에 맞는 방명록 전체게시글 총수를 구하는 메소드 (페이지 처리,검색이 없을때)
	public List<GuestDTO> guestList(int startpage,int endpage) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		List<GuestDTO> list =new ArrayList<>();
		
		String query = "select X.* from (select rownum as rnum, A.* from "
				+ " (select * from tbl_guest order by idx desc) A"
				+ " where rownum <= ? ) X where x.rnum >= ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GuestDTO guest = new GuestDTO();
				guest.setIdx(rs.getInt("idx"));
				guest.setName(rs.getString("name"));
				guest.setSubject(rs.getString("subject"));
				guest.setRegdate(rs.getString("regdate"));
				guest.setReadcnt(rs.getInt("readcnt"));
				
				list.add(guest);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBManager.close(conn, pstmt, rs);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
	}

	//검색조건에 맞는 방명록 전체게시글 총수를 구하는 메소드 (페이지 처리,검색이 있을떄)
	public List<GuestDTO> guestList(String s_query,int startpage,int endpage) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		List<GuestDTO> list =new ArrayList<>();
		
		String query = "select X.* from (select rownum as rnum, A.* from "
				+ " (select * from tbl_guest order by idx desc) A"
				+ " where " + s_query + " and rownum <= ? ) X where " + s_query + " and X.rnum >= ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GuestDTO guest = new GuestDTO();
				guest.setIdx(rs.getInt("idx"));
				guest.setName(rs.getString("name"));
				guest.setSubject(rs.getString("subject"));
				guest.setRegdate(rs.getString("regdate"));
				guest.setReadcnt(rs.getInt("readcnt"));
				
				list.add(guest);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBManager.close(conn, pstmt, rs);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	
	public int guestWrite(GuestDTO guest) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		int row =0;
		
		
		String query="insert into tbl_guest(idx,name,pass,subject,contents)"
				+ "	values(tbl_guest_seq_idx.nextval,?,?,?,?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, guest.getName());
			pstmt.setString(2, guest.getPass());
			pstmt.setString(3, guest.getSubject());
			pstmt.setString(4, guest.getContents());
			
			row = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return row;
	}
	
	//특정글 조회수 증가
	public void guestHits(int idx) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		String query="update tbl_guest set readcnt = readcnt+1 where idx=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
	}
	
	//특정 게시글을 구하는 메소드
		public GuestDTO guestSelect(int idx) {
			Connection conn =null;
			PreparedStatement pstmt =null;
			ResultSet rs = null;
			
			GuestDTO guest =new GuestDTO();
			
			String query = "select * from tbl_guest where idx =?";
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, idx);
				
				rs = pstmt.executeQuery();
				if(rs.next()) {
			
					guest.setIdx(rs.getInt("idx"));
					guest.setName(rs.getString("name"));
					guest.setSubject(rs.getString("subject"));
					guest.setContents(rs.getString("contents"));
					guest.setRegdate(rs.getString("regdate"));
					guest.setReadcnt(rs.getInt("readcnt"));
					
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					DBManager.close(conn, pstmt, rs);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			return guest;
		}
		
		
		public int guestModify(GuestDTO guest) {
			Connection conn =null;
			PreparedStatement pstmt = null;
			ResultSet rs =null;
			
			int row =0;
			
			
			String query="update tbl_guest set subject=?,contents=? where idx=? and pass=?";
			
			try {
				conn = DBManager.getConnection();
				pstmt =conn.prepareStatement(query);
				pstmt.setString(1, guest.getSubject());
				pstmt.setString(2, guest.getContents());
				pstmt.setInt(3, guest.getIdx());
				pstmt.setString(4, guest.getPass());
				
				row = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			
			return row;
		}
		
		public int guestDelete(int idx, String pass) {
			Connection conn =null;
			PreparedStatement pstmt = null;
			ResultSet rs =null;
			
			int row =0;
			
			
			String query="delete from tbl_guest where idx=? and pass=?";
			
			try {
				conn = DBManager.getConnection();
				pstmt =conn.prepareStatement(query);
				pstmt.setInt(1, idx);
				pstmt.setString(2, pass);
				
				row = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			
			return row;
		}
		
		
}
