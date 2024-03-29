<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Condition</title>
</head>
<body>
	<fieldset>
		<legend>Condition - ${conditionVo.conditionId}</legend>
		<form:form method="POST" modelAttribute="conditionVo">
			<table>
				<tr>
					<td><form:hidden path="conditionId" /></td>
				</tr>
				<tr>
					<td><form:label path="condition">Condition:</form:label></td>
					<td><form:input path="condition" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
	</fieldset>
</body>
</html>