<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<c:if test="${row == 1 }" >
<script>
	alert("${userid}님의 이메일(${email})로 임시 비밀번호가 발급되었습니다.");
	window.close();
</script>
</c:if>
<c:if test="${row == 0 }" >
<script>
	alert("일치하는 정보가 없습니다.");
	location.href = "User?cmd=user_search_pass";
</script>
</c:if>
