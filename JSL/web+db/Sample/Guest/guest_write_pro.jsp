<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
  <%
  	//값 처리
  	// db connection
  	
  	//result 저장
  	int row =1;
  /*
  
  if(row==1){
	response.sendRedirect("guest_list.jsp");
  }else{
	response.sendRedirect("guest_write.jsp");
  }
  */
  row =100;
  out.println("<h1>aaaa </h1>:"+row+"<br>");
  out.println("aaaa<br>");
  out.println("aaaa"+"<br>");
  out.println("aaaa");
  out.println("aaaa");
  
  
  
  	if(row==1){
  		
  %>  
 
  <script>
  	alert("등록성공");
  	locationt.href ="guest_list.jsp";
  	
  </script>
  <%
  	}else{
  %>
  	<script>
  	alert("등록실패");
  	history.back();
  </script>
  <%
  	}
  %>
  
  
  <h1>ssssssss</h1>
  <%= row %>