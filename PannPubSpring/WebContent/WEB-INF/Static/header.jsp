<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%@ page import="models.ClientView" %>
	<%
		try {
			ClientView client = (ClientView) session.getAttribute("client");
			
			if(client != null ){
				out.println("<ul>");
				
				out.println("<li>");
				out.println("<h4> WLC "+ client.getName() + "</h4> ");
				out.println("</li>");
				
				out.println("<li>");
				out.println("<p> <a href='addOffer'> Add Offer </a>");
				out.println("</li>");
				
				out.println("<li>");
				out.println("<p> <a href='offers'> All Offers </a>");
				out.println("</li>");
				
				out.println("<li>");
				out.println("<p> <a href='myOffers'> My Offers </a>");
				out.println("</li>");
				
				out.println("<li>");
				out.println("<p> <a href='offersFilters'> Search Offer </a>");
				out.println("</li>");
				
				out.println("<li>");
				out.println("<p> <a href='logOut'> Logout </a>");
				out.println("</li>");
				
				out.println("</ul>");
			}
			else{
				throw new Exception();
			}
		} 
		catch (Exception e) {
			out.println("<ul>");
			
			out.println("<li>");
			out.println("<a href='signIn' > Sign In </a>");
			out.println("</li>");
			
			out.println("<li>");
			out.println("<p> <a href='signUp' > Sign Up </a>");
			out.println("</li>");
			
			out.println("</ul>");
		}
	%>
</body>
</html>