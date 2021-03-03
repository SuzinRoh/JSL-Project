<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
body{
margin:0;
}
.conteiner{
	margin:0;width:100%;
	display:flex;flex-direction: column;
}
.infomation{
	display: flex;flex-direction: row;justify-content: center;
	background-color:grey;
	
}
.comapny_info_index{
	margin:0;
}
.comapny_info_contents{
	margin:0;
}
</style>
<body>
	<div class=conteiner>
		<div> 
			<h3>기업상세정보</h3>
		</div>

			<div>기업이름:${vo.getCom_name()}</div>
			<div class="infomation">
						<!-- company contents -->
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
			
			
			
		</div>
		
		<div> <h3>채용중인공고</h3>
		
		</div>
	
	
	</div>
</body>
</html>