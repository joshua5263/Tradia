<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
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

					<input type="text" placeholder="다녀온 여행지를 검색하세요" style="font-family: 서울남산체 EB; font-size: 16px;" name="areaQuery"  /> 

					<input class="button" type="submit" value="검색" />
			</fieldset>
		</form>
	</section>
	
	<section>
		<c:forEach var="n" items="${List}">
			<ul>
				<li>장소명 ${n.name}</li>
				<li>주소 ${n.firstAdd} ${n.lastAdd}</li>
			</ul>
		
		</c:forEach>
	
	</section>
	
</body>
</html>