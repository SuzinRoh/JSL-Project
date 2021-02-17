package procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import dbconn.DBUtil;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;


public class Exam_05 {

	public static void main(String[] args) throws Exception{
		String sql="call dept_list_pkg.dept_list(?)";
		
		Connection conn = DBUtil.getConnetion();
		
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.registerOutParameter(1, OracleTypes.CURSOR);
		cstmt.execute();
		
		OracleCallableStatement ocstmt =(OracleCallableStatement)cstmt;
		ResultSet rs =(OracleResultSet)ocstmt.getCursor(1);
		
		System.out.println("DNO\tDNAME\tLOC");
		while(rs.next()) {
			DeptVO dept = new DeptVO();
			dept.setDno(rs.getInt("dno"));
			dept.setDname(rs.getString("dname"));
			dept.setLoc(rs.getString("loc"));
			
			System.out.println(dept);
		}
	}

}
