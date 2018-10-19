<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
<head>
</head>
<body>

	<%@ include file="header.jsp" %>

	<!--start main -->
	<form:form method="POST" action="signInService">
		<h1>Sign in</h1>
		<h4>${formSignInErrors.errorInvalidData}</h4>
		<h4>E-mail :</h4>
		<h4>${formSignInErrors.errorEmail}</h4>
		<form:input type="text" path="email" required="true" />
		<h4>Password :</h4>
		<h4>${formSignInErrors.errorPassword}</h4>
		<form:input type="password" path="password" required="true" />
		<input type="submit" value="Sign in" name="Login">
	</form:form>
	<!-- end main  form  -->

</body>
</html>