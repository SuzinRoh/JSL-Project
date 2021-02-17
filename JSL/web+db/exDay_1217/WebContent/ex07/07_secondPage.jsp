<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
one page attribute :<%=pageContext.getAttribute("name") %><br>
one request attribute :<%=request.getAttribute("name") %><br>
one session attribute :<%=session.getAttribute("name") %><br>
one application attribute :<%=application.getAttribute("name") %><br>

<a href="/ex07/07_thirdPage.jsp">another page</a>
</body>
</html>