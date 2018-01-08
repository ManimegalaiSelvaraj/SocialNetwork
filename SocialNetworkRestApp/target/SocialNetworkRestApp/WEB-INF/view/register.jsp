<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    

<html>
<body>
<form:form action="register" method="post" commandName="register">
Password<br>
<form:input type="text" path="password"></form:input>
Email<br>
<form:input type="text" path="emailId"></form:input>
<form:button type="submit" class="btn btn-primary btn-lg btn-block login-button">Register</form:button>
</form:form>
</body>
</html>