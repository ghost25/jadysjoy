<%@ page contentType="text/html;charset=ISO-8859-1" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>Insert title here</title>
</head>
<body>
	  <tr class="prop">
	<td valign="top" class="name">
	<g:message code="user.id.label" default="Id" />
	</td>
	<td valign="top" class="value">
	${fieldValue(bean: userInstance, field: "id")}
	</td>
	</tr>
	<tr class="prop">
	<td valign="top" class="name">
	<g:message code="user.login.label" default="Login" />
	</td>
	<td valign="top" class="value">
	${fieldValue(bean: userInstance, field: "login")}
	</td>
</tr>
</body>
</html>