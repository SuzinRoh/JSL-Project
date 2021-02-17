<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean b = true;
	int su1,su2;
	int sum=0;
 	if(request.getParameter("su1")!=null){
 		su1=Integer.parseInt(request.getParameter("su1"));
   		su2=Integer.parseInt(request.getParameter("su2"));
   		String select = request.getParameter("select");
   		sum=0;
   		
   		if(select.equals("+")){
   			sum = su1+su2;
   		}else if(select.equals("-")){
   			sum = su1-su2;
   		}else if(select.equals("*")){
   			sum = su1*su2;
   		}else if(select.equals("/")){
   			sum = su1/su2;
   		}
 		
 		b=false;
 	}
 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function send(){
		if(f.su1.value==""){
			alert("again");
			return;
		}
		if(f.su2.value==""){
			alert("again");
			return;
		}
		if(f.select.value=="0"){
			alert("again");
			return;
		}
		f.action="/ex_05";
		f.submit();
	}
</script>
</head>
<body>
<h1>계산기</h1>
<%
		if(b==true){
%>
	<form name=f action="" >
	
		<table border=1>
			<tr>
				<td colspan=3 align=center style="background-color:grey">계 산 기
			</tr>
			<tr>
				<td>정수 <input type=text name=su1 value="" style="width:30px">
				<td><select name=select>
						<option value="0">고르기</option>
						<option value="+">+</option>
						<option value="-">-</option>
						<option value="*">*</option>
						<option value="/">/</option>
					</select>
				<td>정수 <input type=text name=su2 value="" style="width:30px">
			</tr>
			<tr>
				<td colspan=3 align=center>
				<button onclick="send()">계산</button>
			</tr>
			
		</table>
	</form>
<%
		}else{
%>
		<table border=1 width=150px height=100px>
			<tr>
			<td align=center>결과
			</tr>
			<tr>
			<td align=center><%=sum %>
			</tr>
		</table>
<%
		}
%>
</body>
</html>