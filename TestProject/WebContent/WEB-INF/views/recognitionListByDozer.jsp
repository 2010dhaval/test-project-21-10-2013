<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Recognition List</title>

<!-- Added by dhaval  start-->


<script type='text/javascript'>
	
	      
	$(window).load(
			function() {

				//var data = 

				$("#grid").jqGrid(
						{
							url : "getRecognitionListForGridByDozer.html",
							datatype : "json",
							//height: 250,
							height : 'auto',
							width : 'auto',
							pager : "#pagingDiv",
							//rowNum : 5,
							//rowList : [ 5, 10, 15, 20 ],
							viewrecords : true,
							sortorder : "desc",
							//rownumbers: true,
							sortname : 'recId',

							colNames : [ 'Recognition ID', 'Description',
									'Question', 'Start Date', 'End Date' ],
							colModel : [ {
								name : 'recId',
								index : 'recId',
								width : 100,
								formatter:abc,
								//formatoptions:{baseLinkUrl:'editRecognition.html',idName:cellValue}
							//sorttype: "int"
							}, {
								name : 'desc',
								index : 'desc',
								width : 100
							//sorttype: "date"
							}, {
								name : 'question',
								index : 'question',
								width : 100
							}, {
								name : 'startDate',
								index : 'startDate',
								width : 100
							//sorttype: "float"
							}, {
								name : 'endDate',
								index : 'endDate',
								width : 100
							//sorttype: "float"
							} ],
							caption : "Recognition List",
						// ondblClickRow: function(rowid,iRow,iCol,e){alert('double clicked');}
							
						});
				function abc(cellvalu,s,sw){
					return "<a href='editRecognitionByDozer.html?recId="+cellvalu+"' >"+cellvalu+"</a>";
				}
				jQuery('#cb_grid').attr('disabled', true);
			
		
			
			});
	
</script>
</head>
<body>
Time To add Rec(Post Method) = ${param.timeDiff}  
<br />


	<table id="grid"></table>
	<div id="pagingDiv"></div>
	<%-- 
	<c:if test="${!empty recognitionVOList}">
		<table align="left" border="1">
			<tr>
				<th>ID</th>
				<th>Description</th>
				<th>Question</th>
				<th>Start dt</th>
				<th>End dt</th>
			</tr>

			<c:forEach items="${recognitionVOList}" var="items">
				<tr>
					<td><c:out value="${items.recId}" /></td>
					<td><c:out value="${items.desc}" /></td>
					<td><c:out value="${items.question}" /></td>
					<td><c:out value="${items.startDate}" /></td>
					<td><c:out value="${items.endDate}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
 --%>
</body>
</html>