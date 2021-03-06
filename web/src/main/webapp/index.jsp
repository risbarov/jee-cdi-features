<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>JEE CDI Features</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/simple">Simple injection</a>
	<br/>

	<a href="${pageContext.request.contextPath}/named">Named injection</a>
	<br/>

	<a href="${pageContext.request.contextPath}/producers/methods">Producer method injection</a>
	<br/>

	<a href="${pageContext.request.contextPath}/producers/fields">Producer field injection</a>
	<br/>

	<a href="${pageContext.request.contextPath}/binding">Annotation field value based binding injection</a>
	<br/>

	<a href="${pageContext.request.contextPath}/context">Context injection</a>
	<br/>

	<a href="${pageContext.request.contextPath}/events">Events</a>
	<br/>
</body>
</html>
