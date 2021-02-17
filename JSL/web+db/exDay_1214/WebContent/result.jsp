<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
 
    	int su1= Integer.parseInt(request.getParameter("su1"));
    	int su2= Integer.parseInt(request.getParameter("su2"));
    	int cal = su1+su2;
   
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1 width=150px height=100px>
		<tr>
		<td align=center>결과
		</tr>
		<tr>
		<td align=center>x+y = <b><%=cal %></b>
		</tr>
	</table>
	
</body>
</html>