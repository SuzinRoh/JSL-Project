<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/Access/NotAccess.jsp" %>
<html>
<head>
<title>공지사항 관리 - 관리자페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
<!--
body, td, tr, table {
	font-size: 9pt;
	font-family: tahoma;
	color: #666666;
	line-height: 160%;
}

A:link {
	font-family: tahoma;
	font-size: 9pt;
	color: #666666;
	text-decoration: none;
}

A:visited {
	font-family: tahoma;
	font-size: 9pt;
	color: #666666;
	text-decoration: none;
}

A:active {
	font-family: tahoma;
	font-size: 9pt;
	color: #666666;
	text-decoration: none;
}

A:hover {
	font-family: tahoma;
	font-size: 9pt;
	color: #009900;
	text-decoration: underline;
}
-->
</style>
<script>
	function sendsearch(){
		b_search.action="Admin?cmd=admin_notice_list";
		b_search.submit();
		
	}
</script>
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
						<td height=40 align="center" style="font-size: 15px;"><b>공지사항
								리스트</b></a> </b></td>
					</tr>
				</table>
				<br>
				<table width="80%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="20">* 총 등록수 : <font color=red>${totcount}</font> 건
						</td>
					</tr>
					<tr>
						<td><table width="100%" border="0" cellpadding="6"
								cellspacing="1" bgcolor="DDDDDD">
								<tr bgcolor="EcECEC">
									<td width="15%" align="center" bgcolor="EcECEC"><strong>번호</strong></td>
									<td align="center" bgcolor="EcECEC"><strong>제목</strong></td>
									<td width="20%" align="center"><strong>접수일</strong></td>
									<td width="10%" align="center"><strong>조회수</strong></td>
								</tr>
								<c:if test="${totcount == 0}">
								<tr>
									<td align="center" bgcolor="#FFFFFF" colspan="4">작성된 글이 없습니다.</td>
								
								</tr>
								</c:if>
								<c:if test="${totcount > 0}">
								<c:forEach var="notice" items="${list }">
								<tr>
									<td align="center" bgcolor="#FFFFFF">${listcount}</td>
									<td bgcolor="#FFFFFF"><a href="Admin?cmd=admin_notice_view&idx=${notice.idx}&page=${page}" >${notice.subject }</a></td>
									<td align="center" bgcolor="#FFFFFF">${notice.regdate.substring(0,10) }</td>
									<td align="center" bgcolor="#FFFFFF">${notice.readcnt }</td>
								</tr>
								<c:set var="listcount" value="${listcount-1 }"/>
								</c:forEach>
								</c:if>
								<tr>
									<td height="35" colspan="10" align="center" bgcolor="#FFFFFF">${pageSkip }</td>
								</tr>
								<form action="" method="post" name="b_search">
									<tr>
										<td colspan="10" align="center" bgcolor="#FFFFFF"><table
												width="610" border="0" cellspacing="0" cellpadding="0">
												<tr>
													<td width=80% height="30" colspan="2" align="center">
														<select name="search" class="textfield">
														<option value="subject">제목</option>
														<option value="contents">내용</option>
														<option value="name">이름</option>
														</select> 
														<input name="key" type="text" class="textfield" size="30" value="${key}">
													</td>
													<td width=20% align="left"><button oneclick="sendsearch()">검색</button>
														&nbsp;<button><a href="Admin?cmd=admin_notice_write&page=${page}">글쓰기</a></button></td>
												</tr>
											</table>
											</td>
									</tr>
							</table>
</body>
</html>
