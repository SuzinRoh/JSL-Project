<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<!-- Ajax구현하기 위해 필요 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- jQuery 사용하기위해서 -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap')
	;

@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100;300;400;500;700;900&display=swap')
	;

body {
	margin: 0;
	background: #fff;
	color: #444;
	font-family: "Noto Sans", sans-serif;
}

.container {
	display: block;
	/* 	background-color: AntiqueWhite; */
	width: 100%;
	padding-right: 15px;
	padding-left: 15px;
	margin-right: auto;
	margin-left: auto;
	max-width: 960px;
	dispaly: flex;
	justify-content: center;
	text-align: center;
}

.board {
	margin-top: 30px;
	dispaly: flex;
	margin-right: 300px;
	margin-left: 300px;
	padding-top: 50px;
	padding-bottom: 50px;
	padding-right: 20px;
	padding-left: 20px;
	/* 	background-color: AliceBlue; */
	justify-content: center;
	text-align: center;
	border: solid 1px #e8e8e8;
	border-radius: 10px;
}

.logo {
	padding-bottom: 50px;
}

.btn_div {
	padding-top: 10px;
}

.btn {
	font-family: "Noto Sans", sans-serif;
	letter-spacing: 4px;
	background-color: #15243b;
	border: none;
	padding: 15px 62px;
	font-size: 20px;
	font-weight: 400;
	border-radius: 10px;
	color: white;
}
</style>
<script>
	function send_com(){
// 		alert('hi');
		frm.action="/Main?cmd=login_form";
		frm.submit();
		
	}

</script>
</head>
<body>

	<div class=container>


		<div class='board'>
			<div class=logo>
				<h1>site name</h1>
			</div>

			<!--본문 -->

			<c:if test="${empty tmp }">
			<form name=frm method=post >
				<div>welcome!</div>
				<div class=btn_div>
<!-- 					<input type=hidden name=com value=com /> -->
					<button id=btn class=btn name=btn value="com" onclick="javascript:send_com()">기업</button>
				</div>
				<div class=btn_div>
<!-- 					<input type=hidden name=user value=user /> -->
					<button id=btn class=btn name=btn value="user" onclick="javascript:send_user()">개인</button>
				</div>
				</form>
			</c:if>
			
			<c:if test="${'com' eq tmp }">
			<div>
				<div>company login</div>
				<div>
					<jsp:include page="/Company/company_login.jsp" flush="false" />
				</div>
				</div>
			</c:if>
			<c:if test="${'user' eq tmp }">
				<div>user login</div>
				<div>
					<jsp:include page="/User/user_login3.jsp" flush="false" />
				</div>
			</c:if>
		</div>

	</div>
</body>
<script>
	
// 	$("#btn").on('click', function() {
// 		var val = $('#btn').val();
// 		$.ajax({
// 			url : "/Main?cmd=login_form&val=" + val,
// 			type : "post",
// 			success : function(data) {
// 				alert("hi");
// 				location.reload();
// 			},
// 			error : function(jqXHR, textStatus, errorThrown) {
// 				alert('Exception:' + errorThrown);
// 			}
// 		});
// 	});
</script>
</html>