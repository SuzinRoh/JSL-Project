<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="model.* , java.util.*" %>
<%
	
	int idx = Integer.parseInt(request.getParameter("idx"));
	
	boardDAO dao = boardDAO.getInstance();
	
	//쿠키가있는지 검사
	boolean b = false;
	Cookie info = null;
	Cookie[] cookies = request.getCookies();
	for(int x=0; x<cookies.length; x++){
		info = cookies[x];
		if(info.getName().equals("boardCookie"+idx)){
			b = true;
			break;//check exist cookies
		}
		
	}
	String newValue =""+System.currentTimeMillis();//현재시간값을 천분의 일초로 만든것
	if(!b){// cookie가 없으면 조회수를 올리고 쿠키생성
		info = new Cookie("boardCookie"+idx , newValue);
		info.setMaxAge(24*60*60);// oneday 초단위 설정 1시간=60*60
		response.addCookie(info);
		dao.updateCount(idx);
	}
	
	boardVO vo = dao.boardSelect(idx);
	

%>
 <html>
 <head><meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
   <title>게시판 내용 보기</title>
   <link rel="stylesheet" type="text/css" href="/stylesheet.css">
   <style type="text/css">
     td.title { padding:4px; background-color:#e3e9ff }
     td.content { padding:10px; line-height:1.6em; text-align:justify; }
     a.list { text-decoration:none;color:black;font-size:10pt; }
   </style>
<script>
	function del(){
		var urlString = "/Board/board_delete.jsp?idx=<%=idx%>" ;
	    window.open(urlString, "del_list"," resizable=no,x=150,y=150,width=100,height=100");
	}

</script>
 </head>
 <body topmargin="0" leftmargin="0">
   <table border="0" width="800">
     <tr>
       <td width="20%"  height="500" bgcolor="#ecf1ef" valign="top">

		 <!--  다음에 추가할 부분 -->

	   </td>
       <td width="80%" valign="top">&nbsp;<br>
         <table border="0" width="90%" align="center">
           <tr>
             <td colspan="2"><img src="./img/bullet-01.gif"> 
              <font color="blue" size="3">자 유 게 시 판</font><font size="2"> - 글읽기</font></td>
           </tr>
         </table>
       <p>
       <table border="0" width="90%" align="center" cellspacing="0"  style="border-width:1px;border-color:#0066cc;border-style:outset;">
         <tr bgcolor="e3e9ff">
           <td class="title">
             <img src="./img/bullet-04.gif"> <font size="2" face="돋움">
                <%=vo.getSubject() %></font>
           </td>
         </tr>
         <tr>
           <td class="content">
             <p align="right"><font size="2" face="돋움">
              <a class="list" href=""> <%=vo.getName() %></a> / 
              <font size="2" face="돋움">
              <%=vo.getRegdate().substring(0,10) %>/ <%=vo.getReadcnt() %>번 읽음</font>
             <p><%=vo.getContents().replace("\n", "<br>") %><p>
           </td>
         </tr>
       </table>
  
      <!--**** 여기서부터 게시물 내용 아래쪽의 버튼들이 나옵니다. 답변, 수정, 삭제, 목록보기 ****-->
      <p align="center">
      <font size="2">
       <!-- 새글쓰기 -->
       <a href="">
       <img src="./img/write.jpg" border="0"></a>&nbsp;&nbsp;
	   <!-- 수정하기 -->
       <a href="/Board/board_modify.jsp?idx=<%=idx%>">
       <img src="./img/edit.gif" border="0"></a>&nbsp;&nbsp;
         <!-- 삭제하기 -->
       <a href="javascript:del()"><img src="./img/del.gif" border="0"></a>&nbsp;&nbsp;
       <!-- 목록보기 -->
       <a href="/Board/board_list.jsp"><img src="./img/list-2.gif" border="0"></a>&nbsp;&nbsp;
      </font>
    </td>
  </tr>
  </table>
  </body>
  </html>

