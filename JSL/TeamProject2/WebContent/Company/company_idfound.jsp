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
		}if(company.com_name.value==""){
			alert("기업이름을 입력해주세요")
			company.com_name.focus();
			return;
		}
		company.action = "Company?cmd=company_idfound_pro";
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
		}if(company.com_name.value==""){
			alert("企業名をご確認ください。")
			company.com_name.focus();
			return;
		}
		company.action = "Company?cmd=company_idfound_pro";
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
	<title>아이디 찾기</title>
</c:if>
<c:if test="${language=='ja'}">
	<title>ID 探し</title>
</c:if>
</head>
<body>
<c:if test="${language=='ko'}">
	<div id = 'idfounddiv'>
	<form name = company method ="post">
		<div>기업 이름을 입력해주세요 : <input type = "text" name = "com_name"></div>
		<div>메일을 입력해주세요 : <input type = "text" name = "com_email"></div>
		<div><input type = button name = gogo value = "전송" onClick = "javascript:send()"></div>
	</form>
	</div>
</c:if>
<c:if test="${language=='ja'}">
	<div id = 'idfounddiv'>
	<form name = company method ="post">
		<div>企業名をご入力してください。 : <input type = "text" name = "com_name"></div>
		<div>メールを入力してください。 : <input type = "text" name = "com_email"></div>
		<div><input type = button name = gogo value = "転送" onClick = "javascript:send()"></div>
	</form>
	</div>
</c:if>
</body>
</html>