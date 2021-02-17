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
	귀하의 ID는 ${id}입니다.
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
	貴下のIDは　${id}となります。
	</c:if>
</c:if>
<input type = button value = "close" onClick ="javascript:self.close()">

