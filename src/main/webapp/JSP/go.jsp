<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>Input</title>
</head>
<body>
	<bean:message key="message.welcome"/>
	<html:form action="/calculate">
		x=<html:text property="x"/><br/>
		y=<html:text property="y"/><br/>
		<html:submit property="method" value="add" />
		<html:submit property="method" value="subtract" />
		<html:submit property="method" value="multiply" />
		<html:submit property="method" value="divide" /><br/>
		<html:reset value="reset" />
	</html:form>
</body>
</html>