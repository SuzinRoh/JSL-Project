<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<!--  -->
<meta charset="utf-8">
<!-- meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"/ -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>기업 정보수정</title>
<!-- Bootstrap -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
<script src="http://code.jquery.com/jquery.js"></script>
<!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
<script
	src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<!-- web icon  https://fontawesome.com/ -->
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>

<!-- Ajax구현하기 위해 필요 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- jQuery 사용하기위해서 -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>



<script type="text/javascript">
	function send() {
		if (frm.id.value == "") {
			document.getElementById('idWarning').innerHTML = "<i class='fas fa-exclamation-circle fa-sm'></i> 아이디를 입력해주세요.";
			frm.id.focus();
			event.preventDefault();
			return;
		}
		if (frm.email.value == "") {
			document.getElementById('emailWarning').innerHTML = "<i class='fas fa-exclamation-circle fa-sm'></i> 이메일을 입력해주세요.";
			frm.email.focus();
			event.preventDefault();
			return;
		}

		if (frm.pass.value == "") {
			document.getElementById('passWarning').innerHTML = "<i class='fas fa-exclamation-circle fa-sm'></i> 비밀번호를 입력해주세요.";
			frm.pass.focus();
			event.preventDefault();
			return;
		}
		if (frm.pwcheck.value == "") {
			document.getElementById('passchkWarning').innerHTML = "<i class='fas fa-exclamation-circle fa-sm'></i> 비밀번호를 확인해주세요.";
			frm.pwcheck.focus();
			event.preventDefault();
			return;
		}
		alert('success!');
		frm.action = "/Company?cmd=company_delete_pro";
		frm.submit();
	}

	function pw_Check() {
		const pw = document.getElementById('password').value;
		const pwchk = document.getElementById('passwordCheck').value;
		if (pw != pwchk) {
			document.getElementById('passchkWarning').style.color = "red";
			document.getElementById('passchkWarning').innerHTML = "<i class='fas fa-exclamation-circle fa-sm'></i> 비밀번호가 일치하지 않습니다.";
			event.preventDefault();
			return;
		} else {
			document.getElementById('passchkWarning').style.color = "blue";
			document.getElementById('passchkWarning').innerHTML = "비밀번호일치.";
		}
	}

	/*function delwarn(){
		const tmp = name;
		;
	}*/
</script>
<style>
a:link {color: black;text-decoration: none;}
a:visited {color: black;text-decoration: none;}
a:hover {color: black;text-decoration: underline;}
</style>



</head>

<body>
	
		<div class="container">
			<!-- 좌우측의 공간 확보 -->
			<!-- 헤더 들어가는 부분 -->

			<!--// 헤더 들어가는 부분 -->
			<div style="">
				<h1>회원탈퇴</h1>
			</div>
			
		
			<!-- 본문 들어가는 부분 -->
			<form name="frm" class="form-horizontal" role="form" method="post">
			<div>&nbsp;</div>
			<div>
				<h3>
					<i class="fas fa-chevron-right"></i>&nbsp;기본정보
				</h3>
			</div>
			<div>&nbsp;</div>
			<div class="form-group" id="divId">
				<label for="inputId" class="col-lg-2 control-label">아이디</label>
				<div class="col-lg-10">
					<input readonly name="id" value="${comvo.getCom_id()}" type="text"
						class="form-control onlyAlphabetAndNumber" id="id"
						data-rule-required="true"
						placeholder="30자이내의 알파벳, 언더스코어(_), 숫자만 입력 가능합니다." maxlength="30"
						onchange="javascript:document.getElementById('idWarning').innerHTML =''">
				</div>
				<p id="idWarning"
					style="color: red; font-size: 12px; padding-left: 25px;"></p>
			</div>

			<div class="form-group" id="divEmail">
				<label for="inputEmail" class="col-lg-2 control-label">기업
					이메일</label>
				<div class="col-lg-10">
					<input readonly name="email" value="${comvo.getCom_email()}"
						type="text" class="form-control" id="" data-rule-required="true"
						placeholder="이메일" maxlength="40">
				</div>
				<p id="emailWarning"
					style="color: red; font-size: 12px; padding-left: 25px;"></p>
			</div>
			

			<div class="form-group" id="divPassword">
				<label for="inputPassword" class="col-lg-2 control-label">패스워드</label>
				<div class="col-lg-10">
					<input onchange="pw_Check()" name="pass" value="" type="password"
						class="form-control" id="password" name="excludeHangul"
						data-rule-required="true" placeholder="패스워드" maxlength="20">
				</div>
				<p id="passWarning"
					style="color: red; font-size: 12px; padding-left: 25px;"></p>
			</div>
			<div class="form-group" id="divPasswordCheck">
				<label for="inputPasswordCheck" class="col-lg-2 control-label">패스워드
					확인</label>
				<div class="col-lg-10">
					<input onchange="pw_Check()" name="pwcheck" value=""
						type="password" class="form-control" id="passwordCheck"
						data-rule-required="true" placeholder="패스워드 확인" maxlength="20">
				</div>
				<p id="passchkWarning"
					style="color: red; font-size: 12px; padding-left: 25px;"></p>
			</div>


			
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<button id="chkemailB" type="submit" class="btn btn-primary"
						onclick="javascript:send()">회원탈퇴</button>
				</div>
			</div>
	</form>
	<!--// 본문 들어가는 부분 -->
	<hr />
	<!-- 푸터 들어가는 부분 -->

	<div>
		<p class="text-center">
			<small><strong>JSL Team Project 46ki</strong></small><br> <small>대표
				: 홍길동 ㆍ 주소 : 사거리 ㆍ 사업자등록번호:123-12-12345 ㆍ 전화 : 02-123-1234</small><br>
			<small>Copyrightⓒ test.com All rights reserved.</small>
		</p>
	</div>
	<!--// 푸터 들어가는 부분 -->
	</div>

	<script type="text/javascript">
		$("#password").blur(
				function() {
					var pass = $('#password').val();
					var id = $('#id').val();
					$.ajax({
						url : "/Company?cmd=company_passchk&id=" + id
								+ "&pass=" + pass,
						type : "post",
						success : function(data) {
							if (data == 0) {
								$("#passWarning").text("패스워드가 일치하지 않습니다.");
								$("#passWarning").css("color", "red");
								$("#reg_submit").attr("disabled", true);
							} else {
								$("#passWarning").css("color", "blue");
								$("#passWarning").text("패스워드가 일치합니다.");
								$("#reg_submit").attr("disabled", false);
							}
						},
						error : function(e) {
							alert("값을 가져오지 못했습니다.");
						}

					});
				});

	</script>

</body>
</html>