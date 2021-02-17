<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


	int row = (int) request.getAttribute("row");

	if(row==1){

%>
	<script>
		alert("등록완료");
		location.href="BoardList.do?${page}";
	</script>
<%
	} else {
%>
	<script>
		alert("등록실패");
		history.back();
	</script>
<%
	}
%>