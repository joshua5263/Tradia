<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tradia</title>

<link href="../resource//css/reset.css" rel="stylesheet" type="text/css"></link>
<link href="../resource/css/shared.css" type="text/css" rel="stylesheet" />
<link href="../resource/postWrite/postCourseWrite.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="../resource/js/modernizr.js"></script>
<script type="text/javascript">
	window.addEventListener("load", function() {
		var win = null;
		var submitAddCourse = document.getElementById("submit-add-course");
		var submitTempSave = document.getElementById("submit-temp-save");
		var submitAftetword = document.getElementById("submit-aftetword");
		var option = document.getElementById("option");

		/* areaName을 잘 받나 테스트를 위함 */
		var courseArea = document.getElementById("course-area");

		/* 코스 추가 버튼 클릭시 option을 course로 */
		submitAddCourse.onclick = function() {
			option.value = "course";
		};
		/* 후기 작성 버튼 클릭 시 option을 afterword로 */
		submitAftetword.onclick = function() {
			alert(courseArea.value);
			option.value = "afterword";
		};
		/* 임시 저장 버튼 클릭 시 option을 save로 */
		submitTempSave.onclick = function() {
			option.value = "save";
		};
		var btnAreaSearch = document.getElementById("btn-area-search");
		btnAreaSearch.onclick = function() {
			win = open("../addarea/addarea", "_blank",
					"width=800px, height=800px");
		};

	});
</script>


<style type="text/css">
#pop {
	width: 300px;
	height: 400px;
	background: #3d3d3d;
	color: #fff;
	position: absolute;
	top: 10px;
	left: 100px;
	text-align: center;
	border: 2px solid #000;
}
</style>
</head>
<body>
	<!-- 헤더 영역 -->
	<jsp:include page="/WEB-INF/view/inc/header.jsp"></jsp:include>
	<div id="body" class="wrap-content">


		<!-- 어사이드영역 -->
		<jsp:include page="/WEB-INF/view/inc/aside.jsp"></jsp:include>

		<main id="main"> <section>
		<div>
		<h1>포스트 쓰기</h1>
		<h2>코스 정보</h2>
		</div>
		<section>
		<div id="course-title">
			<p>코스 정보</p>
		</div>
		<div id="course-info">
			<form method="post" enctype="multipart/form-data">
				<div>
					<legend class="hidden">장소검색</legend>
					<p>장소</p>
					<!--  <input id ="course-area" placeholder="검색 버튼을 누르세요." disabled="disabled" type="text" name="areaName"/> -->
					<input id="course-area" placeholder="검색 버튼을 누르세요." type="text"
						name="areaName" /> <input id="btn-area-search" type="button"
						value="검색" />
				</div>
				<div>
					<p>날짜</p>
					<input type="date" name="csDate" value="date">
				</div>
				<div>
					<fieldset>
						<p>교통 수단</p>
						<input type="radio" id="walk" value="walk" name="traffic">
						<label for="walk">도보</label> <input type="radio" id="car"
							value="car" name="traffic"> <label for="car">차</label> <input
							type="radio" id="subway" value="subway" name="traffic"> <label
							for="subway">지하철</label> <input type="radio" id="taxi"
							value="taxi" name="traffic"> <label for=taxi>택시</label> <input
							type="radio" id="train" value="train" name="traffic"> <label
							for="train">기차</label> <input type="radio" id="fly" value="fly"
							name="traffic"> <label for="fly">비행기</label> <input
							type="radio" id="ship" value="ship" name="traffic"> <label
							for="ship">배</label> <input type="radio" id="other" value="other"
							name="traffic"> <label for="other">기타</label>
					</fieldset>
				</div>
				<div>
					<legend class="hidden">>경비입력</legend>
					<p>경비</p> <input name="cost" type="text"
						placeholder="ex)50000" /> 원
				</div>
				<div>
					<fieldset>
						<legend class="hidden">>사진입력</legend>
						<p>사진</p> <input type="file" name="file" /><br>
						<!-- <label>사진 2</label> <input type="file" name="files"/><br>

			            <label>사진 3</label> <input type="file" name="files"/><br>
			            <label>사진 4</label> <input type="file" name="files"/><br>
			            <label>사진 5</label> <input type="file" name="files"/><br> -->
					</fieldset>
				</div>
				<div>
					<fieldset>
						<legend class="hidden">>느낌입력</legend>
						<p class="느낌" for="feel">느낌</p> <input type="radio"
							id="veryGood" name="feeling" value="veryGood" checked> <label
							for="veryGood"><img
							src="../resource/images/feel-very-good.png" alt="매우 좋음"
							width="55"></label> <input type="radio" id="good" name="feeling"
							value="good"> <label for="good"><img
							src="../resource/images/feel-good.png" alt="좋음" width="55"></label>

						<input type="radio" id="normal" name="feeling" value="normal">
						<label for="normal"><img
							src="../resource/images/feel-normal.png" alt="보통" width="55"></label>

						<input type="radio" id="notGood" name="feeling" value="notGood">
						<label for="notGood"><img
							src="../resource/images/feel-not-good.png" alt="나쁨" width="55"></label>

						<input type="radio" id="veryNotGood" name="feeling"
							value="veryNotGood"> <label for="veryNotGood"><img
							src="../resource/images/feel-very-not-good.png" alt="매우 나쁨"
							width="55"></label>
					</fieldset>
				</div>
				<div>
					<p>메모</p>
						<textarea name="memo" rows="10" cols="50"
							placeholder="간단한 느낌을 남겨주세요!"></textarea>
				</div>
				<div>
				<h1 class="hidden">버튼 목록</h1>
				<p>
					<input type="hidden" id="option" name="option" value="course">
					<input type="submit" id="submit-add-course" value="코스 추가">
					<input type="submit" id="submit-temp-save" value="임시 저장"> <input
						type="submit" id="submit-aftetword" value="후기 작성">
				</p>
				</div>
			</form>
		</div>
		</section>
		</section>
		</main>
	</div>

	<footer id="footer"> <section>
	<h1>Tradia</h1>

	<section>
	<h1>사이트 하이퍼 링크</h1>
	<ul>
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
		<dd>이민우, 김용, 조수나, 윤세리, 권한</dd>
	</dl>
	</section> <section>
	<h1>저작권 정보</h1>
	<p>Copyright tradia.com 2015-2015 All Right Reserved. Contact
		pjh5263@tradia.com</p>
	</section> </section> </footer>

</body>
</html>
