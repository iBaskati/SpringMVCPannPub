<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%@ include file="header.jsp" %>
	<!--start main Form -->
	<form:form method="POST" action="addOfferService" enctype="multipart/form-data" >

		<h1>Add Offer</h1>

		<h4>${formAddOfferErrors.errorAdress}</h4>
		<form:label path="adress">Adress :</form:label>
		<form:input type="text" path="adress" required="true" />
		
		<h4>${formAddOfferErrors.errorType}</h4>
		<form:label path="type">Type :</form:label>
		<form:select path="type" required="true">
			<option>4x3 A</option>
			<option>4x3 B</option>
			<option>Led</option>
		</form:select>
		
		<h4>${formAddOfferErrors.errorHeight}</h4>
		<form:label path="height">Height :</form:label>
		<form:input type="number" path="height" required="true" />
		
		<h4>${formAddOfferErrors.errorWidth}</h4>
		<form:label path="width">Width :</form:label>
		<form:input type="number" path="width" required="true" />

		<h4>${formAddOfferErrors.errorImage}</h4>
		<form:label path="imageString">Image :</form:label>
		<form:input path="imageString" type="file" required="true" />

		<h4>${formAddOfferErrors.errorDescription}</h4>
		<form:label path="description">Description :</form:label>
		<form:textarea type="text" path="description" required="true" />
		
		<h4>${formAddOfferErrors.errorPrice}</h4>
		<form:label path="price">Price (DH) :</form:label>
		<form:input type="number" path="price" required="true" />
		
		<input type="submit" name="AddOffer" value="Add Offer">

	</form:form>
	<!-- end main form  -->
	
</body>
</html>