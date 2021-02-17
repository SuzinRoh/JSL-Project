package com.jslhrd.domain.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jslhrd.domain.board.BoardVO;
import com.jslhrd.util.DBManager;



public class adminNoticeDAO {
	private adminNoticeDAO(){}
	private static adminNoticeDAO instance = new adminNoticeDAO();
	public static adminNoticeDAO getInstance() {
		return instance;
	}
	
	public List<adminNoticeVO> adminNoticeSelectMain(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select * from tbl_notice where rownum <= 3 order by idx desc";
		List<adminNoticeVO> list = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				adminNoticeVO vo = new adminNoticeVO();
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
			DBManager.getClose(conn, pstmt, rs);
		}
		
		return list;
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
	
	public List<adminNoticeVO> NoticeList(int startpage, int endpage) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<adminNoticeVO> list = new ArrayList<>();
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
				adminNoticeVO vo =new adminNoticeVO();
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
	
	public List<adminNoticeVO> NoticeSearch(String s_query,int startpage,int endpage) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<adminNoticeVO> list = new ArrayList<>();
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
				adminNoticeVO vo =new adminNoticeVO();
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
	
	public int noticeWrite(adminNoticeVO vo) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		int row = 0;
		String query = "insert into tbl_notice(idx,subject,contents,pass) "
				+ " values(tbl_notice_seq_idx.nextval,?,?,?)";
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getContents());
			pstmt.setString(3, vo.getPass());
			row = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.getClose(conn, pstmt);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} 
		return row;
	}
	
	public adminNoticeVO noticeSelect(int idx) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		adminNoticeVO vo =new adminNoticeVO();
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
	
	public int NoticeModify(String sub,String con, int idx,String pass) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		int row = 0;
		String query ="update tbl_notice set subject=?,contents=? where idx=? and pass=?";
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1,sub);
			pstmt.setString(2, con);
			pstmt.setInt(3, idx);
			pstmt.setString(4, pass);
			pstmt.executeUpdate();
			row = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.getClose(conn, pstmt);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row ;
	}

}
