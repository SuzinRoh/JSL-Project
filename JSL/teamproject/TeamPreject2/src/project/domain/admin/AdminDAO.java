package project.domain.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.domain.company.CompanyDAO;
import project.domain.company.CompanyVO;
import project.util.DBManager;

public class AdminDAO {
	private AdminDAO() {}
	private static AdminDAO instance = new AdminDAO();
	public static AdminDAO getInstanceof() {
		return instance;
	}
	
	public int AdminLogin(String id, String pass){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row = 0;
		String query = "select count(*) from tb_admin where admin_id = ? and admin_pass = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs= pstmt.executeQuery();
			rs.next();
			row = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	//
	public List<CompanyVO> company_not_confirmed_list() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<CompanyVO> list = new ArrayList<CompanyVO>();
		
		String query = "select * from tb_company where com_confirmed = 'F'";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CompanyVO vo = null;
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
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	
	//기업승인
	public int AdminConfirm(int com_num){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row = 0;
		
		String query = "update tb_company set com_confirmed = 'T' where com_num = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, com_num);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	//정보조회
	public AdminVO AdminSelect(String id, String pass){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		AdminVO vo = null;
		
		String query = "select * from tb_admin where admin_id = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			vo = new AdminVO();
			while(rs.next()) {
				vo.setAdmin_id(rs.getString("admin_id"));
				vo.setAdmin_pass(rs.getString("admin_pass"));
				vo.setAdmin_num(rs.getInt("Admin_num"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}
	

	
}
