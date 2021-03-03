<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <meta charset="utf-8">
        <!-- meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"/ -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>내 정보 보기</title>
        <!-- Bootstrap -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
        <script src="http://code.jquery.com/jquery.js"></script>
        <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <!-- Ajax구현하기 위해 필요 -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- jQuery 사용하기위해서 -->
       <script
  src="https://code.jquery.com/jquery-3.5.1.min.js"
  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
  crossorigin="anonymous"></script>
       <script>
       
       function send2(){
   	    emailcheck.submit();
   	}
       
       </script>
        
       
<title>내 정보 보기</title>
</head>
<body>
<form name="emailcheck" method="post" action="/User?cmd=user_emailcheck">
<input type="hidden" name=username value="${user.user_name}">
<input type="hidden" name=userpass value="${user.user_pass}">
<input type="hidden" name=useremail value="${user.user_email}">
</form>
<div class="container"><!-- 좌우측의 공간 확보 -->
            <!-- 헤더 들어가는 부분 -->
            
            <div class="row">
                <p></p>
                <div class="col-md-12">
                    <small>
                    <a href="User?cmd=user_login">로그인</a> | <a href="User?cmd=user_insert">회원가입</a>
                    </small>
                </div>
            </div>
            <!--// 헤더 들어가는 부분 -->
            <!-- 모달창 -->
            <div class="modal fade" id="defaultModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">알림</h4>
                        </div>
                        <div class="modal-body">
                            <p class="modal-contents"></p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            <!--// 모달창 -->
            <hr/>
            <!-- 본문 들어가는 부분 -->
            <div>
                <h1>MyInformation</h1>
                </div>
 
 
            <form name="user_insert" role="form" method="post">
               
                
                <div class="form-group" id="divId">
                    <label for="inputId" class="col-lg-2 control-label">아이디</label>
                    <div class="col-lg-10">
                        <input type="text" id="user_id" class="form-control onlyAlphabetAndNumber" name="userid" data-rule-required="true"  maxlength="30" value="${user.user_id }" readonly>
                        <div class="check_font" id="id_check"></div>
                    </div>
                </div>
                
                
                <div class="form-group" id="divName">
                    <label for="inputName" class="col-lg-2 control-label">이름</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control onlyHangul" name="username" data-rule-required="true" value="${user.user_name }" maxlength="15" readonly>
                    </div>
                </div>
                
                <div class="form-group" id="divEmail">
                    <label for="inputEmail" class="col-lg-2 control-label">이메일</label>
                    <div class="col-lg-10">
                        <input type="email" class="form-control" id="user_email" name="useremail" data-rule-required="true" value="${user.user_email }" maxlength="40" readonly>
                        <div class="check_font" id="email_check"></div>
                    </div>
                    <div>
                     <c:if test="${user.user_emailauth == 0}">
        				<button type="button" class="btn btn-primary" onClick="send2();">인증하기</button>
        			</c:if>
        			<c:if test="${user.user_emailauth == 1}">
        				<button type="button" class="btn btn-primary" disabled="disabled">인증완료</button>
        			</c:if>
        			</div>
                    <div class="col-lg-offset-2 col-lg-10">
                        
                        
                    </div>
                </div>
                
                <div class="form-group" id="divPhoneNumber">
                    <label for="inputPhoneNumber" class="col-lg-2 control-label">휴대폰 번호</label>
                    <div class="col-lg-10">
                        <input type="tel" class="form-control onlyNumber" name="usertel" data-rule-required="true" value="${user.user_tel }" maxlength="11" readonly>
                    </div>
                </div>
            
                </div>
                </form>
                
                <div class="form-group">
                    <div class="col-lg-offset-2 col-lg-10">
                        <button type="button" class="btn btn-primary" id="reg_submit" onClick="location.href='User?cmd=user_modify'">정보수정</button>
                        <button type="button" class="btn btn-primary" id="reg_submit" onClick="location.href='User?cmd=user_delete'">회원탈퇴</button>
                        <button type="button" class="btn btn-primary" id="reg_submit" onClick="location.href='User?cmd=user_port_list'">내 포트폴리오</button>
                        <button type="button" class="btn btn-primary" id="reg_submit" onClick="location.href='User?cmd=user_cover_letter_list'">내 자기소개서 </button>
                        <button type="button" class="btn btn-primary" id="reg_submit" onClick="location.href='User?cmd=user_resume_view'">내 이력서 </button>
                        <button type="button" class="btn btn-primary" id="reg_submit" onClick="location.herf=history.back()">취소</button>
                    </div>
                </div>
            
                <!--// 본문 들어가는 부분 -->
            <hr/>
            <!-- 푸터 들어가는 부분 -->
            
            <div>
                <p class="text-center">
                    <small><strong>업체명</strong></small><br>
                    <small>대표 : 윤홍철 ㆍ 주소 :  사거리 ㆍ 사업자등록번호:123-12-12345 ㆍ 전화 : 02-123-1234</small><br>
                    <small>Copyrightⓒ test.com All rights reserved.</small>
                </p>
            </div>
            <!--// 푸터 들어가는 부분 -->
        </div>
</body>

</html>