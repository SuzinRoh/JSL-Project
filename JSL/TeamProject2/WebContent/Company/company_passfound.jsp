<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<c:if test="${language=='ko'}">
<script>
	function send(){
		if(company.com_email.value==""){
			alert("메일을 입력해주세요")
			company.com_email.focus();
			return;
		}if(company.com_id.value==""){
			alert("ID를 입력해주세요")
			company.com_id.focus();
			return;
		}
		company.action = "Company?cmd=company_passfound_pro";
		company.submit();
	}
</script>
</c:if>
<c:if test="${language=='ja'}">
<script>
	function send(){
		if(company.com_email.value==""){
			alert("メールをご確認ください。")
			company.com_email.focus();
			return;
		}if(company.com_id.value==""){
			alert("IDをご確認ください。")
			company.com_id.focus();
			return;
		}
		company.action = "Company?cmd=company_passfound_pro";
		company.submit();
	}
</script>
</c:if>
<head>
<style>
#idfounddiv{
	display: flex;
	align-items: center;
}
</style>
<meta charset="UTF-8">
<c:if test="${language=='ko'}">
	<title>비밀번호 찾기</title>
</c:if>
<c:if test="${language=='ja'}">
	<title>パスワード 探し</title>
</c:if>
</head>
<body>
<c:if test="${language=='ko'}">
	<div id = 'idfounddiv'>
	<form name = company method ="post">
		<div>ID를 입력해주세요 : <input type = "text" name = "com_id"></div>
		<div>메일을 입력해주세요 : <input type = "text" name = "com_email"></div>
		<div><input type = button name = gogo value = "전송" onClick = "javascript:send()"></div>
	</form>
	</div>
</c:if>
<c:if test="${language=='ja'}">
	<div id = 'idfounddiv'>
	<form name = company method ="post">
		<div>ID : <input type = "text" name = "com_id"></div>
		<div>メールを入力してください。 : <input type = "text" name = "com_email"></div>
		<div><input type = button name = gogo value = "転送" onClick = "javascript:send()"></div>
	</form>
	</div>
</c:if>
</body>
</html>