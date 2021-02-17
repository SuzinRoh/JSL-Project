<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	int age = Integer.parseInt(request.getParameter("age"));
	String name=request.getParameter("name");
	if(age <=19){
		
%>
<script type="text/javascript">
	alert("your not in");
	history.go(-1)
</script>
<%
	/*}else{
		request.setAttribute("name","yunjeong");
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("05_forwardResult.jsp");
		dispatcher.forward(request,response);
	}*/
	}else{
		
		response.sendRedirect("05_forwardResult.jsp?name="+name+"&age="+age);
		//request.setAttribute("name", name);
		//RequestDispatcher dispatcher = request.getRequestDispatcher("05_forwardResult.jsp");
		//dispatcher.forward(request,response);
	}
%>