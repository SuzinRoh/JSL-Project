<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%request.setCharacterEncoding("utf-8");%>
<c:if test="${language=='ko'}">
	<c:if test="${row==0}">
		<script>
			alert("회원가입 승인에 실패했습니다.");
			history.back();
		</script>
	</c:if>
	<c:if test="${row==1}">
		<script>
			alert("회원가입 승인이 완료되었습니다.");
			 location.href="AdminNeko?cmd=admin_confirm";
		</script>
	</c:if>
</c:if>
<c:if test="${language=='ja'}">
	<c:if test="${row==0}">
		<script>
			alert("失敗");
			history.back();
		</script>
	</c:if>
	<c:if test="${row==1}">
		<script>
			alert("完了");
			 location.href="AdminNeko?cmd=admin_confirm";
		</script> 
	</c:if>
</c:if>
<input type = button value = "close" onClick ="javascript:self.close()">

