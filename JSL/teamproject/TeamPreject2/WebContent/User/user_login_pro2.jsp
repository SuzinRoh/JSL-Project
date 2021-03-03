<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<c:if test="${row eq -1 }">
	<script>
   		alert("존재하지 않는 계정입니다.");
   		history.back();
   </script>
</c:if>

<c:if test="${row eq 0 }">
	<script>
   		alert("비밀번호가 일치하지 않습니다.");
   		history.back();
   </script>
</c:if>

<c:if test="${row eq 1 }">
<body>
	${user.user_num } <br>
	${user.user_id }<br>
	${user.user_email }<br>
	${user.user_name }<br>
	${user.user_tel }<br>
	${user.user_regidate }<br>
	${user.user_lastlogin }<br>
	
	<script>
   location.href="Main?cmd=main_index";
   </script>
</body>
</c:if>
</html>