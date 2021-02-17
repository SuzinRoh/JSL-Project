package util;

import java.sql.*;

public class DBUtil {

	private DBUtil() {}
	
	public static Connection getConnection() {
			Connection conn=null;
	
			String myDriver ="oracle.jdbc.driver.OracleDriver";
			String myURL ="jdbc:oracle:thin:@localhost:1521:xe";
			String myID ="jslhrd46";
			String myPass ="1234";
			
		try {
			Class.forName(myDriver);
			conn = DriverManager.getConnection(myURL,myID,myPass);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
