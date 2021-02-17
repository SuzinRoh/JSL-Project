package project.domain.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import project.util.DBManager;

public class CompanyDAO {
	private CompanyDAO() {}
	private static CompanyDAO instance = new CompanyDAO();
	public static CompanyDAO getInstance() {
		return instance;
	}
	
	public int insertCompany(CompanyVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_company(com_num,com_name,com_empnum,com_tel,com_info," + 
				"com_webpage,com_working_field,com_published_date," + 
				"com_ceo,com_capital,com_location,com_postnum,com_sales,com_email," + 
				"com_image_filename,com_id,com_pass)" + 
				"values(tb_company_seq_com_num_tmp.nextval," + 
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
			DBManager.getClose(conn, pstmt);
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
			DBManager.getClose(conn, pstmt, rs);
		}
		return row;
	}
	
	public int companyMailchk(String id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
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
			DBManager.getClose(conn, pstmt);
		}
		return row;
	}
	
	//company login 
	
	
}
