<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    name : ${name}<br>
 <%
 	
  	String[] str =((String)request.getAttribute("tmp")).split(",");
  
	for(int i=0;i<str.length;i++){
		
	
 %>
 	
 	취미
 	<%
 	out.println((i+1)+":");
 	out.println(str[i]);
 	out.println("<br>");
	}
 	%>
 	<br>
