package com.jslhrd.domain.pds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jslhrd.domain.admin.adminNoticeVO;
import com.jslhrd.util.DBManager;

public class PdsDAO {
	private PdsDAO() {}
	private static PdsDAO instance = new PdsDAO();
	public static PdsDAO getInstance() {
		return instance;
	}
	

	public List<PdsVO> PdsSelectMain(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select * from tbl_pds where rownum <= 3 order by idx desc";
		List<PdsVO> list = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PdsVO vo = new PdsVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setFilename(rs.getString("filename"));
				
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getClose(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public int pdsCount() {
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row=0;
		String query="select count(*) from tbl_pds";
		try {	
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				DBManager.getClose(conn, pstmt, rs);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		return row;
	}
	
	public int pdsSearchCount(String s_query) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row=0;
		String query="select count(*) from tbl_pds where "+ s_query;
		try {	
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				DBManager.getClose(conn, pstmt, rs);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		return row;
	}
	
	
	public List<PdsVO> pdsList(int startpage, int endpage) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<PdsVO> list = new ArrayList<>();
		String query ="select X.* from (select rownum as rnum, A.* from "
				+ " (select * from tbl_pds order by idx desc) A"
				+ " where rownum <= ? ) X where x.rnum >= ?";
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PdsVO vo =new PdsVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setFilename(rs.getString("filename"));
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
	
	public List<PdsVO> pdsSearch(String s_query,int startpage,int endpage){
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<PdsVO> list = new ArrayList<>();
		String query = "select X.* from (select rownum as rnum, A.* from "
				+ " (select * from tbl_pds order by idx desc) A"
				+ " where " + s_query + " and rownum <= ? ) X where " + s_query + " and X.rnum >= ?";
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PdsVO vo =new PdsVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setFilename(rs.getString("filename"));
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
	
	public int psdInsert(PdsVO vo) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		int row = 0;
		String query = "insert into tbl_pds(idx,name,pass,email,subject,contents,filename) " + 
				" values(tbl_pds_seq_idx.nextval,?,?,?,?,?,?)";
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getSubject());
			pstmt.setString(5, vo.getContents());
			pstmt.setString(6, vo.getFilename());
			row=pstmt.executeUpdate();
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
	
	public int pdsHits(int num) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		
		int row=0;
		
		String query ="update tbl_pds set readcnt=readcnt+1 where idx="+num;
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
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
	public PdsVO pdsVeiw(int num) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PdsVO vo = new PdsVO();
		int row=0;
		String query="select * from tbl_pds where idx="+num;
		try {	
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));	
				vo.setPass(rs.getString("pass"));
				vo.setEmail(rs.getString("email"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setFilename(rs.getString("filename"));
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				DBManager.getClose(conn, pstmt, rs);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	public int pdsModify(PdsVO vo) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		int row = 0;
		String query = "update tbl_pds set email=?,subject=?,contents=?,filename=? where idx=? and pass=?";
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getSubject());
			pstmt.setString(3, vo.getContents());
			pstmt.setString(4, vo.getFilename());
			pstmt.setInt(5, vo.getIdx());
			pstmt.setString(6, vo.getPass());
			
			row=pstmt.executeUpdate();
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
	
	public String getFile(int idx) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		String fn = "";
		String query = "select filename from tbl_pds where idx="+idx;
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				fn=rs.getString("filename");
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
		return fn;
	}
	
	public int pdsDelete(int idx,String pass) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		int row = 0;
		String query = "delete from tbl_pds where idx=? and  pass=?";
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.setString(2, pass);
			
			row=pstmt.executeUpdate();
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
}
