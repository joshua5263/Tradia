
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<c:set var="ctxName" value="${pageContext.request.contextPath}"></c:set>

	<header id="header"  class="wrap-content">
		<h1 id="logo">
			<a href="../main/travelMain" alt="Tradia"><img src="../resource/images/logo.png"></a>
		</h1>

		<section>
			<h1 class="hidden">메인 메뉴</h1>

			<section>
				<h1 class="hidden">여행기 검색 폼</h1>
				<form id="travel-search-form" action="../search/tradiasearch" method="post">
					<fieldset>
						<legend class="hidden">통합검색</legend>
						<label class="hidden">검색</label> 

							<input type="text" placeholder="가고싶은 여행지를 검색하세요" style="font-family: 서울남산체 EB; font-size: 16px;" name="headerQuery"  /> 

							<input class="button" type="submit" value="검색" />
					</fieldset>
				</form>
			</section>
			<nav id="profile-menu">
				<h1 class="hidden">프로필</h1>
				<ul>
					<li><img src="../resource/images/header-profile-pic.png"></li>
					<li><security:authentication property="name"/> </li>
					<li id="button-image"><img src="../resource/images/btn-menu-select.png"></li>
						<ul class="sub">
							<li><a href="../mypage/mypage">MyPage</a></li>
							<li><a href="../mypage/myinfo">내정보</a></li>
							<li><a href="../mypage/scrapinfo">스크랩목록</a></li>
							<li><a href="../customer/help">도움말</a></li>
							<security:authorize ifAnyGranted="ROLE_ADMIN">
							<li><a href="../customer/help">관리하기</a></li>
							</security:authorize>
							<li><a href="${ctxName}/j_spring_security_logout">로그아웃</a></li>
							<li><a href="../post/postBeforeWrite">+작성하기</a></li>
						</ul>
				</ul>
			</nav>
		</section>
	</header>
