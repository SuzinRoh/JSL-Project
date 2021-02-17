<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="esDay_1223.model.*" %>
<%

	request.setCharacterEncoding("utf-8");

	guestVO vo =new guestVO();
	
	vo.setIdx(Integer.parseInt(request.getParameter("idx")));
	vo.setName(request.getParameter("name"));
	vo.setPass(request.getParameter("pass"));
	vo.setSubject(request.getParameter("subject"));
	vo.setContents(request.getParameter("contents"));
	
	guestDAO dao = new guestDAO();
	int row = dao.guestEdit(vo);
	
	if(row==0){
%>
 <script>
 	alert("no");
 	history.back();
 </script>
 <%
 } else{
 %>
 <script>
 	alert("ok");
 	location.href="/Guest/guest_list.jsp";
 </script>
 <%
 }
 %>