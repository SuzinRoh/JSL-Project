<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*, java.util.*" %>
<%
request.setCharacterEncoding("utf-8");
	String myDriver = "oracle.jdbc.driver.OracleDriver";
	String myURL = "jdbc:oracle:thin:@localhost:1521:xe";
	String myID = "jslhrd46";
	String myPass = "1234";
%>
<%
	
	String select1=""; String key="";
	if(request.getParameter("key")!=null){
		select1=request.getParameter("select1");
		key=request.getParameter("key");
	}

	Connection conn =null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try{
		Class.forName(myDriver);
		conn = DriverManager.getConnection(myURL,myID,myPass);
		//System.out.println("성공");
	}catch(Exception e){
		e.printStackTrace();
		//System.out.println("error");
	}
	
	int cnt=0;//전체건수
	
	String query1="select count(*) from tbl_guest2";
	String query2="select count(*) from tbl_guest2 where "+ select1 +" like '%"+key+"%'";
	
	if(key.equals("")){
		pstmt = conn.prepareStatement(query1);
	}else{
		pstmt = conn.prepareStatement(query2);
	}

	rs = pstmt.executeQuery();
	
	if(rs.next()){
		cnt = rs.getInt(1);
	}
	
	
%>


<html>
<head><title>방명록 읽기</title>
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<style type="text/css">
  a.list {text-decoration:none;color:black;font-size:10pt;}
</style>
<script>
	function s_send(){
		select1.action="Guest/guest_list.jsp";
		select1.submit();
		
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
        <img src="./img/bullet-01.gif"> <b>방 명 록</b></font></td></tr>
      <tr>
        <td colspan="5" align="right" valign="middle" height="20">
		<font size="2" face="고딕">전체 : <%=cnt %></b>건 - 3 Pages</font></td></tr>
 	   <tr bgcolor="e3e9ff">
 	      <td width="10%"align="center" height="20"><font face="돋움" size="2">번호</font></td>
 	      <td width="50%" align="center" height="20"><font face="돋움" size="2">제목</font></td>
 	      <td width="15%" align="center" height="20"><font face="돋움" size="2">글쓴이</font></td>
 	      <td width="15%" align="center" height="20"><font face="돋움" size="2">작성일</font></td>
 	      <td width="10%" align="center" height="20"><font face="돋움" size="2">조회수</font></td>
 	   </tr>
<%
	if(cnt==0){
%>
	 <tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''">
	        <td align="center" height="25" colspan="5">
	        <font face="돋움" size="2" color="#000000" >글이 없습니다.</font>
	        </td>
	       
      </tr>
<%
	}else{
		query1="select * from tbl_guest2 order by idx desc";
		query2="select * from tbl_guest2 where "+select1+" like '%"+key+"%' order by idx desc";
		//String query2="select * from tbl_guest2 order by idx desc";
		if(key.equals("")){
			pstmt = conn.prepareStatement(query1);
		}else{
			pstmt = conn.prepareStatement(query2);
		}
		rs = pstmt.executeQuery();
		while(rs.next()){
			
			int idx = rs.getInt("idx");
			String name = rs.getString("name");
			String subject =rs.getString("subject");
			String contents = rs.getString("contents");
			
			String regdate =rs.getString("regdate").substring(0,10);
			
			String ip = rs.getString("ip");
			String pass = rs.getString("pass");
			int readcnt = rs.getInt("readcnt");
			
		
%>     

 	<tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''">
	        <td align="center" height="25">
	        <font face="돋움" size="2" color="#000000"> <%=idx %></font></td>
	        <td align="left" height="20">
	      
	        <font face="돋움" size="2" color="#000000">
			     <a href="/Guest/guest_view.jsp?idx=<%=idx%>"><%=subject %></a></td>
	        <td align="center" height="20"><font face="돋움" size="2">
	        <a class="list" href="mailto:ein1027@nate.com"><%=name %></a></font></td>
	        <td align="center" height="20"><font face="돋움" size="2"><%=regdate %></font></td>
	        <td align="center" height="20"><font face="돋움" size="2"><%=readcnt %></font></td>
      </tr>
<%
		}
	}
%>  
     <div align="center">
        <table width="700" border="0" cellspacing="0" cellpadding="5">
          <tr>&nbsp;</tr><tr>
             <td colspan="5">   
              <table align="center">
              	 <form name="search" method="post">	
              	 	<tr align="center">
               			<td>
               				<select name="select1">
	               				<option value="name">이름</option>
	               				<option value="subject">제목</option>
	               				<option value="contents">내용</option>
               				</select>
               			</td>
               			<td><input type=text name="key" value="<%=key%>"></td>
               			<td><button name="button" onclick="s_send()">검색</button>
              	 	</tr>
              	 	<tr>
               	
              	 	</tr>
             	  </form> 
               </table>
                <!--  <div align="center">[1][2][3]</div>-->  
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

