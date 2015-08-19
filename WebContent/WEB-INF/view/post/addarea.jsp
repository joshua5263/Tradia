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
		
		var area = document.querySelector("#area");
		area.onclick = function(event){
			
			if(event.target.nodeName == "LI"){
				//alert("target : " + event.target.innerText + ", currentTarget : " + event.currentTarget.nodeName);			
				
				var areaName = event.target.parentNode.querySelectorAll("li")[1].innerText;
				opener.document.getElementById("course-area").value = areaName;
				
				self.close();
			}
			
			else if(event.target.nodeName == "UL"){
				var areaNameUl = event.target.querySelectorAll("li")[1].innerText;
				opener.document.getElementById("course-area").value = areaNameUl;
			}
		};
		
		
	});

</script>

<style>
	body{
		background: url("../resource/images/add-area-bg.png");
	}
	.area-specific{
		border: 1px solid white;
	}
	
	.area-specific:HOVER{
		
		background-color: rgba( 255, 255, 255, 0.7 );
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

					<input type="text" placeholder="다녀온 여행지를 검색하세요" style="font-family: 서울남산체 EB; font-size: 16px;" name="areaQuery"  /> 

					<input class="button" type="submit" value="검색" />
			</fieldset>
		</form>
	</section>
	
	<section id="area">
		<c:forEach var="n" items="${List}">
			<ul class="area-specific">
				<li>장소명</li>
				<li id="area-name" >${n.name}</li>
				<li>주소</li>
				<li>${n.firstAdd} ${n.lastAdd}</li>
			</ul>
		
		</c:forEach>
	
	</section>
	
</body>
</html>