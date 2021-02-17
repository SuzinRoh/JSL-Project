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
	String name =request.getParameter("name");
	String pass =request.getParameter("pass");
	String subject =request.getParameter("subject");
	String contents =request.getParameter("contents");
	String ip = request.getRemoteAddr();
	
	String query="insert into tbl_guest2(idx,name,subject,contents,ip,pass,regdate) "
				+" values(tbl_guest_seq_idx2.nextval,?,?,?,?,?,sysdate)";
	pstmt =conn.prepareStatement(query);
	pstmt.setString(1, name);
	pstmt.setString(2, subject);
	pstmt.setString(3, contents);
	pstmt.setString(4, ip);
	pstmt.setString(5, pass);
	
	int row = pstmt.executeUpdate();

  	if(row==1){
  		
  %>  
 
  <script>
  	alert("등록성공");
  	location.href ="/Guest/guest_list.jsp";
  	
  </script>
  <%
  	}else{
  %>
  	<script>
  	alert("등록실패");
  	history.back();
  </script>
  <%
  	}
  %>
  
  
  <h1>ssssssss</h1>
  <%= row %>