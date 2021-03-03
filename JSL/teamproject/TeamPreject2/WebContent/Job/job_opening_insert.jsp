<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ko">
<c:if test="${empty comvo}">
	<script>
		alert("로그인이 필요합니다.")
		location.href = "Company?cmd=company_login";
	</script>
</c:if>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
	
  <title>Inner Page - Rapid Bootstrap Template</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Montserrat:300,400,500,600,700" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="assets/vendor/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
  <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Rapid - v3.0.0
  * Template URL: https://bootstrapmade.com/rapid-multipurpose-bootstrap-business-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
<script>
	function send(){
		if(job_opening.subject.value == ""){
			alert("제목을 입력해주세요");
			job_opening.subject.focus();
			return;
		}
		if(job_opening.contents.value == ""){
			alert("내용을 입력해주세요.");
			job_opening.contents.focus();
			return;
		}
		if(job_opening.offer.value == ""){
			alert("고용형태를 입력해주세요.");
			job_opening.offer.focus();
			return;
		}if(job_opening.carrer.value == ""){
			alert("경력을 입력해주세요.");
			job_opening.carrer.focus();
			return;
		}if(job_opening.scale.value == ""){
			alert("회사규모를 입력해주세요.");
			job_opening.scale.focus();
			return;
		}if(job_opening.location.value == ""){
			alert("근무지를 입력해주세요.");
			job_opening.location.focus();
			return;
		}if(job_opening.salary.value == ""){
			alert("급여을 입력해주세요.");
			job_opening.salary.focus();
			return;
		}if(job_opening.startdate.value == ""){
			alert("모집시작일을 입력해주세요.");
			job_opening.regidate.focus();
			return;
		}if(job_opening.enddate.value == ""){
			alert("모집종료일을 입력해주세요.");
			job_opening.enddate.focus();
			return;
		}if(job_opening.working_time.value == ""){
			alert("근무일시를 입력해주세요.");
			job_opening.working_time.focus();
			return;
		}
		job_opening.submit();
	}
</script>
</head>
  <!-- DatePicker-->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script type="text/javascript">
$(document).ready(function () {
    $.datepicker.setDefaults($.datepicker.regional['ko']); 
    $( "#startDate" ).datepicker({
         changeMonth: true, 
         changeYear: true,
         nextText: '다음 달',
         prevText: '이전 달', 
         dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
         dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
         monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
         monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
         dateFormat: "yymmdd",
         minDate: 0,
         onClose: function( selectedDate ) {    
              //시작일(startDate) datepicker가 닫힐때
              //종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
             $("#endDate").datepicker( "option", "minDate", selectedDate );
         }    

    });
    $( "#endDate" ).datepicker({
         changeMonth: true, 
         changeYear: true,
         nextText: '다음 달',
         prevText: '이전 달', 
         dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
         dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
         monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
         monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
         dateFormat: "yymmdd",
         minDate: 0,                       // 선택할수있는 최대날짜, ( 0 : 오늘 이후 날짜 선택 불가)
         onClose: function( selectedDate ) {    
             // 종료일(endDate) datepicker가 닫힐때
             // 시작일(startDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 시작일로 지정
             $("#startDate").datepicker( "option", "maxDate", selectedDate );
         }    
    });    
});
</script>

<body>

  <!-- ======= Top Bar ======= -->
  <div id="topbar" class="d-none d-lg-flex align-items-end fixed-top ">
    <div class="container d-flex justify-content-end">
      <div class="social-links">
        <a href="#" class="twitter"><i class="fa fa-twitter"></i></a>
        <a href="#" class="facebook"><i class="fa fa-facebook"></i></a>
        <a href="#" class="linkedin"><i class="fa fa-linkedin"></i></a>
        <a href="#" class="instagram"><i class="fa fa-instagram"></i></a>
      </div>
    </div>
  </div>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top ">
    <div class="container d-flex align-items-center justify-content-between">

      <h1 class="logo"><a href="index.html">Rapid</a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

      <nav class="main-nav d-none d-lg-block">
        <ul>
          <li class="active"><a href="index.html">Home</a></li>
          <li><a href="#about">About Us</a></li>
          <li><a href="#services">Services</a></li>
          <li><a href="#portfolio">Portfolio</a></li>
          <li><a href="#team">Team</a></li>
          <li class="drop-down"><a href="">Drop Down</a>
            <ul>
              <li><a href="#">Drop Down 1</a></li>
              <li class="drop-down"><a href="#">Drop Down 2</a>
                <ul>
                  <li><a href="#">Deep Drop Down 1</a></li>
                  <li><a href="#">Deep Drop Down 2</a></li>
                  <li><a href="#">Deep Drop Down 3</a></li>
                  <li><a href="#">Deep Drop Down 4</a></li>
                  <li><a href="#">Deep Drop Down 5</a></li>
                </ul>
              </li>
              <li><a href="#">Drop Down 3</a></li>
              <li><a href="#">Drop Down 4</a></li>
              <li><a href="#">Drop Down 5</a></li>
            </ul>
          </li>
          <li><a href="#footer">Contact Us</a></li>
        </ul>
      </nav><!-- .main-nav-->

    </div>
  </header><!-- End Header -->

  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section id="breadcrumbs" class="breadcrumbs">
      <div class="container">

        <ol>
          <li><a href="index.html">Home</a></li>
          <li>Inner Page</li>
        </ol>
        <h2>Inner Page</h2>

      </div>
    </section><!-- End Breadcrumbs -->

    <section class="inner-page pt-4">
      <div class="container">
      <form name = "job_opening" method = "post" action = "Job_opening?cmd=job_opening_insert_pro"  enctype="multipart/form-data">
      <input type = "hidden" name="com_num" value = "${comvo.com_num}">
        <div><input type="text" name="subject" placeholder="제목을 입력하세요." maxlength="50" style="width:800px; " ></div>
		직무
		<div><input type="text" name="duty" placeholder="직무을 입력하세요." maxlength="50" style="width:800px; " ></div>
		고용형태
		<div><input type="text" name="offer" placeholder="고용형태를 입력하세요." maxlength="50" style="width:800px; " ></div>
		경력
		<div><input type="text" name="carrer" placeholder="구직의 하려는 대상자의 희망경력을 입력하세요." maxlength="50" style="width:800px; " ></div>
		학력
		<div><input type="text" name="education" placeholder="구직의 하려는 대상자의 희망학력을 입력하세요." maxlength="50" style="width:800px; " ></div>
		회사규모
		<div><input type="text" name="scale" placeholder="회사규모를 입력하세요." maxlength="50" style="width:800px; " ></div>
		근무지 위치
		<div><input type="text" name="location" placeholder="근무지 위치를 입력하세요." maxlength="50" style="width:800px; " ></div>
		급여
		<div><input type="text" name="salary" placeholder="급여를 입력하세요." maxlength="50" style="width:800px; " ></div>
         모집기간<div><input type="text" id="startDate" name="startdate"> ~ <input type="text" id="endDate" name="enddate"></div>
		<div>내용</div>
		<div><textarea name="contents" cols="30" rows="10"
			placeholder="내용을 입력하세요." class="spellcheck" style="width:800px;"></textarea></div>
		근무일시
		<div><input type="text" name="working_time" placeholder="근무일시를 입력하세요." maxlength="50" style="width:800px; " ></div>
		첨부파일
		<div><input type="file" name="filename" maxlength="50" style="width:800px; " ></div>
		<div><input type=button value="저장" onClick="send()"></div>
          </form>
      </div>
    </section>

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <!--  footer end -->
  <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
  
  <!-- Vendor JS Files -->
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/counterup/counterup.min.js"></script>
  <script src="assets/vendor/venobox/venobox.min.js"></script>
  <script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
  <script src="assets/vendor/waypoints/jquery.waypoints.min.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>