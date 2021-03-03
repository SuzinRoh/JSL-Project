package project.domain.job_opening;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.domain.company.CompanyVO;
import project.util.DBManager;

public class Job_openingDAO {
	private Job_openingDAO() {}
	private static Job_openingDAO instance = new Job_openingDAO();
	public static Job_openingDAO getInstanceof() {
		return instance;
	}
	
	public int JobOpeningInsert(Job_openingVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row = 0; 
		
		String query = "insert into tb_job_opening"
				+ "("
				+ " opening_num,"
				+ " com_num,"
				+ " opening_duty,"
				+ " opening_offer,"
				+ " opening_carrer,"
				+ " opening_scale,"
				+ " opening_location,"
				+ " opening_contents, "
				+ " opening_salary,"
				+ " opening_startdate,"
				+ " opening_enddate,"
				+ " opening_working_time,"
				+ " opening_filename,"
				+ " opening_subject, "
				+ " opening_education "
				+ " ) values( "
				+ " TB_JOB_OPENING_SEQ_OPENING_NUM.nextval,"
				+ " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ?, ?)";
		try {
			//conn = getConnection();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, vo.getCom_num());
			pstmt.setString(2, vo.getOpening_duty());
			pstmt.setString(3, vo.getOpening_offer());
			pstmt.setString(4, vo.getOpening_carrer());
			pstmt.setString(5, vo.getOpening_scale());
			pstmt.setString(6, vo.getOpening_location());
			pstmt.setString(7, vo.getOpening_contents());
			pstmt.setInt(8, vo.getOpening_salary());
			pstmt.setString(9, vo.getOpening_startdate());
			pstmt.setString(10, vo.getOpening_enddate());
			pstmt.setString(11, vo.getOpening_working_time());
			pstmt.setString(12, vo.getOpening_filename());
			pstmt.setString(13, vo.getOpening_subject());
			pstmt.setString(14, vo.getOpening_education());
			row = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	//모든 공고수 카운트
	public int countjobOpening() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row = 0 ;
		String query = "select count(*) from tb_job_opening";
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
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	//조건공고수 카운트
	public int countjobOpening(String key) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row = 0 ;
		String query = "select count(*) from tb_job_opening where opening_subject like '%"+key+"%'";
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
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	//10개까지 보여주는 메소드
	public List<CompanyVO> CompanyList(int startpage, int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CompanyVO> list = new ArrayList<>();
		CompanyVO vo = null;
		String sql = "select A.* from\r\n" + 
				"(select c.com_name, c.com_num, c.com_empnum, c.com_tel , c.com_info, c.com_webpage, c.com_working_field, c.com_published_date, c.com_ceo, c.com_capital, c.com_location, c.com_postnum, c.com_confirmed, c.com_sales, c.com_email, c.com_image_filename, c.com_id, c.com_pass, \r\n" + 
				"j.opening_num, j.opening_duty, j.opening_offer, j.opening_carrer, j.opening_scale, j.opening_location, j.opening_contents, j.opening_salary, j.opening_regidate, j.opening_startdate, j.opening_enddate, j.opening_working_time, j.opening_filename, j.opening_subject, j.opening_education\r\n" + 
				"from tb_job_opening j\r\n" + 
				"inner join tb_company c on j.com_num=c.com_num) A \r\n" + 
				"where rownum <= ? AND rownum >= ?";
		
		try {
			conn  = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
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
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	//10개까지 검색 추가
	public List<CompanyVO> CompanyList(int startpage, int endpage,String s_query) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CompanyVO> list = new ArrayList<>();
		CompanyVO vo = null;
		String sql = "select X.* from (select rownum as rnum, A.*\r\n" + 
				"from (select c.com_name, c.com_num, c.com_empnum, c.com_tel , c.com_info, c.com_webpage, c.com_working_field, c.com_published_date, c.com_ceo, c.com_capital, c.com_location, c.com_postnum, c.com_sales, c.com_email, c.com_image_filename, c.com_id, c.com_pass, c.com_confirmed,\r\n" + 
				"j.opening_num, j.opening_duty, j.opening_offer, j.opening_carrer, j.opening_scale, j.opening_location, j.opening_contents, j.opening_salary, j.opening_regidate, j.opening_startdate, j.opening_enddate, j.opening_working_time, j.opening_filename, j.opening_subject, j.opening_education\r\n" + 
				"from tb_job_opening j\r\n" + 
				"inner join tb_company c on c.com_num = j.com_num order by com_num desc) A\r\n" + 
				"where  "+ s_query + " and  rownum <= ?) X\r\n" + 
				" where "+ s_query + " and X.rnum >= ?";
		
		try {
			conn  = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
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
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<CompanyVO>	openingListRecommend(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<CompanyVO> list =new ArrayList<>();
		
		String query = "select * from tb_company com, tb_job_opening job where com.com_num = job.opening_num";
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
			DBManager.close(conn, pstmt,rs);
		}
		return list;
	}
	//번호로 공고 정보 불러오기
	public CompanyVO selectJobOpening(int com_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		CompanyVO vo = null;
		
		String query = "select * from tb_company c , tb_job_opening j where c.com_num=j.com_num and c.com_num = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, com_num);
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
	//공고번호로 com_num찾기
	public int selectCom_num(int opening_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int com_num = 0 ;
		String query = "select com_num from tb_job_opening where opening_num = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, opening_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				com_num = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return com_num;
	}
	
	//searching tag 
		public List<CompanyVO>	openingListSearch(String SearchQuery){
			Connection conn = null;
			PreparedStatement pstmt = null;
			PreparedStatement pstmtCnt = null;
			ResultSet rs = null;
			
			List<CompanyVO> list =new ArrayList<>();
			String query = "select * from tb_company com, tb_job_opening job where com.com_num = job.com_num " + SearchQuery;
			String queryCount = "select count(*) from tb_company com, tb_job_opening job where com.com_num = job.com_num " + SearchQuery;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmtCnt = conn.prepareStatement(queryCount);
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
					vo.setOpening_location(rs.getString("opening_location"));
					list.add(vo);
				}
				rs = pstmtCnt.executeQuery();
				while(rs.next()) {
					CompanyVO vo = new CompanyVO();
					vo.setCnt(rs.getInt(1));
					list.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt,rs);
			}
			return list;
		}
	
		public CompanyVO companyDetail(int num){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			CompanyVO vo = new CompanyVO();
			
			String query = "select * from tb_company com, tb_job_opening job where com.com_num = job.com_num and opening_num=?" ;
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
					vo.setOpening_education(rs.getString("opening_education"));
					vo.setOpening_location(rs.getString("opening_location"));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt,rs);
			}
			return vo;
		}
	
}