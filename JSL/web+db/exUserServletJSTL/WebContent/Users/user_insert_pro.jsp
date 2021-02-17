<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${row==1}">
	<script>
		alert("ok");
		location.href="Users/user_login.jsp"
	</script>
</c:if>
<c:if test="${row==0}">
	<script>
		alert("no");
		history.back();
	</script>
</c:if>