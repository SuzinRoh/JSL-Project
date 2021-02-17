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
	<table>
		<tr>
			<c:if test="${empty userid }">일치하는 정보가 없습니다.</c:if>
			<c:if test="${!empty userid }">당신의 ID는 ${userid } 입니다.</c:if>
		</td>
	</form>
</body>
</html>