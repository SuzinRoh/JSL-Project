<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


	int row = (int) request.getAttribute("row");

	if(row==1){

%>
	<script>
		alert("삭제완료");
		
		opener.location.href="BoardList.do?${page}";
		self.close();
	</script>
<%
	} else {
%>
	<script>
		alert("삭제실패");
		self.close();
	</script>
<%
	}
%>