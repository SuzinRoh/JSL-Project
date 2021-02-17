package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class boardDAO {
	
	//
	private boardDAO() {}
	private static boardDAO instance = new boardDAO();
	public static boardDAO getInstance() {
		return instance;
	}
	//
	
	private static Connection getConnection() {
		String myDriver = "oracle.jdbc.driver.OracleDriver";
		String myURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String myID = "jslhrd46";
		String myPass = "1234";
		Connection conn = null;
		try{
			Class.forName(myDriver);
			conn = DriverManager.getConnection(myURL,myID,myPass);
			//System.out.println("성공");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("error");
		}
		return conn;
	}
	
	//메소드 정e
	public int boardWrite(boardVO vo) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		
		
		String query="insert into tbl_board(idx,pass,name,email,subject,contents,ip) "
					+" values(tbl_board_seq_idx.nextval,?,?,?,?,?,?)";
		int row = 0;//return type
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getPass());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getSubject());
			pstmt.setString(5, vo.getContents());
			pstmt.setString(6, vo.getIp());
			
			row = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn !=null)conn.close();
				if(pstmt !=null)pstmt.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return row;
	}
	
	
	public int boardCount() {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		String query = "select count(*) from tbl_board ";
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
				if(conn !=null)conn.close();
				if(pstmt !=null)pstmt.close();
				if(rs !=null)rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return row;
	}
	public List<boardVO> boardList() {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<boardVO> list = new ArrayList<>();
		String query = "select * from tbl_board order by idx desc";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				boardVO vo =new boardVO();
				vo.setIdx(rs.getInt("idx"));//고유번
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
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn !=null)conn.close();
				if(pstmt !=null)pstmt.close();
				if(rs !=null)rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<boardVO> boardList(int startpage,int endpage) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		List<boardVO> list = new ArrayList<>();
		String query = "select X.* from (select rownum as rnum, A.* from"
				+ "(select * from tbl_board order by idx desc) A "
				+ "where rownum <=? ) X where X.rnum >= ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				boardVO vo =new boardVO();
				vo.setIdx(rs.getInt("idx"));//고유번
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
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn !=null)conn.close();
				if(pstmt !=null)pstmt.close();
				if(rs !=null)rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public boardVO boardSelect(int idx) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		String query = "select * from tbl_board where idx ="+idx;
		boardVO vo =new boardVO();
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				vo.setIdx(rs.getInt("idx"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setIp(rs.getString("ip"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn !=null)conn.close();
				if(pstmt !=null)pstmt.close();
				if(rs !=null)rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return vo;
	}
	public int boardSearchcnt(String search,String key) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		String query = "select count(*) from tbl_board where "+search+" like '%"+key+"%' ";
		int row =0;
		
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
				if(conn !=null)conn.close();
				if(pstmt !=null)pstmt.close();
				if(rs !=null)rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return row;
	}
	
	public List<boardVO> boardSearch(String search,String key) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		List<boardVO> list =new ArrayList<>();
		
		String query = "select * from tbl_board where "+search+" like '%"+key+"%' order by idx desc";
		
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				boardVO vo =new boardVO();
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
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn !=null)conn.close();
				if(pstmt !=null)pstmt.close();
				if(rs !=null)rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public void updateCount(int idx) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		
		String query = "update tbl_board set readcnt = readcnt+1 where idx ="+idx;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn !=null)conn.close();
				if(pstmt !=null)pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public int boardEdit(int idx,String subject,String email,String contents,String pass) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		
		String query = "update tbl_board set subject=?, email=?, contents=? "
						+ "where idx=? and pass=?";
		int row = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, subject);
			pstmt.setString(2, email);
			pstmt.setString(3, contents);
			pstmt.setInt(4, idx);
			pstmt.setString(5, pass);
			row = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn !=null)conn.close();
				if(pstmt !=null)pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return row;
	}
	
	public int boardDelete(int idx,String pass) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		
		String query = "delete from tbl_board where idx=? and pass =? ";
		int row = 0;
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
				if(conn !=null)conn.close();
				if(pstmt !=null)pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return row;
	}
	
	//검색 조건 포함페이지별 목록 메소드
	public List<boardVO> boardList(String search,String key,int startpage,int endpage) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<boardVO> list = new ArrayList<>();
		
		//select * from tbl_board where "+search+" like '%"+key+"%' order by idx desc
		String query = "select X.* from (select rownum as rnum, A.* from "
				+ "(select * from tbl_board order by idx desc) A "
				+ " where "+search+" like '%"+key+"%' and rownum <=? ) X "
				+" where "+search+" like '%"+key+"%' and X.rnum >= ? ";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				boardVO vo =new boardVO();
				vo.setIdx(rs.getInt("idx"));//고유번
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
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn !=null)conn.close();
				if(pstmt !=null)pstmt.close();
				if(rs !=null)rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	
}
