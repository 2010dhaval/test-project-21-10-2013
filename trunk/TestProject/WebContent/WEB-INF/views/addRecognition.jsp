<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Recognition</title>


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

	$(window).load(
			function() {
				$("#grid").jqGrid(
						{
							url : "getRecognitionListForGrid.html",
							datatype : "json",
							height : 'auto',
							width : 'auto',
							pager : "#pagingDiv",
							rowNum : 5,
							rowList : [ 5, 10, 15, 20 ],
							viewrecords : true,
							sortorder : "desc",

							sortname : 'recId',
							multiselect : 'true',

							colNames : [ 'Recognition ID', 'Description',
									'Question', 'Start Date', 'End Date' ],
							colModel : [ {
								name : 'recId',
								index : 'recId',
								width : 100

							}, {
								name : 'desc',
								index : 'desc',
								width : 100

							}, {
								name : 'question',
								index : 'question',
								width : 100
							}, {
								name : 'startDate',
								index : 'startDate',
								width : 100

							}, {
								name : 'endDate',
								index : 'endDate',
								width : 100

							} ],
							caption : "Condition Link List",

						});

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

				</tr>
			</table>

			<br />
			<br />
			<fieldset>
				<legend>Answer</legend>
				<a href="#">Add</a>
			</fieldset>
			<br />
			<br />
			<br />
			<br />
			<fieldset>
				<legend>Condition</legend>
				<a href="#">Add</a>
			</fieldset>
			<br />
			<br />
			<input type="submit" value="Submit" />
		</form:form>
	</fieldset>
</body>
</html>