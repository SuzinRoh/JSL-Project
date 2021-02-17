<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*, java.util.*" %>
<%
	
	String myDriver = "oracle.jdbc.driver.OracleDriver";
	String myURL = "jdbc:oracle:thin:@localhost:1521:xe";
	String myID = "jslhrd46";
	String myPass = "1234";
%>
<%

	//db 연동테스t
	
	Connection conn =null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try{
		Class.forName(myDriver);
		conn = DriverManager.getConnection(myURL,myID,myPass);
		//System.out.println("성공");
	}catch(Exception e){
		e.printStackTrace();
		//System.out.println("error");
	}
	int idx= Integer.parseInt(request.getParameter("idx"));
	String pass =request.getParameter("pass");
	
	String query ="delete from tbl_board where idx=? and pass=?";
	
	pstmt = conn.prepareStatement(query);
	pstmt.setInt(1,idx);
	pstmt.setString(2,pass);
	
	int row = pstmt.executeUpdate();
			
	if (row ==1 ){
%>
	<script type="text/javascript">
		alert("delete");
		
		self.close();
	</script>
<%
	}else{ 
%>
	<script type="text/javascript">
		alert("비밀번호가 틀립니다");
		history.back();
	</script>
<%
	}
%>
