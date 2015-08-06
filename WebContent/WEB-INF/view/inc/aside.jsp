
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<c:set var="ctxName" value="${pageContext.request.contextPath}"></c:set>	
	
	
	<aside id="aside">
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
	</aside>