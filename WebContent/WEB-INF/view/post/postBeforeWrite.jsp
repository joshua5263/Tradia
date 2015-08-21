<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tradia</title>

<link href="../resource/css/reset.css" rel="stylesheet" type="text/css"></link>
<link href="../resource/css/shared.css" type="text/css" rel="stylesheet" />
<link href="../resource/postWrite/postBeforeWrite.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../resource/js/modernizr.js"></script>
<script type="text/javascript">
	window.addEventListener("load", function() {
		var submitAddCourse = document.getElementById("submit-add-course");
		var submitTempSave = document.getElementById("submit-temp-save");
		var option = document.getElementById("option");

		/* 코스 추가 버튼을 누를경우 option의 value를 course로 변경 */
		submitAddCourse.onclick = function() {
			option.value = "course";
		};
		/* 임시 저장 버튼을 누를경우 option의 value를 save로 변경 */
		submitTempSave.onclick = function() {
			alert("임시 저장합니다!");
			option.value = "save";
		};

	});
</script>



</head>
<body>
	<!-- 헤더 영역 -->
	<jsp:include page="/WEB-INF/view/inc/header.jsp"></jsp:include>
	
	<div id="body" class="wrap-content">
	
	<!-- 어사이드영역 -->
	<jsp:include page="/WEB-INF/view/inc/aside.jsp"></jsp:include>


	<main id="main">
	<section>
		<h1>포스트 쓰기</h1>

		<form method="post">
			<fieldset>
				<legend>제목입력</legend>
				<label>제목</label>
				<input type="text" id="title" name="title" />
				<%-- <p>
					<security:authentication property="name"/>
				</p> --%>
				

				<legend>동행인입력</legend>
				<label>동행인</label>
				<select id="fellowTraveler" name="fellowTraveler">
					<option value="friend" selected>친구</option>
					<option value="family">가족</option>
					<option value="couple">연인</option>
					<option value="solo">나홀로</option>
				</select>

				<legend>기간입력</legend>
				<label>여행을 시작한 날</label>
				<input type="date" id="startDate"	name="startDate" />
				<label>여행의 마지막 날</label>
				<input type="date"	id="lastDate" name="lastDate" />

				<h1>버튼 목록</h1>
				<p>
					<input type="hidden" id="option" name="option" value="course">
					<input id="submit-add-course" type="submit" value="코스추가" > 
					<input id="submit-temp-save" type="submit" value="임시 저장">
				</p>
			</fieldset>
		</form>
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
