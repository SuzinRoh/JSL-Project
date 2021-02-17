<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>  
    
    
    
 <%
 
 	//1.driver roading
 	
 	
 	
 	try{
 		Class.forName("oracle.jdbc.driver.OracleDriver");
 		out.print("driver roading succse" );
 	}catch(Exception e){
 		e.printStackTrace();
 	}
 
 	//2. db connection
 	
 	try{
 		
 		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jslhrd46","1234");
 		out.print("connection succse");
 	}catch(Exception e){
 		e.printStackTrace();
 	}
 %>