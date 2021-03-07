<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${row==1}" >	
	<script>
		alert("ok");
		location.href="board_list";
	</script>
</c:if>


<c:if test="${row!==1}" >
	<script>
		
		location.href="board_list";
	</script>

</c:if>