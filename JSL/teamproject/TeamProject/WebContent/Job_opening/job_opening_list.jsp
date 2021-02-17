<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기업공고리스트</title>
 <!-- Ajax구현하기 위해 필요 -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		  <!-- jQuery 사용하기위해서 -->
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"
				integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
				crossorigin="anonymous"></script>
				
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100;300;400;500;700;900&display=swap');
.container {
	font-family: 'Noto Sans JP', sans-serif;
	font-family: 'Noto Sans', sans-serif;
	display: flex;
	justify-content: center;
	item-align: center;
	flex-direction: column;
/* 	background-color: grey; */
}
ul{
	list-style: none;
	}
.main {
	background-color: white;
	min-width: 800px;
	margin-left:15%;margin-right:15%;
}

.listmenu {
	display: flex;
	justify-content: center;
	item-align: center;
	background-color: pink;
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
.openinglist ul{
	list-style: none;
	padding:5px;
	margin:0px;
}
.opening_companyInfo {
	display: flex;
	justify-content: space-evenly;
	align-items: center;
	align-content: center;
/* 	box-shadow: 5px 5px 10px 1px rgba(10, 10, 10, 0.1); */
	width: 380px;
	height: 100px;
	background-color: #ffffff; 
	border:solid 1px #282a52;
	padding: 2px;
	border-radius:5px;text-align:center;
}
.countopening {
	display: flex;
	padding:0px;
	margin-top:20px;
	margin-left:30px;margin-right:30px;
	justify-content: space-between;
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
/*location*/
.search_location_drop_con{
	padding:6px;
	display:none;
	position:absolute;
	min-width:60px;
	text-align:left;
	text-size:8px;
	background-color: #f9f9f9;
	box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
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
	min-width:60px;
	text-align:left;
	text-size:8px;
	background-color: #f9f9f9;
	box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
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
	min-width:60px;
	text-align:left;
	text-size:8px;
	background-color: #f9f9f9;
	box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
 	z-index: 1;
}
.search_salary_drop:hover .search_salary_drop_con{
	display:block;
}
#checkedlist , #openinglist {
  transition: transform .2s ease-in-out, opacity 0.3s ease-in-out;
}
</style>
</head>
<body>
	<div class=container>
		<div>
			<h2>공고리스트</h2>
		</div>
		<div class=main>
			<div class=listmenu>
				<div>채용공고</div>
				<div>지원한 공고</div>
			</div>
			<!-- search -->
			<div class=searchjob>
				<div>
					<input type=text placeholder='회사이름'>
				</div>
				<div>
					<input type=text placeholder='키워드'>
				</div>
					 
				<div class=search_location_drop>
					<button class=dropbtn>지역&nbsp;<i class="fas fa-caret-down"></i></button>
					<div class=search_location_drop_con>
						<label><input class=loction type="checkbox" name="location_drop_con" value="tokyo" onclick='getCheckedCnt()'/>도쿄</label>
						<label><input class=loction type="checkbox" name="location_drop_con" value="osaka" onclick='getCheckedCnt()'/>오사카</label>
						<label><input class=loction type="checkbox" name="location_drop_con" value="etc" onclick='getCheckedCnt()'/>그외</label>
					</div>
				</div>
				
				<div class=search_salary_drop>
					<button class=dropbtn>지역&nbsp;<i class="fas fa-caret-down"></i></button>
					<div class=search_salary_drop_con>
						<label><input class=salary type="checkbox" name="salary_drop_con" value="2500" onclick='getCheckedCnt()'/>2500</label>
						<label><input class=salary type="checkbox" name="salary_drop_con" value="3000" onclick='getCheckedCnt()'/>오사카</label>
						<label><input class=salary type="checkbox" name="salary_drop_con" value="3500" onclick='getCheckedCnt()'/>그외</label>
					</div>
				</div>
				
			</div>
			<!-- search end -->
			<!-- count-->
			<div class=countopening >
				<div id=opeingcountsearch style="display:none">hiihi</div>
				<div id=opeingcount style="">${count}개의 공고</div>
				<div>ㅇ</div>
			</div>
			<!-- count end-->
			
			<span class=search_tag></span>
			
			<!-- list-->
			<div class=openinglist id=openinglist style="">
				<c:forEach var="company" items="${list}" begin="0" end="20">
					<ul id=tmp>
						<li><div class=opening_companyInfo onclick="location.href='/Job_opening?cmd=company_job_opening_detail&num=${company.getCom_num()}'">

								<div class=opening_comimage
									style="flex-shrink: 0; width: 30px; height: 30px;">
									 <img style="width:30px;height:30px;" src="<%=request.getRealPath("/Company/upload/")%>${company.getCom_image_filename()}"> 
<!-- 									<img style="width: 35px; height: 35px;" -->
<!-- 										src="/Company/upload/pizza.png"> -->
								</div>
								<div style="text-align: left; flex-shrink: 1;">
									<div class=opening_comname
										style="font-size: 12px; font-weight: 500;">${company.getCom_name()}</div>
									<div class=opening_comfiled
										style="width: 200px; font-size: 20px; font-weight: 900;">${company.getOpening_duty()}</div>
									<div class=opening_comloction
										style="font-size: 12px; border: soild 1px black;">${company.getCom_location().substring(0,3)}
									</div>

									<div class=opening_comfiled
										style="font-size: 12px; border-radius: 2px; background-color: #d5e2f7; padding: 2px;">${company.getCom_working_field()}<!--jobopening table 에서 가져오기 이따-->
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
	function getCheckedCnt()  {
		  // 선택된 목록 가져오기
		  //alert('hi');
		  const query = 'input[name="location_drop_con"]:checked';
		  const selectedElements =  document.querySelectorAll(query);
		  
		  // 선택된 목록의 갯수 세기
		  const selectedElementsCnt = selectedElements.length;
		  //alert(selectedElementsCnt);
		  // 출력
		  // document.getElementById('result').innerText  = selectedElementsCnt;
		  if(selectedElementsCnt <= 0 ){
			  //count
			  document.getElementById("opeingcountsearch").style.display="none";
			  document.getElementById("opeingcount").style.display="block";
			  //list
			  document.getElementById("checkedlist").style.display="none";
			  document.getElementById("openinglist").style.display="flex";
		  } else{
			  //count
			  document.getElementById("opeingcount").style.display="none";
			  document.getElementById("opeingcountsearch").style.display="block";
			  //list
			  document.getElementById("checkedlist").style.display="flex";
			  document.getElementById("openinglist").style.display="none";
		  }
	}
	$(".loction").ready(function() {
		$(".loction").change(function() {//checkbox 클릭시동작
			var location = [];
			$('input:checkbox[name=location_drop_con]:checked').each(function () {
				location.push($(this).val());
			});
				$.ajax({
					url : "/Job_opening?cmd=company_job_opening_search&location="+location,
					type : "post",
					datatype:"json",
					success : function(openinglist){
						$("#checkedlist").html("");//div초기화
						$.each(openinglist ,function(i , val){
							
							//opeing count 아직구현안됨
							$("#opeingcountsearch").html("d")
							//div에 html추가
							$("#checkedlist").append("<div>"+
														"<ul>"+	
															"<li><div class=opening_companyInfo onclick=\"location.href='/Job_opening?cmd=company_job_opening_detail&num="+val.com_num +"'\">"+
																		
																		"<div class=opening_comimage style=\"flex-shrink: 0; width: 30px; height: 30px;\"><img style=\"width:30px;height:30px;\" src=\"val.com_file_name\"></div>"+
																			"<div style=\"text-align: left; flex-shrink: 1;\">"+
																				"<div class=opening_comname style=\"font-size: 12px; font-weight: 500;\">"+val.com_name+"</div>"+
																				"<div class=opening_comfiled style=\"width: 200px; font-size: 20px; font-weight: 900;\">"+val.opening_duty+"</div>"+
																				"<div class=opening_comloction style=\"font-size: 12px; border: soild 1px black;\">"+val.com_location.substring(0,3)+"</div>"+
																				"<div class=opening_comfiled style=\"font-size: 12px; border-radius: 2px; background-color: #d5e2f7; padding: 2px;\">"+val.com_working_field+"</div>"+
																		"</div>"+
															"</div>"+
															"</li>"+
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