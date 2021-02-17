package project.domain.jobopening;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.domain.company.CompanyDAO;
import project.domain.company.CompanyVO;
import project.util.DBManager;

public class JobOpeningDAO {
	private JobOpeningDAO() {}
	private static JobOpeningDAO instance = new JobOpeningDAO();
	public static JobOpeningDAO getInstanceof() {
		return instance;
	}
	
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
	public List<CompanyVO>	openingList(){
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
				vo.setOpening_location(rs.getString("opening_location"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt,rs);
		}
		return list;
	}
	public List<CompanyVO>	openingListRecommend(){
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
				vo.setOpening_location(rs.getString("opening_location"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt,rs);
		}
		return list;
	}
	//searching tag 
	public List<CompanyVO>	openingListSearch(String SearchQuery){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<CompanyVO> list =new ArrayList<>();
		String query = "select * from tb_company com, tb_job_opening job where com.com_num = job.com_num " + SearchQuery;
		
		
		
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
				vo.setOpening_location(rs.getString("opening_location"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt,rs);
		}
		return list;
	}

	   
	   
	
}
