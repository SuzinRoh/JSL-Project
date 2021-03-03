<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지원하기</title>


<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<c:if test="${empty user}">
	<script>
		alert("유저 로그인이 필요합니다.");
		window.location.href = 'User?cmd=user_login';
	</script>
</c:if>
<style type="text/css">
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap')
	;

@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100;300;400;500;700;900&display=swap')
	;

body {
	font-family: 'Noto Sans JP', sans-serif;
	font-family: 'Noto Sans', sans-serif;
	margin: 0;
	box-sizing: border-box;
	border-collapse:collapse;
}
h4{
	margin:0;
}
.container {
	/* 	background-color:#ededed; */
	display: flex;
	justify-content: center;
	item-align: center;
	flex-direction: column;
	border-bottom: 1px solid #cfcfcf;
}
.headtitle{
	border-bottom: 1px solid #cfcfcf;
	margin-left:10%;margin-right:20%;
	width:70%;
	min-width:800px;
}
.view{
	display: flex;
	flex-direction: row;
	margin-bottom:200px;
}
.rightnav{
	border-bottom: 1px solid #cfcfcf;border-left: 1px solid #cfcfcf ;
	box-sizing: border-box;
	border-collapse:collapse;
	padding-left:20px;padding-top:25px;
/* 	background-color:grey; */
	min-width:300px;
}
.main {
	background-color: white;
	display: flex;
	flex-direction: column;
	justify-content: center;
	padding-top: 10px;padding-left: 30px;padding-right:30px;
	margin-left: 10%;
/* 	margin-right: 15%; */
	border-bottom: 1px solid #cfcfcf;
	border-radius: 2px;
	min-width:700px;
	box-sizing: border-box;
	border-collapse:collapse;
	
	/* 	border-top:solid 5px #192145; */
	/* 	border-bottom:solid 5px #192145; */
}

.main div {
	text-align: left;
}

.fieldName {
	margin: 0;
}

.jobopening_title {
	display: flex;
	justify-content: space-between;
	align-items: flex-end;
	margin-bottom: 20px;
}

.jobopening_title_content {
	
}

.jobopening_apply {
	
}

.comName {
	margin-top: 20px;
	margin-bottom: 0;
}


.openingdate h5 {
	margin-top: 5px;
	margin-bottom: 5px;
}

.jobopeing_info {
	display: flex;
}

.infolist {
	display: flex;
	border-top: 1px solid #f0f0f0;
	border-bottom: 1px solid #f0f0f0;
	margin-left: 10px;
	width: 50%;
}

.infolistindex {
	color: grey;
	font-size: 12px;
	padding: 5px;
	padding-right: 50px;
	padding-top: 20px;
	font-wehigt: 300;
}

.infolistindex div {
	padding-bottom: 10px;
}

ul {
	list-style: none;
}

.infolistcon {
	padding-top: 50px;
	font-size: 14px;
	padding: 5px;
	padding-right: 50px;
	padding-top: 20px;
	font-wehigt: 900;
}

.infolistcon div {
	padding-bottom: 10px;
}

.company_info {
	display: flex;
	align-items: flex-start;
	margin-top: 50px;
	padding-top: 20px;
	padding-bottom: 50px;
	border-top: 1px solid #f0f0f0;
	justify-content: space-around;
}

.company_info_title {
	padding-left: 10px;
	padding-right: 50px;
}

.comapny_info_index, .company_info_title, .comapny_info_contents {
	
}

.comapny_info_index div, .company_info_title div, .comapny_info_contents div
	{
	padding: 5px;
}

.comapny_info_index {
	color: grey;
	padding-right: 20px;
	font-size: 14px;
}

.comapny_info_index div {
	/* 	text-align: right; */
	padding-bottom: 12px;
	border-bottom: 1px solid #e8e8e8;
	width: 100px;
}

.comapny_info_contents {
	font-size: 14px;
	font-weight: 500;
}

.comapny_info_contents div {
	padding-bottom: 12px;
	width: 300px;
	border-bottom: 1px solid #e8e8e8;
}

.btn {
	background-color: #0059e0;
	border: none;
	padding: 6px 25px;
	font-size: 14px;
	font-weight: 400;
	border-radius: 8px;
	color: white;
}

.btn_fav {
	background-color: white;
	border: 1px solid #cfcfcf;
	padding: 6px 10px;
	font-size: 14px;
	font-weight: 400;
	border-radius: 8px;
	color: grey;
}

.contents {
	margin-top:20px;
	display: flex;
	justify-content: center;
	align-items: center;
	justify-content: space-around;
	flex-direction: column;
}
.contents div{
	padding:10px;
}


.openingdate {
	padding-top:10px;padding-bottom:10px;
	border-top: solid 1px #f0f0f0;
	display:flex;
	justify-content: space-around;
	align-items: flex-start;
	margin-bottom:10px;
	box-sizing: border-box;
	border-collapse:collapse;
}


#countingdate{
	color:#f26c2e;
	font-weight:600;
}
.dateindex{
	color: grey;
	font-size: 14px;
}
.dateindex div {
	
}
.datecon{
}
.contentlist{
	flex-direction: column;
	display:flex;
	align-items: center;
	
	 align-items: flex-start;
	 
	
}
.contentlist div{
	display:flex;
	border-bottom: solid 1px #e8e8e8;
	justify-content: space-between;
	width:100%;
	font-size: 14px;
    font-weight: 500;
	
}
.contentlist p{
	margin:0;
	padding-left:5px;padding-right:50px;
}
.contentslistindex{
	color: grey;
	width:100px;
}
.contentslistcon{
	text-align:left;
	width:100%;
}
</style>
</head>
<body>
	<div class=container>
	
			<div class=headtitle>
				<h3>지원하기</h3>
			</div>
			<div class=view>
			
			<div class=main>
				<div class=jobopening_title>
					<div class=jobopening_title_content>
						<div class=userid>
							<h4 class=comName>${user.user_id}</h4>
						</div>
						<div class="workingField">
							<h1 class=fieldName>${user.user_name}님 ! ${vo.com_name}에 지원하시겠습니까? </h1>
						</div>
					</div>
					<div class=jobopening_apply>
					<form name = job_application method = post action = "Job_application?cmd=job_application_insert_pro">
					<input type = hidden name = com_num value ='${vo.com_num}'>
					<input type = hidden name = user_num value ='${user.user_num}'>
					<input type = hidden name = openingnum value ='${openingnum}'>
					
					
					</form>
						<button class=btn onclick="javascript:job_application.submit()">지원하기</button>
						<button class=btn_fav onclick="location.href='#'">
							<i class="far fa-star" style="width: 10px;"></i>&nbsp;관심등록
						</button>
					</div>
				</div>
	
	
					<div class=company_info>
						<!-- company contents -->
						<div class="company_info_title">
							<h4 style="padding: 0; margin: 0;">상세정보</h4>
						</div>
						<div class=comapny_info_index>
							
							<div>
								<i class="fas fa-building"
									style="font-size: 11px; color: grey; padding-right: 5px;"></i>회사이름
							</div>
							<div>
								<i class="fas fa-building"
									style="font-size: 11px; color: grey; padding-right: 5px;"></i>규모
							</div>
							<div>
								<i class="fas fa-users"
									style="font-size: 11px; color: grey; padding-right: 5px;"></i>사원수
							</div>
							<div>
								<i class="fas fa-map-marker-alt"
									style="font-size: 11px; color: grey; padding-right: 5px;"></i>업종
							</div>
							<div>
								<i class="fas fa-envelope"
									style="font-size: 11px; color: grey; padding-right: 5px;"></i>우편번호
							</div>
							<div>
								<i class="fas fa-map-marker-alt"
									style="font-size: 11px; color: grey; padding-right: 5px;"></i>본사
							</div>
							<div>
								<i class="fas fa-star"
									style="font-size: 11px; color: grey; padding-right: 5px;"></i>대표
							</div>
							<div>
								<i class="fas fa-phone-square-alt"
									style="font-size: 11px; color: grey; padding-right: 5px;"></i>대표전화번호
							</div>
							<div>
								<i class="fas fa-file-invoice-dollar"
									style="font-size: 11px; color: grey; padding-right: 5px;"></i>자본금
							</div>
							<div>
								<i class="fas fa-file-invoice-dollar"
									style="font-size: 11px; color: grey; padding-right: 5px;"></i>매출액
							</div>
							<div>
								<i class="fas fa-at"
									style="font-size: 11px; color: grey; padding-right: 5px;"></i>이메일
							</div>
							<div>
								<i class="far fa-window-maximize"
									style="font-size: 11px; color: grey; padding-right: 5px;"></i>웹사이트
							</div>
						</div>
						<div class=comapny_info_contents>
							<div>${vo.getCom_name()}</div>
							<div>${vo.getOpening_scale()}</div>
							<div>${vo.getCom_empnum()}</div>
							<div>${vo.getCom_working_field()}</div>
							<div>${vo.getCom_postnum()}</div>
							<div>${vo.getCom_location()}</div>
							<div>${vo.getCom_ceo()}</div>
							<div>${vo.getCom_tel()}</div>
							<div>${vo.getCom_capital()}</div>
							<div>${vo.getCom_sales()}</div>
							<div>${vo.getCom_email()}</div>
							<div>${vo.getCom_webpage()}</div>
						</div>
					</div>
	
					<div>
						<div class=openingdate>
							<div>
								<h4>공고일</h4>
							</div>
							<div>
								<div id=countingdate></div>
							</div>
							<div class=dateindex>
								<div >모집시작일</div>
								<div >모집종료일</div>
							</div>
							<div class=datecon>
								<div id=startdate>${vo.getOpening_startdate().substring(0,10)}</div>
								<div id=enddate >${vo.getOpening_enddate().substring(0,10)}</div>
							</div>
							
						</div>
						
					</div>
				</div>
			</div>
			<!-- main end-->
			<!-- 추천 회사 부분 ***쿼리부분 수정하기*** -->
			<div class=rightnav>
				<div>회사 추천 리스트 보여줄것</div>
				<c:forEach var="company" items="${list}" begin="0" end="12">
					<ul style="list-style:none;margin:0;padding:5px;">
						<li><div class="opening_companyInfo" onclick="location.href='/Job_opening?cmd=company_job_opening_detail&num=${company.getCom_num()}'" style="display:flex; justify-content: space-evenly;align-items: center;align-content:center;border:1px solid #e3e3e3;width:130px;height:170px;background-color: #ffffff;
						text-align:center;">
								
							<div class=opening_comimage > <img style="width:30px;height:30px;" src="<%=request.getRealPath("/Company/upload/")%>${company.getCom_image_filename()}">
<!-- 							<img style="width:35px;height:35px;" src="/Company/upload/pizza.png"> -->
							</div>
							<div style="text-align:center;width:150px;">
								<div class=opening_comname style="font-size:12px;">${company.getCom_name()}</div>
								<div class=opening_comfiled style="font-size:20px;font-weight:900;">${company.getOpening_duty()}</div>
								<div class=opening_comloction style="font-size:12px;border:soild 1px black;">${company.getCom_location().substring(0,3)} </div>
								
								<div class=opening_comfiled style="font-size:12px;border-radius:2px;background-color:#d5e2f7;padding:2px;">${company.getCom_working_field()}<!--jobopening table 에서 가져오기 이따--></div>
							</div>	
						</div>
					</ul>
				</c:forEach>
			</div>
	</div>
	</div>
	<!-- conteiner end  -->

</body>
<script>

	const countDownTimer = function (id, date) { 
			var _vDate = new Date(date); // 전달 받은 일자 
			var _second = 1000; 
			var _minute = _second * 60; 
			var _hour = _minute * 60; 
			var _day = _hour * 24; 
			var timer;
			
			function showRemaining() { 
				//var startdate = document.getElementById('startdate').innerHTML;
				
 				var now = new Date();
				var distDt = _vDate - now; 
				if (distDt < 0) { 
					clearInterval(timer); 
					document.getElementById(id).textContent = '해당 공고는 종료 되었습니다.'; 
					return;
				}
				var days = Math.floor(distDt / _day); 
				var hours = Math.floor((distDt % _day) / _hour); 
				var minutes = Math.floor((distDt % _hour) / _minute); 
				var seconds = Math.floor((distDt % _minute) / _second); 
				//document.getElementById(id).textContent = date.toLocaleString() + "까지 : ";
				document.getElementById(id).textContent = days + '일 ';
				document.getElementById(id).textContent += hours + '시간 ';
				document.getElementById(id).textContent += minutes + '분 ';
				document.getElementById(id).textContent += seconds + '초';
				} 
		timer = setInterval(showRemaining, 1000); 
   } 
	
	var enddate = document.getElementById('enddate').innerHTML;
	//alert(enddate);
// 	var dateObj = new Date(); 
// 	dateObj.setDate(dateObj.getDate() + 1);
		
	countDownTimer('countingdate', enddate);
	

</script>

</html>