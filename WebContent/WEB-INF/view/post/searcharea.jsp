<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

window.addEventListener("load", function(){
	
	btnArea = [];
	
	for(var i = 0, j=0; i<document.getElementById("area").getElementsByTagName("ul").length; i++){

		btnArea[j++] = document.getElementById("area").getElementsByTagName("ul")[i];
		
	}
	
	btnArea[0].onclick = function(){
		
		var li = btnArea[0].getElementsByTagName("li")[1].innerHTML;
		alert(li);
		opener.document.getElementById("course-area").value = li;
	};	
	
});
	
	
</script>

<style>
	#area-name:HOVER {
	background: red;
	}
	body{
		background: url("../resource/images/add-area-bg.png") no-repeat center;
	}

</style>

</head>
<body>
	<section>
		<h1 class="hidden">여행기 검색 폼</h1>
		<form id="" action="../addarea/searcharea" method="post">
			<fieldset>
				<legend class="hidden">통합검색</legend>
				<label class="hidden">검색</label> 

					<input type="text" placeholder="가고싶은 여행지를 검색하세요" style="font-family: 서울남산체 EB; font-size: 16px;" name="areaQuery"  /> 

					<input class="button" type="submit" value="검색" />
			</fieldset>
		</form>
	</section>
	
	<section id="area">		
		
				<c:forEach var="n" items="${List}" >
					<ul id="area-specific">
						<fieldset>
							<li>장소명</li>
							<li id="area-name" >${n.name}</li>
							<li>주소</li>
							<li>${n.firstAdd} ${n.lastAdd}</li>
							<li></li>
						</fieldset>
					</ul>			
				</c:forEach>
		
		
		<a href="../addarea/createarea"><input id="give-area" type="button" value="장소추가하러가기" /></a>
		
	
	</section>
	
</body>
</html>