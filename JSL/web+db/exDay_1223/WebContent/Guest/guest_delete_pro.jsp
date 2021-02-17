<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="esDay_1223.model.*" %>
<%

	request.setCharacterEncoding("utf-8");

	guestVO vo =new guestVO();
	
	int idx =Integer.parseInt(request.getParameter("idx"));
	String pass = request.getParameter("pass");
	guestDAO dao = new guestDAO();
	
	int row = dao.guestDelete(idx,pass);
	
	if(row==1){
%>
<script type="text/javascript">
		opener.location.replace("/Guest/guest_list.jsp");
		self.close();
			
</script>
<%
		//response.sendRedirect("/Guest/guest_list.jsp");

 	} else {
 %>
 <script type="text/javascript">
	alert("비밀번호를 확인해 주세요");
	history.back();
</script>
<%
 }
 %>