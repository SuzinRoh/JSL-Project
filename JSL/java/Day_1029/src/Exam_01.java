/*
 * jdbc programing
 * 1, 드라이버 로딩 :class.forName()
 
 * 2. 커넥션 : DriverManeger.getConnection()
 * 3. 명령문 처리 :Statement , preparedStatement
 * 3. 쿼리: executeQuery()
 */
import java.sql.*;//다쓸수있음  연동은 이거로 하면
//collection> util
public class Exam_01 {

	public static void main(String[] args) {
		String myURL ="jdbc:oracle:thin:@localhost:1521:xe";
		String myID="jslhrd46";
		String myPass="1234";
		Connection conn =null;
		Statement stmt =null;
		ResultSet rs =null;// select쓸때 필
		
		//열었으면 닫아야함
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(myURL,myID,myPass;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
