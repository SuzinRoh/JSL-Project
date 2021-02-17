package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class CustomerDAO {
	private CustomerDAO() {}
	private static CustomerDAO instance = new CustomerDAO();
	
	public static CustomerDAO getInstance() {
		return instance;
	}
	//커낵션 설정
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jslhrd46","1234");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	//메소드 정의
	
	public void test() {
		Connection conn = null;
		try {
			conn = getConnection();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
