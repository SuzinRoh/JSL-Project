package procedure;

import java.sql.CallableStatement;
import java.sql.Connection;

import dbconn.DBUtil;

public class Exam_02 {

	public static void main(String[] args) throws Exception{
		Connection conn = DBUtil.getConnetion();
		
		String sql="{call dept_insert(?,?,?,?)}";
		
		CallableStatement cstmt =conn.prepareCall(sql);
		
		cstmt.setInt(1, 60);
		cstmt.setString(2, "TESTPART");
		cstmt.setString(3, "DEAJEON");
		cstmt.registerOutParameter(4, java.sql.Types.INTEGER);
		cstmt.execute();
		
		int row=cstmt.getInt(4);
		System.out.println(row);
	}

}
