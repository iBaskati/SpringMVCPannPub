<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%@ include file="header.jsp" %>
	<h1>Search Offers By </h1>
	<label for="type">Type :</label>
	<select name="type" id="type" onchange="search()">
		<option>4x3 A</option>
		<option>4x3 B</option>
		<option>Led</option>
	</select>

	
	<!-- 	<p>
	<label for="city">City :</label>
	<input type="text" name="city"/> -->
	
	<p>
	<label for="price">Price :</label>
	<input type="range" id="price" name="price" min="0" max="10000"
		step="10" Value=10000 onchange="search()" />
	
	<div id="result"> Result </div>
	
	
	
	
</body>

	<script  type ="text/javascript">
		function search() {
			if (window.XMLHttpRequest) {
				// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp = new XMLHttpRequest();
			} else {
				// code for IE6, IE5
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					document.getElementById("result").innerHTML = this.responseText;
				}
			};
			var price = document.getElementById("price").value;
			var type = document.getElementById("type").value;
			xmlhttp.open("GET", "offersFiltersService?type="+type+"&price="+price,true);
			xmlhttp.send();
	
		}
		
		
		/* window.onload = function() {
			search();
		}; */
		
	</script>
	
	
</html>