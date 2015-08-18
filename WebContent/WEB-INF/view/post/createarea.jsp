<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js">	
</script>

<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false">	
</script>

<script type="text/javascript">
window.addEventListener("load", function(){
	$(document).ready(function(){
		var lating = new google.maps.LatLng(37.5640, 126.9751);
		var myOption = {
				zoom : 12, center : lating, mapTypeId : google.maps.MapTypeId.ROADMAP
		}
		var map = new google.maps.Map(document.getElementById("map_canvas"), myOption);
		var marker = new google.maps.Marker({
			position : lating, map : map
		});
		
		var geocoder = new google.maps.Geocoder();
		
		google.maps.event.addListener(map, 'click', function(event){
			var location = event.latLng;
			geocoder.geocode({
				'latLng' : location
			},
			function(result, status){
				if(status == google.maps.GeocoderStatus.OK) {
					$('#address').html(result[0].formatted_address);
					$('#lat').html(result[0].geometry.location.lat());
					$('#lng').html(result[0].geometry.location.lng());					
				}
				else{
					alert("Geocoder failed due to: " + status);
				}
			});
			if(!marker){
				marker = new google.maps.Marker({
					position : location, map : map
				});
			}
			else{
				marker.setMap(null);
				marker = new google.maps.Marker({
					position : location, map : map
				});
			}
			map.setCenter(location);
		});
	});
	
	var createArea = document.getElementById("create-area")
	createArea.onclick = function(){
		
		var address = document.querySelector("#address");
		document.querySelector("#address-txt").value = address.innerText.slice(5);
		
		opener.document.getElementById("course-area").value = document.querySelector("#areaname").value;
		
		self.close();
	};
	
	
	
});
</script>

<style>
	#area-name:HOVER {
	background: red;
	}
	
	.hidden{
		display:none;
	}
	body{
		background: url("../resource/images/add-area-bg.png") no-repeat center;
	}
</style>

</head>
<body>
		<form action="../addarea/createarea" method="post">
			<section>
				<h1>장소명</h1>
				<input id="areaname" type="text" name="areaname" />
			</section>
			
			<section id="area">	
				<h1>관광지</h1>			
					<input type="radio" name="preferLocation" value="산" checked>산
					<input type="radio" name="preferLocation" value="바다">바다
					<input type="radio" name="preferLocation" value="공원">공원
					<input type="radio" name="preferLocation" value="테마파크">테마파크
					<input type="radio" name="preferLocation" value="유적지">유적지
					<input type="radio" name="preferLocation" value="랜드마크">랜드마크
					<input type="radio" name="preferLocation" value="고궁">고궁
					<input type="radio" name="preferLocation" value="계곡">계곡 
			</section>
			
			<section>
				<div id="map_canvas" style="width:460px; height: 380px;"></div>
				
			</section>
			<section>
				<div class="hidden" id="address" name="address"></div>
				<input class="hidden" id="address-txt" type="text" name="addressTxt" />
				
				<input id="create-area" type="submit" value="장소추가하기"/>
			</section>
		</form>
			
	
</body>
</html>