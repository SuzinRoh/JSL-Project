<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

	
<%
int dno =70 ;
String dname="JSLHRD";
String loc="edu";

Connection conn= null;
PreparedStatement pstmt=null;

try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jslhrd46","1234");
	}catch(Exception e){
		e.printStackTrace();
	}

	//stmt = conn.createStatement();
	String sql="insert into department(dno,dname,loc) values(?,?,?)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1,dno);
	pstmt.setString(2,dname);
	pstmt.setString(3,loc);
	int row =pstmt.executeUpdate(sql);
	
	if(row==1){
%>

<script>
	alert("성공");
</script>
<%
	}else{
%>

<script>
	alert("실패");
</script>

<%
	}
%>