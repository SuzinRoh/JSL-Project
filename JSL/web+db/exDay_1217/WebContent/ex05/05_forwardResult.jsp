<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor=pink>
redirect 방식으로 이동된 페이지<br>



	name :<%= request.getParameter("name") %><br>
	age: <%=  request.getParameter("age") %>

</body>
</html>