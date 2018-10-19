<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%@ include file="header.jsp" %>
	<form method="POST" action="requestReservationService" >
		
		
		<h4>${formRequestReservationErrors.errorFreePeriod}</h4>
		
		<h4>${formRequestReservationErrors.errorDateStart}</h4>
		<label for="dateStart">Date start of period :</label>
		<input id="dateStart" value="${dateStart}" name = "dateStart" type="text" required>
		
		<h4>${formRequestReservationErrors.errorDateEnd}</h4>
		<label for="dateEnd">Date end of period :</label>
		<input id="dateEnd" value="${dateEnd}" name ="dateEnd" type="text" required>
		
		
		<h4>${formRequestReservationErrors.errorRequestLetter}</h4>
		<label for="requestLetter" >Request Letter :</label>
		<textarea name="requestLetter" required> ${requestLetter} </textarea>
		
		
		/// hide this input 
		<input id="ID" value="${ID}" name ="ID" type="text"  required>
		
		<input type="submit" name="reservation" value="Send">
	</form>
</body>

<!---start-date-piker---->
<script src="JS/jquery.min.js"></script>
<link rel="stylesheet" href="CSS/jquery-ui.css" />
<script src="JS/jquery-ui.js"></script>
<script>
	$(function() {
		$( "#dateStart,#dateEnd" ).datepicker();
	});
</script>
<!---/End-date-piker---->


</html>