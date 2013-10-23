<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Recognition</title>


<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />
<script>
	$(function() {
		//$.datepicker.formatDate('yy-mm-dd');
		$("#stDate").datepicker({
			dateFormat : 'yy-mm-dd'
		});
		$("#edDate").datepicker({
			dateFormat : 'yy-mm-dd'
		})
		
	});
</script>

</head>
<body>
	<fieldset>
		<legend>Recognition - ${recognitionVO.recId}</legend>
		<form:form method="POST" modelAttribute="recognitionVO">
			<table>
				<tr>
					<td><form:hidden path="recId" /></td>
				</tr>
				<tr>
					<td><form:label path="desc">Description:</form:label></td>
					<td><form:input path="desc" /></td>
				</tr>
				<tr>
					<td><form:label path="question">Question:</form:label></td>
					<td><form:input path="question" /></td>
				</tr>
				<tr>
					<td><form:label path="startDate">Start date:</form:label></td>
					<td><form:input path="startDate" id="stDate" /></td>
				</tr>

				<tr>
					<td><form:label path="endDate">End date:</form:label></td>
					<td><form:input path="endDate" id="edDate" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
	</fieldset>
</body>
</html>