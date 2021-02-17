<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${row == 1 }">
	<script>
		alert("이메일전송 완료 이메일을 확인해주세요.");
		location.href="/Main?cmd=main_index";
	</script>
</c:if>

</body>
</html>