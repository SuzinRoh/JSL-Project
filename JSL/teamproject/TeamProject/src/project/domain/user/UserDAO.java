package project.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import project.util.DBManager;

public class UserDAO {
	private static UserDAO instance = new UserDAO();

	public static UserDAO getInstance() {
		return instance;
	}
	
	public int userInsert(UserVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String sql = "insert into tb_user (user_num, user_name, user_email, user_pass, user_id, user_regidate, user_tel) values (TB_USER_SEQ_USER_NUM.nextval,?,?,?,?,sysdate,?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUser_name());
			pstmt.setString(2, vo.getUser_email());
			pstmt.setString(3, vo.getUser_pass());
			pstmt.setString(4, vo.getUser_id());
			pstmt.setString(5, vo.getUser_tel());
			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	
	public int userIdcheck(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String sql = "select count(*) from tb_user where user_id = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	
	// 로그인
		public int userLogin(String userid, String passwd) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int row = 0;

			String query = "select user_pass from tb_user where user_id=?";
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userid);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					String pass = rs.getString("user_pass");
					if (pass.equals(passwd)) {
						query = "update tb_user set user_lastlogin=sysdate where user_id=? and user_pass=?";
						conn = DBManager.getConnection();
						pstmt = conn.prepareStatement(query);
						pstmt.setString(1, userid);
						pstmt.setString(2, passwd);
						row = pstmt.executeUpdate();
					} else {
						row = 0;
					}
				} else {
					row = -1;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return row;
		}

		// 유저정보
		public UserVO userSelect(String userid) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			UserVO vo = new UserVO();
			int row = 0;

			String query = "select * from tb_user where user_id=?";
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userid);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					vo.setUser_num(rs.getInt("user_num"));
					vo.setUser_name(rs.getString("user_name"));
					vo.setUser_id(rs.getString("user_id"));
					vo.setUser_email(rs.getString("user_email"));
					vo.setUser_tel(rs.getString("user_tel"));
					vo.setUser_regidate(rs.getString("user_regidate"));
					vo.setUser_lastlogin(rs.getString("user_lastlogin"));
					vo.setUser_email(rs.getString("user_email"));
					vo.setUser_emailauth(rs.getInt("user_emailauth"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return vo;
		}

		// ID찾기
		public String userSearchId(String name, String email) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int row = 0;
			String userid = null;

			String query = "select user_id from tb_user where user_name=? and user_email=?";
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, name);
				pstmt.setString(2, email);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					userid = rs.getString("user_id");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return userid;
		}
		
		public void userEmailAuth(String userid) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int row = 0;

			String sql = "update tb_user set user_emailauth = 1 where user_id = ?";
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userid);
				pstmt.executeQuery();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			
		}
		
		// 비밀번호 찾기
		public int userFoundPass(String userid, String email) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int row = 0;

			String query = "select * from tb_user where user_id=? and user_email=?";
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userid);
				pstmt.setString(2, email);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					row = 1;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return row;
		}

		// 비밀번호 임시설정
		public int userPassUpdate(String userid, String email, String tempSha256) {

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int row = 0;

			String query = "update tb_user set user_pass=? where user_email=? and user_id=?";
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, tempSha256);
				pstmt.setString(2, email);
				pstmt.setString(3, userid);
				row = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return row;
		}
	
}
