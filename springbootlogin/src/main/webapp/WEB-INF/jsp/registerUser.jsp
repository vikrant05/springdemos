<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<jsp:include page="menu.jsp" />
<body>
	<h3 style="color: red;">Enter Username and Password to Register</h3>

	<div id="login">
		<form:form action="/addUser" method="post"
			modelAttribute="user">
			<p>
                    <label>Username</label>
                    <form:input path="userName" />
                </p>
                <p>
                    <label>Password</label>
                    <form:input path="password" />
                </p>

                <input type="SUBMIT" value="Submit" />
		</form:form>
	</div>
</body>
</html>