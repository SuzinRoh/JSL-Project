<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%request.setCharacterEncoding("utf-8");%>
<c:if test="${!empty com_id}">
	${com_id}님 !<br>
	${com_email}로 이메일을 보냈습니다.
</c:if>
<input type = button value = "close" onClick ="javascript:self.close()">

