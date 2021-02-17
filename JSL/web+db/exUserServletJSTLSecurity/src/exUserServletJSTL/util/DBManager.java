package exUserServletJSTL.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
	
	public static Connection getConnection() {
		
		Connection conn =null;
		String myDriver="oracle.jdbc.driver.OracleDriver";
		String myURL="jdbc:oracle:thin:@localhost:1521:xe";
		String myID="jslhrd46";
		String myPass="1234";
		
		try {
			Class.forName(myDriver);
			conn = DriverManager.getConnection(myURL,myID,myPass);
		} catch (SQLException sqle) { 
			sqle.printStackTrace();
		} catch (ClassNotFoundException classe) {
			classe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void getClose(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		try {
			if(conn != null) conn.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getClose(Connection conn,PreparedStatement pstmt) {
		try {
			if(conn != null) conn.close();
			if(pstmt != null) pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
