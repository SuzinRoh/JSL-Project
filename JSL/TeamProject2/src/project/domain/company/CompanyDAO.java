package project.domain.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.domain.job_opening.Job_openingVO;
import project.domain.user.UserCoverLetterVO2;
import project.domain.user.UserResumeVO2;
import project.domain.user.UserVO;
import project.util.DBManager;

public class CompanyDAO {
	private CompanyDAO() {
	}

	private static CompanyDAO instance = new CompanyDAO();

	public static CompanyDAO getInstanceof() {
		return instance;
	}

	public int CompanyLogin(String com_id, String com_pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int row = 0;

		String query = "select com_pass from tb_company where com_id = ? ";
		try {
			// conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, com_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String dbpass = rs.getString("com_pass");
				if (dbpass.equals(com_pass)) {
					query = "select com_confirmed from tb_company where com_id = ?";
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, com_id);
					rs = pstmt.executeQuery();
					rs.next();
					if (rs.getString(1).equals("T")) {
						row = 1;// 비밀번호가 같고 관리자에게 승인을 받았다면 (로그인성공)
					} else {
						row = 2; // 비밀번호가 같지만 관리자에게 승인을 받지 못했다면
					}

				} else {
					row = 0;// 비밀번호가 틀리다면
				}
			} else {
				row = -1; // id가 존재하지 않으면
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	public String idSearch(String com_email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String id = "";

		String query = "select com_email from tb_company where com_email = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, com_email);
			rs = pstmt.executeQuery();
			rs.next();
			id = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return id;
	}

	public CompanyVO companyInfo(String com_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		CompanyVO vo = null;

		String query = "select * from tb_company where com_id = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, com_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new CompanyVO();
				vo.setCom_num(rs.getInt("com_num"));
				vo.setCom_name(rs.getString("com_name"));
				vo.setCom_empnum(rs.getInt("com_empnum"));
				vo.setCom_tel(rs.getString("com_tel"));
				vo.setCom_info(rs.getString("com_info"));
				vo.setCom_webpage(rs.getString("com_webpage"));
				vo.setCom_confirmed(rs.getString("com_confirmed"));
				vo.setCom_working_field(rs.getString("com_working_field"));
				vo.setCom_published_date(rs.getString("com_published_date"));
				vo.setCom_ceo(rs.getString("com_ceo"));
				vo.setCom_capital(rs.getInt("com_capital"));
				vo.setCom_location(rs.getString("com_location"));
				vo.setCom_postnum(rs.getString("com_postnum"));
				vo.setCom_sales(rs.getInt("com_sales"));
				vo.setCom_email(rs.getString("com_email"));
				vo.setCom_image_filename(rs.getString("com_image_filename"));
				vo.setCom_id(rs.getString("com_id"));
				vo.setCom_pass(rs.getString("com_pass"));
				vo.setCom_emailauth(rs.getInt("com_emailauth"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}

	public String companyIdfound(String com_name, String com_email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String id = "";

		String query = "select com_id from tb_company where com_name = ? and com_email = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, com_name);
			pstmt.setString(2, com_email);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				id = rs.getString("1");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return id;
	}

	// 아이디와 메일이 동일한지 확인
	public int CompanyPassFound(String com_id, String com_email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int row = 0;

		String query = "select * from tb_company where com_id = ? and com_email = ? ";
		try {
			// conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, com_id);
			pstmt.setString(2, com_email);
			rs = pstmt.executeQuery();
			rs.next();
			row = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	// 암호화된새로운비밀번호등록
	public int CompanyPassUpdate(String com_id, String com_email, String tempShaPass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int row = 0;

		String query = "update tb_company set com_pass = ? where com_id = ? and com_email = ?";
		try {
			// conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, tempShaPass);
			pstmt.setString(2, com_id);
			pstmt.setString(3, com_email);
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	public int insertCompany(CompanyVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "insert into tb_company(com_num,com_name,com_empnum,com_tel,com_info,"
				+ "com_webpage,com_working_field,com_published_date,"
				+ "com_ceo,com_capital,com_location,com_postnum,com_sales,com_email,"
				+ "com_image_filename,com_id,com_pass)" + "values(tb_company_seq_com_num.nextval,"
				+ "?,?,?,?,?,?,to_date(?,'YYYYMMDD'),?,?,?,?,?,?,?,?,?)";
		int row = 0;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getCom_name());
			pstmt.setInt(2, vo.getCom_empnum());
			pstmt.setString(3, vo.getCom_tel());
			pstmt.setString(4, vo.getCom_info());
			pstmt.setString(5, vo.getCom_webpage());
			pstmt.setString(6, vo.getCom_working_field());
			pstmt.setString(7, vo.getCom_published_date());
			pstmt.setString(8, vo.getCom_ceo());
			pstmt.setInt(9, vo.getCom_capital());
			pstmt.setString(10, vo.getCom_location());
			pstmt.setString(11, vo.getCom_postnum());
			pstmt.setInt(12, vo.getCom_sales());
			pstmt.setString(13, vo.getCom_email());
			pstmt.setString(14, vo.getCom_image_filename());
			pstmt.setString(15, vo.getCom_id());
			pstmt.setString(16, vo.getCom_pass());

			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	public int companyIdchk(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int row = 0;
		String query = "select com_id from tb_company where com_id=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				row = 1;
			} else {
				row = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	public int companyMailchk(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int row = 0;
		String query = "update tb_company set com_emailauth = 1 where com_id=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	public List<CompanyVO> companyListJoin() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<CompanyVO> list = new ArrayList<>();

		String query = "select * from tb_company com, tb_job_opening job where com.com_num = job.com_num order by opening_num desc";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CompanyVO vo = new CompanyVO();
				vo.setCom_num(rs.getInt("com_num"));
				vo.setCom_name(rs.getString("com_name"));
				vo.setCom_empnum(rs.getInt("com_empnum"));
				vo.setCom_tel(rs.getString("com_tel"));
				vo.setCom_info(rs.getString("com_info"));
				vo.setCom_webpage(rs.getString("com_webpage"));
				vo.setCom_confirmed(rs.getString("com_confirmed"));
				vo.setCom_working_field(rs.getString("com_working_field"));
				vo.setCom_published_date(rs.getString("com_published_date"));
				vo.setCom_ceo(rs.getString("com_ceo"));
				vo.setCom_capital(rs.getInt("com_capital"));
				vo.setCom_location(rs.getString("com_location"));
				vo.setCom_postnum(rs.getString("com_postnum"));
				vo.setCom_sales(rs.getInt("com_sales"));
				vo.setCom_email(rs.getString("com_email"));
				vo.setCom_id(rs.getString("com_id"));
				vo.setCom_pass(rs.getString("com_pass"));
				vo.setCom_image_filename(rs.getString("com_image_filename"));
				vo.setOpening_num(rs.getInt("opening_num"));
				vo.setOpening_duty(rs.getString("opening_duty"));
				vo.setOpening_offer(rs.getString("opening_offer"));
				vo.setOpening_carrer(rs.getString("opening_carrer"));
				vo.setOpening_scale(rs.getString("opening_scale"));
				vo.setOpening_salary(rs.getInt("opening_salary"));
				vo.setOpening_regidate(rs.getString("opening_regidate"));
				vo.setOpening_startdate(rs.getString("opening_startdate"));
				vo.setOpening_enddate(rs.getString("opening_enddate"));
				vo.setOpening_working_time(rs.getString("opening_working_time"));
				vo.setOpening_filename(rs.getString("opening_filename"));
				vo.setOpening_contents(rs.getString("opening_contents"));
				vo.setOpening_subject(rs.getString("opening_subject"));

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public Job_openingVO comGetJobOpening(int num) {// num > 기업번호
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Job_openingVO vo = new Job_openingVO();
		String query = "select * from tb_job_opening where com_num=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo.setCom_num(rs.getInt("com_num"));
				vo.setOpening_num(rs.getInt("opening_num"));
				vo.setOpening_duty(rs.getString("opening_duty"));
				vo.setOpening_offer(rs.getString("opening_offer"));
				vo.setOpening_carrer(rs.getString("opening_carrer"));
				vo.setOpening_scale(rs.getString("opening_scale"));
				vo.setOpening_salary(rs.getInt("opening_salary"));
				vo.setOpening_regidate(rs.getString("opening_regidate"));
				vo.setOpening_startdate(rs.getString("opening_startdate"));
				vo.setOpening_enddate(rs.getString("opening_enddate"));
				vo.setOpening_working_time(rs.getString("opening_working_time"));
				vo.setOpening_filename(rs.getString("opening_filename"));
				vo.setOpening_contents(rs.getString("opening_contents"));
				vo.setOpening_education(rs.getString("opening_education"));
				vo.setOpening_location(rs.getString("opening_location"));
				vo.setOpening_subject(rs.getString("opening_subject"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;

	}

	public CompanyVO companyList(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		CompanyVO vo = new CompanyVO();
		String query = "select * from tb_company where com_num=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo.setCom_num(rs.getInt("com_num"));
				vo.setCom_name(rs.getString("com_name"));
				vo.setCom_empnum(rs.getInt("com_empnum"));
				vo.setCom_tel(rs.getString("com_tel"));
				vo.setCom_info(rs.getString("com_info"));
				vo.setCom_webpage(rs.getString("com_webpage"));
				vo.setCom_confirmed(rs.getString("com_confirmed"));
				vo.setCom_working_field(rs.getString("com_working_field"));
				vo.setCom_published_date(rs.getString("com_published_date"));
				vo.setCom_ceo(rs.getString("com_ceo"));
				vo.setCom_capital(rs.getInt("com_capital"));
				vo.setCom_location(rs.getString("com_location"));
				vo.setCom_postnum(rs.getString("com_postnum"));
				vo.setCom_sales(rs.getInt("com_sales"));
				vo.setCom_email(rs.getString("com_email"));
				vo.setCom_id(rs.getString("com_id"));
				vo.setCom_pass(rs.getString("com_pass"));
				vo.setCom_image_filename(rs.getString("com_image_filename"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}

	// ========================================
	// 자기소개서 리스트(기업)
	public List<UserCoverLetterVO2> userCoverLetterList(int startpage, int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserCoverLetterVO2> vo = new ArrayList<UserCoverLetterVO2>();
		UserCoverLetterVO2 ucvl = null;

		String query = "select X.* from (select rownum as rnum, A.* from (select * from tb_cover_letter order by cover_num desc) A where rownum<=? and cover_private='T') X where rnum>=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);

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

	// 자기소개서 전체 카운트(기업)
	public int userCoverLetterCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String query = "select count(*) from tb_cover_letter where cover_private='T'";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
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

	// 자기소개서 뷰(기업)
	public UserCoverLetterVO2 userCoverLetterView(int cover_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserCoverLetterVO2 ucvl = null;

		String query = "select * from tb_cover_letter where cover_num=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cover_num);
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

	// 구직자이력서 리스트(기업)
	public List<UserResumeVO2> userResumeList(int startpage, int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserResumeVO2> vo = new ArrayList<UserResumeVO2>();
		UserResumeVO2 ur = null;

		String query = "select X.* from (select rownum as rnum, A.* from (select * from tb_user_resume order by resume_num desc) A where rownum<=?) X where rnum>=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				ur = new UserResumeVO2();
				ur.setResume_num(rs.getInt("resume_num"));
				ur.setUser_num(rs.getInt("user_num"));
				ur.setResume_private(rs.getString("resume_private"));
				ur.setResume_readcnt(rs.getInt("resume_readcnt"));
				ur.setResume_regidate(rs.getString("resume_regidate"));
				ur.setResume_modifydate(rs.getString("resume_modifydate"));
				vo.add(ur);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}

	// 유저기본정보(기업)
	public UserVO userSimple(int user_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO vo = new UserVO();
		int row = 0;

		String query = "select * from tb_user where user_num=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, user_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
//					vo.setUser_num(rs.getInt("user_num"));
				vo.setUser_name(rs.getString("user_name"));
//					vo.setUser_id(rs.getString("user_id"));
				vo.setUser_email(rs.getString("user_email"));
//					vo.setUser_tel(rs.getString("user_tel"));
//					vo.setUser_regidate(rs.getString("user_regidate"));
//					vo.setUser_lastlogin(rs.getString("user_lastlogin"));
//					vo.setUser_emailauth(rs.getInt("user_emailauth"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}

	// 구직자이력서 전체 카운트(기업)
	public int userResumeCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		String query = "select count(*) from tb_user_resume where resume_private='T'";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
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

	// 구직자이력서 뷰(기업)
	public UserResumeVO2 userResumeView(int resume_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserResumeVO2 ur = null;

		String query = "select * from tb_user_resume where resume_num=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, resume_num);
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
	
	// 구직자이력서 링크(기업)
		public UserResumeVO2 userResumeGetLink(int user_num) {
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
//					ur.setResume_gender(rs.getString("resume_gender"));
//					ur.setResume_education(rs.getString("resume_education"));
//					ur.setResume_tel(rs.getString("resume_tel"));
//					ur.setResume_picture_filename(rs.getString("resume_picture_filename"));
//					ur.setResume_language(rs.getString("resume_language"));
//					ur.setResume_foreign_language(rs.getString("resume_foreign_language"));
//					ur.setResume_career(rs.getString("resume_career"));
//					ur.setResume_file(rs.getString("resume_file"));
//					ur.setResume_private(rs.getString("resume_private"));
//					ur.setResume_readcnt(rs.getInt("resume_readcnt"));
//					ur.setResume_regidate(rs.getString("resume_regidate"));
//					ur.setResume_modifydate(rs.getString("resume_modifydate"));
//					ur.setResume_address(rs.getString("resume_address"));
//					ur.setResume_certification(rs.getString("resume_certification"));
//					ur.setCover_num(rs.getInt("cover_num"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return ur;
		}
	

	// 구직자이력서 조회수(기업)
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

	// --------------------

	// company id delete
	public int companyDelete(String id, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int row = 0;
		String query = "delete from tb_company where com_id=? and com_pass=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}

	// company imfomation page (아직 css구현안됨)
	public CompanyVO companyInfomation(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		CompanyVO vo = new CompanyVO();

		String query = "select * from tb_company com, tb_job_opening job where com.com_num = job.com_num and com.com_num=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo.setCom_num(rs.getInt("com_num"));
				vo.setCom_name(rs.getString("com_name"));
				vo.setCom_empnum(rs.getInt("com_empnum"));
				vo.setCom_tel(rs.getString("com_tel"));
				vo.setCom_info(rs.getString("com_info"));
				vo.setCom_webpage(rs.getString("com_webpage"));
				vo.setCom_confirmed(rs.getString("com_confirmed"));
				vo.setCom_working_field(rs.getString("com_working_field"));
				vo.setCom_published_date(rs.getString("com_published_date"));
				vo.setCom_ceo(rs.getString("com_ceo"));
				vo.setCom_capital(rs.getInt("com_capital"));
				vo.setCom_location(rs.getString("com_location"));
				vo.setCom_postnum(rs.getString("com_postnum"));
				vo.setCom_sales(rs.getInt("com_sales"));
				vo.setCom_email(rs.getString("com_email"));
				vo.setCom_id(rs.getString("com_id"));
				vo.setCom_pass(rs.getString("com_pass"));
				vo.setCom_image_filename(rs.getString("com_image_filename"));
				vo.setOpening_num(rs.getInt("opening_num"));
				vo.setOpening_duty(rs.getString("opening_duty"));
				vo.setOpening_offer(rs.getString("opening_offer"));
				vo.setOpening_carrer(rs.getString("opening_carrer"));
				vo.setOpening_scale(rs.getString("opening_scale"));
				vo.setOpening_salary(rs.getInt("opening_salary"));
				vo.setOpening_regidate(rs.getString("opening_regidate"));
				vo.setOpening_startdate(rs.getString("opening_startdate"));
				vo.setOpening_enddate(rs.getString("opening_enddate"));
				vo.setOpening_working_time(rs.getString("opening_working_time"));
				vo.setOpening_filename(rs.getString("opening_filename"));
				vo.setOpening_contents(rs.getString("opening_contents"));
				vo.setOpening_subject(rs.getString("opening_subject"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}

	// company id infomation modify
	public int companyModify(CompanyVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int row = 0;
		String query = "update tb_company set com_name=?,com_empnum=?,com_tel=?,com_info=?,com_webpage=?,com_working_field=?, "
				+ "com_published_date=?,com_ceo=?,com_location=?,com_postnum=?,com_sales=?,com_email=?,com_image_filename=?, "
				+ "com_pass=? where com_id=? and com_pass=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getCom_name());
			pstmt.setInt(2, vo.getCom_empnum());
			pstmt.setString(3, vo.getCom_tel());
			pstmt.setString(4, vo.getCom_info());
			pstmt.setString(5, vo.getCom_webpage());
			pstmt.setString(6, vo.getCom_working_field());
			pstmt.setString(7, vo.getCom_published_date());
			pstmt.setString(8, vo.getCom_ceo());
			pstmt.setString(9, vo.getCom_location());
			pstmt.setString(10, vo.getCom_postnum());
			pstmt.setInt(11, vo.getCom_sales());
			pstmt.setString(12, vo.getCom_email());
			pstmt.setString(13, vo.getCom_image_filename());
			pstmt.setString(14, vo.getCom_pass());
			pstmt.setString(15, vo.getCom_id());
			pstmt.setString(16, vo.getPrePass());
			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	// company imfomation modify password checking
	public int companyPasschk(String id, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int row = 0;
		String query = "select com_pass from tb_company where com_id=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String dbpass = rs.getString("com_pass");
				if (dbpass.equals(pass)) {
					row = 1;
				} else {
					row = 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

}
