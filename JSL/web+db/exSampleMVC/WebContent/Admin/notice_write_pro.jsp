<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
 
 <%@ include file="/Access/NotAccess.jsp" %>
 <<c:if test="${row==1 }">
  <script>
  	alert("등록성공");
  	location.href ="Admin?cmd=admin_notice_list&page=${page}";
  </script>
</c:if>
<<c:if test="${row==0 }">
  	<script>
  	alert("등록실패");
  	history.back();
  </script>
</c:if>