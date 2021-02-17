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
	<h1>exUserServletJSTL</h1>
	<h2><a href="UserInsert">회원가입</a></h2>
	<c:if test="${empty user}">
	<h2><a href="UserLogin">로그인</a></h2>
	</c:if>
	<c:if test="${!empty user}">
	<h2><a href="UserModify">정보수정</a></h2>
	<h2><a href="UserLogout">로그아웃</a></h2>
	</c:if>
	
	<h2><a href="UserList">리스트</a></h2>
</body>
</html>