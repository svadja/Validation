<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<form:form method="post" modelAttribute="testForm">
		<label>String</label>
		<form:input path="str" type="text" />

		<label>Integer Class</label>
		<form:input path="int_class" />

		<label>integer type</label>
		<form:input path="int_type" />
		
		<label>Email</label>
		<form:input path="email"/>
		
		<button type="submit">Send</button>
	</form:form>


</body>
</html>
