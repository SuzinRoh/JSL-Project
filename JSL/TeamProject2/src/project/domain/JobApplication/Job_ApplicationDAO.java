
package project.domain.JobApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import project.util.DBManager;

public class Job_ApplicationDAO {
	private Job_ApplicationDAO() {}
	private static Job_ApplicationDAO instance = new Job_ApplicationDAO();
	public static Job_ApplicationDAO getInstanceof() {
		return instance;
	}
	//지원서 신청
		public int jobApplicationInsert(int com_num, int user_num, int opening_num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int row = 0; 
			
			String query = "insert into tb_job_application"
					+ "(ja_num, com_num, user_num, opening_num)"
					+ " values(TB_JOB_APPLICATION_SEQ_JA_NUM.nextval,?,?,?)";
			try {
				conn = DBManager.getConnection();
				pstmt=conn.prepareStatement(query);
				pstmt.setInt(1, com_num);
				pstmt.setInt(2, user_num);
				pstmt.setInt(3, opening_num);
				row = pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return row;
	}
		
		public List<Job_ApplicationVO> jobApplicationSelect(int com_num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Job_ApplicationVO> list = new ArrayList<Job_ApplicationVO>();
			Job_ApplicationVO vo = null;
			
			String query = "select * from tb_job_application where com_num = ?";
			try {
				
				conn = DBManager.getConnection();
				pstmt=conn.prepareStatement(query);
				pstmt.setInt(1, com_num);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					vo = new Job_ApplicationVO();
					vo.setCom_num(rs.getInt("com_num"));
					vo.setJa_num(rs.getInt("ja_num"));
					vo.setJa_regidate(rs.getString("ja_regidate"));
					vo.setUser_num(rs.getInt("user_num"));
					list.add(vo);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		//
		public List<Job_ApplicationVO> jobApplicationSelectUser(int user_num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Job_ApplicationVO> list = new ArrayList<Job_ApplicationVO>();
			Job_ApplicationVO vo = null;
			
			String query = "select * from tb_job_application j , tb_company c where j.com_num = c.com_num And j.user_num = ?";
			try {
				
				conn = DBManager.getConnection();
				pstmt=conn.prepareStatement(query);
				pstmt.setInt(1, user_num);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					vo = new Job_ApplicationVO();
					vo.setCom_num(rs.getInt("com_num"));
					vo.setJa_num(rs.getInt("ja_num"));
					vo.setJa_regidate(rs.getString("ja_regidate"));
					vo.setUser_num(rs.getInt("user_num"));
					vo.setCom_name(rs.getString("com_name"));
					vo.setCom_tel(rs.getString("com_tel"));
					vo.setCom_webpage(rs.getString("com_webpage"));
					
					list.add(vo);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		public List<Job_ApplicationVO> jobApplicationUserSelect(int com_num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Job_ApplicationVO> list = new ArrayList<Job_ApplicationVO>();
			Job_ApplicationVO vo = null;
			
			String query = "select * from tb_job_application j , tb_user u where j.user_num = u.user_num And j.com_num = ?";
			try {
				conn = DBManager.getConnection();
				pstmt=conn.prepareStatement(query);
				pstmt.setInt(1, com_num);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					vo = new Job_ApplicationVO();
					vo.setJa_num(rs.getInt("ja_num"));
					vo.setJa_regidate(rs.getString("ja_regidate"));
					vo.setUser_num(rs.getInt("user_num"));
					vo.setOpening_num(rs.getInt("opening_num"));
					
					vo.setUser_name(rs.getString("user_name"));
					vo.setUser_id(rs.getString("user_id"));
					vo.setUser_email(rs.getString("user_email"));
					vo.setUser_tel(rs.getString("user_tel"));
					vo.setUser_regidate(rs.getString("user_regidate"));
					vo.setUser_lastlogin(rs.getString("user_lastlogin"));
					vo.setUser_email(rs.getString("user_email"));
					vo.setUser_emailauth(rs.getInt("user_emailauth"));
					
					list.add(vo);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}

				//신청 유저페이지의 메소드
		public List<Job_ApplicationVO> jobApplicationListUserSelect(int user_num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Job_ApplicationVO> list = new ArrayList<Job_ApplicationVO>();
			Job_ApplicationVO vo = null;
			
			String query = "select * from tb_job_application j , tb_user u where j.user_num = u.user_num And j.com_num = ?;";
			try {
				conn = DBManager.getConnection();
				pstmt=conn.prepareStatement(query);
				pstmt.setInt(1, user_num);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					vo = new Job_ApplicationVO();
					vo.setJa_num(rs.getInt("ja_num"));
					vo.setJa_regidate(rs.getString("ja_regidate"));
					vo.setUser_num(rs.getInt("user_num"));

					vo.setUser_name(rs.getString("user_name"));
					vo.setUser_id(rs.getString("user_id"));
					vo.setUser_email(rs.getString("user_email"));
					vo.setUser_tel(rs.getString("user_tel"));
					vo.setUser_regidate(rs.getString("user_regidate"));
					vo.setUser_lastlogin(rs.getString("user_lastlogin"));
					vo.setUser_email(rs.getString("user_email"));
					vo.setUser_emailauth(rs.getInt("user_emailauth"));
					
					list.add(vo);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		//기업
		public int countApplication(int com_num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			int row = 0;
			
			String query = "select count(*) from tb_job_application where com_num = ?";
			try {
				conn = DBManager.getConnection();
				pstmt=conn.prepareStatement(query);
				pstmt.setInt(1, com_num);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					row = rs.getInt(1);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return row;
		}
		//유저
		public int countApplicationUser(int user_num, int opening_num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			int row = 0;
			
			String query = "select count(*) from tb_job_application where user_num = ? and opening_num = ?";
			try {
				conn = DBManager.getConnection();
				pstmt=conn.prepareStatement(query);
				pstmt.setInt(1, user_num);
				pstmt.setInt(2, opening_num);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					row = rs.getInt(1);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return row;
		}
		//유저
				public int countApplicationUser(int user_num) {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;

					int row = 0;
					
					String query = "select count(*) from tb_job_application where user_num = ?";
					try {
						conn = DBManager.getConnection();
						pstmt=conn.prepareStatement(query);
						pstmt.setInt(1, user_num);
						rs = pstmt.executeQuery();
						while(rs.next()) {
							row = rs.getInt(1);
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
					return row;
				}
		
		
}
