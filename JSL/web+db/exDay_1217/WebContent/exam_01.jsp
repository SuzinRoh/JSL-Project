<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="b.jsp">b</a><br>
 컨텍스트패스 :<%= request.getContextPath() %><br>
 요청방식    :<%= request.getMethod() %><br>
 요청한 URL :<%= request.getRequestURL() %><br>
 요청한 URI :<%= request.getRequestURI() %><br>
 서버의 이름 :<%= request.getServerName() %><br>
 프로토콜    :<%= request.getProtocol() %><br>
 네트워크 주소:<%= request.getRemoteHost() %><br>
 <form method="post" action="b.jsp">
 	<%= request.getMethod() %>
 	<input  type=submit>
 </form>
</body>
</html>