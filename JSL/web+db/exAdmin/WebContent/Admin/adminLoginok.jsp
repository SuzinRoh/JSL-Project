<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>관리자 정보 - 관리자페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
<!--
body, td, th {
	font-size: 12px;
	color: #606060;
}

body {
	margin-left: 0px;
	margin-top: 0px;
}
-->
</style>


</head>

<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td><jsp:include page="top_menu.jsp" flush="true" /></td>
		</tr>
		<tr>
			<td align="center" height="100%" valign=middle><br>
				<table width="30%" border="1" cellspacing="0" cellpadding="3"
					bgcolor="#FFCC66" bordercolor="#FFFFFF" bordercolorlight="#000000">
					<tr>

						<td height=40 align="center" style="font-size: 15px;"><b>${admin}님
								환영합니다.</b> </b></td>
					</tr>
			
				<table cellpadding=0 cellspacing=0 border=0 width=330>
					<tr>
						<td align="center"><a href="UserModify">[자기정보수정]</a> <a
							href="UserLogout">[로그아웃] <a href="index.jsp">[메인] </td>
					</tr>
				</table>
</body>
</html>
