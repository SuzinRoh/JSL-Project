import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO {
	private AccountDAO() {}
	private static AccountDAO instance = new AccountDAO();
	public static AccountDAO getInstance() {
		return instance;
	}
	
	public void createTable() {
		Connection conn =null;
		PreparedStatement pstmt=null;
		//ResultSet rs = null;
		
		String sql="create table accountbook(" + 
				"indate date not null," + 
				"kategorie varchar(20)," + 
				"contents varchar(40)," + 
				"income number(10)," + 
				"expenditure number(10))";
		
		try {
			conn = Connect.getConnection();
			pstmt =conn.prepareStatement(sql);
			int row = pstmt.executeUpdate();
			
			System.out.println("Created table in given database...");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)conn.close();
				if(pstmt != null)pstmt.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void insertData(AccountVO vo) {
		Connection conn =null;
		PreparedStatement pstmt=null;
		
		int row =0;
		
		String sql="insert into accountbook"
				+ "(indate,kategorie,contents,income,expenditure)"
				+ "values(?,?,?,?,?)";
		
		try {
			conn = Connect.getConnection();
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, vo.getIndate());
			pstmt.setString(2, vo.getKategorie());
			pstmt.setString(3, vo.getContents());
			pstmt.setInt(4, vo.getIncome());
			pstmt.setInt(5, vo.getExpenditure());
			
			row =pstmt.executeUpdate();
			if(row==1) {
				System.out.println("success");
			}else {
				System.out.println("false");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)conn.close();
				if(pstmt != null)pstmt.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
