<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%

	//db연결설정
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs =null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDirver");
		
	}catch(Exception e){
		e.printStackTrace();
	}
	try{
		
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jslhrd46","1234");
	}catch(Exception e){
		e.printStackTrace();
	}
	String query="select * from department";
	pstmt = conn.prepareStatement(query);
	rs = pstmt.executeQuery();
	


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr>
			<td>부서번호</td>
			<td>부서명</td>
			<td>지역명</td>
		</tr>
		<%
			while(rs.next()){
				String dname =rs.getString("dname");
				String loc =rs.getString("loc");
		 %>
		<tr>
			<td><%=rs.getInt("dno") %>
			<td><%=dname %>
			<td><%=loc %>
		</tr>
		 <% 
		 	}
		 %>
		 
	</table>
</body>
</html>