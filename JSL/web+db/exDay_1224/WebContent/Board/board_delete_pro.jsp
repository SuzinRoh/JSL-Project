<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%

	int idx = Integer.parseInt(request.getParameter("idx"));
	String pass = request.getParameter("pass");
	boardDAO dao = boardDAO.getInstance();
	
	
	int row = dao.boardDelete(idx,pass);
	
	if(row==0){
%>
 <script>
 	alert("no");
 	self.close();
 </script>
 <%
 } else{
 %>
 <script>
 	alert("ok");
 	opener.location.replace("/Guest/guest_list.jsp");
	self.close();
 </script>
 <%
 }
 %>