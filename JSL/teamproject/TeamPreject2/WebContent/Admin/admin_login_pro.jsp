<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%request.setCharacterEncoding("utf-8");%>
<c:if test="${language=='ko'}">
	<c:if test="${row==0}">
		<script>
			alert("일치하는 정보가 없습니다.");
			history.back();
		</script>
	</c:if>
	<c:if test="${row==1}">
		<script>
			alert("로그인 되었습니다.");
			 location.href="AdminNeko?cmd=admin_index";
		</script>
	</c:if>
</c:if>
<c:if test="${language=='ja'}">
	<c:if test="${row==0}">
		<script>
			alert("一致する情報がありません。");
			history.back();
		</script>
	</c:if>
	<c:if test="${row==1}">
		<script>
			location.href="AdminNeko?cmd=admin_index";
		</script>
	</c:if>
</c:if>
<input type = button value = "close" onClick ="javascript:self.close()">

