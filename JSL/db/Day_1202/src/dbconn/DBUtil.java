package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getConnetion() {
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jslhrd46","1234");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
