<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="../resource//css/reset.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript" src="../resource/js/modernizr.js"></script>

<link href="../resource/css/shared.css" type="text/css" rel="stylesheet" />
	<style>

	
	
	</style>
</head>
<body id = "bg">

	<!-- 헤더영역 -->
	<jsp:include page="/WEB-INF/view/inc/header.jsp"></jsp:include>
	
	<div id="body" class="wrap-content clearfix">
		<!-- 어사이드영역 -->
		<jsp:include page="/WEB-INF/view/inc/aside.jsp"></jsp:include>
		
		<main id="main">
			<div>			
				<section id = "section">
					<h1 class="hidden">기본정보</h1>
					<section>
						<article>
						안녕하세요! TRADIA에 오신것을 환영합니다.
						메인페이지에 띄울 선호 지역을 선택해주세요.
						(다중 선택 불가)
						<security:authentication property="name"/>
						</article>
					</section>
					<section>
						<h1 class="hidden">선호지역선택</h1>
							<section>
								<h1 class="hidden">선호지역</h1>
								<p class="hidden">지역사진</p>
									<img src="../resource/images/korea_map.png">
								<form method="post">
									<fieldset>
										<legend>지역선택</legend>
										<label class="지역선택" for="preferLocation">지역선택</label> 
											<input type="radio" name="preferLocation" value="전국" checked>전국
											<input type="radio" name="preferLocation" value="서울시">서울
											<input type="radio" name="preferLocation" value="경기도">경기
											<input type="radio" name="preferLocation" value="인천시">인천
											<input type="radio" name="preferLocation" value="강원도">강원 
											<input type="radio" name="preferLocation" value="충청도">충청
											<input type="radio" name="preferLocation" value="대전시">대전
											<input type="radio" name="preferLocation" value="전라도">전라 
											<input type="radio" name="preferLocation" value="광주시">광주
											<input type="radio" name="preferLocation" value="경상도">경상 
											<input type="radio" name="preferLocation" value="대구시">대구 
											<input type="radio" name="preferLocation" value="울산시">울산
											<input type="radio" name="preferLocation" value="부산시">부산 
											<input type="radio" name="preferLocation" value="제주도">제주
											<br/>
											<input type="submit" name=prefer-location value="선호지역선택하기">
									</fieldset>
								</form>
							</section>
					</section>
				</section>
			</div>		
		</main>
	</div>
	<footer id="footer" class="wrap-content">
		<section>
			<h1 class="hidden">Tradia</h1>

			<section>
				<h1 class="hidden">사이트 하이퍼 링크</h1>
				<ul>
					<li><a href="" alt="메인">메인</a></li>
					<li><a href="" alt="공지사항">공지사항</a></li>
					<li><a href="" alt="도움말">도움말</a></li>
				</ul>

			</section>
			<section>
				<h1 class="hidden">관리자 정보</h1>
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
				<h1 class="hidden">저작권 정보</h1>
				<p>Copyright tradia.com 2015-2015 All Right Reserved. Contact
					pjh5263@tradia.com</p>
			</section>
		</section>
	</footer>
</body>
</html>