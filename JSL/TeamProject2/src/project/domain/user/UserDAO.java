package project.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
			if (rs.next()) {
				row = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
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
				vo.setUser_emailauth(rs.getInt("user_emailauth"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}

	// ID 찾기
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

	// 자기소개서 글쓰기
		public int userCoverLetterInsert(String subject, String contents, String set_private, int user_num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int row = 0;

			String sql = "insert into tb_cover_letter (cover_num, user_num, cover_subject, cover_contents, cover_private) values (tb_user_letter_seq_cover_num.nextval,?,?,?,?)";
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, user_num);
				pstmt.setString(2, subject);
				pstmt.setString(3, contents);
				pstmt.setString(4, set_private);
				row = pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return row;
		}

		// 자기소개서 전체 카운트
		public int userCoverLetterCount(int user_num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int row = 0;

			String query = "select count(*) from tb_cover_letter where user_num=?";

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, user_num);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					row = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return row;
		}

		// 자기소개서 리스트
		public List<UserCoverLetterVO2> userCoverLetterList(int startpage, int endpage, int user_num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<UserCoverLetterVO2> vo = new ArrayList<UserCoverLetterVO2>();
			UserCoverLetterVO2 ucvl = null;

			String query = "select X.* from (select rownum as rnum, A.* from (select * from tb_cover_letter order by cover_num desc) A where rownum<=? and user_num=?) X where rnum>=?";

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, endpage);
				pstmt.setInt(2, user_num);
				pstmt.setInt(3, startpage);

				rs = pstmt.executeQuery();
				while (rs.next()) {
					ucvl = new UserCoverLetterVO2();
					ucvl.setCover_num(rs.getInt("cover_num"));
					ucvl.setUser_num(rs.getInt("user_num"));
					ucvl.setCover_subject(rs.getString("cover_subject"));
					ucvl.setCover_contents(rs.getString("cover_contents"));
					ucvl.setCover_regidate(rs.getString("cover_regidate"));
					ucvl.setCover_modifydate(rs.getString("cover_modifydate"));
					ucvl.setCover_private(rs.getString("cover_private"));

					vo.add(ucvl);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return vo;
		}

		// 자기소개서 뷰
		public UserCoverLetterVO2 userCoverLetterView(int user_num, int cover_num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			UserCoverLetterVO2 ucvl = null;

			String query = "select * from tb_cover_letter where user_num=? and cover_num=?";

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, user_num);
				pstmt.setInt(2, cover_num);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					ucvl = new UserCoverLetterVO2();
					ucvl.setCover_num(rs.getInt("cover_num"));
					ucvl.setCover_subject(rs.getString("cover_subject"));
					ucvl.setCover_contents(rs.getString("cover_contents"));
					ucvl.setCover_regidate(rs.getString("cover_regidate"));
					ucvl.setCover_modifydate(rs.getString("cover_modifydate"));
					ucvl.setCover_private(rs.getString("cover_private"));

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return ucvl;
		}
		
		// 자기소개서 수정
		public int userCoverLetterModify(String subject, String contents, String set_private, int user_num, int cover_num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int row = 0;

			String sql = "update tb_cover_letter set cover_subject=?, cover_contents=?, cover_private=?, cover_modifydate=sysdate where user_num=? and cover_num=?";
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, subject);
				pstmt.setString(2, contents);
				pstmt.setString(3, set_private);
				pstmt.setInt(4, user_num);
				pstmt.setInt(5, cover_num);

				row = pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return row;
		}

		// 자기소개서 삭제
		public int userCoverLetterDelete(int user_num, int cover_num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int row = 0;

			String query = "delete from tb_cover_letter where user_num=? and cover_num=?";

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, user_num);
				pstmt.setInt(2, cover_num);
				row = pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return row;
		}

		// 자기소개서 공개전환
		public int userCoverLetterChange(int cover_num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int row = 0;

			String sql = "update tb_cover_letter set cover_private='T' where cover_num=?";
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cover_num);

				row = pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return row;
		}

		// 구직자이력서 등록
		public int userResumeInsert(UserResumeVO2 vo) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int row = 0;

			String sql = "insert into tb_user_resume (resume_num, user_num, resume_gender, resume_education, resume_tel, resume_picture_filename, resume_language, resume_foreign_language, resume_career, resume_file, resume_private, resume_address, resume_certification, cover_num ) values (tb_user_resume_seq_resume_num.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, vo.getUser_num());
				pstmt.setString(2, vo.getResume_gender());
				pstmt.setString(3, vo.getResume_education());
				pstmt.setString(4, vo.getResume_tel());
				pstmt.setString(5, vo.getResume_picture_filename());
				pstmt.setString(6, vo.getResume_language());
				pstmt.setString(7, vo.getResume_foreign_language());
				pstmt.setString(8, vo.getResume_career());
				pstmt.setString(9, vo.getResume_file());
				pstmt.setString(10, vo.getResume_private());
				pstmt.setString(11, vo.getResume_address());
				pstmt.setString(12, vo.getResume_certification());
				pstmt.setInt(13, vo.getCover_num());
				row = pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return row;
		}

		// 구직자이력서 리스트
		/*
		 * public List<UserResumeVo> userResumeList(int startpage, int endpage, int
		 * user_num) { Connection conn = null; PreparedStatement pstmt = null; ResultSet
		 * rs = null; List<UserResumeVo> vo = new ArrayList<UserResumeVo>();
		 * UserResumeVo ur = null;
		 * 
		 * String query =
		 * "select X.* from (select rownum as rnum, A.* from (select * from tb_user_resume order by resume_num desc) A where rownum<=? and user_num=?) X where rnum>=?"
		 * ;
		 * 
		 * try { conn = DBManager.getConnection(); pstmt = conn.prepareStatement(query);
		 * pstmt.setInt(1, endpage); pstmt.setInt(2, user_num); pstmt.setInt(3,
		 * startpage);
		 * 
		 * rs = pstmt.executeQuery(); while (rs.next()) { ur = new UserResumeVo();
		 * ur.setResume_num(rs.getInt("resume_num"));
		 * ur.setUser_num(rs.getInt("user_num"));
		 * ur.setResume_private(rs.getString("resume_private"));
		 * ur.setResume_readcnt(rs.getInt("resume_readcnt"));
		 * ur.setResume_regidate(rs.getString("resume_regidate"));
		 * ur.setResume_modifydate(rs.getString("resume_modifydate")); vo.add(ur); } }
		 * catch (Exception e) { e.printStackTrace(); } finally { DBManager.close(conn,
		 * pstmt, rs); } return vo; }
		 */
		// 구직자이력서 뷰
		public UserResumeVO2 userResumeView(int user_num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			UserResumeVO2 ur = null;

			String query = "select * from tb_user_resume where user_num=?";

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, user_num);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					ur = new UserResumeVO2();
					ur.setResume_num(rs.getInt("resume_num"));
					ur.setUser_num(rs.getInt("user_num"));
					ur.setResume_gender(rs.getString("resume_gender"));
					ur.setResume_education(rs.getString("resume_education"));
					ur.setResume_tel(rs.getString("resume_tel"));
					ur.setResume_picture_filename(rs.getString("resume_picture_filename"));
					ur.setResume_language(rs.getString("resume_language"));
					ur.setResume_foreign_language(rs.getString("resume_foreign_language"));
					ur.setResume_career(rs.getString("resume_career"));
					ur.setResume_file(rs.getString("resume_file"));
					ur.setResume_private(rs.getString("resume_private"));
					ur.setResume_readcnt(rs.getInt("resume_readcnt"));
					ur.setResume_regidate(rs.getString("resume_regidate"));
					ur.setResume_modifydate(rs.getString("resume_modifydate"));
					ur.setResume_address(rs.getString("resume_address"));
					ur.setResume_certification(rs.getString("resume_certification"));
					ur.setCover_num(rs.getInt("cover_num"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return ur;
		}

		// 구직자이력서 조회수
		public void userResumeReadcnt(int resume_num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int row = 0;

			String query = "update tb_user_resume set resume_readcnt=resume_readcnt+1 where resume_num=?";

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, resume_num);
				pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}

		// 구직자이력서 수정
		public int userResumeModify(UserResumeVO2 vo) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int row = 0;

			String sql = "update tb_user_resume set resume_gender=?, resume_education=?, resume_tel=?, resume_picture_filename=?, resume_language=?, resume_foreign_language=?, resume_career=?, resume_file=?, resume_private=?, resume_address=?, resume_certification=?, resume_modifydate=sysdate, cover_num=? where user_num=?";
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getResume_gender());
				pstmt.setString(2, vo.getResume_education());
				pstmt.setString(3, vo.getResume_tel());
				pstmt.setString(4, vo.getResume_picture_filename());
				pstmt.setString(5, vo.getResume_language());
				pstmt.setString(6, vo.getResume_foreign_language());
				pstmt.setString(7, vo.getResume_career());
				pstmt.setString(8, vo.getResume_file());
				pstmt.setString(9, vo.getResume_private());
				pstmt.setString(10, vo.getResume_address());
				pstmt.setString(11, vo.getResume_certification());
				pstmt.setInt(12, vo.getCover_num());
				pstmt.setInt(13, vo.getUser_num());
				
				row = pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return row;
		}

		// 구직자이력서 작성 카운트
		public int userResumeCount(int user_num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int row = 0;

			String query = "select * from tb_user_resume where resume_private='T' and user_num=?";

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, user_num);
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
	//유저포트폴리오 작성
	public int userWritePort(UserPortVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String sql = "insert into tb_portfolio (port_num, user_num, port_filename , port_link) values (TB_PORTFOLIO_SEQ_PORT_NUM.nextval,?,?,?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,vo.getUser_num());
			pstmt.setString(2, vo.getPort_filename());
			pstmt.setString(3, vo.getPort_link());
			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	//내 포트폴리오 리스트 불러오기
	public List<UserPortVO> userPortList(int usernum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserPortVO> list = new ArrayList<UserPortVO>();

		String sql = "select * from tb_portfolio where user_num = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, usernum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserPortVO vo = new UserPortVO();
				vo.setPort_num(rs.getInt("port_num"));
				vo.setPort_readcnt(rs.getInt("port_readcnt"));
				vo.setPort_private(rs.getString("port_private"));
				vo.setPort_regidate(rs.getString("port_regidate"));
				vo.setPort_filename(rs.getString("port_filename"));
				list.add(vo);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	//내 포트폴리오 개수
	public int userPortCount(int usernum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String sql = "select count(*) from tb_portfolio where user_num = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, usernum);
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

	public UserPortVO userPortSelect(int portnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		UserPortVO vo = new UserPortVO();

		String sql = "select * from tb_portfolio where port_num = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, portnum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setPort_filename(rs.getString("port_filename"));
				vo.setPort_link(rs.getString("port_link"));
				vo.setPort_num(portnum);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}
	public int userPortModify(UserPortVO vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String query = "update tb_portfolio set port_link= ? , port_filename = ?, port_private = ? , port_modifydate = sysdate where port_num = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getPort_link());
			pstmt.setString(2, vo.getPort_filename());
			pstmt.setString(3, vo.getPort_private());
			pstmt.setInt(4, vo.getPort_num());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	public int userPortDelete(int portnum) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String query = "delete from tb_portfolio where port_num = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, portnum);

			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	public int userModify(UserVO vo) {
		Connection conn = null;
		Connection conn2 = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		int row = 0;

		String sql = "select user_pass from tb_user where user_id =?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUser_id());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String pass = rs.getString("user_pass");
				if (pass.equals(vo.getUser_pass())) {
					sql = "update tb_user set user_pass = ?, user_tel = ? where user_id = ? and user_pass = ?";
					conn2 = DBManager.getConnection();
					pstmt2 = conn.prepareStatement(sql);
					pstmt2.setString(1, vo.getUser_newpass());
					pstmt2.setString(2, vo.getUser_tel());
					pstmt2.setString(3, vo.getUser_id());
					pstmt2.setString(4, vo.getUser_pass());
					row = pstmt2.executeUpdate();
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
	//delete\
	public int userDelete(String userid, String userpass) {
		Connection conn = null;
		Connection conn2 = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		int row = 0;

		String sql = "select user_pass from tb_user where user_id =?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String pass = rs.getString("user_pass");
				if (pass.equals(userpass)) {
					sql = "delete from tb_user where user_id = ?";
					conn2 = DBManager.getConnection();
					pstmt2 = conn.prepareStatement(sql);
					pstmt2.setString(1, userid);
					row = pstmt2.executeUpdate();
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
}
