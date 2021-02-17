<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
<meta charset="UTF-8">
<title>회원등록</title>
<STYLE TYPE="text/css">
<!--
body { font-family: 돋움, Verdana; font-size: 9pt}
td   { font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color: #000000; BACKGROUND-POSITION: left top; BACKGROUND-REPEAT: no-repeat;}
-->
.formbox {
	BACKGROUND-COLOR: #F0F0F0; FONT-FAMILY: "Verdana", "Arial", "Helvetica", "돋움"; FONT-SIZE:9pt
} 
--->
</STYLE>
<!-- 
<script type="text/javascript">
	function checkpass(){
		//var pass = document.getElementsByName("passwd");
		//var repass = document.getElementsByName("repasswd");
	/*	if(document.getElementsByName("passwd") == document.getElementsByName("repasswd")){
			return;
		}else{
			alert("Passwords did not match");
			insert.passwd.focus();
			insert.passwd.value="";
			insert.repasswd.value="";
			return;
		}
	*/		
	}
	
	function idcheck(){
		if(insert.userid.value==""){
			alert("insert your ID");
			insert.userid.focus();
			return
		}else{
			//get 방식
			var url="user_idcheck.jsp?userid="+insert.userid.value;
			window.open(url,"title","width=100 height=100");
		}
	}
	
	
	function warn(){
		if(insert.name.value==""){
			alert("insert your name");
			insert.name.focus();
			return
		}
		if(insert.userid.value==""){
			alert("insert your ID");
			insert.userid.focus();
			return
		}
		
		if(insert.passwd.value==""||insert.repasswd.value==""){
			if(insert.passwd.value==""){
				alert("insert your password");
				insert.passwd.focus();
			}else{
				alert("insert your Confirm password");
				insert.repasswd.focus();
			}
			return
		}
		
		
		if(insert.userid.value==""){
			alert("insert your ID");
			insert.userid.focus();
			return
		}
		
		for(var i=0, flag=0; i<insert.gender.length;i++){
			if(insert.gender[i].checked){
				flag=1;
				break;
			}
		}
		if(flag==0){
			alert("check your gender");
			return;
		}
		if(insert.tel.value==""){
			alert("insert your tel");
			insert.tel.focus();
			return
		}
		if(insert.email1.value==""){
			alert("insert your email");
			insert.email1.focus();
			return
		}
		
		if(insert.email2.selectedIndex==0){
			if(insert.email2.value==""){
				alert("insert");
				insert.email2.focus();
				return
			}
		}
		
		if(insert.passwd.value != insert.repasswd.value){
			alert("Passwords did not match");
			insert.passwd.focus();
			insert.passwd.value="";
			insert.repasswd.value="";
			
			return;
		}else{
			
		}
		insert.action="user_insert_pro.jsp";
		insert.submit();
		alert("submit");
		
		
	}
	
	
	function aa(){
		if(insert.email2.selectIndex==0){
			insert.email2.readOnly==false;
		}else{
			insert.email2.readOnly==true;
		}
	}

</script>
 -->
 <script>
	//if(document.getElementByNames("name")[0].value==""){
	//if(insert.name.value==""){
		//alert("AAA");
	//}
	//}
 	function send(){
 		alert("submit");
 		insert.action="user_insert_pro.jsp";
 		insert.submit();
 		
 	}
 	function del(){
 		alert("bbb");
 	}
 </script>
</head>

<body bgcolor="#FFFFFF" LEFTMARGIN=0  TOPMARGIN=0 >
 
 <!-- 탑 메뉴 영역 삽입-->


<table border="0" width="800">
<tr>
  <td width="20%"  bgcolor="#ecf1ef" valign="top" style="padding-left:0;">
	
	<!--로그인 영역 삽입-->

  </td>
  <td width="80%" valign="top">&nbsp;<img src="./img/title1.gif" ><br>    
	<form name=insert method=post action="">
	
	<input type=hidden name=kor value=100>
	<input type=hidden name=eng value=100>

	
	<table border=0 cellpadding=0 cellspacing=0 border=0 width=730 valign=top>
		<tr><td align=center><br>                            
			<table cellpadding=0 cellspacing=0 border=0 width=650 align=center>       
				<tr>
					<td bgcolor="#7AAAD5">            
						<table cellpadding=0 cellspacing=0 border=0 width=100%>
							<tr bgcolor=#7AAAD5>
								<td align=left BORDER="0" HSPACE="0" VSPACE="0"><img src="./img/u_b02.gif"></td>
								<td align=center bgcolor="#7AAAD5"><FONT COLOR="#FFFFFF"><b>사용자등록&nbsp;</b><font color=black>(</font><font color=red>&nbsp;*&nbsp;</font><font color=black>표시항목은 반드시 입력하십시요.)</font></FONT></td>
								<td align=right BORDER="0" HSPACE="0" VSPACE="0"><img src="./img/u_b03.gif"></td>
							</tr>
						</table>
						<table cellpadding=3 cellspacing=1 border=0 width=100%>
							<tr>
								<td width=110 bgcolor=#EFF4F8>&nbsp;회원 성명<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE>
									<input type=text name=name size=16 maxlength=20 value="">성명은 빈칸없이 입력하세요.
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;회원 ID<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE>
									<table cellspacing=0 cellpadding=0>
										<tr>
											<td align=absmiddle>
												<input type=text name=userid size=12 maxlength=16 value="" style="width:120">
											</td>
											<td>
                  								<a href=""><img src="./img/u_bt01.gif" hspace=2 border=0 name=img1  align=absmiddle></a>
                   									5~16자 이내의 영문이나 숫자만 가능합니다.
                  							</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;비밀번호<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE>
								<input type=password name=passwd size=8 maxlength=12 style="width:80" >
									6~12자 이내의 영문이나 숫자만 가능합니다.
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;비밀번호확인<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE><input type=password name=repasswd size=8 maxlength=12 value="" style="width:80" >비밀번호 확인을 위해서 비밀번호를 한번 더 입력해주세요. </td>
							</tr>
								<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;성별<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE>
									&nbsp;<input type=radio name=gender size=13 maxlength=13 value="여자">여자
									&nbsp;<input type=radio name=gender size=13 maxlength=13 value="남자">남자
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;전화번호<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE>
									<input type=text name=tel size=13 maxlength=13 value="">
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;E-mail
                					<font color=red>&nbsp;</font>
								</td>
								<td bgcolor=WHITE valign=middle>
									<input type="text" name="email1" maxlength="15">
									@ <input type="text" name="email2" maxlength="15">
									<select name="email3" onchange="">
		      							<option value="0">직접입력</option>
		      							<option value="naver.com">naver.com</option>
		      							<option value="daum.net">daum.net</option>
		      							<option value="nate.com">nate.com</option>
		      							<option value="gmail.com">gmail.com</option>
		  							   </select>
									 <input type="button"  value="인증하기">
								</td>
							</tr>
						</table>
						<table cellpadding=0 cellspacing=0 border=0 width=100%>
							<tr bgcolor=#7AAAD5>
								<td valign=bottom>
									<img src="./img/u_b04.gif" align=left hspace=0 vspace=0 border=0>
								</td>
								<td align=center></td>
								<td valign=bottom>
									<img src="./img/u_b05.gif" align=right hspace=0 vspace=0 border=0>
								</td>
							</tr>
							<tr bgcolor=#ffffff>
								<td colspan=3 align=center>
									<a href="javascript:send()"><img src="./img/u_bt06.gif" vspace=3 border=0 name=img3></a>
									<img src="./img/u_bt05.gif" border=0 hspace=10 vspace=3 name=img4 onClick="del()">
								</td>
							</tr>
						</table> 
					</td>
				</tr>
				</td>
			</tr>
		</table>
	</form>
	</td>
</tr>
</table>

 <!-- copyright 영역 삽입-->
  

</body>
</html>
