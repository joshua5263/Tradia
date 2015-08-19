<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../resource/mypage/mypage.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../resource/js/header.js"></script>
<style type="text/css">

#aaa {
	border: 1px red solid;
	width: 460px;
	float: left;
}

#information {
	/* border: 3px red solid; */
}

#mypage-list {
	/* border: 1px maroon solid; */
	display: inline-block;
	width: 800px;
}

#mypage-list ul {
	/* border: 1px black solid; */
	height: 25px;
}

#mypage-recommend {
	height: 25px;
	width: 80px;
	float: left;
	margin-left: 500px;
}

#myPage-updated {
	height: 25px;
	width: 80px;
	float: left;
	margin-left: 5px;
}
#travel-diary {
	/* border: 2px black solid; */
	display: inline-block;
	width: 680px;
	height: inherit;
	margin: auto;
}

#diary-top {
	border: 1px blue solid;
}

#travel-diary-fieldset {
	border: 1px blue solid;
	float: left;
	width: 640px;
	margin-left: 20px;
	margin-top: 5px;
	background: grey;
	display: inline-block;
}

#travel-diary-fieldset-in {
	margin: 5px;
	background: white;
	display: inline-block;
}

#diary-top {
	display: inline-block;
}

#diary-top ul {
	border: 1px red solid;
	width: 140px;
	height: 120px;
	float: left;
}

#diary-top ul+ul {
	border: 1px red solid;
	width: 380px;
	height: 50px;
	float: left;
	margin-top: 20px;
	display: inline-block;
}

#diary-top ul+ul+ul {
	border: 1px red solid;
	width: 100px;
	height: 90px;
	float: left;
	margin: 0px;
	text-align: center;
}

#diary-top ul li {
	border: 1px blue solid;
}

#travel-diary-profile-pic {
	width: 100px;
	height: 100px;
	margin-left: 13px; 
	text-align: center;
}

#travel-diary-profile-id {
	height: 20px;
	text-align: center;
}

#travel-diary-profile-day {
	width: 150px;
	height: 20px;
}

#travel-diary-profile-title {
	width: 370px;
	height: 30px;
	text-align: left;
	line-height: 30px;
	font-size: 30px; 
}

#travel-diary-profile-like {
	width: 50px;
	height: 50px;
	margin-left: 23px;
	margin-top: 10px;
	text-align: center;
}

#diary-middle{
	border: 1px blue solid;
	height: 80px;
	line-height: 40px;
}

#diary-middle li{
	border: 1px black solid;
	display: inline-block;
}

#my-info {
   height: inherit;
   width: 140px;
   float: left;
   min-height: 300px;
   margin: 10px;
  /*  border: 1px maroon solid; */
}

#normal-info {
	border: 1px maroon solid;
}

#course-image li{
	border: 1px maroon solid;
	width: 276px;
	height: 228px;
	float: left;
	margin-left: 24px;
	margin-top: 10px;
}

.clearfix:after {	
	content: ".";
	display: block;
	clear: both;
	visibility: hidden;
	line-height: 0;
	height: 0;
}


/* ------------------------------------------------------------ */

/* #travel-diary-fieldset-in {
	position: absolute;
} */

/* #travel-diary-fieldset-in ul {
	left: 0px;
	top: 0px;
	width: 50px;
	height: 50px;
}

#travel-diary-fieldset-in ul+ul {
	left: 80px;
	top: 0px;
}

#travel-diary-fieldset-in ul+ul+ul {
	right: 0px;
	top: 0px;
}
 */

</style>

<title>Insert title here</title>
<link href="../resource/css/reset.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/modernizr.js"></script>

<link href="../resource/css/shared.css" type="text/css" rel="stylesheet" />
<style>
</style>
</head>
<body class="content-wrapper">

	<header id="header">
		<jsp:include page="/WEB-INF/view/inc/header.jsp"></jsp:include>
	</header>

	<div id="body" class="wrap-content clearfix">

		<!-- 어사이드영역 -->
		<jsp:include page="/WEB-INF/view/inc/aside.jsp"></jsp:include>
		<!-- <aside id="aside">
      <h1>SelectPreferLocation</h1>

      <section>
         <h1>PreferLocationButton</h1>
         <form>
            <legend>지역선택</legend>
            <label class="지역선택" for="location">지역선택</label> <input type="radio"
               name="location">전국 <input type="radio" name="location">서울
            <input type="radio" name="location">경기 <input type="radio"
               name="location">인천 <input type="radio" name="location">강원
            <input type="radio" name="location">충청 <input type="radio"
               name="location">대전 <input type="radio" name="location">전라
            <input type="radio" name="location">광주 <input type="radio"
               name="location">경상 <input type="radio" name="location">대구
            <input type="radio" name="location">울산 <input type="radio"
               name="location">부산 <input type="radio" name="location">제주
         </form>
      </section>
   </aside> -->
		<main id="main">

		<section id="profile-bg">
				<h1 class="hidden">프로필배경</h1>
				<section>
					<h1 class="hidden">프로필사진</h1>
					<ul id="profile">
						<li id="profile-pic">							
							<img src="../resource/upload/profilePicture/${m.picture}" />
						</li>
						<li>
							<form action="fileUpload" method="post" enctype="multipart/form-data">
								<input type="file" id="file-upload" name="file" />
								<input type="submit" value="수정하기" />
							</form>
						</li>
						<li><security:authentication property="name" /></li>
					</ul>
				</section>
			</section>

			<!--  <nav id="profile">
      <h1>프로필</h1>
      <form method="post">
         <ul>
            <li>프로필 사진</li>
            <dl class="article-detail-row">
               <dt class="article-detail-title">사진수정</dt>
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
						<form action="update_member_profile1" method="post">
						<dd class="hidden">내 소개</dd>
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
				<!-- <section id="normal-info">
					<div id="map" style="width: 500px; height: 400px;"></div>
					<script type="text/javascript"
						src="//apis.daum.net/maps/maps3.js?apikey=발급받은 API KEY를 넣으시면 됩니다."></script>
				</section> -->
				<section>

					<h1 class="hidden">지역 페이지</h1>

					<section id="mypage-list">
						<h1 class="hidden">선택 지역</h1>

						<p>(서울)여행기</p>
						<ul>
							<li><input id="mypage-recommend" type="submit" value="추천순"/></li>
							<li><input id="myPage-updated" type="submit" value="최신순"/></li>
						</ul>
					</section>

					<section id="travel-diary">

						<c:forEach var="n" items="${td}" varStatus="td">

							<div id="travel-diary-fieldset">
							<div id="travel-diary-fieldset-in">
								<section id="diary-top">
								<h1 class="hidden">여행기${td.count}</h1>
									<h1 class="hidden">여행기 ${td.count}등록정보</h1>
									<ul>
										<li id="travel-diary-profile-pic"><a href=""><img
												src="../resource/images/header-profile-pic.png"><p class="hidden">${n.mpic}</p></a></li>
										<li id="travel-diary-profile-id"><a href="">${m.id}</a></li>
									</ul>
									<ul>	
										<li id="travel-diary-profile-day"><fmt:formatDate value="${n.regDate}"
												pattern="yyyy년MM월dd일" /></li>
										<li id="travel-diary-profile-title"><a href="../main/travelDetail?tcode=${n.code}">${n.title}</a></li>
									</ul>	
									<ul>
										<li id="travel-diary-profile-like"><img src="../resource/images/btn-like.png"></li>
										<li>${n.likeCnt}</li>
									</ul>
								</section>
								<section id="diary-middle">
									<h1><p class="hidden">여행기 ${td.count}코스</p></h1>
									<ul>
										<li>Start</li>
										<c:forEach var="c" items="${n.oneCourse}">
											<li><a href="">${c.areasName}</a></li>
										</c:forEach>
										<li>End</li>
									</ul>
								</section>

								<section>
									<h1><p class="hidden">코스별 이미지</p></h1>
									<section id="course-image">
										<c:forEach var="c" items="${n.oneCourse}" varStatus="cc">

											<h1><p class="hidden">${td.count}-${cc.count}코스 이미지</p></h1>
											<ul>
												<li>a${c.pic1}</li>
												<li>b${c.pic2}</li>
												<li>c${c.pic3}</li>
												<li>d${c.pic4}</li>
											</ul>
										</c:forEach>
									</section>
								</section>
							</div>
							</div>
						</c:forEach>

					</section>

				</section>
			</section>
		</main>
	</div>


	<footer id="footer">
		<section>
			<h1>Tradia</h1>

			<section>
				<h1>사이트 하이퍼 링크</h1>
				<ul class="article-detail-data">
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
					<dd>
						이민우, <a href="download?f=mys-release.apk" alt="yong-game-down">김용</a>,
						조수나, 윤세리, 권한
					</dd>
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
