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

<c:if test="${language == 'ko' }">
<script>
	
</script>
</c:if>

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
                            <tr>
                                <th>번호</th>
                                <th colspan="2">제목</th>
                                <th>작성일</th>
                                <th>공개여부</th>
                            </tr>
                        </thead>
                        <tbody>
                           
            <c:if test="${empty list }">
 	   			<td colspan="5" align="center">등록된 자료가 없습니다.</td>
 	   		</c:if>
 	   		
 	   		<c:forEach var="user" items="${list }">
							 <tr>
                                <td>${listcount }</td>
                                <td colspan="2"><a class="list" href="User?cmd=user_cover_letter_select&idx=${user.cover_num }">${user.cover_subject }</td>
                                <td>${user.cover_regidate.substring(0,10) }</td>
                                <c:if test="${user.cover_private == 'T' }">
                                	<td>공개</td>
                                </c:if>
                                <c:if test="${user.cover_private == 'F' }">
                                	<td>비공개</td>
                                </c:if>
                                <td></td>
                            </tr>
		<c:set var="listcount" value="${listcount-1 }"/>
		</c:forEach>
                        </tbody>
                        </table>
                        
	 <div align="center">
        <table border="0" cellspacing="0" cellpadding="5">
          <tr>&nbsp;</tr><tr>
             <td colspan="5">        
                <div align="center">${pageSkip }</div>
			  </td>
			 </tr>
		</table>
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
