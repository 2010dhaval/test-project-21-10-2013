<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type='text/javascript'>//<![CDATA[
   $(window).load(function(){
    
    //var data = 
     
    $("#grid").jqGrid({
    	url: "getConditionListForGrid.html",
        datatype: "json",
        //height: 250,
        height: 'auto',
		width: 300,
        pager: "#pagingDiv",
        rowNum:20,
        rowList:[5,10,15,20],
        //rownumbers: true,
        //sortname: 'id',
        //colNames: ['Inv No', 'Thingy', 'Blank', 'Number', 'Status'],
        colNames: ['Condition ID', 'Condition'],
        colModel: [{
            name: 'conditionId',
            index: 'conditionId',
            width: 100
          //sorttype: "int"
            },
        {
            name: 'condition',
            index: 'condition',
            width: 100
            //sorttype: "date"
            }
        ],
        caption: "Condition List",
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
<table id="grid"></table>
<div id="pagingDiv"></div>
<%-- <c:if test="${!empty conditionList}"> --%>
<!-- 		<table align="left" border="1"> -->
<!-- 			<tr> -->
<!-- 				<th>ID</th> -->
<!-- 				<th>Description</th> -->
				
<!-- 			</tr> -->

<%-- 			<c:forEach items="${conditionList}" var="items"> --%>
<!-- 				<tr> -->
<%-- 					<td><c:out value="${items.conditionId}" /></td> --%>
<%-- 					<td><c:out value="${items.condition}" /></td> --%>
				
<!-- 				</tr> -->
<%-- 			</c:forEach> --%>
<!-- 		</table> -->
<%-- 	</c:if> --%>
</body>
</html>