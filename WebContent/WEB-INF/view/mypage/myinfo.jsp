
<%@page import="com.fantastic.web.vo.Member"%>
<%@page import="com.fantastic.web.dao.mybatis.MybatisMemberDao"%>
<%@page import="com.fantastic.web.dao.MemberDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- <%String memberId = (String)session.getAttribute("mid");%> --%>
<%-- <%
	MemberDao memberDao = new MybatisMemberDao();
	Member m = memberDao.getMember("starbucks@coffee.com");
	request.setAttribute("m", m);
	
	/* if ("gender" == 0)
	{
		int gender = 0;
		m.setGender(gender);
	} */
	int preferlocation = m.getPreferLocation();

	
	if (request.getMethod().equals("POST"))
	{
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		//int gender = Integer.parseInt(request.getParameter("gender"));
		//Date birthday = getParameter("birthday");//

		Member member = new Member();
		member.setId("starbucks@coffee.com");
		
		if (password != "" && password2 != "" && password.equals(password2))
		{
			member.setPassword(password);
			memberDao.modMember(member);
			//member.setGender(gender);
		}
		//member.setBirthday(birthday);
		

		String code = request.getParameter("myinfo");
		session.setAttribute("m", m);
		response.sendRedirect("Myinfo.jsp");
	}
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="../resource/css/reset.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript" src="../resource/js/modernizr.js"></script>

<link href="../resource/css/shared.css" type="text/css" rel="stylesheet" />

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

		<main id="main">


		<section>
			<h1 class="hidden">프로필정보</h1>

			<section id="profile-bg">
				<h1 class="hidden">프로필배경</h1>
				<section>
					<h1 class="hidden">프로필사진</h1>
					<ul id="profile">
						<li id="profile-pic"></li>
						<li><security:authentication property="name" /></li>
					</ul>
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

				<section id="normal-info">
					<h1 class="hidden">기본정보</h1>
					<form action="myinfo_reg" method="post">
						<h1 id="normal-info-title">프로필정보</h1>
						<dl>
						<nav>
							<dt>ID</dt>
							<dd class="first-info">${m.id}</dd>
						</nav>
						<nav>
							<dt>비밀번호</dt>
							<dd class="first-info">새 비밀번호</dd>
							<dd><input type="text" name="password"/><dd>
							<dd class="first-info">새 비밀번호 확인</dd>
							<dd><input type="text" name="password2"/></dd>
						</nav>
						<nav>
							<dt>생년월일</dt>
							<dd class="first-info">${m.birthday}</dd>

							<label class="hidden">생년월일 입력</label>
							<input type="date" name="birthday">
						</nav>
						<nav>
							<dt>성별</dt>

							<c:if test="${m.gender == 0}">
								<dd class="first-info">남</dd>
							</c:if>
							<c:if test="${m.gender == 1}">
								<dd class="first-info">여</dd>
							</c:if>

							<label class="hidden" for="gender">성별선택</label>
							<!-- <label>성별</label>
						<input type="text" name="gender"> -->

							<c:if test="${m.gender == 0}">
								<input class="first-info" type="radio" name="gender"
									checked="checked" value="man">남
						<input type="radio" name="gender" value="1">녀
						</c:if>
							<c:if test="${m.gender == 1}">
								<input class="first-info" type="radio" name="gender" value="0">남
						<input type="radio" name="gender"
									checked="checked" value="woman">녀
						</c:if>
							<c:if test="${m.gender == null}">
								<input class="first-info" type="radio" name="gender" value="0">남
						<input  type="radio" name="gender" value="1">녀
						</c:if>
						</dl>
						</nav>
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




<%-- 	<style>
	
	
	
	</style>
</head>
<body id="bg">

<!-- -------------------------------------------------------------------------------------------- -->
<!-- 헤더영역 -->

<jsp:include page="/WEB-INF/view/inc/header.jsp"></jsp:include>
	<header id="header"  class="wrap-content">
		<h1>
			<a href="" alt="Tradia"><img src="../resource/images/logo.png"></a>
		</h1>

		<section>
			<h1>메인 메뉴</h1>

			<section>
				<h1>여행기 검색 폼</h1>
				<form>
					<fieldset>
						<legend>통합검색</legend>
						<label>검색</label> <input type="text" value="가고싶은 여행지를 검색하세요" /> <input
							type="submit" value="검색" />
					</fieldset>
				</form>
			</section>
			<nav>
				<h1>프로필</h1>
				<ul>
					<li>ProfilePicture</li>
					<li>${m.id}</li>
					<li><a href=""> ButtonImage</a>
						<ul class="sub">
							<li><a href="">MyPage</a></li>
							<li><a href="">내정보</a></li>
							<li><a href="">스크랩목록</a></li>
							<li><a href="">도움말</a></li>
							<li><form method="post">
								<a href="../intro/Login"><input type="button" name="logout" value="로그아웃"></a>
							</form></li>
							<li><a href="../post/postcourse">+작성하기</a></li>
						</ul>
				</ul>
			</nav>
		</section>
	</header>
	
<!-- -------------------------------------------------------------------------------------------- -->
<!-- 바디영역 -->
	
	<div id="body" class="wrap-content clearfix">
	
	<!-- 어사이드영역 -->
	<jsp:include page="/WEB-INF/view/inc/aside.jsp"></jsp:include>
	
	<!-- <aside id="aside">
		<h1 class="hidden">SelectPreferLocation</h1>

		<section>
			<h1 class="hidden">PreferLocationButton</h1>
			<form>
				<legend class="hidden">지역선택</legend>
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
	
	
	
	<section>
		<h1 class="hidden">기본정보</h1>
		<section>
			<h1 class="hidden">프로필정보</h1>
			
			<section id="profile-bg">
				<h1 class="hidden">프로필배경</h1>
				<section>
					<h1 class="hidden">프로필사진</h1>
					<ul id="profile">
						<li id="profile-pic"></li>
						<li>${m.id}</li>
					</ul>
				</section>
			</section>
			
			<nav id="profile">
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
      </nav>
      <section id="information">
         <section id="my-info">
            <div>
               <dd class="hidden">내 소개</dd>
               <textarea id="txtContent" rows="15" cols="16" class="txtContent"
                  name="content"></textarea>
            </div>
            <div>
               <dd>
                  <a href="mypage">My Page</a>
               </dd>
            </div>
            <div>
               <dd>
                  <a href="myinfo">내 정보</a>
               </dd>
            </div>
            <div>
               <dd>
                  <a href="scrapinfo">스크랩 목록</a>
               </dd>
            </div>
         </section>
			
			<fieldset>
				<form method="post">
					<dl>
						<dt>ID :</dt>
						<dd>${m.id}</dd>
						<dt>비밀번호 :</dt>
						<dd>${m.password}</dd>

						<label>새 비밀번호</label>
						<input type="text" name="password">
						<label>새 비밀번호 확인</label>
						<input type="text" name="password2">

						
						<dt>생년월일 :</dt>
						<dd>${m.birthday}</dd>

						<label>생년월일 입력</label>
						<input type="date" name="birthday">

						<dt>성별 :</dt>

						<c:if test="${m.gender == 0}">
							<dd>남</dd>
						</c:if>
						<c:if test="${m.gender == 1}">
							<dd>여</dd>
						</c:if>

						<label class="성별" for="gender">성별선택</label>
						
						<!-- <label>성별</label>
						<input type="text" name="gender"> -->
						
						<c:if test="${m.gender == 0}">
						<input type="radio" name="gender" checked="checked" value="man">남
						<input type="radio" name="gender" value="1">녀
						</c:if>
						<c:if test="${m.gender == 1}">
						<input type="radio" name="gender" value="0">남
						<input type="radio" name="gender" checked="checked" value="woman">녀
						</c:if>
						<c:if test="${m.gender == null}">
						<input type="radio" name="gender" value="0">남
						<input type="radio" name="gender" value="1">녀
						</c:if>
						
						
						<label>수정</label>
						<input type="submit" value="수정" />
					</dl>
				</form>
			</fieldset>
		</section>
		<section>
			<h1>스크랩목록</h1>
			<fieldset>
				<section>
					<h1>선호지역</h1>
					<p>지역사진</p>
					<form method="post">
						<legend>지역선택</legend>
						<label class="지역선택" for="preferLocation">지역선택</label> 
						<input type="radio" name="preferLocation" value="0">전국
						<input type="radio" name="preferLocation" value="1">서울
						<input type="radio" name="preferLocation" value="2">경기
						<input type="radio" name="preferLocation" value="3">인천
						<input type="radio" name="preferLocation" value="4">강원 
						<input type="radio" name="preferLocation" value="5">충청
						<input type="radio" name="preferLocation" value="6">대전
						<input type="radio" name="preferLocation" value="7">전라 
						<input type="radio" name="preferLocation" value="8">광주
						<input type="radio" name="preferLocation" value="9">경상 
						<input type="radio" name="preferLocation" value="10">대구 
						<input type="radio" name="preferLocation" value="11">울산
						<input type="radio" name="preferLocation" value="12">부산 
						<input type="radio" name="preferLocation" value="13">제주
					</form>
				</section>
			</fieldset>
		</section>
	</section>
	</main>
	</div>
	
<!-- -------------------------------------------------------------------------------------------- -->
<!-- 푸터영역 -->
	
	<footer id="footer"  class="wrap-content">
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
</html> --%>