<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${ row ==1 }">
		<script>
			alert("delete ok");
			window.opener.location.replace("pds_list");
			self.close();
		</script>
	</c:when>
	<c:when test="${ row ==0 }">
		<script>
			alert("password error ");
			history.back();
		</script>
	</c:when>
</c:choose>