<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		f.action="/ex_04_servlet";
		f.submit();
	}
</script>
</head>
<body>
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
</body>
</html>