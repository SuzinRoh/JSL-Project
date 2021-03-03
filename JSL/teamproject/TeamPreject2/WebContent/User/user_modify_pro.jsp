<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${row == 1}">
		<script>
			alert("정보수정 완료");
			location.href="User?cmd=user_myinfo";
		</script>
	</c:if>
	<c:if test="${row == 0}">
		<script>
		alert("실패하였습니다. 비밀번호를 확인해주세요");
		history.back();
		</script>
	</c:if>
</body>
</html>