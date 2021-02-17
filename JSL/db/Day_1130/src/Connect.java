import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public static Connection getConnection() {
		Connection conn =null;
		
		String myDriver = "oracle.jdbc.driver.OracleDriver";
		String myURL ="jdbc:oracle:thin:@localhost:1521:xe";
		String myID = "jslhrd46";
		String myPass = "1234";
		
		try {
			Class.forName(myDriver);
			//System.out.println("jdbc driver 로딩 성공");
		} catch(Exception e) {
			e.printStackTrace();
			//System.out.println("jdbc driver 로딩 실패");
		}
		try {
			conn = DriverManager.getConnection(myURL,myID,myPass);
			//System.out.println("오라클 연결 성공");
		} catch(SQLException e) {
			e.printStackTrace();
			//System.out.println("오라클 연결 실패");
		}
		return conn;
	}
}
