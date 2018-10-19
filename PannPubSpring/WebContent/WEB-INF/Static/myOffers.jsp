<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList , models.Offer"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%@ include file="header.jsp" %>
	<h1>My Offers</h1>
	<%
		ArrayList<Offer> myOffers = (ArrayList<Offer>) request.getAttribute("myOffers");
		if(myOffers.isEmpty()){
			out.println("<span> <h4> No offer ! </h4></span>");
		}
		else{
			for(Offer offer : myOffers){
				out.println("<div>");
				out.println("<h4> Type : "+offer.getType()+" </h4>");
				out.println("<h4> Price : "+offer.getPrice()+" </h4>");
				out.println("<h5> Adress :  "+offer.getAdress()+" </h5>");
				out.println("<a href='showOffer?ID="+offer.getId()+"'> Show more </a> <p>");
				out.println("</div>");
			}
		}

	%>
</body>
</html>