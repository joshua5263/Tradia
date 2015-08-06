<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TRADIA</title>

<link href="../resource/css/reset.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript" src="../resource/js/modernizr.js"></script>

<link href="../resource/css/shared.css" type="text/css" rel="stylesheet" />

<style>
	#notice{
		width: 660px;
		border-top: 2px #8cba35 solid;
	}	
	#notice table tr{
		height: 30px;
		line-height: 30px;
	}		
	#notice table td,
	#notice table th{
		text-align: center;
		border-bottom: 1px #e9e9e9 solid;
	}	
	#notice table td:FIRST-CHILD,
	#notice table th:FIRST-CHILD{
		width: 60px;
	}
	#notice table td:FIRST-CHILD+td,
	#notice table th:FIRST-CHILD+td{
		
		width: 400px;
	}
	#notice table td:FIRST-CHILD+td{
		text-align : left;
		text-indent: 10px;
	}
	#notice table td:FIRST-CHILD+td+td,
	#notice table th:FIRST-CHILD+td+td{
		width: 100px;
	}
	#notice table td:FIRST-CHILD+td+td+td,
	#notice table th:FIRST-CHILD+td+td+td{
		width: 100px;
	}
	
	#notice th{
		background: #f5f5f5 url("../images/bg-title-sp.png") no-repeat left center;
	}
	
	#notice th:FIRST-CHILD{
		background: #f5f5f5;
	}
	
	#pager{
		border: 1px solid blue;
		overflow: auto;
		display: inline-block;
	}
	
	#pager p{
		border:1px solid black;
		width:25px;
		height:25px;
		line-height: 25px;
		text-align: center;
	}
	
	#pager p,
	#pager ul{
		float: left;
	}
	
	#pager ul{
		border:1px solid green;
		overflow: auto;
	}
	
	#pager li{
		float: left;
		width:25px;
		height: 25px;
		line-height: 25px;
		border: 1px solid red;
		text-align: center;
	}
	
</style>
	
</head>
<body>
	
	<!-- 헤더영역 -->
	<jsp:include page="/WEB-INF/view/inc/header.jsp"></jsp:include>
	
	<div id="body" class="wrap-content">
	
		<!-- 어사이드영역 -->
		<jsp:include page="/WEB-INF/view/inc/aside.jsp"></jsp:include>
	
		<main id = "main">
			<section>
					<h1 class="main-title">
						도움말
					</h1>
					
					<ul>
						<li>도움말</li>
						<li>공지사항</li>
					</ul>				
					
					<section id="notice">
					<h1 class="hidden">
						공지사항목록
					</h1>
						<table>
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
								</tr>
							</thead>							
							<tbody>	
								<c:forEach var="n" items="${list}">
									<tr>
										<td class="seq">${n.code}</td>
										<td class="title">
											<a href="noticeDetail?c=${n.code}">${n.title}</a>
										</td>
										<td class="writer">${n.adminId}</td>
										<td class="regdate"><fmt:formatDate value="${n.regDate}" pattern="yyyy/MM/dd"/></td>
									</tr>
								</c:forEach>
							</tbody>		
						</table>
					</section>
						
					<section>
						<h1>
							현재 페이지 번호
						</h1>
						<p>1 of 3pages</p>
					</section>
						
					<nav id="pager">
						<h1 class="hidden">
							페이지
						</h1>
						<ul>
							<li><a href="">1</a></li> 
							<li><a href="">2</a></li>
							<li><a href="">3</a></li>
							<li><a href="">4</a></li>
							<li><a href="">5</a></li>
						</ul>
					</nav>	
					
					<section>
						<h1 class="hidden">
							공지사항 검색폼
						</h1>		
						<form>
							<legend class="hidden">공지사항검색</legend>
							<label class="hidden">검색필드</label>
								<select>
									<option>제목</option>
									<option>작성자</option>
								</select>
							<label class="hidden">검색어</label>
							<input type="text"/>
							<input type="submit" value="검색"/>
						</form>
					</section>	
			</section>	
		</main>
		
	</div>

</body>
</html>