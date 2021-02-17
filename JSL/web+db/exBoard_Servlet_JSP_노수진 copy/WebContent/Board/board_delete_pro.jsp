<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${row==1 }">
	<script>
		alert("삭제완료");
		
		opener.location.href="BoardList.do?${page}";
		self.close();
	</script>
</c:if>
<c:if test="${row==0 }">
	<script>
		alert("삭제실패");
		self.close();
	</script>
</c:if>
