/*
 * jdbc programing
 * 1, ����̹� �ε� :class.forName()
 
 * 2. Ŀ�ؼ� : DriverManeger.getConnection()
 * 3. ��ɹ� ó�� :Statement , preparedStatement
 * 3. ����: executeQuery()
 */
import java.sql.*;//�پ�������  ������ �̰ŷ� �ϸ�
//collection> util
public class Exam_01 {

	public static void main(String[] args) {
		String myURL ="jdbc:oracle:thin:@localhost:1521:xe";
		String myID="jslhrd46";
		String myPass="1234";
		Connection conn =null;
		Statement stmt =null;
		ResultSet rs =null;// select���� ��
		
		//�������� �ݾƾ���
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(myURL,myID,myPass;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
