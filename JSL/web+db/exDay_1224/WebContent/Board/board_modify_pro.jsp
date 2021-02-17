<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%
	boardDAO dao = boardDAO.getInstance();
	boardVO vo =new boardVO();
	
	request.setCharacterEncoding("utf-8");
	int idx = Integer.parseInt(request.getParameter("idx"));
	String email = request.getParameter("email");
	String subject = request.getParameter("subject");
	String contents =request.getParameter("contents");
	String pass = request.getParameter("pass");
	
	
	
	int row = dao.boardEdit(idx,subject,email,contents,pass);
	
	
	if(row==0){
%>
<script>
	alert("no");
	history.back();
</script>
<%
	} else {
%>
<script>
	alert("yes");
	location.href="/Board/board_view.jsp?idx=<%=idx%>";
</script>
<%
	}
%>