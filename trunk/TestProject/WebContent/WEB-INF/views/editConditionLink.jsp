<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Condition Link</title>
</head>
<body>
	<form:form method="Post" modelAttribute="conditionLinkVO">
		<fieldset>
			<legend>Condition Link ${conditionLinkVO.conditionLinkId}</legend>
<%-- 			<form:hidden path="conditionLinkId" /> --%>
			<label>Rank :</label>
			<form:input path="rank" />
			<br /> <br /> <label>Recognition id:</label>
			<form:input readonly="true" path="recognition.recId" />
			<form:hidden path="condition.conditionId" id="rec123" /> <br /> <br /> <br />
			<table id="grid"></table>
			<div id="pagingDiv"></div>
			<br /> <br /> <input type="submit" value="Submit" id="submit" />
		</fieldset>
	</form:form>
	<script type='text/javascript'>
		$(window)
				.load(
						function() {

							$("#grid")
									.jqGrid(
											{
												url : "getConditionListForGrid.html",
												datatype : "json",
												height : 'auto',
												width : 300,
												pager : "#pagingDiv",
												multiselect : 'true',
												beforeSelectRow : function(
														rowid, e) {
													jQuery("#grid").jqGrid(
															'resetSelection');

													return (true);
												},
												onSelectRow : function(
														conditionId) {
													var selRowIds = $("#grid")
															.jqGrid(
																	'getGridParam',
																	'selrow');
													var celValue = $("#grid")
															.jqGrid('getCell',
																	selRowIds,
																	'conditionId');
													document
															.getElementById("rec123").value = celValue;
													return (true);
												},

												rowNum : 20,
												rowList : [ 5, 10, 15, 20 ],

												colNames : [ 'Condition ID',
														'Condition' ],
												colModel : [

												{
													name : 'conditionId',
													index : 'conditionId',
													width : 100
												}, {
													name : 'condition',
													index : 'condition',
													width : 100
												} ],
												caption : "Condition List",

											});
							jQuery('#cb_grid').attr('disabled', true);
						});
	</script>
</body>
</html>