import java.sql.DriverManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JDBCTest {
	private static final Logger log = 
			LoggerFactory.getLogger(JDBCTest.class);
	static {
		try {
			Class.forName("oracle.jdbc.dribver.OracleDriver");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hslhrd46","1234");
			Log.info("db 연결 ");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
