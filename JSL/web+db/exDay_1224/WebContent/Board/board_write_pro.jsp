<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, model.*"  %>

<%
	request.setCharacterEncoding("utf-8");
	
	
 	//2. db connection
 	
 	boardDAO dao = boardDAO.getInstance();
 	boardVO vo =new boardVO();
	
 	vo.setName(request.getParameter("name"));
 	vo.setEmail(request.getParameter("email"));
 	vo.setSubject(request.getParameter("subject"));
 	vo.setContents(request.getParameter("contents"));
 	vo.setPass(request.getParameter("pass"));
 	vo.setIp(request.getRemoteAddr());
 	
 	int row = dao.boardWrite(vo);
	
	
	if(row==1){
%>
<script type="text/javascript">
	alert("등록");
	location.href="/Board/board_list.jsp";
</script>	
		
<%		
	}else{

%>
<script type="text/javascript">
	alert("실패");
	location.href="/Board/board_write.jsp";
</script>	
<%		
	}

%>