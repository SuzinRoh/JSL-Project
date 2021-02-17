package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.EmpVO;
import util.DBUtil;

public class EmpDAO {
	private EmpDAO() {};
	private static EmpDAO instance =new EmpDAO();
	
	public static EmpDAO getInstance() {
		return instance;
	}
	
	public EmpVO exam_01() {
		EmpVO emp=new EmpVO();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "select e.ename, e.dno, d.dname from employee e, department d"
					+ " where e.dno = d.dno and e.ename = 'SCOTT'";
			
			conn = DBUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				emp.setEname(rs.getString(1));
				emp.setDno(rs.getInt(2));
				emp.setDname(rs.getString(3));
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)conn.close();
				if(pstm != null)pstm.close();
				if(rs != null)rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return emp;
	}
	
	public List<EmpVO> exam_02() {
		EmpVO emp=null;
		List<EmpVO> list =new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "select ename, dname,loc from employee e join department d"
					+ " on e.dno = d.dno";
			
			conn = DBUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				emp = new EmpVO();
				emp.setEname(rs.getString(1));
				emp.setDname(rs.getString(2));
				emp.setLoc(rs.getString(3));
				
				
				list.add(emp);
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)conn.close();
				if(pstm != null)pstm.close();
				if(rs != null)rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<EmpVO> exam_03() {
		EmpVO emp=null;
		List<EmpVO> list =new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "select dno,job,loc from employee inner join department using(dno) where dno =10";
			
			conn = DBUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				emp = new EmpVO();
				emp.setDno(rs.getInt(1));
				emp.setJob(rs.getString(2));
				emp.setLoc(rs.getString(3));
				
				
				list.add(emp);
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)conn.close();
				if(pstm != null)pstm.close();
				if(rs != null)rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<EmpVO> exam_04() {
		EmpVO emp=null;
		List<EmpVO> list =new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "select ename,dname,loc from employee natural join department"
					+ " where commission > 0";
			
			conn = DBUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				emp = new EmpVO();
				emp.setEname(rs.getString(1));
				emp.setDname(rs.getString(2));
				emp.setLoc(rs.getString(3));
				
				
				list.add(emp);
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)conn.close();
				if(pstm != null)pstm.close();
				if(rs != null)rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<EmpVO> exam_05() {
		EmpVO emp=null;
		List<EmpVO> list =new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "select e.ename, d.dname from employee e, department d"
					+ " where e.dno =d.dno"
					+ " and e.ename like '%A%'";
			
			conn = DBUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				emp = new EmpVO();
				emp.setEname(rs.getString(1));
				emp.setDname(rs.getString(2));
				
				
				
				list.add(emp);
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)conn.close();
				if(pstm != null)pstm.close();
				if(rs != null)rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
}
