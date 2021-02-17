<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String id = request.getParameter("userid");
		String pass = request.getParameter("passwd");
		String gender = request.getParameter("gender");
		String tel = request.getParameter("tel");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		
		
		
	%>
	<h3><%=name %>님 회원가입 되었습니다</h3>
	이름 :<%= name %><br>
	아이디 :<%= id %><br>
	비밀번호 :<%= pass %><br>
	성별 :<%= gender %><br>
	전화 :<%= tel %><br>
	이메일:<%= email1 %>@<%= email2 %><br>
	
	<a href="user_login.jsp">login</a>
	
	
</body>
</html>