<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> test09</h1>
	name : ${list}<br>
	<br>
	<c:forEach var="name" items="${list}">
		이름 : ${name}<br>
	</c:forEach>
</body>
</html>