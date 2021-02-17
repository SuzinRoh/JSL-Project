<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
one page attribute :<%=pageContext.getAttribute("name") %><br>
one request attribute :<%=request.getAttribute("name") %><br>
one session attribute :<%=session.getAttribute("name") %><br>
one application attribute :<%=application.getAttribute("name") %><br>
	
</body>
</html>