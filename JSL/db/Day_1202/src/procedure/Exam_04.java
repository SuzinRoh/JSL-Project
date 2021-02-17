package procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

import dbconn.DBUtil;

/*
 * 키보드로 서번호를 입력받아  department 테이블에서 검색
 * 부서정보를 출력하는 procedure 생성 자바에서 호출하는 프로그램 작성
 *  입력형식
 *  부서번호 10
 *  
 *  
 *  출력형식 
 *  
 *  부서번호 부서명 지역명
 */
public class Exam_04 {

	public static void main(String[] args) throws Exception{
		Connection conn = DBUtil.getConnetion();
		
		Scanner sc =new Scanner(System.in);
		String sql="{Call dept_select(?,?,?,?)}";
		CallableStatement cstmt = conn.prepareCall(sql);
		DeptVO vo =new DeptVO();
		while(true) {
			
			System.out.print("부서번호 :");
			int dno = sc.nextInt();
			cstmt.setInt(1, dno);
			cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			cstmt.execute();
			
			vo.setDno(cstmt.getInt(2));
			vo.setDname(cstmt.getString(3));
			vo.setLoc(cstmt.getString(4));
			/*
			int dno1=cstmt.getInt(2);
			String dname=cstmt.getString(3);
			String loc =cstmt.getString(4);
			*/
			
			System.out.println("dno\tdname\t\tloc");
			System.out.println("------------------------------");
			System.out.println(vo.getDno()+"\t"+vo.getDname()+"\t"+vo.getLoc());
			System.out.println();
		}
	}

}
