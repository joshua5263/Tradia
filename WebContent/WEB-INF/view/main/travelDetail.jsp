<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


<c:set var="ctxName" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TD-TravelDiary</title>

<link href="../resource/css/reset.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript" src="../resource/js/modernizr.js"></script>

<link href="../resource/css/shared.css" type="text/css" rel="stylesheet" />
<link href="../resource/css/mainDetail.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="../resource/js/header.js"></script>

<style>
	
</style>

<script type="text/javascript">

       window.addEventListener("load",function(){
    	   
    	  //var comDel = document.getElementById("com-del");
    	   var comDel = document.querySelector("#com-del");
    	   		 comDel.onclick = function(){
    	   			 
    	   			var a = confirm("댓글을 삭제하시겠습니까?");
    	   			if(a== false)
    	   			 	  return false;
    	   			
    	   		};
    	   		
    	   var diaryDel = document.querySelector("#diary-del");
   	   		 	diaryDel.onclick = function(){
   	   			 
   	   			var b = confirm("게시글을 삭제하시겠습니까?");
   	   			   if(b== false)
   	   			 	  return false;
   	   			
   	   		};		
    	
 	   		
  	   		var comEdit = document.querySelector("#comments ul > input");
  	   		     comEdit.onclick = function(){
  	   		    	 
  	   		    	alert("111"); 
  	   		     };
  	   		
  	   		        
       });

</script>
</head>
<body>

     <jsp:include page="/WEB-INF/view/inc/header.jsp"></jsp:include>
 

	<div id="body" class="wrap-content">
	   <!-- 어사이드영역 -->
	<jsp:include page="/WEB-INF/view/inc/aside.jsp"></jsp:include>
	
	
	   <main id = "main">
	   <section>
	
	      <h1 class="hidden">여행기</h1>
	
		  <div id="travel-information">
		      <section>
		         <h1 class="hidden">게시글 정보란</h1>
		         <ul>
		            <li>${td.mpic }</li>
		            <li>${td.memberID }</li>
		            <li><fmt:formatDate value="${td.regDate }" pattern="yyyy년MM월dd일" /></li>
		            <li>${td.title }</li>
		            <li>- ${td.fellowTraveler}와 함께</li>
		            <c:if test="${loginID == td.memberID }">
		            <li><a>수정</a></li>
		            <li><a id="diary-del" href="travel_Del?tcode=${td.code}">삭제</a></li>
		            </c:if>
		            <li><a href="add_like_del?tcode=${td.code}">
		                 <img src="../resource/images/btn-like.png">(${td.likeCnt }) </a></li>
		            <li><a href="add_scrap?tcode=${td.code}">
		                 <img src="../resource/images/btn-scrap.png"> </a></li>
		         </ul>
		      </section>
		
		      <nav>
		         <h1 class="hidden">여행경로</h1>
		         
		         <ul>
		             <li>Start</li>
		             <li>${td.startDate }</li>
		             <c:forEach var ="c" items="${td.oneCourse}" >
		            <li><a href="">${c.areasName }</a></li> 
		            </c:forEach> 
		            <li>${td.lastDate }</li>
		            <li>End</li>
		         </ul>
		      </nav>
	      </div>
	      
	      <div id="travel-cource-information">
		      <section>
		            <c:forEach var="c1" items = "${td.oneCourse}" varStatus="cc">
		              <h1 class="hidden">코스${cc.count } 내용</h1>
		              <ul>
		                  <li>${c1.csDate }</li>
		                  <li>${c1.areasName }</li>
		                  <li>코스${cc.count }</li>
		                  <li>${c1.memo}</li>
		                  <li>${c1.feeling} (느낌)</li>
		                  <li>금액</li>
		                  <li>${c1.cost }</li>
		                  <li>교통편</li>
		                  <li>${c1.traffic }</li>
		                  <li>선택큰이미지</li>
		                <li>${c1.pic1}</li>
		               <li>${c1.pic2}</li>
		               <li>${c1.pic3}</li>
		               <li>${c1.pic4}</li> 
		               <li>${c1.pic5}</li>
		              </ul>
		              </c:forEach>
		      </section>
		      <section>
		           <h1>여행 후기</h1>
		              <ul>
		                   <li>${td.memo }</li>
		                   <li>총 금액</li>
		                   <li>${td.totalCost }원</li>
		              </ul>
		      </section>
	      </div>
	      
	      <div id="reply">
	      <section>
	          <h1 class="hidden">댓글</h1>
	            <form method="post" action="com_reg?tcode=${td.code}">
	               <legend class="hidden">댓글입력란</legend>
	                <label>댓글쓰기</label> 
	               <textarea rows="3" cols="80"  name="contents"></textarea> 
	               <input type="submit"   value="확인" />
	           </form>
	      </section>
	      
	       <section id="comments">
	         <h1> 댓글내용 </h1>
	           <c:forEach var="cm" items="${td.travelCommnet}" >
	            <ul>
	               <li>${cm.mpic}</li>
	               <li>${cm.memberID}</li>
	               <c:if test="${loginID == cm.memberID }">
	            <%--    <form method="post" action="com_edit?cmcode=${cm.code}">
	               <input type="hidden" name="tcode" value = "${td.code}"/>
	               <input type="submit" value="수정" />  
	               </form> --%>
	               
	               <input type="button" value="수정" />
	               
	               <form id="com-del" method="post" action="com_del?cmcode=${cm.code}">
	               		<input type="hidden" name="tcode" value = "${td.code}"/>
	                  	<input type="submit"   value="삭제" />
	               </form>
	               </c:if>
	               <li>${cm.contents }</li>
	               <li><fmt:formatDate value="${cm.regDate}" pattern="yyyy.MM.dd hh:mm" /></li>
	            </ul>
	            <br />
	           </c:forEach>
     		 </section>
     		
	      </div>
	      
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
            <p>Copyright tradia.com 2015-2015 All Right Reserved.
               Contact pjh5263@tradia.com</p>
         </section>
      </section>
   </footer>


</body>


</html>
