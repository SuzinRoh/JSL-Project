package exUserServletJSTL.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import exUserServletJSTL.util.DBManager;

public class UserDAO {
	private UserDAO() {}
	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance() {
		return instance;
	}
	
	public int UserInsert(UserVO vo) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		
		int row = 0;
		String query = "insert into tbl_users_sec(name,userid,passwd,tel,email) "
				+ " values(?,?,?,?,?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getPasswd());
			pstmt.setString(4, vo.getTel());
			pstmt.setString(5, vo.getEmail());
			
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.getClose(conn, pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return row;
	}
	
	
	public UserVO UserSelect(String id) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		UserVO vo = null;
		String query = "select * from tbl_users_sec where userid=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new UserVO();
				vo.setName(rs.getString("name"));
				vo.setUserid(rs.getString("userid"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setTel(rs.getString("tel"));
				vo.setEmail(rs.getString("email"));
				vo.setFirst_time(rs.getString("first_time"));
				vo.setLast_time(rs.getString("last_time"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.getClose(conn, pstmt ,rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return vo;
	}
	
	public int UserIdCheck(String id) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		int row = 0;
		String query = "select count(*) from tbl_users_sec where userid=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				row = rs.getInt(1);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.getClose(conn, pstmt ,rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	public int UserIdCheck(String id,String pass) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		int row = 0;
		String query = "select passwd from tbl_users_sec where userid=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dbpass = rs.getString("passwd");
				if(dbpass.equals(pass)) {
					row=1;
					
					query="update tbl_users_sec set last_time = sysdate where userid=?";
					pstmt=conn.prepareStatement(query);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					
				}else {
					row=0; //비밀번호오류
				}
			} else {
				row = -1;//존재하지않음
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.getClose(conn, pstmt ,rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	public int UserModify(String id,String pw) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		
		int row = 0 ;
		String query = "update tbl_users_sec set passwd=? where userid=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			row = pstmt.executeUpdate();

			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.getClose(conn, pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return row;
	}
	
} 
