<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
	<c:when test="${row == 1}">
		<script>
			alert("성공");
			location.href="BoardList.do?page=${page}";
		</script>
	</c:when>
	<c:when test="${row == 0}">
		<script>
			alert("실패");
			history.back();
		</script>
	</c:when>
	<c:otherwise> </c:otherwise>
</c:choose>