<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="esDay_1223.model.* , java.util.*" %>
<%
	guestDAO dao = new guestDAO();

	int count = dao.guestCount();
	List<guestVO> list= dao.guestList();
	
	
%>
<html>
<head><title>방명록 읽기</title>
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<style type="text/css">
  a.list {text-decoration:none;color:black;font-size:10pt;}
</style>
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
        <img src="./img/bullet-01.gif"> <b>방 명 록</b></font></td></tr>
      <tr>
        <td colspan="5" align="right" valign="middle" height="20">
		<font size="2" face="고딕">전체 : <%=count %></b>건 - 3 Pages</font></td></tr>
 	   <tr bgcolor="e3e9ff">
 	      <td width="10%"align="center" height="20"><font face="돋움" size="2">번호</font></td>
 	      <td width="50%" align="center" height="20"><font face="돋움" size="2">제목</font></td>
 	      <td width="15%" align="center" height="20"><font face="돋움" size="2">글쓴이</font></td>
 	      <td width="15%" align="center" height="20"><font face="돋움" size="2">작성일</font></td>
 	      <td width="10%" align="center" height="20"><font face="돋움" size="2">조회수</font></td>
 	   </tr>
<%	
	if(list.size()==0){//if(list.size()==0){
%>
	<tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''">
        <td align="center" height="25" colspan="5">
        <font face="돋움" size="2" color="#000000">등록된 자료가 없습니다.</font></td>
        </tr>
<%
	} else{
		//List<guestVO> list= dao.guestList();
		//System.out.println("list1");
		for(int x=0; x<list.size();x++){	
			//System.out.println("list2");
		
%>
		<tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''">
        <td align="center" height="25">
        <font face="돋움" size="2" color="#000000"><%=list.get(x).getIdx() %></font></td>
        <td align="left" height="20">
        <font face="돋움" size="2" color="#000000"><a href="/Guest/guest_view.jsp?idx=<%=list.get(x).getIdx()%>"><%=list.get(x).getSubject() %></a></td>
        <td align="center" height="20"><font face="돋움" size="2">
        <a class="list" href="mailto:ein1027@nate.com"><%=list.get(x).getName() %></a></font></td>
        <td align="center" height="20"><font face="돋움" size="2"><%=list.get(x).getRegdate().substring(0,10) %></font></td>
        <td align="center" height="20"><font face="돋움" size="2"><%=list.get(x).getReadcnt() %></font></td>
      </tr>
 <%
		}
	}
%>
	     
      
     <div align="center">
        <table width="700" border="0" cellspacing="0" cellpadding="5">
          <tr>&nbsp;</tr><tr>
             <td colspan="5">        
                <div align="center">[1][2][3]</div>
			  </td>
			 </tr>
			<tr align=right><td colspan="5">
				<a href="guest_write.jsp?page=1&now=10&kor=100"><img src="Guest/img/write.gif" border="0"></a>
			</td>
			</tr>
		</table>
		</div>
	</body>
	</html>

