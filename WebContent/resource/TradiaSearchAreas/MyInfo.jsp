<%@page import="com.fantastic.web.vo.Member"%>
<%@page import="com.fantastic.web.dao.mybatis.MybatisMemberDao"%>
<%@page import="com.fantastic.web.dao.MemberDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%	

   MemberDao memberDao = new MybatisMemberDao();
   Member m = memberDao.getMember("starbucks@coffee.com");
   request.setAttribute("m", m); 
%>  --%>
<link href="../css/reset.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/modernizr.js"></script>
<style>
	#body{
			width : 1160px;
			background : yellow;
			margin-top: auto;
			margin-bottom: auto;
		}
</style>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body id="body">
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
               <li>${m.nickName}</li>
               <li><a href=""> ButtonImage</a>
                  <ul class="sub">
                     <li><a href="">MyPage</a></li>
                     <li><a href="">내정보</a></li>
                     <li><a href="">스크랩목록</a></li>
                     <li><a href="">도움말</a></li>
                     <li><a href="">로그아웃</a></li>
                     <li><a href="">+작성하기</a></li>
                  </ul>
            </ul>
         </nav>
      </section>
   </header>

   <aside>
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
   </aside>
   <main>
   <section>
      <h1>기본정보</h1>
      <section>
         <h1>프로필정보</h1>
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

                  <dt>별명 :</dt>
                  <dd>${m.nickName}</dd>
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
                  
                  
                  
                  <c:if test="${m.gender == 0}">
                  <input type="radio" name="gender" checked="checked" value="0">남
                  <input type="radio" name="gender" value="1">녀
                  </c:if>
                  <c:if test="${m.gender == 1}">
                  <input type="radio" name="gender" value="0">남
                  <input type="radio" name="gender" checked="checked" value="1">녀
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
                  <label class="지역선택" for="location">지역선택</label> <input
                     type="radio" name="location">전국 <input type="radio"
                     name="location">서울 <input type="radio" name="location">경기
                  <input type="radio" name="location">인천 <input type="radio"
                     name="location">강원 <input type="radio" name="location">충청
                  <input type="radio" name="location">대전 <input type="radio"
                     name="location">전라 <input type="radio" name="location">광주
                  <input type="radio" name="location">경상 <input type="radio"
                     name="location">대구 <input type="radio" name="location">울산
                  <input type="radio" name="location">부산 <input type="radio"
                     name="location">제주
               </form>
            </section>
         </fieldset>
      </section>
   </section>
   </main>
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