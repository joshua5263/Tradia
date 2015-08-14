<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	
	#main input[type="text"]{
		font-size:40px;
		color:white;
		width:602px;
		height:74px;
		background: url("../resource/images/text_intro.png") no-repeat center;
		border: 0px;
	}
	
	#main input[type="password"]{
		font-size:40px;
		color:white;
		width:602px;
		height:74px;
		background: url("../resource/images/text_intro.png") no-repeat center;
		border: 0px;
	}
	
	#main input[type="submit"]{
		font-size:40px;
		color:white;
		width:279px;
		height:74px;
		background: url("../resource/images/btn_intro.png") no-repeat center;
		border: 0px;
		margin-left: 20px;
	}
	
	#main input[type="submit"]:hover{
		font-size:40px;
		color:white;
		width:279px;
		height:74px;
		background: url("../resource/images/btn_intro_mouseover.png") no-repeat center;
		border: 0px;
		margin-left: 20px;
	}
	
	#main input[type="button"]{
	
		font-size:40px;
		color:white;
		width:279px;
		height:74px;
		background: url("../resource/images/btn_intro.png") no-repeat center;
		border: 0px;
		margin-right: 20px;
	}
	
	#main input[type="button"]:hover{
	
		font-size:40px;
		color:white;
		width:279px;
		height:74px;
		background: url("../resource/images/btn_intro_mouseover.png") no-repeat center;
		border: 0px;
		margin-right: 20px;
	}
	
	.hidden{
		display: none;
	}
	
	#main img{
		margin-left: 220px;
		margin-right: 220px;
		margin-top: 40px;
		margin-bottom: 40px;
	}
</style>
</head>
<body id="bg">
	<main id="main">
		<section>
			<h1 class="hidden">Intro</h1>
			
			<img src ="../resource/images/logo_intro.png" alt="TRADIA"/>
		
		
			<form action="../join/join" method="post">
			<fieldset>
				
				<legend class="hidden">E-mail 입력</legend>
				<label class="hidden">ID입력</label> <input type="text" placeholder="ID입력" name="join-id" />
			<br/>			
				<legend class="hidden">비밀번호입력</legend>
				<label class="hidden">비밀번호</label> <input type="password" placeholder="비밀번호입력" name = "pw"/>
			<br/>			
				<legend class="hidden">비밀번호확인입력</legend>
				<label class="hidden">비밀번호</label> <input type="password" placeholder="비밀번호입력확인" name = "pw-check"/>
					
				<nav>
					<h1 class="hidden">버튼 목록</h1>
						<p>
							<a href="../intro/intro">								
									<legend class="hidden">취소버튼</legend>
									<label class="hidden">취소</label> <input type="button" value="취소하기" />
									
								</a>
							
								
									<legend class="hidden">회원가입버튼</legend>
									<label class="hidden">회원가입</label> <input type="submit" value="회원가입" />
									
							</a> 
						</p>
				</nav>
				</fieldset>
			</form>			
		</section>

	</main>	
</body>
</html>