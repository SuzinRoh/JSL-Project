package procedure;

import java.sql.CallableStatement;
import java.sql.Connection;

import dbconn.DBUtil;

public class Exam_01 {

	public static void main(String[] args) throws Exception{
		Connection conn = DBUtil.getConnetion();
		
		//System.out.println(conn);
		String sql="{call sp_salary(?,?,?)}";
		CallableStatement cstmt = conn.prepareCall(sql);
		
//		cstmt.setString(1, "SCOTT");
//		cstmt.registerOutParameter(2,java.sql.Types.INTEGER);		
//		cstmt.execute();
//		int salary = cstmt.getInt(2);
		
		cstmt.setString("v_ename", "SCOTT");
		cstmt.registerOutParameter("v_sal",java.sql.Types.INTEGER);
		cstmt.registerOutParameter("v_job",java.sql.Types.VARCHAR);		
		cstmt.execute();
		int salary = cstmt.getInt("v_sal");
		String job = cstmt.getString("v_job");
		System.out.println("SCOTT 의 급여는 "+salary);
		System.out.println("SCOTT 의 직업은 "+job);
	}

}
