<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%@ include file="header.jsp"%>
	<!--start main Form -->
	<form:form method="POST" onsubmit="myFunction()" action="signUpService">

		<h1>Sign Up</h1>

		<h4>${formSignUpErrors.errorName}</h4>
		<form:label path="name">Name :</form:label>
		<form:input type="text" path="name" required="true" />

		<h4>${formSignUpErrors.errorResponsable}</h4>
		<form:label path="responsable">Responsable :</form:label>
		<form:input type="text" path="responsable" required="true" />

		<h4>${formSignUpErrors.errorType}</h4>
		<form:label path="type">Type :</form:label>
		<form:select path="type" required="true">
			<option value="ANNC">ANNC</option>
			<option value="PROP">PROP</option>
		</form:select>

		<h4>${formSignUpErrors.errorEmail}</h4>
		<form:label path="email">Email :</form:label>
		<form:input type="text" path="email" required="true" />

		<h4>${formSignUpErrors.errorPassword}</h4>
		<form:label path="password">Password :</form:label>
		<form:input id="pass1" type="password" path="password" required="true" />
		<label>Confirmation :</label>
		<form:input id="pass2" path="passwordConf" type="password"
			required="true" />
		<input type="submit" name="signUp" value="Sign Up">

	</form:form>
	<!-- end main form  -->

</body>
	<!--script password check -->
	<script>
    function myFunction() {
        var pass1 = document.getElementById("pass1").value;
        var pass2 = document.getElementById("pass2").value;
        if (pass1 != pass2) {
            document.getElementById("pass1").style.borderColor = "#E34234";
            document.getElementById("pass2").style.borderColor = "#E34234";
			document.getElementById('demo2').innerHTML = 'Mots de passe incompatible' ;
			return false;
       }
        return true;
    };
	</script>
	<!--  end of script -->
</html>