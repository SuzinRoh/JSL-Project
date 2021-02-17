<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setCharacterEncoding("utf-8"); %>
<%-- <c:if test="${language=='ko'}"> --%>
	<c:if test="${row==0}">
		<script>
			alert("비밀번호를 확인해주세요");
			history.back();
		</script>
	</c:if>

	<c:if test="${row==-1}">
		<script>
			alert("ID 없음");
			history.back();
		</script>
	</c:if>
	<c:if test="${row==1}">
		<script>
			alert("로그인 완료");
			window.location.href = "Main?cmd=main_index";
		</script>
	</c:if>
	<c:if test="${row==2}">
		<script>
			alert("관리자의 승인이 필요합니다.");
			history.back();
		</script>
	</c:if>
<%-- </c:if> --%>
<c:if test="${language=='ja'}">
	<c:if test="${row==0}">
		<script>
			alert("パスワードをご確認ください。");
			history.back();
		</script>
	</c:if>

	<c:if test="${row==-1}">
		<script>
			alert("IDがありません");
			history.back();
		</script>
	</c:if>
	<c:if test="${row==1}">
		<script>
			alert("ログインしました");
			window.location.href = "/index.jsp";
		</script>
	</c:if>
	<c:if test="${row==2}">
		<script>
			alert("管理者の確認が必要ですので少々お待ちください");
			window.location.href = "/Company?cmd=company_login";
		</script>
	</c:if>
</c:if>