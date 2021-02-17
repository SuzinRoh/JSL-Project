<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import= "java.util.* , exBoard_Servlet_JSP.model.*" %>
<%

	List<BoardVO> list = (List) request.getAttribute("list");
	int listcount = (int)request.getAttribute("listcount");
	String search =(String)request.getAttribute("search");
	
%>
<html>
<head><title>게시판 읽기</title>
<link rel="stylesheet" type="text/css" href="/stylesheet.css">
<style type="text/css">
  a.list {text-decoration:none;color:black;font-size:10pt;}
  a {text-decoration:none; color:black;} 
</style>
<script>
	function sear(){
		if(frm_s.key.value==""){
			alert("check search box");
			frm_s.key.focus();
			return;
		}
		frm_s.submit();
		
	}
</script>
</head>
<body bgcolor="#FFFFFF" topmargin="0" leftmargin="0">
<table border="0" width="800">
  <tr>
    <td width="20%" height="500" valign="top" bgcolor="#ecf1ef">

	<!-- 다음에 추가할 부분 --></td>

	<td width="80%" valign="top">	
		<br>
    <table border="0" cellspacing="1" width="100%" align="center">
      <tr>
        <td colspan="7" align="center" valign="center" height="20">
        <font size="4" face="돋움" color="blue">
        <img src="Board/img/bullet-01.gif"> <b>자 유 게 시 판</b></font></td></tr>
      <tr>
        <td colspan="5" align="right" valign="middle" height="20">
		<font size="2" face="고딕">전체 : <b>${totcount}</b>건 - ${totpage}/ ${page} Pages</font></td></tr>
 	   <tr bgcolor="e3e9ff">
 	      <td width="10%" align="center" height="20"><font face="돋움" size="2">번 호</font></td>
 	      <td width="50%" align="center" height="20"><font face="돋움" size="2">제 목</font></td>
 	      <td width="15%" align="center" height="20"><font face="돋움" size="2">글쓴이</font></td>
 	      <td width="15%" align="center" height="20"><font face="돋움" size="2">작성일</font></td>
 	      <td width="10%" align="center" height="20"><font face="돋움" size="2">조회수</font></td>
 	   </tr>
<%
	for(int i=0;i<list.size(); i++){
		int idx=list.get(i).getIdx();
%>
		<tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''">
			<td align="center" height="25">
			<font face="돋움" size="2" color="#000000"><%=listcount-- %></font></td>
			<td align="left" height="20">&nbsp;
				<font face="돋움" size="2" color="#000000">
				<a class="list" href=""><a href="BoardView.do?idx=<%=idx%>&page=${page}"><%=list.get(i).getSubject()%></a></td>
					<td align="center" height="20"><font face="돋움" size="2">
					<a class="list" href="mailto:ein1027@nate.com"><%=list.get(i).getName()%></a></font></td>
				<td align="center" height="20"><font face="돋움" size="2"><%=list.get(i).getRegdate().substring(0,10)%></font></td>
				<td align="center" height="20"><font face="돋움" size="2">
				<%=list.get(i).getReadcnt() %></font></td>
		</tr>
<% 
	}
%>	
	 <div align="center">
        <table width="700" border="0" cellspacing="0" cellpadding="5">
          <tr>&nbsp;</tr><tr>
             <td colspan="5">        
                <div align="center">${pageSkip}</div>
			  </td>
			 </tr>
		</table>

	<table width="600">
		<tr>
			<td width="25%"> &nbsp;</td>
			<td width="50%" align="center">
				<table>
					<form name = "frm_s" method="post" action="BoardList.do">	
					<!-- 검색어를 이용하여 글제목, 작성자, 글내용 중에 하나를 입력 받아 처리하기 위한 부분 -->
						<tr>
							<td>
								<select name="search">
									<option value="subject" <%if(search.equals("subject")) { %> selected <%} %>>글제목</option>
									<option value="name" <%if(search.equals("name")) { %> selected <%} %>>작성자</option>
									<option value="contents" <%if(search.equals("contents")) { %> selected <%} %>>글내용</option>
								</select>
							</td>
							<td> <input type="text" size=20 name="key" value="${key}"></td>
							<td> <button onclick="javascript:sear()">검색</button></td>
						</tr>
					</form>
				</table>
			</td>
			<td width="25%" align="right">
			 <a href="BoardWrite.do?page=${page}"><img src="Board/img/write.gif" border="0"></a>
			</td>
		</tr>
	</table>
</body>
</html>

