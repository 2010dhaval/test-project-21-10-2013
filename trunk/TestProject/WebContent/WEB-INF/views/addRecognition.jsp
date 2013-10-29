<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Recognition</title>



</head>
<body>
	<fieldset>
		<legend>Recognition - ${recognitionVO.recId}</legend>
		<form:form method="POST" modelAttribute="recognitionVO">
			<table>
				<tr>
					<td><form:hidden path="recId" id="recId123" /></td>
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
				<a
					onclick="window.open('addConditionLink.html?recId=${recognitionVO.recId}',
				 'Continue_to_Application','width=700,height=700')"
					href="#"> Add</a>

				<table id="grid"></table>
				<div id="pagingDiv"></div>
			</fieldset>
			<br />
			<br />
			<input type="submit" value="Submit" />
		</form:form>
	</fieldset>


	<script>
		var recId = document.getElementById("recId123").value;

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
								url : "getConditionLinkListForGrid.html?recId="
										+ recId,
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

								colNames : [ 'Condition Link ID', 'rank',
										'Rec Id', 'Con Id', 'Condition' ],
								colModel : [ {
									name : 'conditionLinkId',
									index : 'conditionLinkId',
									width : 100

								}, {
									name : 'rank',
									index : 'rank',
									width : 100

								}, {
									name : 'recognition.recId',
									index : 'recognition.recId',
									width : 100
								}, {
									name : 'condition.conditionId',
									index : 'condition.conditionId',

									width : 100

								}, {
									name : 'condition.condition',
									index : 'condition.condition',
									width : 100

								} ],
								caption : "Condition Link List",

							});

				});
	</script>

</body>
</html>