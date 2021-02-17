package com.jslhrd.domain.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jslhrd.domain.board.BoardVO;
import com.jslhrd.util.DBManager;



public class NoticeDAO {
	private NoticeDAO(){}
	private static NoticeDAO instance = new NoticeDAO();
	public static NoticeDAO getInstance() {
		return instance;
	}
	
	
	
	public int NoticeSearchCount(String s_query) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		int row=0;
		
		String query ="select count(*) from tbl_notice where "+ s_query;
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
	
	public int NoticeListCount() {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		int row=0;
		
		String query ="select count(*) from tbl_notice";
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
	
	public List<NoticeVO> NoticeList(int startpage, int endpage) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<NoticeVO> list = new ArrayList<>();
		String query ="select X.* from (select rownum as rnum, A.* from "
				+ " (select * from tbl_notice order by idx desc) A"
				+ " where rownum <= ? ) X where x.rnum >= ?";
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeVO vo =new NoticeVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setReadcnt(rs.getInt("readcnt"));
				
				list.add(vo);
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
		return list;
	}
	
	public List<NoticeVO> NoticeSearch(String s_query,int startpage,int endpage) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<NoticeVO> list = new ArrayList<>();
		String query = "select X.* from (select rownum as rnum, A.* from "
				+ " (select * from tbl_notice order by idx desc) A"
				+ " where " + s_query + " and rownum <= ? ) X where " + s_query + " and X.rnum >= ?";
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeVO vo =new NoticeVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setReadcnt(rs.getInt("readcnt"));
				list.add(vo);
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
		return list;
	}
	
	
	public NoticeVO noticeSelect(int idx) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		NoticeVO vo =new NoticeVO();
		String query = "select * from tbl_notice where idx="+idx;
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setReadcnt(rs.getInt("readcnt"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.getClose(conn, pstmt,rs);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} 
		return vo;
	}
	
	public void NoticeHits(int idx) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		
		String query ="update tbl_notice set readcnt = readcnt+1 where idx="+idx;
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.getClose(conn, pstmt);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
