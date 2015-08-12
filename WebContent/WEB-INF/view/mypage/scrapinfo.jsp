<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="../resource/mypage/mypage.css" rel="stylesheet" type="text/css" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../resource/css/reset.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/modernizr.js"></script>

<link href="../resource/css/shared.css" type="text/css" rel="stylesheet" />

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
   margin-left: auto;
   margin-right: auto;
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

#information {
   height: inherit;
}

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
   background: grey;
   float: left;
   min-height: 300px;
}
</style>
</head>
   <body class="content-wrapper clearfix:after">
      <header>
        <jsp:include page="/WEB-INF/view/inc/header.jsp"></jsp:include>
      </header>
      
      <!-- 바디영역 -->
	
	<div id="body" class="wrap-content clearfix">
	
	<!-- 어사이드영역 -->
	<jsp:include page="/WEB-INF/view/inc/aside.jsp"></jsp:include>
      
      <section>
			<h1 class="hidden">프로필정보</h1>
			
			<section id="profile-bg">
				<h1 class="hidden">프로필배경</h1>
				<section>
					<h1 class="hidden">프로필사진</h1>
					<ul id="profile">
						<li id="profile-pic"></li>
						<li><security:authentication property="name"/></li>
					</ul>
				</section>
			</section>
   
   <!-- <nav id="profile">
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
   </form>
   </nav> -->
      
   <main id="main" class="clearfix:after">
     	 <section id="my-info">
					<div>
						<dd class="hidden">내 소개</dd>
						<textarea id="txtContent" rows="15" cols="16" 
						class="txtContent" name="content">${m.profile }</textarea>
					<form method="post">
						<label class="hidden">수정</label> <input id="myProfileReg" type="submit"
							value="수정" name="myProfileReg"/>
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
			<section id="aaa">

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
							
			
						<c:forEach var="sds" items="${sc}" varStatus="scc">

							<div id="travel-diary-fieldset">
								<h1 class="hidden">여행기${scc.count}</h1>

								<nav>
									<h1 class="hidden">여행기 ${scc.count}등록정보</h1>
									<ul>
										<li><a href=""><img
												src="../resource/images/header-profile-pic.png">${sds.mpic}</a></li>
										<li><a href="">${sds.memberID}</a></li>
										<li><fmt:formatDate value="${sds.regDate}"
												pattern="yyyy년MM월dd일" /></li>
										<li><a href="travelDetail?tcode=${sds.code}">${sds.title}</a></li>
										<li><img src="../resource/images/btn-like.png">
											${sds.likeCnt}</li>

									</ul>
								</nav>

								<section>
									<h1>여행기 ${scc.count}코스</h1>
									<ul>
										<li>Start</li>
										<c:forEach var="c" items="${sds.oneCourse}">
											<li><a href="">${c.areasName}</a></li>
										</c:forEach>
										<li>End</li>
									</ul>
								</section>

								<section>
									<h1>코스별 이미지</h1>
									<section>
										<c:forEach var="c" items="${sds.oneCourse}" varStatus="cc">

											<h1>${scc.count}-${cc.count}코스 이미지</h1>
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
							<form action="scrap_del?scrap=${scrap }" method="post">
							<div>
							<label class="hidden">수정</label> 
							<input id="scrapDel" type="submit" value="스크랩삭제 ${scc.count}" name="scrapDel"/>
							</div>	
							</form>						
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