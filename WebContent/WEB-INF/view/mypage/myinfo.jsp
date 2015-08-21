
<%@page import="com.fantastic.web.vo.Member"%>
<%@page import="com.fantastic.web.dao.mybatis.MybatisMemberDao"%>
<%@page import="com.fantastic.web.dao.MemberDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="../resource/css/reset.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript" src="../resource/js/modernizr.js"></script>
<link href="../resource/mypage/mypage.css" rel="stylesheet" type="text/css"></link>
<link href="../resource/css/shared.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="../resource/js/header.js"></script>

<script type="text/javascript">
window.addEventListener("load", function(){
	var btnProBgFile = document.querySelector("#profile-bg > div > form > span");
	btnProBgFile.onclick = function(){
		//alert("안녕");
		
		//클릭 이벤트 객체 만들기
		var event = new MouseEvent("click", {
			'view' : window,
			'bubbles' : true,
			'cancelable' : true				
		});
		
		//파일 업로드 기능 가져오기
		var inputFile = document.querySelector("#profile-bg-file-upload");
		inputFile.dispatchEvent(event);
	};
	
	var btnProFile = document.querySelector("#profile > li:FIRST-CHILD+li > form > span");
	btnProFile.onclick = function(){
		//alert("안녕");
		
		//클릭 이벤트 객체 만들기
		var event = new MouseEvent("click", {
			'view' : window,
			'bubbles' : true,
			'cancelable' : true				
		});
		
		//파일 업로드 기능 가져오기
		var inputFile = document.querySelector("#profile > li:FIRST-CHILD+li > form > input:FIRST-CHILD");
		inputFile.dispatchEvent(event);
	};
});
</script>

<style>

.quick-menu {
	height: 65px;
	width: 100%;
	position: fixed;
	/* left: ?; */
	top: 0px;
	background: white;
}

.content-wrapper {
	width: 960px;
	height: 100%;
	/* height: inherit; */
	margin-left: auto;
	margin-right: auto;
	/* background: yellow;   
   opacity: 0.3; */
}

#main-menu {
	height: 65px;
}

#information {
	height: inherit;
}

#normal-info {
	height: inherit;
	width: 700px;
	float: left;
	min-height: 300px;
	background: white;
	margin-top: 10px;
	font-family: SeoulNamsan;
	font-size: 15px;
	font-weight: bold;
/* 	border: 1px dotted red; */
}

#normal-info-title {
	margin: 20px;
	font-size: 20px;
}

#normal-info nav {
/* 	border: 1px solid blue; */
	display: inline-block;
	width: 700px;
}

#normal-info dt, dd {
/* 	border: 1px dotted blue; */
	display: inline-block;
}

#normal-info dt {
	width: 80px;
	text-align: center;
	margin-top: 10px;
}

#normal-info dd {
	text-align: center;
}

#normal-info input[type="text"] {
	background: grey;
	width: 130px;
	height: 20px;
	border: 1px solid #50b4ff;
}

#button {
	margin-top: 10px;
	margin-bottom: 20px;
	margin-left: 283px;
	width: 134px;
	height: 48px;
	border: 0px;
	background: url("../resource/images/btn_modify.png");
	text-indent: -999px;
}

.hidden {
	display: none !important;
}

.left {
	float: left;
}

#profile-bg-file-upload,
#profile > li:FIRST-CHILD+li > form > input:FIRST-CHILD{
	display: none;
}

#profile-bg > div > form > span,
#profile > li:FIRST-CHILD+li > form > span{
	background: pink;
	cursor: pointer;
	font-size: 15px;
	color:black;
}
</style>
</head>

<body>
	<header>
		<jsp:include page="/WEB-INF/view/inc/header.jsp"></jsp:include>
	</header>

	<!-- 바디영역 -->

	<div id="body" class="wrap-content clearfix">

		<!-- 어사이드영역 -->
		<jsp:include page="/WEB-INF/view/inc/aside.jsp"></jsp:include>

		<main id="main" class="clearfix">

			<section>
				<h1 class="hidden">프로필정보</h1>
	
				<section>
					<h1 class="hidden">프로필배경</h1>
					<div id="profile-bg">
						<img src="../resource/upload/profileBackground/${m.background}"/>
						<form id="profile-bg-back" action="profileBgFileUpload" method="post" enctype="multipart/form-data">
							<input type="file" id="profile-bg-file-upload" name="file" />
							<span>배경파일선택</span>
							<input type="submit" value="배경적용" />
						</form>
					</div>
					<div id="profile-image">
						<h1 class="hidden">프로필사진</h1>
											
							<p id="profile-pic">							
								<img src="../resource/upload/profilePicture/${m.picture}" /></p>
							
							
								<form id="profile-pic-back" action="fileUpload" method="post" enctype="multipart/form-data">
									<input type="file" id="file-upload" name="file" />
									<span>프로필파일선택</span>
									<input type="submit" value="프로필적용" />
								</form>
							<p id="profile-name"><security:authentication property="name" /></p>
					</div>
				</section>
			</section>
	
				<!--  <nav id="profile">
	         <h1 class="hidden">프로필</h1>
	         <form method="post">
	            <ul>
	               <li id="profile-image"/>
	               <dl class="article-detail-row">
	                  <dt class="article-detail-title hidden">사진수정</dt>
	                  <dd class="article-detail-data">
	                     &nbsp;<input type="file" id="txtFile" name="file" />
	                  </dd>
	                  <input type="submit" value="수정" />
	               </dl>
	            </ul>
	         </form>
	      </nav> -->
				<section id="information">
					<section id="my-info">
						<div>
							<form action="update_member_profile2" method="post">
							<div class="hidden">내 소개</div>
							<textarea rows="15" cols="16" name="myProfile">${m.profile }</textarea>
							<label class="hidden">수정</label> 
							<input id="myProfile" type="submit" value="수정"/>
							</form>
						</div>
						<div>
							<dd>
								<a href="mypage">My Page</a>
							</dd>
							<dd>
								<a href="myinfo">내 정보</a>
							</dd>
							<dd>
								<a href="scrapinfo">스크랩 목록</a>
							</dd>
						</div>
					</section>
				</section>
	
					<section id="normal-info">
						<h1 class="hidden">기본정보</h1>
							<h1 id="normal-info-title">프로필정보</h1>
	
						<form action="modMyInfo" method="post">
							<ul>						
								<li>ID</li>
								<li class="first-info">${m.id}</li>
							
								<li>비밀번호</li>
								<li class="first-info">새 비밀번호</li>
								<li><input type="text" name="password" /></li>
								<li class="first-info">새 비밀번호 확인</li>
								<li><input type="text" name="password2" /></li>
								
							</ul>
						
							<ul>
								
							
								<li>생년월일</li>
								<li class="first-info">${m.birthday}</li>
								<li class="hidden">생년월일 입력</li>
								<li><input type="date" name="birthday"></li>
							</ul>
							
							
							<ul>
								<li>성별</li>
								<c:if test="${m.gender == 0}">
									<li class="first-info">남</li>
								</c:if>
								<c:if test="${m.gender == 1}">
									<li class="first-info">여</li>
								</c:if>
							
								<li>
									<fieldset>
										<legend class="hidden">지역선택</legend>
										<label class="지역선택  hidden" for="gender-check">성별선택</label> 
											<input type="radio" name="gender-check" value="0" checked>남
											<input type="radio" name="gender-check" value="1">여
									</fieldset>
								</li>
							</ul>
							
							<label class="hidden">수정</label> 
							<input id="button" type="submit" value="수정" />
						</form>
					</section>
				</section>
			</section>
		</main>
	</div>
	<!-- -------------------------------------------------------------------------------------------- -->
	<!-- 푸터영역 -->

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
				<p>Copyright tradia.com 2015-2015 All Right Reserved. Contact
					pjh5263@tradia.com</p>
			</section>
		</section>
	</footer>
</body>
</html>
