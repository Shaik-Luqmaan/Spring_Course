<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>

<title> Student Registration Form </title>

<style>
	.error{color:red}
</style>

</head>

<body>
	<i>* is Required</i>
	<!-- modelAttribute should match model name in controller -->
	<form:form action="processForm" modelAttribute="student"> 
	
		First Name : <form:input path="firstName"/> <!-- Property of Student class, getFirstName() -->
		<br>
		Last Name (*) : <form:input path="lastName"/>
			<form:errors path="lastName" cssClass="error"/>
		
		<br><br>
		Roll Number (*) : <form:input path="rollNumber"/>
			<form:errors path="rollNumber" cssClass="error"/>
			
		<br><br>
		Course Code : <form:input path="courseCode"/>
			<form:errors path="courseCode" cssClass="error"/>	
			
			<br><br>
		Postal Code: <form:input path="postalCode"/>
			<form:errors path="postalCode" cssClass="error"/>	
		
		<br><br>
		Country:
		<form:select path="country">
			<form:options items	="${student.countryOptions}"/>
			
		</form:select>
		<br><br>
		
		Java<form:radiobutton path="favouriteLanguage" value="Java"/>
		JS<form:radiobutton path="favouriteLanguage" value="JS"/>
		React<form:radiobutton path="favouriteLanguage" value="React"/>
		NodeJS<form:radiobutton path="favouriteLanguage" value="NodeJS"/>
		<br><br>
		
		Operating System:
		
		Windows<form:checkbox path="operatingSystem" value="Windows"/>
		Linux<form:checkbox path="operatingSystem" value="Linux"/>
		MacOS<form:checkbox path="operatingSystem" value="MacOS"/>
	
		<br><br>
		<input type = "submit" value="Submit"/>	
	
	</form:form>

</body>

</html>