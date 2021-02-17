package exSample.model.Board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import exSample.model.Guest.GuestVO;
import exSample.util.DBManager;

public class BoardDAO {
	private BoardDAO() {}
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	
	public List<BoardVO> BoardSelectMain(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select * from tbl_board where rownum <= 3 order by idx desc";
		List<BoardVO> list = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
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
	
	public int BoardSearchCount(String searchQuery) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query ="select count(*) from tbl_board " + searchQuery;
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
	
	public int BoardListCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query ="select count(*) from tbl_board ";
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
	
	public List<BoardVO> BoardSelect(int startpage, int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query ="select X.* from (select rownum as rnum, A.* from "
				+ " (select * from tbl_board order by idx desc) A"
				+ " where rownum <= ? ) X where x.rnum >= ?";
		
		List<BoardVO> list = new ArrayList<>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setPass(rs.getString("pass"));
				vo.setEmail(rs.getString("email"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setIp(rs.getString("ip"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getClose(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<BoardVO> BoardSearch(String s_query,int startpage,int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select X.* from (select rownum as rnum, A.* from "
				+ " (select * from tbl_board order by idx desc) A"
				+ " where " + s_query + " and rownum <= ? ) X where " + s_query + " and X.rnum >= ?";
		
		List<BoardVO> list = new ArrayList<>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setPass(rs.getString("pass"));
				vo.setEmail(rs.getString("email"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setIp(rs.getString("ip"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getClose(conn, pstmt, rs);
		}
		return list;
	}
}
