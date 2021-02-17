package exSample.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import exSample.util.DBManager;

public class UserDAO {
	private UserDAO() {}
	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance() {
		return instance;
	}
	
	public int UserIdCheck(String id) {
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		
		int row = 0;
		String query = "select count(*) from tbl_users where userid = ? ";
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
			DBManager.getClose(conn, pstmt,rs);
		}
		return row;
	}
	

	public int UserIdCheck(String id,String pass) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		
		int row = 0;
		String query = "select passwd from tbl_users where userid=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dbpass = rs.getString("passwd");
				if(dbpass.equals(pass)) {
					row =1 ;
					
					query="update tbl_users set last_time = sysdate where userid=?";
					pstmt=conn.prepareStatement(query);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					
				} else {
					row =0;
				}
			} else {
				row = -1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getClose(conn, pstmt,rs);
		}
		return row;
	}
	
	public int UserInsert(UserVO vo) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		
		
		int row = 0;
		String query = "insert into tbl_users(name,userid,passwd,tel,email) "
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
			DBManager.getClose(conn, pstmt);
		}
		return row;
		
	}
	
	public UserVO UserSelect(String id) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		UserVO vo =new UserVO();
		
		int row = 0;
		String query = "select * from tbl_users where userid =?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setUserid(rs.getString("userid"));
				vo.setEmail(rs.getString("email"));
				vo.setTel(rs.getString("tel"));
				vo.setFirst_time(rs.getString("first_time"));
				vo.setLast_time(rs.getString("Last_time"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getClose(conn, pstmt);
		}
		return vo;
	}
	
	
	public int UserModify(String beforepw,String passwd,String userid) {
		Connection conn =null;
		PreparedStatement pstmt = null;
	
		int row = 0;
		String query = "update tbl_users set passwd=? where userid=? and passwd=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, passwd);
			pstmt.setString(2, userid);
			pstmt.setString(3, beforepw);
			row = pstmt.executeUpdate();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.getClose(conn, pstmt);
		}
		return row;
	}
}
