package procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import dbconn.DBUtil;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleTypes;

public class Exam_06 {

	public static void main(String[] args) throws Exception{
		String sql="call emp_list_pkg.emp_list(?)";
		
		Connection conn = DBUtil.getConnetion();
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.registerOutParameter(1, OracleTypes.CURSOR);
		cstmt.execute();
		
		OracleCallableStatement ocstmt = (OracleCallableStatement)cstmt;
		ResultSet rs=(OracleResultSet)ocstmt.getCursor(1);
		
		while(rs.next()) {
			EmpVO emp =new EmpVO();
			emp.setEno(rs.getInt("eno"));
			emp.setEname(rs.getString("ename"));
			emp.setJob(rs.getString("job"));
			emp.setManager(rs.getInt("manager"));
			emp.setHiredate(rs.getDate("hiredate"));
			emp.setSalary(rs.getInt("salary"));
			emp.setCommission(rs.getInt("commission"));
			emp.setDno(rs.getInt("dno"));
			
			System.out.println(emp);
		}
	}

}
