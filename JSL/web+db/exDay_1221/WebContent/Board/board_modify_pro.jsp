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
	
	request.setCharacterEncoding("utf-8");
	int idx = Integer.parseInt(request.getParameter("idx"));
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");
	String pass = request.getParameter("pass");
	String ip = request.getRemoteAddr();
	
	String query = "update tbl_board set email=?,subject=?,contents=? where idx=? and pass=?";
	
	pstmt = conn.prepareStatement(query);
	pstmt.setString(1,email);
	pstmt.setString(2,subject);
	pstmt.setString(3,contents);
	pstmt.setInt(4,idx);
	pstmt.setString(5,pass);
	
	
	int row = pstmt.executeUpdate();
	
	if(row==0){
	
%>
	<script>
		alert("비밀번호가 맞지 않습니다");
		history.back();
	</script>
<%
	}
%>
<script>
	alert("ok");
	location.href="/Board/board_list.jsp"
</script>



