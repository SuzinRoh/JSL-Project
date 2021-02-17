<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
  <%
  request.setCharacterEncoding("utf-8");
  
  
  String name = request.getParameter("name");
  String subject =request.getParameter("subject");
  String contents=request.getParameter("contents");
  contents = contents.replace ("\n", "<br>");
  out.print("writer :"+name+"<br>");
  out.print("writer :"+subject+"<br>");
  out.print("writer :"+contents+"<br>");
  %>