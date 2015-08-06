<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tradia</title>
</head>
<body>
	<header>
		<h1>
			<a href="" alt="Tradia">Tradia</a>
		</h1>

		<section>
			<h1>메인 메뉴</h1>

			<section>
				<h1>여행기 검색 폼</h1>
				<form>
					<legend>통합검색</legend>
					<label>검색</label> <input type="text" value="가고싶은 여행지를 검색하세요" /> <input
						type="submit" value="검색" />
				</form>
			</section>

			<nav>
				<h1>프로필</h1>
				<ul>
					<li>ProfilePicture</li>
					<li>MemberId</li>
					<li><a href=""> ButtonImage</a>
						<ul class="sub">
							<li><a href="">MyPage</a></li>
							<li><a href="">내정보</a></li>
							<li><a href="">스크랩목록</a></li>
							<li><a href="">도움말</a></li>
							<li><a href="">로그아웃</a></li>
							<li><a href="">+작성하기</a></li>
						</ul></li>
				</ul>
			</nav>
		</section>

	</header>

	<aside>
		<h1>SelectPreferLocation</h1>

		<section>
			<h1>PreferLocationButton</h1>

			<form>
				<filedset> <legend>지역선택</legend> <label class="지역선택"
					for="location">지역선택</label> <input type="radio" name="location">전국
				<input type="radio" name="location">서울 <input type="radio"
					name="location">경기 <input type="radio" name="location">인천
				<input type="radio" name="location">강원 <input type="radio"
					name="location">충청 <input type="radio" name="location">대전
				<input type="radio" name="location">전라 <input type="radio"
					name="location">광주 <input type="radio" name="location">경상
				<input type="radio" name="location">대구 <input type="radio"
					name="location">울산 <input type="radio" name="location">부산
				<input type="radio" name="location">제주 </filedset>
			</form>
		</section>
	</aside>

	<main>
	<section>
		<h1>포스트 쓰기</h1>

		<form method="post">
			<fieldset>
				<legend>제목입력</legend>
				<label>제목</label> <input type="text" id="title" name="title" />

				<legend>동행인입력</legend>
				<label>동행인</label> <select id="fellowTraveler" name="fellowTraveler">
					<option value="1">1~3</option>
					<option value="2">4~6</option>
					<option value="3">7~</option>
				</select>

				<legend>기간입력</legend>
				<label>여행을 시작한 날</label> <input type="date" id="startDate"
					name="startDate" /> <label>여행의 마지막 날</label> <input type="date"
					id="lastDate" name="lastDate" />

				<h1>버튼 목록</h1>
				<p>
					<input type="submit" value="코스추가"> 
					<input type="submit" value="임시 저장">
					<input type="submit" value="후기 작성">
				</p>
			</fieldset>
		</form>
	</section>
	</main>


	<aside></aside>


	<footer>
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