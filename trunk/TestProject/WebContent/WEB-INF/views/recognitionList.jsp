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

<script type='text/javascript'
	src='http://code.jquery.com/jquery-1.6.2.js'></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/themes/base/jquery-ui.css">
<link rel="stylesheet" type="text/css"
	href="http://trirand.com/blog/jqgrid/themes/ui.jqgrid.css">
<script type='text/javascript'
	src="http://trirand.com/blog/jqgrid/js/i18n/grid.locale-en.js"></script>
<script type='text/javascript' src="js/jquery.jqGrid.min.js"></script>
<script type='text/javascript'>//<![CDATA[
   $(window).load(function(){
    
    //var data = 
     
    $("#grid").jqGrid({
    	url: "getRecognitionListForGrid.html",
        datatype: "json",
        //height: 250,
        height: 'auto',
		width: 'auto',
        pager: "#pagingDiv",
        rowNum:20,
        rowList:[5,10,15,20],
        //rownumbers: true,
        //sortname: 'id',
        //colNames: ['Inv No', 'Thingy', 'Blank', 'Number', 'Status'],
        colNames: ['Recognition ID', 'Description', 'Question', 'Start Date', 'End Date'],
        colModel: [{
            name: 'recId',
            index: 'recId',
            width: 100
            //sorttype: "int"
            },
        {
            name: 'desc',
            index: 'desc',
            width: 100
            //sorttype: "date"
            },
        {
            name: 'question',
            index: 'question',
            width: 100},
        {
            name: 'startDate',
            index: 'startDate',
            width: 100
            //sorttype: "float"
            },
        {
            name: 'endDate',
            index: 'endDate',
            width: 100
            //sorttype: "float"
            }
        ],
        caption: "Recognition List",
        // ondblClickRow: function(rowid,iRow,iCol,e){alert('double clicked');}
    });
     
    /* var names = ["id", "name", "age", "salary", "address"];
    var mydata = [];
    //alert(data.length);
    for (var i = 0; i < data.length; i++) {
        mydata[i] = {};
        //alert(data[0][0]);
        for (var j = 0; j < data[i].length; j++) {
        	//alert("test "+data[i][j]);
            mydata[i][names[j]] = data[i][j];
        }
    } */
    
    //for (var i = 0; i <= mydata.length; i++) {
        //$("#grid").jqGrid('addRowData', i + 1, mydata[i]);
    //}
    
    /*
    $("#grid").jqGrid('setGridParam', {onSelectRow: function(rowid,iRow,iCol,e){alert('row clicked');}});
    */
    //$("#grid").jqGrid('setGridParam', {ondblClickRow: function(rowid,iRow,iCol,e){alert('double clicked');}});
     
   });//]]>
  </script>
</head>
<body>
${param.msg}
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