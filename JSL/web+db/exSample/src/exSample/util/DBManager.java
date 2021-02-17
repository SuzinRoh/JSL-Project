package exSample.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBManager {
	public static Connection getConnection() {
		Connection conn =null;
		
		String myDriver = "oracle.jdbc.driver.OracleDriver";
		String myURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String myID = "jslhrd46";
		String myPass = "1234";
		
		try {
			Class.forName(myDriver);
			//System.out.println(" 성공1");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		try {
			conn = DriverManager.getConnection(myURL, myID, myPass);
			//System.out.println(" 성공2");
		} catch  (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void getClose(Connection conn,PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		public static void getClose(Connection conn,PreparedStatement pstmt) {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
				
			}
	}
}
