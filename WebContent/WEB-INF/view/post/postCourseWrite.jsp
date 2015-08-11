<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tradia</title>

<link href="../resource//css/reset.css" rel="stylesheet" type="text/css"></link>
<link href="../resource/css/shared.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="../resource/js/modernizr.js"></script>
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
		         <section>
		            <h1>코스 정보</h1>
		      
		         <form action="" method="post">
		            
		            <legend>장소검색</legend>
		            <label>장소</label>
		             <input type="text" />
		             <input type="submit"   value="검색" />
		             
		             <legend>날짜</legend>
		             <input type="date" name="csDate" value="date">
		
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
		            <label>경비</label> <input name="cost" type="text" placeholder="ex)50000"/> 원
		            
		            <fieldset>
			            <legend>사진입력</legend>
			            <label>사진 1</label> <input type="file" /><br>
			            <label>사진 2</label> <input type="file" /><br>
			            <label>사진 3</label> <input type="file" /><br>
			            <label>사진 4</label> <input type="file" /><br>
			            <label>사진 5</label> <input type="file" /><br>
		            </fieldset>
		            <fieldset>
		               <legend>느낌입력</legend>
		               <label class="느낌" for="feel">느낌</label> 
		               <input type="radio" id="veryGood" name="feeling" value="veryGood" checked>
		               <label for="veryGood"><img src="../resource/images/feel-very-good.png" alt="매우 좋음" width="55"></label>
		               
		               <input type="radio" id="good" name="feeling" value="good" >
		               <label for="good"><img src="../resource/images/feel-good.png" alt="좋음" width="55"></label>
		               
		               <input type="radio" id="normal" name="feeling" value="normal" >
		               <label for="normal"><img src="../resource/images/feel-normal.png" alt="보통" width="55"></label>
		               
		               <input type="radio" id="notGood" name="feeling" value="notGood" >
		               <label for="notGood"><img src="../resource/images/feel-not-good.png" alt="나쁨" width="55"></label>
		               
		               <input type="radio" id="veryNotGood" name="feeling" value="veryNotGood" >
		               <label for="veryNotGood"><img src="../resource/images/feel-very-not-good.png" alt="매우 나쁨" width="55"></label>
		            </fieldset>            
		      
		            <p>
		               <label>메모</label>
		               <textarea name="memo" rows="10" cols="50"></textarea>
		               <br>해당 코스의 후기를 남겨주세요!</br>
		            </p>
		      
		            <h1>버튼 목록</h1>
		            <p>
		               <a href="">코스추가</a>
		               <a href=""><input type="submit" value="임시 저장"></a>
		               <a href=""><input type="submit" value="후기 작성"></a>
		            </p>
		            </form>         
		         </section>
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