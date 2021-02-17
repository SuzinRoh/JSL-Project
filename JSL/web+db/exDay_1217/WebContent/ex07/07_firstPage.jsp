<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	pageContext.setAttribute("name","page man");
    	request.setAttribute("name","request man");
    	session.setAttribute("name","session man");
    	application.setAttribute("name", "application man");
    	
    	System.out.println("firstPage.jsp :");
    	System.out.println("one page attribute"+pageContext.getAttribute("name"));
    	System.out.println("one request attribute"+request.getAttribute("name"));
    	System.out.println("one session attribute"+session.getAttribute("name"));
    	System.out.println("one application attribute"+application.getAttribute("name"));
    	request.getRequestDispatcher("/ex07/07_secondPage.jsp").forward(request, response);
    	
    %>    
    
    
    
    