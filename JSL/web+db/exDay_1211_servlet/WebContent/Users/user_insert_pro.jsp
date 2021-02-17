<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
  이름 : ${name}<br>
  row : ${row}
  
  <%
  	String name = (String)request.getAttribute("name");
  	int row = (int) request.getAttribute("row");
  
  %>
  
  
 이름 <%=name%>