<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String[] far = request.getParameterValues("fa");
	
	
%>

<jsp:useBean id="member" class="model.MemberBean">
	<jsp:setProperty name="member" property="*"/>
</jsp:useBean>
<%
	member.setIntro(member.getIntro().replace("\n","<br>"));
%>
이름 : <%=member.getName()%><br>
아이디 :<%=member.getUserid()%><br>
비밀번호 :<%=member.getPasswd()%><br>
tel :<%=member.getTel()%><br>
email :<%=member.getEmail()%><br>
job :<%=member.getJob()%><br>
취미 :
	<%
	for(int i=0;i<far.length;i++){
		out.print(far[i]+" , ");
		
		} 
	%><br>
intro :<%=member.getIntro()%><br>
