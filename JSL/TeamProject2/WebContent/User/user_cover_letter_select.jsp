<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<!-- cover_letter
	자기소개서번호	cover_num		🔑
	제목			cover_subject
	내용			cover_contents
	고객번호		user_num		🗝
	생성일자		cover_regidate	
	수정일자		cover_modifydate
 -->
<c:if test="${empty user }">
<script>
	alert("세션이 존재하지 않습니다.");
	location.href = "User?cmd=user_login";
</script>
</c:if>

<script>
	function cover_letter_select(){
		opener.user_resume.cover_subject.value= '${ucvl.cover_subject}';
		opener.user_resume.cover_num.value= '${ucvl.cover_num}';
		opener.user_resume.cover_private.value= '${ucvl.cover_private}';
		self.close();
	}
</script>

<c:if test="${language == 'ja' }">
<script>
	
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
</head>

<body>

  

  <main id="main">

    <section class="inner-page pt-4">
      <div class="container">
     	<table class="table table-hover">
                        <thead>
                             <th>${ucvl.cover_subject }</th>
                                <td>작성일 : ${ucvl.cover_regidate.substring(0,10) }</td>
                                
                                <c:if test="${empty ucvl.cover_modifydate }">
                                	<td>최종수정일 : 수정이력 없음</td>
                                </c:if>
                                <c:if test="${!empty ucvl.cover_modifydate }">
                                	<td>최종수정일 : ${ucvl.cover_modifydate.substring(0,16) }
                                </c:if>
                        </thead>
                        <tbody>
                           <tr>
                                <td colspan="3">${ucvl.cover_contents }</td>
                            </tr>
		</table>
		 <input type=button value="선택"  onClick="cover_letter_select()">
		 <input type=button value="뒤로가기"  onClick="history.back()">
        </p>
      </div>
    </section>

  </main><!-- End #main -->

  <!-- Vendor JS Files -->
  <script src="assets/vendor/jquery/jquery.min.js"></script>
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
