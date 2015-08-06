<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctxName" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="../resource/css/reset.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript" src="../resource/js/modernizr.js"></script>

<style>
	#bg{
		background: url("../resource/images/bg_intro.png") no-repeat center;
		
	}
	#main{
		font-size: 18px;
		font-family : SeoulNamsanEB;
		width: 700px;
		height: 700px;
		margin-top: 100px;
		margin-left: auto;
		margin-right: auto;
		background: url("../resource/images/bg_login.png") no-repeat center;
	}
	
	#main input{
		margin-left: 50px;
		margin-top: 30px;
		margin-bottom:30px;
	}
	
	.button:hover{
		cursor: pointer;
	}
	
	.text-area{
		font-size:40px;
		color:white;
		width:602px;
		height:74px;
		background: url("../resource/images/text_intro.png") no-repeat center;
		border: 0px;
	}
	
	.green-button{
		font-size:40px;
		color:white;
		width:279px;
		height:74px;
		background: url("../resource/images/btn_intro.png") no-repeat center;
		border: 0px;
		margin-left: 20px;
	}
	
	.green-button:hover{
		background: url("../resource/images/btn_intro_mouseover.png") no-repeat center;
	}	
	
	.hidden{
		display: none;
	}
	
	#main img{
		margin-left: 220px;
		margin-right: 220px;
		margin-top: 90px;
		margin-bottom: 90px;
	}

</style>

</head>
<body id="bg">
	<main id="main">
		<section>
			<h1  class="hidden">Intro</h1>
			
			<img src ="../resource/images/logo_intro.png" alt="TRADIA"/>
		
		
			<form action="${ctxName}/j_spring_security_check" method="post">
			<fieldset>
				<legend class="hidden">E-mail 입력</legend>
				<label class="hidden">ID입력</label> <input class="text-area" type="text" name="j_username" />
			<br/>
				<legend class="hidden">비밀번호입력</legend>
				<label class="hidden">비밀번호</label> <input class="text-area" type="password" name ="j_password"/>
					
			<nav>
				<h1  class="hidden">버튼 목록</h1>
				<p>
											
							<legend class="hidden">회원가입버튼</legend>
							<label class="hidden">회원가입</label> 
							<a href="../join/join">
								<input class="button green-button" type="button" value="회원가입"  />
							</a> 
						
							<legend class="hidden">로그인버튼</legend>
							<label class="hidden">로그인</label> <input class="button green-button" type="submit" value="로그인" />
						
					</p>
				</nav>
				</fieldset>
			</form>			
		</section>

	</main>	
</body>
</html>