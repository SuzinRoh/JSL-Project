<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>회원목록 보여주기</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<STYLE TYPE="text/css">
<!--
body {
	font-family: 돋움, Verdana;
	font-size: 9pt
}

td {
	font-family: 돋움, Verdana;
	font-size: 9pt;
	text-decoration: none;
	color: #000000
}
-
-->
</STYLE>
</head>
<body>
	<tr>
		<td><jsp:include page="top_menu.jsp" flush="true" /></td>
	</tr>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td align="center" height="100%" valign=middle><br>
				<table width="30%" border="1" cellspacing="0" cellpadding="3"
					bgcolor="#FFCC66" bordercolor="#FFFFFF" bordercolorlight="#000000">
					<tr>
						<td height=40 align="center" style="font-size: 15px;"><b>회원관리</b></a>
							</b></td>
					</tr>
				</table> <br>
				<table width="80%" border="0" cellspacing="0" cellpadding="0">
					<td height="20">* 총 등록수 : <font color=red>10</font> 건
					</td>
					<tr>

						<td><table width="100%" border="0" cellpadding="6"
								cellspacing="1" bgcolor="DDDDDD">
								<tr bgcolor="EcECEC">
									<td align="center" bgcolor="EcECEC"><strong>번호</strong></td>
									<td align="center" bgcolor="EcECEC"><strong>ID</strong></td>
									<td align="center"><strong>이름</strong></td>
									<td align="center"><strong>주소</strong></td>
									<td align="center"><strong>전화번호</strong></td>
									<td align="center" bgcolor="EcECEC"><strong>이메일</strong></td>
									<td align="center" bgcolor="EcECEC"><strong>가입일자</strong></td>
									<td align="center" bgcolor="EcECEC"><strong>최근접속일자</strong></td>
									<td align="center" bgcolor="EcECEC"><strong>삭제여부</strong></td>
								</tr>
								<tr>
									<td align="center" bgcolor="#FFFFFF">1</td>
									<td align="center" bgcolor="#FFFFFF">1</td>
									<td align="center" bgcolor="#FFFFFF">1</td>
									<td align="center" bgcolor="#FFFFFF">1</td>
									<td align="center" bgcolor="#FFFFFF">1</td>
									<td align="center" bgcolor="#FFFFFF">1</td>
									<td align="center" bgcolor="#FFFFFF">1</td>
									<td align="center" bgcolor="#FFFFFF">1</td>
									<td align="center" bgcolor="#FFFFFF">1</td>

								</tr>

								<tr>
									<td height="35" colspan="10" align="center" bgcolor="#FFFFFF"></td>
								</tr>
								<form action="" method="post" name="b_search">
									<tr>
										<td colspan="10" align="center" bgcolor="#FFFFFF"><table
												width="610" border="0" cellspacing="0" cellpadding="0">
												<tr>
													<td><select name="search_gubun">
															<option>이름</option>
															<option>주소</option></td>
													</select>
													<td>찾는이름: <input type="text" name="search_name"
														size=10> &nbsp; <input type=hidden name="user_id">[조회]</a>
													</td>
											</table></td>
									</tr>
							</table> <!-- <tr>
						<table width="800" border="1" cellspacing="0" cellpadding="2"
							bordercolorlight="#173E7C" bordercolordark="white">
							
							<tr>
								<td width=50 align=center>번호</td>
								<td width=100 align=center>ID</td>
								<td width=100 align=center>이름</td>
								<td width=400 align=center>주소</td>
								<td width=150 align=center>전화번호</td>
								<td width=200 align=center>이메일</td>
								<td width=150 align=center>가입일자</td>
								<td width=150 align=center>최근접속일자</td>
								<td width=100 align=center>삭제여부</td>

							</tr>
							<tr>
								<td align=center>9</td>
								<td align=center>ein1027</td>
								<td align=center>홍길동</td>
								<td width=300>대전광역시 중구 도마동 114(집)</td>
								<td align=center>042-222-1111</td>
								<td align=center>aaaa@aaaa.com</td>
								<td align=center>2019-01-01</td>
								<td align=center>2019-03-30</td>
								<td align=center>[삭제]</td>
							</tr>

						</table>
						<table width=550>
							<tr>
								<td><select name="search_gubun">
										<option>이름</option>
										<option>주소</option></td>
								<td>찾는이름: <input type="text" name="search_name" size=10>
									&nbsp; <input type=hidden name="user_id">[조회]</a>
								</td>
							</tr>
						</table>
						-->
</body>
</html>
