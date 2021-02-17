<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String[][] hak={{"1","홍길동","010-1111-1111"},
			      {"2","김정민","010-1111-1111"},
			      {"3","박현수","010-1111-1111"},
			      {"4","김덕배","010-1111-1111"},
			      {"5","황시현","010-1111-1111"}};


	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<br>

	<table border=1>
		<tr>
			<td>번호
			<td>이름
			<td>전화
		</tr>
		
<%
	for(int i=0;i<hak.length;i++){
		out.print("<tr>");
		for(int j=0; j<hak[i].length;j++){
			//String name=hak[i][j];
			out.print("<td>"+hak[i][j]+"</td>");
			//out.print("<br>");

		}
		out.print("<tr>");
	}

%>
	
	</table>

</body>
</html>