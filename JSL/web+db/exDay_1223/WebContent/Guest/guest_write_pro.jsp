<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="esDay_1223.model.*" %>
<%

	request.setCharacterEncoding("utf-8");

	String name =request.getParameter("name");
	String pass =request.getParameter("pass");
	String subject =request.getParameter("subject");
	String contents =request.getParameter("contents");
	
	System.out.println(name);
	
	guestVO vo =new guestVO();
	
	vo.setName(name);
	vo.setPass(pass);
	vo.setSubject(subject);
	vo.setContents(contents);
	
	guestDAO dao = new guestDAO();
	int row = dao.guestWrite(vo);
	
	//int row = dao.guestWrite(name,pass,subject,contents);
	
	if(row==0){
%>
 <script>
 	alert("no");
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