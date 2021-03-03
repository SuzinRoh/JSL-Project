<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${row == 1}">
		<script>
			alert("기업공고 등록 완료!!");
			location.href="/Main?cmd=main_index";
		</script>
	</c:if>
</body>
</html>