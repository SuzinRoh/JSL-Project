package com.jslhrd.domain.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jslhrd.util.DBManager;

public class GuestDAO {
	private GuestDAO() {}
	private static GuestDAO instance = new GuestDAO();
	public static GuestDAO getInstance() {
		return instance;
	}
	
	public List<GuestVO> GuestSelectMain() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query ="select * from tbl_guest where rownum <= 3 order by idx desc";
		List<GuestVO> list = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GuestVO vo = new GuestVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getClose(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<GuestVO> GuestSelect() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query ="select * from tbl_guest order by idx desc";
		List<GuestVO> list = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GuestVO vo = new GuestVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getClose(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<GuestVO> GuestSelect(int startpage, int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query ="select X.* from (select rownum as rnum, A.* from "
				+ " (select * from tbl_guest order by idx desc) A"
				+ " where rownum <= ? ) X where x.rnum >= ?";
		
		List<GuestVO> list = new ArrayList<>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GuestVO vo = new GuestVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getClose(conn, pstmt, rs);
		}
		return list;
	}
	
	
	public int GuestSearchCount(String searchQuery) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query ="select count(*) from tbl_guest " + searchQuery;
		int row = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getClose(conn, pstmt, rs);
		}
		return row;
	}
	
	public List<GuestVO> GuestSearch(String s_query,int startpage,int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select X.* from (select rownum as rnum, A.* from "
				+ " (select * from tbl_guest order by idx desc) A"
				+ " where " + s_query + " and rownum <= ? ) X where " + s_query + " and X.rnum >= ?";
		
		List<GuestVO> list = new ArrayList<>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GuestVO vo = new GuestVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getClose(conn, pstmt, rs);
		}
		return list;
	}
	
	public int GuestListCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query ="select count(*) from tbl_guest ";
		int row = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getClose(conn, pstmt, rs);
		}
		return row;
	}
	
	public GuestVO GuestView(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		GuestVO vo = new GuestVO();
		
		String query ="select * from tbl_guest where idx=" +idx;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getClose(conn, pstmt, rs);
		}
		return vo;
	}
	
	public int GuestHits(int idx) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		int row=0;
		
		String query ="update tbl_guest set readcnt=readcnt+1 where idx="+idx;
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.getClose(conn, pstmt, rs);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	public int GuestInsert(GuestVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		String query ="insert into tbl_guest(idx,name,subject,contents,pass) "
				+ " values(tbl_guest_seq_idx.nextval,?,?,?,?)";
		int row = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getSubject());
			pstmt.setString(3, vo.getContents());
			pstmt.setString(4, vo.getPass());
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getClose(conn, pstmt);
		}
		return row;
	}
	
	public int GuestModify(GuestVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		String query ="update tbl_guest set subject = ? ,contents = ? where idx = ? and pass = ? ";
		int row = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getContents());
			pstmt.setInt(3, vo.getIdx());
			pstmt.setString(4, vo.getPass());
			
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getClose(conn, pstmt);
		}
		return row;
	}
	
	public int GuestDelete(String pass,int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		String query ="delete from tbl_guest where idx = ? and pass = ? ";
		int row = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.setString(2, pass);
			
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getClose(conn, pstmt);
		}
		return row;
	}
}
