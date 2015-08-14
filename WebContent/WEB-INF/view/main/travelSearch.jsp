<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TRADIA</title>

<link href="../resource/css/reset.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript" src="../resource/js/modernizr.js"></script>

<link href="../resource/css/shared.css" type="text/css" rel="stylesheet" />
<link href="../resource/css/search.css" type="text/css" rel="stylesheet" />

<style>

	
	</style>

</head>
<body>

	<jsp:include page="/WEB-INF/view/inc/header.jsp"></jsp:include>



	<div id="body" class="wrap-content">
	
	<!-- 어사이드영역 -->
	<jsp:include page="/WEB-INF/view/inc/aside.jsp"></jsp:include>



	<main id="main" class="wrap-content">
	<section>

		<h1 class="hidden">지역 페이지</h1>

		<section>
			<h1 class="hidden">선택 지역</h1>
			
			<p>${list.getAreasName} 여행기</p>
			
			<ul>
				<li>추천순</li>
				<li>최신순</li>
			</ul>
		</section>

		<section id="travel-diary">
		
				<c:forEach var="n" items="${List}" varStatus="tc">
				
					<div id="travel-diary-fieldset">
						<h1 class="hidden">여행기${tc.count}</h1>
						
						<section>
							<h1 class="hidden">검색여행기</h1>
							
							<nav>
							<c:forEach var="t" items="${n.travelDiaries}">
							<ul>
							
								<li><a href=""><img src="../resource/images/header-profile-pic.png">${t.mpic}</a></li>
								<li><a href="">${t.memberID}</a></li>
								<li><fmt:formatDate value="${t.regDate}" pattern="yyyy년MM월dd일" /></li>
								<li><a href="../main/travelDetail?tcode=${t.code}">${t.title}</a></li> 
								<li><img src="../resource/images/btn-like.png"> ${t.likeCnt}</li>
							</ul>
							</nav>
							<section>
								<h1>여행기 ${tc.count}코스</h1>
								<ul>
									<li>Start</li>
										<c:forEach var="c" items="${n.oneCourse}" >
									<li><a href="">${c.areasName}</a></li>
									    </c:forEach>
									<li>End</li>
								</ul>		
							</section>
				
							<section>
								<h1>코스별 이미지</h1>
								<section>						
									<c:forEach var="c" items ="${n.oneCourse}" varStatus="cc">
									
									<h1>${tc.count} - ${cc.count}코스 이미지</h1>
									<ul>
							 			<li>${c.pic1}</li>
										<li>${c.pic2}</li>
										<li>${c.pic3}</li>
										<li>${c.pic4}</li> 
									</ul>
									</c:forEach>
								</section>
							</section>						
								
							</c:forEach>
							
						</section>			
					</div>
				</c:forEach>				
		</section>

	</section>
	</main>
	</div>


	<footer id="footer" class="wrap-content">
      <section>
         <h1>Tradia</h1>
         
         <section>
            <h1>사이트 하이퍼 링크</h1>
            <ul>
               <li><a href="" alt="메인">메인</a></li>
               <li><a href="" alt="공지사항">공지사항</a></li>
               <li><a href="" alt="도움말">도움말</a></li>
            </ul>
         
         </section>
   
   
         <section>
            <h1>관리자 정보</h1>
            <dl>
               <dt>주소:</dt>
               <dd>서울특별시 마포구</dd>
               <dt>관리자메일:</dt>
               <dd>pjh5263@naver.com</dd>
               <dt>전화:</dt>
               <dd>010-0000-0000</dd>               
               <dt>대표:</dt>
               <dd>박종하</dd>
               <dt>관리자:</dt>
               <dd>이민우, 김용, 조수나, 윤세리, 권한</dd>
            </dl>
         </section>
   
         <section>
            <h1>저작권 정보</h1>
            <p>Copyright tradia.com 2015-2015 All Right Reserved.
               Contact pjh5263@tradia.com</p>
         </section>
      </section>
   </footer>


</body>
</html>