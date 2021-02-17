package project.domain.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.domain.jobopening.JobOpeningVO;
import project.util.DBManager;

public class CompanyDAO {
	private CompanyDAO() {}
	private static CompanyDAO instance = new CompanyDAO();
	public static CompanyDAO getInstanceof() {
		return instance;
	}
	//로그인부분
	public int CompanyLogin(String com_id, String com_pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row = 0; 
		
		String query = "select com_pass from tb_company where com_id = ? ";
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, com_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dbpass = rs.getString("com_pass");
				if(dbpass.equals(com_pass)){
					query = "select com_confirmed from tb_company where com_id = ?";
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, com_id);
					rs = pstmt.executeQuery();
					rs.next();
					if(rs.getString(1).equals("T")) {
						row = 1;// 비밀번호가 같고 관리자에게 승인을 받았다면 (로그인성공)
					}else {
						row = 2; // 비밀번호가 같지만 관리자에게 승인을 받지 못했다면
					}
					
				}else {
					row = 0;// 비밀번호가 틀리다면
				}
			}else{
				row = -1;  //id가 존재하지 않으면
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
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
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
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
			while(rs.next()) {
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
				vo.setCom_id(rs.getString("com_id"));
				vo.setCom_pass(rs.getString("com_pass"));
				vo.setCom_image_filename(rs.getString("com_image_filename"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}
	public String companyIdfound(String com_name,String com_email) {
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
			while(rs.next()) {
				id = rs.getString("1");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return id;
	}
	//아이디와 메일이 동일한지 확인
	public int CompanyPassFound(String com_id, String com_email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row = 0; 
		
		String query = "select * from tb_company where com_id = ? and com_email = ? ";
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, com_id);
			pstmt.setString(2, com_email);
			rs = pstmt.executeQuery();
			rs.next();
			row = rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	//암호화된새로운비밀번호등록
	public int CompanyPassUpdate(String com_id, String com_email, String tempShaPass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row = 0; 
		
		String query = "update tb_company set com_pass = ? where com_id = ? and com_email = ?";
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, tempShaPass);
			pstmt.setString(2, com_id);
			pstmt.setString(3, com_email);
			row = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	//insert부분
	public int insertCompany(CompanyVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "insert into tb_company(com_num,com_name,com_empnum,com_tel,com_info," + 
				"com_webpage,com_working_field,com_published_date," + 
				"com_ceo,com_capital,com_location,com_postnum,com_sales,com_email," + 
				"com_image_filename,com_id,com_pass)" + 
				"values(tb_company_seq_com_num.nextval," + 
				"?,?,?,?,?,?,to_date(?,'YYYYMMDD'),?,?,?,?,?,?,?,?,?)";
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
	
	public int companyIdchk(String id){
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
			if(rs.next()) {
				row = 1 ;
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
	
	public int companyMailchk(String id){
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
//정보수정
	public int companyPasschk(String id,String pass) {
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
			if(rs.next()) {
				String dbpass = rs.getString("com_pass");
				if(dbpass.equals(pass)) {
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
	public int companyModify(CompanyVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row = 0;
		String query = "update tb_company set com_name=?,com_empnum=?,com_tel=?,com_info=?,com_webpage=?,com_working_field=?,"
					 + "com_published_date=?,com_ceo=?,com_location=?,com_postnum=?,com_sales=?,com_email=?,com_image_filename=?,"
					 + "com_pass=? "
					 + " where com_id=? and com_pass=?";
		
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
			pstmt.setString(16, vo.getCom_pass());
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	public int companyDelete(String id,String pass) {
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
	//get company list for main
	public List<CompanyVO> companyList(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<CompanyVO> list =new ArrayList<>();
		String query = "select * from tb_company order by com_num desc";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
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
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt,rs);
		}
		return list;
	}
	
	//get company list for main join tb company + tb job opening
		public List<CompanyVO> companyListJoin(){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			List<CompanyVO> list =new ArrayList<>();
			
			String query = "select * from tb_company com, tb_job_opening job where com.com_num = job.com_num";
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				while(rs.next()) {
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
				DBManager.close(conn, pstmt,rs);
			}
			return list;
		}
	
	// job opening
		public JobOpeningVO comGetJobOpening(int num) {//num2 > 기업번호
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			JobOpeningVO vo = new JobOpeningVO();
			String query = "select * from tb_job_opening where com_num=?";
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					vo.setOpening_num(rs.getInt("opening_num"));
					vo.setCom_num(rs.getInt("com_num"));
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
				DBManager.close(conn, pstmt,rs);
			}
			return vo;
			
		}
		
		//get company deteil 
		public CompanyVO companyList(int num){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			CompanyVO vo =new CompanyVO();
			String query = "select * from tb_company where com_num=?";
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery();
				if(rs.next()) {
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
				DBManager.close(conn, pstmt,rs);
			}
			return vo;
		}
}
