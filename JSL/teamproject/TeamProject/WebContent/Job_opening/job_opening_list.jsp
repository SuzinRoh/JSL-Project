<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon-precomposed" href="favicon.ico">
<meta charset="UTF-8">
<title>기업공고리스트</title>

 		<!-- Ajax구현하기 위해 필요 -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		  <!-- jQuery 사용하기위해서 -->
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
				
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script>
	function search_post() {
		if(search.key.value == ""){
			alert("검색어가 등록되지 않았습니다.");
			search.key.focus();
			return;
		}
		search.submit();
	}
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100;300;400;500;700;900&display=swap');
body{
	margin:0;
}
.container {
	font-family: 'Noto Sans JP', sans-serif;
	font-family: 'Noto Sans', sans-serif;
	display: flex;
	justify-content: center;
	item-align: center;
	flex-direction: column;
/* 	background-color: grey; */
}
.title{
	text-align:center;
}
ul,li{
	list-style: none;
	}
.main {
	background-color: white;
	width:100%;
	min-width: 800px;
}

.listmenu {
	display: flex;
	justify-content: center;
	item-align: center;
	background-color:#121024;
	color:white;
	padding: 10px;
}

.listmenu div {
	padding-left: 10px;
	padding-right: 10px;
	text-align: center;
}

.searchjob {
	display: flex;
	justify-content: center;
	item-align: center;
	background-color: white;
	border-bottom:solid 1px #c4c4c4;
	padding: 10px;
}

.searchjob div {
	padding-left: 10px;
	padding-right: 10px;
}
.openinglist{
	display: flex; 
	flex-wrap: wrap; 
	width: 100%; 
	justify-content: center;
}
.list_ul{
	list-style: none;
	padding:5px;
	margin:0px;
}
.opening_companyInfo {
	display: flex;
	justify-content: space-evenly;
	align-items: center;
	align-content: center;
	width: 380px;
	height: 100px;
	background-color: #ffffff; 
	border:solid 1px #c4c4c4;;
	padding: 2px;
	border-radius:5px;text-align:center;
}
.countopening {
	display: flex;
	justify-content: center;
	item-align: center;
	padding: 10px;
	font-size:12px;
	color:grey;font-weght:700;
	align-items: baseline;
}
.dropbtn{
	width:60px;
}
.search_location_drop{
	position:relative;
	display:inline-block;
}
.dropbtn{
	background-color: white;
	text-decoration: none;
	border: solid 1px grey;
	border-radius:5px;
	padding:5px;
}
/*location*/
.search_location_drop_con{
	padding:6px;
	display:none;
	position:absolute;
	min-width:50px;
	text-align:left;
	text-size:8px;
	background-color: white;
	box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
	border-radius:10px;
 	z-index: 1;
}
.search_location_drop:hover .search_location_drop_con{
	display:block;
}
/*duty*/
.search_duty_drop{
	position:relative;
	display:inline-block;
	
}
.search_duty_drop_con{
	padding:6px;
	display:none;
	position:absolute;
	width:80px;
	text-align:left;
	text-size:8px;
	background-color: white;
	box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
	border-radius:10px;
 	z-index: 1;
}
.search_duty_drop:hover .search_duty_drop_con{
	display:block;
}
/*salary*/
.search_salary_drop{
	position:relative;
	display:inline-block;
	
}
.search_salary_drop_con{
	padding:6px;
	display:none;
	position:absolute;
	min-width:40px;
	text-align:left;
	text-size:8px;
	background-color: white;
	box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
	border-radius:10px;
 	z-index: 1;
}
.search_salary_drop:hover .search_salary_drop_con{
	display:block;
}
label{
	font-size:10px;
}
#checkedlist , #openinglist {
  transition: transform .2s ease-in-out, opacity 0.3s ease-in-out;
}
#checkedlist, #search_tag{
display: flex;
    flex-wrap: wrap;
    width: 100%;
    justify-content: center;
}
#search_tag{
	display:flex;
	font-size:12px;
	font-weight:200;
}
#tag_duty{
	display:none;
	background-color:#f59a40;
	border: solid 1px #f59a40;
	border-radius:5px;
	padding:3px;
	color:white;
}
#tag_lo{
	display:none;
	background-color:#8fe33b;
	border: solid 1px #8fe33b;
	border-radius:5px;
	padding:3px;
	color:white;
}
#tag_sal{
	display:none;
	background-color:#4b4ef2;
	border: solid 1px #4b4ef2;
	border-radius:5px;
	padding:3px;
	color:white;
}
</style>
</head>
<body>
	<div class=container>
		<div class=title>
			<h2>공고리스트</h2>
		</div>
		
		<div class=main>
			<div class=listmenu>
				<div>채용공고</div>
				<div>지원한 공고</div>
			</div>
			<!-- search -->
			<div class=searchjob>
				<div style="display:flex;">
					<form name = search method = post action = "Job_opening?cmd=job_opening_list"><input placeholder='회사이름' type=text name = key></form>
					<button onClick = javascript:search_post()>검색</button><button onClick = 'javascript:history.back()'>취소</button>
					
				</div>
				
				<!-- chk1 -->
				<div class=search_duty_drop>
					<button class=dropbtn>직무&nbsp;<i class="fas fa-caret-down"></i></button>
					<div class=search_duty_drop_con>
						<li><label><input  class=chkbtn type="checkbox" name="duty_drop_con" value="back" onclick=' getChkInnerChange_duty();'/>백엔드</label>
						<li><label ><input  class=chkbtn type="checkbox" name="duty_drop_con" value="front" onclick=' getChkInnerChange_duty();'/>프론트</label>
						<li><label ><input  class=chkbtn type="checkbox" name="duty_drop_con" value="android" onclick=' getChkInnerChange_duty();'/>안드로이드 앱</label>
						<li><label ><input  class=chkbtn type="checkbox" name="duty_drop_con" value="ios" onclick=' getChkInnerChange_duty();'/>아이폰 앱</label>
						<li><label ><input  class=chkbtn type="checkbox" name="duty_drop_con" value="AI" onclick=' getChkInnerChange_duty();'/>인공지능</label>
						<li><label ><input  class=chkbtn type="checkbox" name="duty_drop_con" value="game" onclick=' getChkInnerChange_duty();'/>게임</label>
					</div>
				</div>
				<!-- chk2 -->
				<div class=search_location_drop>
					<button class=dropbtn>지역&nbsp;<i class="fas fa-caret-down"></i></button>
					<div class=search_location_drop_con>
						<li><label><input  class=chkbtn type="checkbox" name="location_drop_con" value="tokyo" onclick='getChkInnerChange_lo();'/>도쿄</label>
						<li><label><input  class=chkbtn type="checkbox" name="location_drop_con" value="osaka" onclick='getChkInnerChange_lo();'/>오사카</label>
						<li><label><input  class=chkbtn type="checkbox" name="location_drop_con" value="etc" onclick='getChkInnerChange_lo();'/>그외</label>
					</div>
				</div>
				<!-- chk3 -->
				<div class=search_salary_drop>
					<button class=dropbtn>연봉&nbsp;<i class="fas fa-caret-down"></i></button>
					<div class=search_salary_drop_con>
						<li><label><input class=chkbtn type="checkbox" name="salary_drop_con" value="2500" onclick=' getChkInnerChange_sal();'/>2500</label>
						<li><label><input  class=chkbtn type="checkbox" name="salary_drop_con" value="3000" onclick=' getChkInnerChange_sal();'/>3000</label>
						<li><label><input  class=chkbtn type="checkbox" name="salary_drop_con" value="3500" onclick=' getChkInnerChange_sal();'/>3500</label>
						<li><label><input  class=chkbtn type="checkbox" name="salary_drop_con" value="4000" onclick=' getChkInnerChange_sal();'/>3500</label>
						<li><label><input  class=chkbtn type="checkbox" name="salary_drop_con" value="4500" onclick=' getChkInnerChange_sal();'/>4500</label>
						<li><label><input  class=chkbtn type="checkbox" name="salary_drop_con" value="5000" onclick=' getChkInnerChange_sal();'/>5000</label>
					</div>
				</div>
				
			</div>
			<!-- search end -->
			<!-- count-->
			<div class=countopening >
				<div id=openingcountsearch style="display:none"></div>
				<div id=openingcount style="">${count}개의 공고</div>
			</div>
			<!-- count end-->
			
			<div id=search_tag >
				<div id=tag_duty></div>
				<div id=tag_lo></div>
				<div id=tag_sal></div>
			</div>
			
			<!-- list-->
			<div class=openinglist id=openinglist style="">
				<c:forEach var="company" items="${list}" begin="0" end="20">
					<ul class=list_ul>
						<li><div class=opening_companyInfo onclick="location.href='/Job_opening?cmd=company_job_opening_detail&num=${company.getOpening_num()}'">

								<div class=opening_comimage
									style="flex-shrink: 0; width: 30px; height: 30px;">
									 <img style="width: 35px; height: 35px;" src="<%=request.getContextPath()%>/Company/upload/${company.getCom_image_filename()}">

								</div>
								<div style="text-align: left; flex-shrink: 1;">
									<div class=opening_comname
										style="font-size: 12px; font-weight: 500;">${company.getCom_name()}</div>
								
										<div class=opening_comfiled
										style="width: 200px; font-size: 20px; font-weight: 900;">${company.getOpening_subject()}</div>
									<div class=opening_comloction
										style="font-size: 12px; border: soild 1px black;">${company.getCom_location()}
									</div>

									<div class=opening_comfiled
										style="font-size: 12px; border-radius: 2px; background-color: #d5e2f7; padding: 2px; ">${company.getOpening_duty()}
									</div>
								</div>
							</div>
							</li>
					</ul>
				</c:forEach>
				
			</div>
			<!-- list change bubun -->
			<div id=checkedlist style=""></div>
			<!-- list end -->
		</div>

	</div>
	<!-- container end -->
<script type="text/javascript" >
	
	function getChkInnerChange_duty() {
		// 선택된 목록 가져오기
		  const query = 'input[name="duty_drop_con"]:checked';
		  const selectedEls =  document.querySelectorAll(query);
		  const cnt = selectedEls.length;
		  
		  // 선택된 목록에서 value 찾기
		  let result = '';
		  selectedEls.forEach((el) => {
		    result +=  el.value + ' ';
		  });
		  // 출력
		  //alert(result.length);
		  if(result.length > 0){
		  	document.getElementById('tag_duty').innerText = result;
		  	document.getElementById('tag_duty').style.display = "inline-block";
		  } else{
			  document.getElementById('tag_duty').style.display = "none";
		  }
		  if(cnt <= 0 ){
		        //count
		        document.getElementById("openingcountsearch").style.display="none";
		        document.getElementById("openingcount").style.display="block";
		        //list
		        document.getElementById("checkedlist").style.display="none";
		        document.getElementById("openinglist").style.display="flex";
		    } else{
		        //count
		        document.getElementById("openingcount").style.display="none";
		        document.getElementById("openingcountsearch").style.display="block";
		        //list
		        document.getElementById("checkedlist").style.display="flex";
		        document.getElementById("openinglist").style.display="none";
		    }
	}
	
	function getChkInnerChange_lo() {
		// 선택된 목록 가져오기
		  const query = 'input[name="location_drop_con"]:checked';
		  const selectedEls = document.querySelectorAll(query);
 		  const cnt = selectedEls.length;
		  
		  
		  // 선택된 목록에서 value 찾기
		  let result = '';
		  selectedEls.forEach((el) => {
		    result += el.value + ' ';
		  });
		  
		  if(result.length > 0){
			 document.getElementById('tag_lo').style.display = "inline-block";
		 	 document.getElementById('tag_lo').innerText = " "+result+" ";
		  } else{
			  document.getElementById('tag_lo').style.display = "none";
		  }
		  
		  if(cnt <= 0 ){
		        //count
		        document.getElementById("openingcountsearch").style.display="none";
		        document.getElementById("openingcount").style.display="block";
		        //list
		        document.getElementById("checkedlist").style.display="none";
		        document.getElementById("openinglist").style.display="flex";
		    } else{
		        //count
		        document.getElementById("openingcount").style.display="none";
		        document.getElementById("openingcountsearch").style.display="block";
		        //list
		        document.getElementById("checkedlist").style.display="flex";
		        document.getElementById("openinglist").style.display="none";
		    }
		  
	}
	function getChkInnerChange_sal() {
		// 선택된 목록 가져오기
		  const query = 'input[name="salary_drop_con"]:checked';
		  const selectedEls =  document.querySelectorAll(query);
		  const cnt = selectedEls.length;
		  // 선택된 목록에서 value 찾기
		  let result = '';
		  selectedEls.forEach((el) => {
		    result += el.value + ' ';
		  });
		  
		  if(result.length > 0){
			 document.getElementById('tag_sal').style.display = "inline-block";
		 	 document.getElementById('tag_sal').innerText = " "+result+" ";
		  } else{
			 document.getElementById('tag_sal').style.display = "none";
		  }
		  
		  if(cnt <= 0 ){
		        //count
		        document.getElementById("openingcountsearch").style.display="none";
		        document.getElementById("openingcount").style.display="block";
		        //list
		        document.getElementById("checkedlist").style.display="none";
		        document.getElementById("openinglist").style.display="flex";
		    } else{
		        //count
		        document.getElementById("openingcount").style.display="none";
		        document.getElementById("openingcountsearch").style.display="block";
		        //list
		        document.getElementById("checkedlist").style.display="flex";
		        document.getElementById("openinglist").style.display="none";
		    }
		
	}
	
	$(".chkbtn").ready(function() {
		$(".chkbtn").change(function() {//checkbox 클릭시동작
			var location = [];
			var salary = [];
			var duty = [];
			
			$('input:checkbox[name=location_drop_con]:checked').each(function () { location.push($(this).val()); });
			$('input:checkbox[name=salary_drop_con]:checked').each(function () { salary.push($(this).val()); });
			$('input:checkbox[name=duty_drop_con]:checked').each(function () { duty.push($(this).val()); });
			
			$.ajax({
				url : "/Job_opening?cmd=company_job_opening_search&location="+location+"&salary="+salary+"&duty="+duty,
				type : "post",
				datatype:"json",
				success : function(openinglist){
					$("#checkedlist").html("");//div초기화
					$.each(openinglist ,function(i , val){
						
						$("#openingcountsearch").html(val.cnt+"개의 공고");
						//div에 html추가
						$("#checkedlist").append("<div>"+
													"<ul class=list_ul>"+	
														"<li><div class='opening_companyInfo' onclick=\"location.href='/Job_opening?cmd=company_job_opening_detail&num="+val.com_num +"'\">"+
																"<div class=opening_comimage style=\"flex-shrink: 0; width: 30px; height: 30px;\"><img style=\"width: 35px; height: 35px;\" src=\"${pageContext.request.contextPath}/Company/upload/"+val.com_image_filename+"\"></div>"+
																"<div style=\"text-align: left; flex-shrink: 1;\">"+
																	"<div class=opening_comname style=\"font-size: 12px; font-weight: 500;\">"+val.com_name+"</div>"+
																	"<div class=opening_comfiled style=\"width: 200px; font-size: 20px; font-weight: 900; \">"+val.opening_subject+"</div>"+
																	"<div class=opening_comloction style=\"font-size: 12px; border: soild 1px black;\">"+val.com_location+"</div>"+
																	"<div class=opening_comfiled style=\"font-size: 12px; border-radius: 2px; background-color: #d5e2f7; padding: 2px;\">"+val.opening_duty+"</div>"+
																"</div>"+		
														"</div></li>"+
													"</ul>"+
												"</div>");
					});
				},
				error : function(request, status , error){ alert("no"); }
		    });	
		
		 });
		});

</script>
</body>
</html>