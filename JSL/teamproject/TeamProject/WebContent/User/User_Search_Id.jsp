<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
	function check() {
		if (user.name.value == "") {
			alert("이름을 입력해주세요");
			user.name.focus();
			return;
		}
		if (user.email.value == "") {
			alert("이름을 입력해주세요");
			user.email.focus();
			return;
		}
		user.submit();
	}
</script>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name=user method=post action="User?cmd=user_search_id_pro">
		<table>
			<tr>
				<td>이름을 입력해주세요. <input type=text name=name size=16 maxlenght=16 style="WIDTH: 155">
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