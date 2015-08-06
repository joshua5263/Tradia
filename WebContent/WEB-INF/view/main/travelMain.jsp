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
<link href="../resource/css/main.css" type="text/css" rel="stylesheet" />

<style>

	
	</style>

</head>
<body>

	<jsp:include page="/WEB-INF/view/inc/header.jsp"></jsp:include>


<%-- <header id="header" class="wrap-content">
      <h1>
         <a href="" alt="Tradia"><img src="../resource/images/logo.png"></a>
      </h1>

      <section>
         <h1 class="hidden">메인 메뉴</h1>

         <section>
            <h1 class="hidden">여행기 검색 폼</h1>
            <form id = "travel-search-form">
               <legend class="hidden">통합검색</legend>
               <label>검색</label> <input type="text" value="가고싶은 여행지를 검색하세요" /> 
               <input type="submit" value="검색" />
            </form>
         </section>

         <nav id="profile-menu">
            <h1 class="hidden">프로필</h1>
            <ul>
               <li>ProfilePicture</li>
               <li><security:authentication property="name" /></li>
               <li>ButtonImage</li>
            </ul>
         </nav>

         <nav>
            <h1 class="hidden">프로필목록</h1>
            <ul>
               <li><a href="" alt="MyPage">MyPage</a></li>
               <li><a href="" alt="내정보">내정보</a></li>
               <li><a href="" alt="스크랩목록">스크랩목록</a></li>
               <li><a href="" alt="도움말">도움말</a></li>
               <li><a href="" alt="로그아웃">로그아웃</a></li>
               <li><a href="" alt="작성하기">+작성하기</a></li>
            </ul>
         </nav>
      </section>

   </header> --%>

	<div id="body" class="wrap-content">
	
	<!-- 어사이드영역 -->
	<jsp:include page="/WEB-INF/view/inc/aside.jsp"></jsp:include>
	
  <!--  <aside id="aside">
      <h1>SelectPreferLocation</h1>

      <section>
         <h1>PreferLocationButton</h1>
         <ul>
            <li>전국</li>
            <li>서울</li>
            <li>경기</li>
            <li>인천</li>
            <li>강원</li>
            <li>충청</li>
            <li>대전</li>
            <li>전라</li>
            <li>광주</li>
            <li>경상</li>
            <li>대구</li>
            <li>울산</li>
            <li>부산</li>
            <li>제주</li>

         </ul>
      </section>
   </aside> -->


	<main id="main" class="wrap-content">
	<section>

		<h1 class="hidden">지역 페이지</h1>

		<section>
			<h1 class="hidden">선택 지역</h1>
			
			<p>서울여행기</p>
			<ul>
				<li>추천순</li>
				<li>최신순</li>
			</ul>
		</section>

		<section id="travel-diary">
		
				<c:forEach var="n" items="${List}" varStatus="tc">
				
				<div id="travel-diary-fieldset">
					<h1 class="hidden">여행기${tc.count}</h1>
		    
					<nav>
						<h1 class="hidden">여행기 ${tc.count}등록정보</h1>
						<ul>
							<li><a href=""><img src="../resource/images/header-profile-pic.png">${n.mpic}</a></li>
							<li><a href="">${n.memberID}</a></li>
							<li><fmt:formatDate value="${n.regDate}" pattern="yyyy년MM월dd일" /></li>
							<li><a href="travelDetail?tcode=${n.code}">${n.title}</a></li> 
							<li><img src="../resource/images/btn-like.png"> ${n.likeCnt}</li>
							
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