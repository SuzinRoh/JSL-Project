<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
  <%
   	int row =(int) request.getAttribute("row");
  
  	if(row==1){
  		
  %>  
 
  <script>
  	alert("삭제성공");

  	opener.location.href ="guest_list?page=${page}";
  	self.close();
  </script>
  <%
  	}else{
  %>
  	<script>
  	alert("삭제실패");
  	history.back();
  </script>
  <%
  	}
  %>
