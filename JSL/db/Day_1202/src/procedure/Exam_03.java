package procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

import dbconn.DBUtil;

public class Exam_03 {

	public static void main(String[] args) throws Exception{
		Connection conn = DBUtil.getConnetion();
		
		String sql="{Call dept_delete(?,?)}";
		CallableStatement cstmt = conn.prepareCall(sql);
		
		Scanner sc =new Scanner(System.in);
		int dno = sc.nextInt();
		cstmt.setInt(1,dno);
		cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
		cstmt.execute();
		
		int row =cstmt.getInt(2);
		System.out.println(row);
		
		
		
	}

}
