<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

%>

<jsp:useBean id="guest" class="model.guestBean">

	<jsp:setProperty name="guest" property="*"/>
	

</jsp:useBean>
<%
	guest.setContents(guest.getContents().replace("\n", "<br>"));

%>
name : <%=guest.getName() %><br>
title : <%=guest.getSubject() %><br>
contents :<%=guest.getContents() %> <br>
