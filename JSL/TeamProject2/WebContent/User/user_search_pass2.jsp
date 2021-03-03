<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
	function check() {
		if (pass.userid.value == "") {
			alert("아이디을 입력해주세요");
			pass.userid.focus();
			return;
		}
		if (pass.email.value == "") {
			alert("메일을 입력해주세요");
			pass.email.focus();
			return;
		}
		pass.submit();
	}
</script>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name=pass method=post action="User?cmd=user_search_pass_pro">
		<table>
			<tr>
				<td>아이디를 입력해주세요. <input type=text name=userid size=16 maxlenght=16 style="WIDTH: 155">
				</td>
			</tr>
			<tr>
				<td>이메일을 입력해주세요. <input type=text name=email size=16 maxlenght=16 style="WIDTH: 155">
				<td><input type=button value="확인" onClick="check()"></td>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>