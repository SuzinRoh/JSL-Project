<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
        <!-- meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"/ -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>회원가입</title>
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
        	function send(){
        		
        		if(user_insert.userid.value == ""){
        			alert("아이디를 입력해주세요");
        			return;
        		}
        		if(user_insert.userpass.value == ""){
        			alert("비밀번호를 입력해주세요");
        			return;
        		}
        		if(user_insert.username.value == ""){
        			alert("이름을 입력해주세요");
        			return;
        		}
        		if(user_insert.useremail.value == ""){
        			alert("이메일을 입력해주세요");
        			return;
        		}
        		if(user_insert.usertel.value == ""){
        			alert("전화번호를 입력해주세요");
        			return;
        		}
        		if(user_insert.provisionYn[1].checked){
        			alert("회원가입 약관에 동의해주세요");
        			return;
        		}
        		if(user_insert.memberInfoYn[1].checked){
        			alert("개인정보 동의 약관에 동의해주세요");
        			return;
        		}
        		if(user_insert.userpass.value != user_insert.repass.value){
        			alert("입력하신 비밀번호가 같지 않습니다.");
        			return;
        		}
        		
        		user_insert.action="User?cmd=user_insert_pro";
        		user_insert.submit();
        	}
        </script>
        
        <script>
        	
        </script>
        
       
<title>Insert title here</title>
</head>
<body>
<div class="container" ><!-- 좌우측의 공간 확보 -->
            <!-- 헤더 들어가는 부분 -->
            
            <div class="row">
                <p></p>
                <div class="col-md-12">
                    <small>
                    <a href="#">로그인</a> | <a href="#">회원가입</a>
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
                
 
 
            <form name="user_insert" role="form" method="post">
                <div class="form-group">
                    <label for="provision" class="col-lg-2 control-label">회원가입약관</label>
                    <div class="col-lg-10" id="provision">
                        <textarea class="form-control" rows="8" style="resize:none">약관동의
회원가입 약관 내용
                        </textarea>
                        <div class="radio">
                            <label>
                                <input type="radio" name="provisionYn" value="Y" autofocus="autofocus" checked>
                                동의합니다.
                            </label>
                        </div>
                        <div class="radio">
                            <label>
                                <input type="radio" name="provisionYn" value="N">
                                동의하지 않습니다.
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="memberInfo" class="col-lg-2 control-label">개인정보취급방침</label>
                    <div class="col-lg-10" id="memberInfo">
                        <textarea class="form-control" rows="8" style="resize:none">개인정보의 항목 및 수집방법
개인정보 항목 및 수집 약관 내용
                        </textarea>
                        <div class="radio">
                            <label>
                                <input type="radio" id="memberInfoYn" name="memberInfoYn" value="Y" checked>
                                동의합니다.
                            </label>
                        </div>
                        <div class="radio">
                            <label>
                                <input type="radio" id="memberInfoYn" name="memberInfoYn" value="N">
                                동의하지 않습니다.
                            </label>
                        </div>
                    </div>
                </div>
                
                <div class="form-group" id="divId">
                    <label for="inputId" class="col-lg-2 control-label">아이디</label>
                    <div class="col-lg-10">
                        <input type="text" id="user_id" class="form-control onlyAlphabetAndNumber" name="userid" data-rule-required="true" placeholder="30자이내의 알파벳, 언더스코어(_), 숫자만 입력 가능합니다." maxlength="30" value="">
                        <div class="check_font" id="id_check"></div>
                    </div>
                </div>
                <div class="form-group" id="divPassword">
                    <label for="inputPassword" class="col-lg-2 control-label">패스워드</label>
                    <div class="col-lg-10">
                        <input type="password" class="form-control" id="user_pass" name="userpass" data-rule-required="true" placeholder="패스워드" maxlength="30">
                    </div>
                </div>
                <div class="form-group" id="divPasswordCheck">
                    <label for="inputPasswordCheck" class="col-lg-2 control-label">패스워드 확인</label>
                    <div class="col-lg-10">
                        <input type="password" class="form-control" name="repass" data-rule-required="true" placeholder="패스워드 확인" maxlength="30">
                    </div>
                </div>
                <div class="form-group" id="divName">
                    <label for="inputName" class="col-lg-2 control-label">이름</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control onlyHangul" name="username" data-rule-required="true" placeholder="한글만 입력 가능합니다." maxlength="15">
                    </div>
                </div>
                
                <div class="form-group" id="divEmail">
                    <label for="inputEmail" class="col-lg-2 control-label">이메일</label>
                    <div class="col-lg-10">
                        <input type="email" class="form-control" id="user_email" name="useremail" data-rule-required="true" placeholder="이메일" maxlength="40">
                        <div class="check_font" id="email_check"></div>
                    </div>
                    <div class="col-lg-offset-2 col-lg-10">
                        
                        
                    </div>
                </div>
                
                <div class="form-group" id="divPhoneNumber">
                    <label for="inputPhoneNumber" class="col-lg-2 control-label">휴대폰 번호</label>
                    <div class="col-lg-10">
                        <input type="tel" class="form-control onlyNumber" name="usertel" data-rule-required="true" placeholder="-를 제외하고 숫자만 입력하세요." maxlength="11">
                    </div>
                </div>
            
                </div>
                </form>
                
                <div class="form-group" style="text-align:right; padding-right:10%">
                    <div class="col-lg-offset-2 col-lg-10" >
                        <button type="button" class="btn btn-primary" id="reg_submit" onClick="send();">Sign in</button>
                        <button type="button" class="btn btn-primary" id="reg_submit" onClick="javascript:history.back();">취소</button>
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
<script type="text/javascript">
        $("#user_id").blur(function(){
        	var idStr = $("#user_id").val();
        	$.ajax({
        		url : "/User?cmd=user_idcheck&userid=" + idStr,
        		type : "get",
        		success : function(data){
        			//alert(data);
        			if (data == 1) {
						// 1 : 아이디가 중복되는 문구
						$("#id_check").text("사용중인 아이디입니다 :p");
						$("#id_check").css("color", "red");
						$("#reg_submit").attr("disabled", true);
        			}
        			else{
        				if(idStr == ""){
        					$("#id_check").text("아이디를 입력해주세요.");
        					$("#reg_submit").attr("disabled", true);
        				}
        				else{
        					$("#id_check").text("사용가능한 아이디입니다 :p");
        					$("#reg_submit").attr("disabled", false);
        				}
        				
        			}
        		}
        	});
        });
        
        </script>
       
</html>