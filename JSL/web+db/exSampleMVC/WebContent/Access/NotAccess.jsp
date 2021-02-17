<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
 String strReferer = request.getHeader("referer");
 
 if(strReferer == null){
%>
 <script>
	alert("잘못된 접근입니다");
 	location.href="Main?cmd=index";
 </script>
<%
  return;
 }
%>
