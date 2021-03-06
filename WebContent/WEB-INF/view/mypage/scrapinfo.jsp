<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../resource/css/reset.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/modernizr.js"></script>
<link href="../resource/mypage/mypage.css" rel="stylesheet"
	type="text/css" />
<link href="../resource/css/shared.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="../resource/js/header.js"></script>

<script type="text/javascript">
	window
			.addEventListener(
					"load",
					function() {
						var btnProBgFile = document
								.querySelector("#profile-bg > div > form > span");
						btnProBgFile.onclick = function() {
							//alert("안녕");

							//클릭 이벤트 객체 만들기
							var event = new MouseEvent("click", {
								'view' : window,
								'bubbles' : true,
								'cancelable' : true
							});

							//파일 업로드 기능 가져오기
							var inputFile = document
									.querySelector("#profile-bg-file-upload");
							inputFile.dispatchEvent(event);
						};

						var btnProFile = document
								.querySelector("#profile > li:FIRST-CHILD+li > form > span");
						btnProFile.onclick = function() {
							//alert("안녕");

							//클릭 이벤트 객체 만들기
							var event = new MouseEvent("click", {
								'view' : window,
								'bubbles' : true,
								'cancelable' : true
							});

							//파일 업로드 기능 가져오기
							var inputFile = document
									.querySelector("#profile > li:FIRST-CHILD+li > form > input:FIRST-CHILD");
							inputFile.dispatchEvent(event);
						};
					});
</script>

<style>
/* .clearfix:after {
   content: ".";
   display: block;
   clear: both;
   visibility: hidden;
   line-height: 0;
   height: 0;
}

.content-wrapper {
   width: 960px;
   height: 100%;
   /* height: inherit; */
/* margin-left
:
 
auto
;

   
margin-right
:
 
auto
; */
/* background: yellow;   
   opacity: 0.3; */
}

/* #main-menu {
   height: 65px;
   background: aqua;
}

#footer {
   height: inherit;
   background: orange;
} */
/* #information {
	height: inherit;
}
 */
/* #aside {
   height: inherit;
   width: 80px;
   background: blue;
   float: left;
   min-height: 450px;
} */

/* #body {
   height: 300px;
   background: beige;
} */
/* #profile {
   width: 880px;
   background: green;
   float: left;
   min-height: 150px;
} */
#my-info {
	height: inherit;
	width: 140px;
	float: left;
	min-height: 300px;
	margin: 10px;
}

#normal-info {
	height: inherit;
	width: 740px;
	/* background: grey; */
	float: left;
	min-height: 300px;
}

#scrapDel {
	margin-top: 2px;
	margin-left: 590px;
	width: 40px;
	height: 40px;
}

#profile-bg-file-upload, #profile>li:FIRST-CHILD+li>form>input:FIRST-CHILD
	{
	display: none;
}

#profile-bg>div>form>span, #profile>li:FIRST-CHILD+li>form>span {
	background: pink;
	cursor: pointer;
	font-size: 15px;
	color: black;
}
</style>
</head>
<body class="content-wrapper clearfix">
	<header> <jsp:include page="/WEB-INF/view/inc/header.jsp"></jsp:include>
	</header>

	<!-- 바디영역 -->

	<div id="body" class="wrap-content clearfix">

		<!-- 어사이드영역 -->
		<jsp:include page="/WEB-INF/view/inc/aside.jsp"></jsp:include>

		<main id="main" class="clearfix"> 
			
				<h1 class="hidden">프로필정보</h1>
	
				<section>
					<h1 class="hidden">프로필배경</h1>
					<div id="profile-bg">
						<img src="../resource/upload/profileBackground/${m.background}" />
						<form id="profile-bg-back" action="profileBgFileUpload" method="post"
							enctype="multipart/form-data">
							<input type="file" id="profile-bg-file-upload" name="file" /> <span>배경파일선택</span>
							<input type="submit" value="배경적용" />
						</form>
					</div>
					<div id="profile-image">
					<h1 class="hidden">프로필사진</h1>
	
						<p id="profile-pic"><img src="../resource/upload/profilePicture/${m.picture}" /></p>
						<form id="profile-pic-back" action="fileUpload" method="post"
							enctype="multipart/form-data">
							<input type="file" id="file-upload" name="file" /> <span>프로필파일선택</span>
							<input type="submit" value="프로필적용" />
						</form>
						<p id="profile-name"><security:authentication property="name" /></p>
					</div>
				</section> 
			
				<section id="my-info">
					<div>
					<form action="update_member_profile3" method="post">
						<dd class="hidden">내 소개</dd>
						<textarea rows="15" cols="16" name="myProfile">${m.profile }</textarea>
		
						<label class="hidden">수정</label> <input id="myProfile" type="submit"
							value="수정" />
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

				<section id="normal-info"> 
					
					<h1 class="hidden">지역 페이지</h1>
						<section>
						<h1 class="hidden">지역 페이지</h1>
							<section id="mypage-list">
								<h1 class="hidden">선택 지역</h1>
								<p>(서울)여행기</p>
								
							</section> 
							<section id="travel-diary"> 
							<c:forEach var="sds"
								items="${sc}" varStatus="scc">

								<div id="travel-diary-fieldset">
								<div id="travel-diary-fieldset-in">
									<section id="diary-top">
										<h1 class="hidden">여행기${scc.count}</h1>
										<h1 class="hidden">여행기 ${scc.count}등록정보</h1>
										<ul>
											<li id="travel-diary-profile-pic"><a href=""><img
													src="../resource/images/header-profile-pic.png"> <%-- ${sds.mpic} --%></a></li>
											<li id="travel-diary-profile-id"><a href="">${sds.memberID}</a></li>
										</ul>
										<ul>
											<li id="travel-diary-profile-day"><fmt:formatDate
													value="${sds.regDate}" pattern="yyyy년MM월dd일" /></li>
											<li id="travel-diary-profile-title"><a
												href="travelDetail?tcode=${sds.code}">${sds.title}</a></li>
										</ul>
										<ul>
											<li id="travel-diary-profile-like"><img
												src="../resource/images/btn-like.png"></li>
											<li>${sds.likeCnt}</li>
										</ul>
									</section>
									<section id="diary-middle">
										<h1>
											<p class="hidden">여행기 ${scc.count}코스</p>
										</h1>
										<ul>
											<li>Start</li>
											<c:forEach var="c" items="${sds.oneCourse}">
												<li><a href="">${c.areasName}</a></li>
											</c:forEach>
											<li>End</li>
										</ul>
									</section>
									<section>
									<h1 class="hidden">코스별 이미지</h1>
										<section id="course-image"> 
										<%-- <c:forEach var="c" items="${sds.oneCourse}" varStatus="cc"> --%>
										<h1 class="hidden">${scc.count}-${cc.count}코스이미지</h1>
										<ul>
											<li>a${c.pic1}</li>
											<li>b${c.pic2}</li>
											<li>c${c.pic3}</li>
											<li>d${c.pic4}</li>
										</ul>
										<%-- </c:forEach> --%> 
										</section>
									</section>
										<form action="scrap_del?sCode=${sds.travelCode}" method="post"\>
											<label class="hidden">스크랩삭제</label> <input id="scrapDel"
												type="submit" value="삭제 ${scc.count }" />
										</form>
								</div>
								</div>
							</c:forEach> 
						</section>
					</section>
			
			</section>
		</main>
	</div>

	<footer id="footer"> <section>
	<h1>Tradia</h1>

	<section>
	<h1>사이트 하이퍼 링크</h1>
	<ul class="article-detail-data">
		<li><a href="" alt="메인">메인</a></li>
		<li><a href="" alt="공지사항">공지사항</a></li>
		<li><a href="" alt="도움말">도움말</a></li>

	</ul>

	</section> <section>
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
		<dd>
			이민우, <a href="download?f=mys-release.apk" alt="yong-game-down">김용</a>,
			조수나, 윤세리, 권한
		</dd>
	</dl>
	</section> <section>
	<h1>저작권 정보</h1>
	<p>Copyright tradia.com 2015-2015 All Right Reserved. Contact
		pjh5263@tradia.com</p>
	</section> </section> </footer>
</body>
</html>
