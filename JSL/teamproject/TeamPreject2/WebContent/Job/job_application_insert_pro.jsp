<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${row == 1 }">
	<script>
	 	alert("지원성공");
	 	window.location.href="Job_opening?cmd=company_job_opening_detail&num=${num}"
	</script>
</c:if>
<c:if test="${row == 0 }">
	<script>
		alert("지원실패");
	</script>
</c:if>