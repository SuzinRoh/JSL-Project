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
		if (frm.name.value == "") {
			document.getElementById('nameWarning').innerHTML = "<i class='fas fa-exclamation-circle fa-sm'></i> 기업의 이름을 입력해주세요.";
			frm.name.focus();
			event.preventDefault();
			return;
		}

		if (frm.workingField.value == "") {
			document.getElementById('workingFieldWarning').innerHTML = "<i class='fas fa-exclamation-circle fa-sm'></i> 업종을 입력해주세요.";
			frm.workingField.focus();
			event.preventDefault();
			return;
		}
		if (frm.info.value == "") {
			document.getElementById('infoWarning').innerHTML = "<i class='fas fa-exclamation-circle fa-sm'></i> 기업정보를 입력해주세요.";
			frm.info.focus();
			event.preventDefault();
			return;
		}
		if (frm.publishedDate.value == "") {
			document.getElementById('publishedDateWarning').innerHTML = "<i class='fas fa-exclamation-circle fa-sm'></i> 기업설립일을 입력해주세요.";
			frm.publishedDate.focus();
			event.preventDefault();
			return;
		}
		if (frm.empnum.value == "") {
			document.getElementById('empnumWarning').innerHTML = "<i class='fas fa-exclamation-circle fa-sm'></i> 사원수 입력해주세요.";
			frm.empnum.focus();
			event.preventDefault();
			return;
		}
		if (frm.capital.value == "") {
			document.getElementById('capitalWarning').innerHTML = "<i class='fas fa-exclamation-circle fa-sm'></i> 자본금 입력해주세요.";
			frm.capital.focus();
			event.preventDefault();
			return;
		}
		if (frm.sales.value == "") {
			document.getElementById('salesWarning').innerHTML = "<i class='fas fa-exclamation-circle fa-sm'></i> 매출을 입력해주세요.";
			frm.sales.focus();
			event.preventDefault();
			return;
		}
		if (frm.postnum.value == "") {
			document.getElementById('postnumWarning').innerHTML = "<i class='fas fa-exclamation-circle fa-sm'></i> 우편번호 입력해주세요.";
			frm.postnum.focus();
			event.preventDefault();
			return;
		}
		if (frm.postnum.value == "") {
			document.getElementById('postnumWarning').innerHTML = "<i class='fas fa-exclamation-circle fa-sm'></i> 우편번호 입력해주세요.";
			frm.postnum.focus();
			event.preventDefault();
			return;
		}
		if (frm.tel.value == "") {
			document.getElementById('telWarning').innerHTML = "<i class='fas fa-exclamation-circle fa-sm'></i> 전화번호를 입력해주세요.";
			frm.tel.focus();
			event.preventDefault();
			return;
		}
		//alert('success!');
		frm.action = "/Company?cmd=company_modify_pro";
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
	<form name="frm" class="form-horizontal" role="form" method="post"
		enctype="multipart/form-data">
		<div class="container">
			<!-- 좌우측의 공간 확보 -->
			<!-- 헤더 들어가는 부분 -->

			<!--// 헤더 들어가는 부분 -->
			<div style="">
				<h1>기업 정보수정</h1>
			</div>
			<!-- 모달창 -->
			<div style="text-align: right;">
				<a href="/Company?cmd=company_delete">회원탈퇴</a>
			</div>
			<div class="modal fade" id="defaultModal">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title">알림</h4>
						</div>
						<div class="modal-body">
							<p class="modal-contents"></p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">닫기</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
			<!--// 모달창 -->
			<hr />
			<!-- 본문 들어가는 부분 -->

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
			<div class="form-group" id="divPrePassword">
				<label for="inputPrePassword" class="col-lg-2 control-label">이전패스워드</label>
				<div class="col-lg-10">
					<input onchange="" name="prepass" value="" type="password"
						class="form-control" id="prepassword" name="excludeHangul"
						data-rule-required="true" placeholder="이전패스워드" maxlength="20">
				</div>
				<p id="prePassWarning"
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


			<div>&nbsp;</div>
			<div>
				<h3>
					<i class="fas fa-chevron-right"></i>&nbsp;상세정보
				</h3>
			</div>
			<div>&nbsp;</div>
			<!--  추가한부분 -->
			<div class="form-group" id="divName">
				<label for="input" class="col-lg-2 control-label">기업 이름</label>
				<div class="col-lg-10">
					<input name="name" value="${comvo.getCom_name()}" type="text"
						class="form-control onlyHangul" id="name"
						data-rule-required="true" placeholder="한글/일본어만 입력 가능합니다."
						maxlength="30">
				</div>
				<p id="nameWarning"
					style="color: red; font-size: 12px; padding-left: 25px;"></p>
			</div>

			<div class="form-group" id="divWorkingField">
				<label for="inputWorkingField" class="col-lg-2 control-label">업종</label>
				<div class="col-lg-10">
					<input name="workingField" value="${comvo.getCom_working_field()}"
						type="text" class="form-control" id="workingField"
						data-rule-required="true" placeholder="업종" maxlength="30">
				</div>
				<p id="workingFieldWarning"
					style="color: red; font-size: 12px; padding-left: 25px;"></p>
			</div>

			<div class="form-group" id="divInfo">
				<label for="inputInfo" class="col-lg-2 control-label">회사소개</label>
				<div class="col-lg-10">
					<input name="info" value="${comvo.getCom_info()}" type="text"
						class="form-control" id="info" data-rule-required="true"
						placeholder="짧은회사소개 140자 이내" maxlength="140">
				</div>
				<p id="infoWarning"
					style="color: red; font-size: 12px; padding-left: 25px;"></p>
			</div>

			<div class="form-group" id="divImageFilename">
				<label for="inputImageFilename" class="col-lg-2 control-label">회사로고/이미지</label>
				<div class="col-lg-10">
					첨부된 파일: <input value="${comvo.getCom_image_filename()}"
						style="border: none;" name="oldImageFilename" class="form-control"
						id="oldImageFilename" data-rule-required="true"
						placeholder="로고이미지" maxlength="140" readolny> 새파일: <input
						style="border: none;" name="imageFilename" type="file"
						class="form-control" id="imageFilename" data-rule-required="true"
						placeholder="로고이미지" maxlength="140" value="">

				</div>
			</div>

			<div class="form-group" id="divWebpage">
				<label for="inputWebpage" class="col-lg-2 control-label">회사홈페이지</label>
				<div class="col-lg-10">
					<input name="webPage" value="${comvo.getCom_webpage()}" type="text"
						class="form-control" id="Webpage" data-rule-required="true"
						placeholder="홈페이지" maxlength="100">
				</div>
			</div>

			<div class="form-group" id="divCEO">
				<label for="inputCEO" class="col-lg-2 control-label">대표자</label>
				<div class="col-lg-10">
					<input name="ceo" value="${comvo.getCom_ceo()}" type="text"
						class="form-control" id="ceo" data-rule-required="true"
						placeholder="대표자" maxlength="20">
				</div>
			</div>

			<div class="form-group" id="divPublishedDate">
				<label for="inputPublishedDate" class="col-lg-2 control-label">설립일</label>
				<div class="col-lg-10">
					<input name="publishedDate"
						value="${comvo.getCom_published_date().substring(0,10)}"
						type="text" class="form-control" id="publishedDate"
						data-rule-required="true" placeholder="설립일" maxlength="15">
				</div>
				<p id="publishedDateWarning"
					style="color: red; font-size: 12px; padding-left: 25px;"></p>
			</div>

			<div class="form-group" id="divEmpnum">
				<label for="inputEmpnum" class="col-lg-2 control-label">사원수</label>
				<div class="col-lg-10">
					<input name="empnum" value="${comvo.getCom_empnum()}" type="text"
						class="form-control" id="empnum" data-rule-required="true"
						placeholder="사원수" maxlength="15">
				</div>
				<p id="empnumWarning"
					style="color: red; font-size: 12px; padding-left: 25px;"></p>
			</div>

			<div class="form-group" id="divCapital">
				<label for="inputCapital" class="col-lg-2 control-label">자본금</label>
				<div class="col-lg-10">
					<input name="capital" value="${comvo.getCom_capital()}" type="text"
						class="form-control" id="capital" data-rule-required="true"
						placeholder="자본금" maxlength="15">
				</div>
				<p id="capitalWarning"
					style="color: red; font-size: 12px; padding-left: 25px;"></p>
			</div>

			<div class="form-group" id="divSales">
				<label for="inputSales" class="col-lg-2 control-label">매출</label>
				<div class="col-lg-10">
					<input name="sales" value="${comvo.getCom_sales()}" type="text"
						class="form-control" id="sales" data-rule-required="true"
						placeholder="매출" maxlength="15">
				</div>
				<p id="salesWarning"
					style="color: red; font-size: 12px; padding-left: 25px;"></p>
			</div>

			<div class="form-group" id="divPostnum">
				<label for="inputPostnum" class="col-lg-2 control-label">우편번호</label>
				<div class="col-lg-10">
					<input name="postnum" value="${comvo.getCom_postnum()}" type="text"
						class="form-control" id="postnum" data-rule-required="true"
						placeholder="우편번호" maxlength="15">
				</div>
				<p id="postnumWarning"
					style="color: red; font-size: 12px; padding-left: 25px;"></p>
			</div>

			<div class="form-group" id="divLoction">
				<label for="inputLoction" class="col-lg-2 control-label">본사소재지</label>
				<div class="col-lg-10">
					<input name="loction" value="${comvo.getCom_location()}"
						type="text" class="form-control" id="loction"
						data-rule-required="true" placeholder="소재지" maxlength="50">
				</div>

			</div>

			<div class="form-group" id="divTel">
				<label for="inputTel" class="col-lg-2 control-label">대표번호</label>
				<div class="col-lg-10">
					<input name="tel" type="text" value="${comvo.getCom_tel()}"
						class="form-control onlyNumber" id="tel" data-rule-required="true"
						placeholder="-를 제외하고 숫자만 입력하세요." maxlength="11">
				</div>
				<p id="telWarning"
					style="color: red; font-size: 12px; padding-left: 25px;"></p>
			</div>
			<!-- option.....
                <div class="form-group">
                    <label for="inputPhoneNumber" class="col-lg-2 control-label">성별</label>
                    <div class="col-lg-10">
                        <select class="form-control" id="gender">
                            <option value="M">남</option>
                            <option value="F">여</option>
                        </select>
                    </div>
                </div>
                 -->

			<div class="form-group">
				<label for="inputEmailReceiveYn" class="col-lg-2 control-label">이메일
					수신여부</label>
				<div class="col-lg-10">
					<label class="radio-inline"> <input type="radio"
						id="emailReceiveYn" name="emailReceiveYn" value="Y" checked>
						동의합니다.
					</label> <label class="radio-inline"> <input type="radio"
						id="emailReceiveYn" name="emailReceiveYn" value="N"> 동의하지
						않습니다.
					</label>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPhoneNumber" class="col-lg-2 control-label">SMS
					수신여부</label>
				<div class="col-lg-10">
					<label class="radio-inline"> <input type="radio"
						id="smsReceiveYn" name="smsReceiveYn" value="Y" checked>
						동의합니다.
					</label> <label class="radio-inline"> <input type="radio"
						id="smsReceiveYn" name="smsReceiveYn" value="N"> 동의하지
						않습니다.
					</label>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<button id="chkemailB" type="submit" class="btn btn-primary"
						onclick="javascript:send()">정보수정</button>
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
		$("#prepassword").blur(
				function() {
					var pass = $('#prepassword').val();
					var id = $('#id').val();
					$.ajax({
						url : "/Company?cmd=company_passchk&id=" + id
								+ "&pass=" + pass,
						type : "post",
						success : function(data) {
							if (data == 0) {
								$("#prePassWarning").text("패스워드가 일치하지 않습니다.");
								$("#prePassWarning").css("color", "red");
								$("#reg_submit").attr("disabled", true);
							} else {
								$("#prePassWarning").css("color", "blue");
								$("#prePassWarning").text("패스워드가 일치합니다.");
								$("#reg_submit").attr("disabled", false);
							}
						},
						error : function(e) {
							alert("값을 가져오지 못했습니다.");
						}

					});
				});

		// 	//이메일인증
		// 	$("#chkemailB").on('click',function() {
		// 			var mail = $('#mail').val();
		// 			var pass = $('#pw_mailchk').val();
		// 			var id = $('#id_mailchk').val();
		// 			$.ajax({
		// 				url : "/Company?cmd=company_emailchk&email="+mail+"&id="+id+"&pass="+pass,
		// 				type : "get",
		// 				success : function(data){

		// 				},
		// 				error:function(jqXHR,textStatus,errorThrown ){
		// 					 alert('Exception:'+errorThrown );
		// 				}
		// 	});
		// 	});
	</script>

</body>
</html>