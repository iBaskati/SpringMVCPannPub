<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="models.Offer"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%@ include file="header.jsp" %>
	<h1>Offer</h1>
	<%
		Offer offer = (Offer) request.getAttribute("offer");
		if (offer == null) {
			out.println("<span> <h4> No Such offer ! </h4></span>");
		} else {
			out.println("<span> <h4>  " + offer.toString() + " </h4> </span> <p>");
			out.println("<a href='requestReservation?ID="+offer.getId()+"'> Make a reservation  </a>");
		}
	%>
	
	
</body>
</html>