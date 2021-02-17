package exBoard_Servlet_JSP.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import exBoard_Servlet_JSP.util.DBManager;

public class BoardDAO {
	private BoardDAO () {}
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	
	public int BoardListCount() {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		int row=0;
		
		String query ="select count(*) from tbl_board";
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
	
	public int BoardHits(int idx) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		int row=0;
		
		String query ="update tbl_board set readcnt=readcnt+1 where idx="+idx;
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
	
	
	public BoardVO BoardList(int idx) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		BoardVO vo =new BoardVO();
		
		String query ="select * from tbl_board where idx="+idx;
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setIp(rs.getString("ip"));
				
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
		return vo;
	}
	
	public List<BoardVO> BoardList(int startpage, int endpage) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<BoardVO> list = new ArrayList<>();
		String query ="select X.* from (select rownum as rnum, A.* from "
				+ " (select * from tbl_board order by idx desc) A"
				+ " where rownum <= ? ) X where x.rnum >= ?";
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo =new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setIp(rs.getString("ip"));
				
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
	
	
	public int BoardSearchCount(String s_query) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		int row=0;
		
		String query ="select count(*) from tbl_board where "+ s_query;
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
	
	
	public List<BoardVO> BoardSearch(String s_query,int startpage,int endpage) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<BoardVO> list = new ArrayList<>();
		String query = "select X.* from (select rownum as rnum, A.* from "
				+ " (select * from tbl_board order by idx desc) A"
				+ " where " + s_query + " and rownum <= ? ) X where " + s_query + " and X.rnum >= ?";
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo =new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setIp(rs.getString("ip"));
				
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
	
	public int BoardWrite(BoardVO vo) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		String query = "insert into tbl_board(idx,pass,name,email,subject,contents,ip) "
					+ " values(tbl_board_seq_idx.nextval,?,?,?,?,?,?)";
		int row= 0;
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, vo.getPass());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getSubject());
			pstmt.setString(5, vo.getContents());
			pstmt.setString(6, vo.getIp());
			
			row =pstmt.executeUpdate();
			
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
	
	public int BoardEdit(BoardVO vo) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		int row = 0;
		
		String query = "update tbl_board set email =?, subject = ?"
						+" , contents =? where idx =? and pass =?";
	
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getSubject());
			pstmt.setString(3, vo.getContents());
			pstmt.setInt(4, vo.getIdx());
			pstmt.setString(5, vo.getPass());
			
			row =pstmt.executeUpdate();
			
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
	
	
	public int BoardDelete(int idx) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		
		int row=0;
		
		String query ="delete from tbl_board where idx="+idx;
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

}
