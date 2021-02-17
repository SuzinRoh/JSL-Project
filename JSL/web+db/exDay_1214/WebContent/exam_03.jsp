<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function send(){
		if(form_1.su1.value==""){
			alert("입력하세요");
			return;
		}
		if(form_1.su2.value==""){
			alert("입력하세요");
			return;
		}
		
		alert("전송");
		form_1.action="/cal";
		form_1.submit();
	}
</script>
</head>
<body>

	<form name=form_1 action="">
		<table border=1>
			<tr>
			<td colspan="2" align="center">
			 입력
			</tr>
			
			<tr>
			<td>값1</td>
			<td><input type=text name=su1 value="" ></td>
			</tr>
			
			<tr>
			<td>값2</td>
			<td><input type=text name=su2 value="" ></td>
			</tr>
			
			<tr>
			<td colspan="2"  align="center">
			 <button name=sendbutton  onclick="send()">계산</button>
			</tr>
			
		</table>
	</form>
</body>
</html>