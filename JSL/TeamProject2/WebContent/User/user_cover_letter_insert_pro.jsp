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
	<c:if test="${row == 1 }">
		<script>
			alert("저장이 완료되었습니다.");
			location.href = "User?cmd=user_cover_letter_list";
		</script>
	</c:if>
	<c:if test="${row == 0 }">
		<script>
			alert("작성에 실패하였습니다.");
			history.back();
		</script>
	</c:if>
	<c:if test="${row == -1 }">
		<script>
			alert("세션이 존재하지 않습니다. 로그인후 다시 이용해주시길 바랍니다.");
			location.href = "User?cmd=user_login";
		</script>
	</c:if>
</body>
</html>