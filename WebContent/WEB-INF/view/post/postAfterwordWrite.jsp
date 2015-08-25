<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tradia</title>

<link href="../resource/css/reset.css" rel="stylesheet" type="text/css"></link>
<link href="../resource/css/shared.css" type="text/css" rel="stylesheet" />
<link href="../resource/postWrite/postAfterwordWrite.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../resource/js/modernizr.js"></script>
</head>
<body>
	<!-- 헤더 영역 -->
	<jsp:include page="/WEB-INF/view/inc/header.jsp"></jsp:include>
	<div id="body" class="wrap-content">
	
	<!-- 어사이드영역 -->
	<jsp:include page="/WEB-INF/view/inc/aside.jsp"></jsp:include>
	
	<main id="main">
		<section>
			<div>
			<h1>포스트 쓰기</h1>
			<h2>후기 작성</h2>
			</div>
			<section id="course-info">
			<h1 class="hidden">코스 정보</h1>
		      
				<form method="post">
					<div>
					<p>총경비</p>
					<legend class="hidden">>경비입력</legend>
					<p class="hidden">경비</p> <input name="cost" type="text"
						placeholder="ex)50000" /> 원
					</div>
					<div>
					<p>후기</p>
						<textarea name="memo" rows="28" cols="64" placeholder="*후기는 필수가 아닙니다."></textarea>
					</div>
					<h1 class="hidden">버튼 목록</h1>
					<input type="submit" value="작성 완료">
				</form>         
			</section>
		</section>
	</main>
	</div>
	
	<footer id="footer">
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
				<p>Copyright tradia.com 2015-2015 All Right Reserved. Contact
					pjh5263@tradia.com</p>
			</section>
		</section>
	</footer>
</body>
</html>