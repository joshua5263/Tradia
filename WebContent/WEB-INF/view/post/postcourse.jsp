<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="../resource//css/reset.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript" src="../resource/js/modernizr.js"></script>

<style>
	#bg{
		background: url("../resource/images/background.png") no-repeat;
	}	
	
	.wrap-content{
		width : 1020px;
		min-height:inherit;
		margin-left : auto;
		margin-right : auto;
			
		/* opacity:0.1; /*투명도  */ */
	}	

	#header{
		position : fixed;
		top : 0px;
		width : 100%;
		height : 65px;
		margin-left: auto;
		margin-right: auto;
		background: white;
		font-size: 25px;
		display: block;
	}
	
	.hidden{
		display: none;
		visibility: hidden;
	}
	
	#body{
		margin-top : 65px;
		width : 1160px;
		height : 800px;
		margin-left: auto;
		margin-right: auto;
		
	}
	#footer{
		width : 1020px;
		height : inherit;
		margin-left: auto;
		margin-right: auto;
		background-color: rgba( 255, 255, 255, 0.7 );
	}
	#aside{
		width : 70px;
		height : inherit;
		margin-left: auto;
		margin-right: auto;
		
		float: left;
		position : fixed;
		left : 50px;
		top : 50%;
	}
	#aside:hover{
		width : 500px;
		height : 700px
		
	}
	#main{
		width : 1020px;
		height : inherit;
		margin-left: auto;
		margin-right: auto;		
		/* float: left; */
		background-color: rgba( 255, 255, 255, 0.7 );
	}
	.clearfix:after{
		content : ".";
		display : block;
		clear : both;
		visibility : hidden;
		line-height : 0;
		height : 0;
	}
</style>
</head>
<body id="bg">
	<header id="header" class="wrap-content">
		<%-- <h1>
			<a href="" alt="Tradia"><img src="../resource/images/logo.png"></a>
		</h1>

		<section>
			<h1 class="hidden">메인 메뉴</h1>

			<section>
				<h1 class="hidden">여행기 검색 폼</h1>
				<form>
					<fieldset>
						<legend class="hidden">통합검색</legend>
						<label class="hidden">검색</label> <input type="text" value="가고싶은 여행지를 검색하세요" /> <input
							type="submit" value="검색" />
					</fieldset>
				</form>
			</section>
			<nav>
				<h1 class="hidden">프로필</h1>
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
								<!-- <a href="../intro/intro"> -->
								<input type="submit" name="logout" value="로그아웃"></a>
							</form></li>
							<li><a href="">+작성하기</a></li>
						</ul>
				</ul>
			</nav>
		</section> --%>
	</header>
	<div id="body" class="wrap-content clearfix">
		<aside id = "aside">
			<h1 class="hidden">SelectPreferLocation</h1>
	
			<section>
				<h1 class="hidden">PreferLocationButton</h1>
				<form>
					<fieldset>
					<legend class="hidden">지역선택</legend>
					<label class="지역선택" for="location">지역선택</label> 
					<input type="radio" name="location">전국 
					<input type="radio" name="location">서울
					<input type="radio" name="location">경기 
					<input type="radio"	name="location">인천 
					<input type="radio" name="location">강원
					<input type="radio" name="location">충청 
					<input type="radio"	name="location">대전 
					<input type="radio" name="location">전라
					<input type="radio" name="location">광주 
					<input type="radio"	name="location">경상 
					<input type="radio" name="location">대구
					<input type="radio" name="location">울산 
					<input type="radio"	name="location">부산 
					<input type="radio" name="location">제주
					<input type="submit" value="선택하기">
					</fieldset>
				</form>
			</section>
		</aside>
		<main id="main">
		      <section>
		         <h1>포스트 쓰기</h1>
		         <section>
		            <h1>코스 정보</h1>
		         
		      
		         <form action="" method="post">
		            
		            <legend>장소검색</legend>
		            <label>장소</label>
		             <input type="text" />
		             <input type="submit"   value="검색" />
		             
		             <legend>날짜</legend>
		             <input type="date" value="date">
		
		            <fieldset>
		               <legend>교통 수단</legend>
		               <label for = "walk" >도보</label>
		               <input type="checkbox" id = "walk" value="0" />               
		               <label for = "car">차</label>
		               <input type="checkbox" id = "car" value="1" />               
		               <label for = "subway">지하철</label>
		               <input type="checkbox" id = "subway" value="2" />               
		               <label for = taxi>택시</label>
		               <input type="checkbox" id = "taxi" value="3" />               
		               <label for = "train">기차</label>
		               <input type="checkbox" id = "train" value="4" />               
		               <label for = "waflylk">비행기</label>
		               <input type="checkbox" id = "fly" value="5" />               
		               <label for = "walshipk">배</label>
		               <input type="checkbox" id = "ship" value="6" />               
		            </fieldset>
		            
		            <legend>경비입력</legend>
		            <label>경비</label> <input type="text" value = "ex)500000"/>
		            
		            <legend>사진입력</legend>
		            <label>사진</label> <input type="file" />
		            <fieldset>
		               <legend>느낌입력</legend>
		               <label class="느낌" for="feel">느낌</label> 
		               <input type="radio" name="feel" value="0" checked>좋음
		               <input type="radio" name="feel" value="1" >심심<img src="" alt=""/>
		               <input type="radio" name="feel" value="2" >보통<img src="" alt=""/>
		               <input type="radio" name="feel" value="3" >나쁨<img src="" alt=""/>
		               <input type="radio" name="feel" value="4" >싫음<img src="" alt=""/>
		               <input type="radio" name="feel" value="5" >완전싫음<img src="" alt=""/>
		            </fieldset>            
		      
		            <p>
		               <label>메모</label>
		               <textarea rows="10" cols="50"></textarea>
		               <br>해당 코스의 후기를 남겨주세요!</br>
		            </p>
		      
		            <h1>버튼 목록</h1>
		            <p>
		               <a href="postCourse">코스추가</a>
		               <a href=""><input type="submit" value="임시 저장"></a>
		               <a href=""><input type="submit" value="후기 작성"></a>
		            </p>
		            </form>         
		         </section>
		      </section>
		   </main>
	</div>
	<footer id="footer" class="wrap-content">
		<section>
			<h1 class="hidden">Tradia</h1>

			<section>
				<h1 class="hidden">사이트 하이퍼 링크</h1>
				<ul>
					<li><a href="" alt="메인">메인</a></li>
					<li><a href="" alt="공지사항">공지사항</a></li>
					<li><a href="" alt="도움말">도움말</a></li>
				</ul>

			</section>
			<section>
				<h1 class="hidden">관리자 정보</h1>
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
				<h1 class="hidden">저작권 정보</h1>
				<p>Copyright tradia.com 2015-2015 All Right Reserved. Contact
					pjh5263@tradia.com</p>
			</section>
		</section>
	</footer>
</body>
</html>