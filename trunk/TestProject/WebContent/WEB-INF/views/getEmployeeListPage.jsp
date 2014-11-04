<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
<script>
var projListCurrentPage=1;
jQuery(document).ready(	function() {
	// 1st part
		jQuery("#gridEmployee").jqGrid(
			{
				url : "getEmployeeList.html",
				datatype : "json",
				loadonce : true,
				height : '340',
				autowidth : true,
				rowNum : 10,
				headertitles: true,
				rowList : [ 10, 20, 30, 40, 50 ],
				viewrecords : true,
				sortname : "empName",
				pager : "#pagingDivEmployee",
				caption : "Employee List",
				jsonReader : {
					root : "rows",
					page : "page",
					total : "total",
					records : "records",
					repeatitems : false,
					cell : "cell",
					id : "id"
				},
				colNames : [ 'Employee ID', 'Name', 'Age', 'Salary','Address','Gender' ],
				colModel : [ {
					name : 'empID',
					index : 'empID',
					width : 100
				
				}, {
					name : 'empName',
					index : 'empName',
					width : 100
				
				},
				{
					name : 'empAge',
					index : 'empAge',
					width : 100
				
				},
				{
					name : 'salary',
					index : 'salary',
					width : 100
				
				},
				{
					name : 'address',
					index : 'address',
					width : 100
				
				},
				{
					name : 'gender',
					index : 'gender',
					width : 100
				
				}],
				//loadComplete : initGrid,
				onPaging: function (pgButton) {
					handlePaging(pgButton, "gridEmployee");
			    },
				resizeStop : function() {
					saveGridParameters("gridEmployee",false,true);
				}
			});
// 2nd part	
		jQuery("#gridEmployee").jqGrid('navGrid', '#pagingDivEmployee',
				{
					add : false,
					edit : false,
					del : false,
					search : false,
					refresh : true,
					beforeRefresh : function() {				
						//Added for VPKBE-1114
						projListCurrentPage = $("#gridEmployee").getGridParam('pagingDivEmployee'); 
						
						$("#gridEmployee").setGridParam({
							datatype : 'json'
							//page : 1
						}).trigger('reloadGrid');
					}
				});
		// 3rd part			
		jQuery("#gridEmployee").jqGrid('navButtonAdd','#pagingDivEmployee',{
		    caption: "",
		    title: "Reorder Columns",
		    onClickButton : function() {
		    	jQuery("#gridEmployee").jqGrid('columnChooser',{modal: true});
		    }
		});
		
		// add custom button to export the data to excel
		jQuery("#gridEmployee").jqGrid('navButtonAdd',"#pagingDivEmployee",{
	       caption:"", 
		    buttonicon :'ui-icon-transferthick-e-w',
	       title: "Export to CSV",
	       onClickButton : function () {
	    	   var exclColList = new Array();	
	    	   exclColList.push('empID');
	    	   exclColList.push('empName');
	    	   exclColList.push('empAge');
	    	   exclColList.push('salary');
	    	   exclColList.push('gender');
	    	   exportToExcel("EMPLOYEELIST", $(this), exclColList, false);
	       }
		});
		
		
		
		
		
		
		
// new js Start
		function handlePaging(pgButton, gridId) {
			// if user has entered page number
		    if ("user" == pgButton) {
		    	// find out the requested and last page
		      	var requestedPage = $("#"+gridId).getGridParam("page");
		      	var lastPage = $("#"+gridId).getGridParam("lastpage");
		      	// if the requested page is higher than the last page value
		      	if (eval(requestedPage) > eval(lastPage)) {
		        	// set the requested page to the last page value
		        	$("#"+gridId).setGridParam({page: lastPage});
		      	}
		      	// otherwise, if the number of records per page has changed
			} else if ("records" == pgButton) {
		    	// find out the requested page, totolal number of rows, and rows per page
		       	var requestedPage = $("#"+gridId).getGridParam("page");
		       	var totalRows = $("#"+gridId).getGridParam("records");
		       	var rowsPerPage = $("#"+gridId).getGridParam("rowNum");
		       	// calculate what last page SHOULD be
		       	var lastPage = Math.ceil(eval(totalRows) / eval(rowsPerPage));
		       	// if the requested page is greater than what the last page should be
		       	if (eval(requestedPage) > lastPage) {
		      		// set the requested page to the last page value
		       		$("#"+gridId).setGridParam({page: lastPage});
		       	}
		    }
		}

		function updateGridPagerData(data, gridid) {
			var $this = $("#"+gridid);
			var gridobj = $("#"+gridid)[0];
			
		    if ($this.jqGrid('getGridParam', 'datatype') === 'json') {
		        // because one use repeatitems: false option and uses no
		        // jsonmap in the colModel the setting of data parameter
		        // is very easy. We can set data parameter to data.rows:
		        //alert("json:rows="+data.rows+",page="+data.page+",records="+data.records);
		        $this.jqGrid('setGridParam', {
		        	//Changes done for VP-1040 : Select Columns on Session List isn't working
		        	//avoid to set data type as local, because we consider data type JSON to get grid information from cookie  
		            //datatype: 'local',
		            data: data.rows,
		            pageServer: data.page,
		            recordsServer: data.records,
		            lastpageServer: data.total
		        });

		        // because we changed the value of the data parameter
		        // we need update internal _index parameter:
		        gridobj.refreshIndex();
		        
		        if ($this.jqGrid('getGridParam', 'sortname') !== '') {
		            // we need reload grid only if we use sortname parameter,
		            // but the server return unsorted data
		            $this.trigger('reloadGrid');
		        }
		    } else {
		    	//alert("local:rows="+$this.jqGrid('getGridParam', 'lastpageServer')+",page="+$this.jqGrid('getGridParam', 'pageServer')+",records="+$this.jqGrid('getGridParam', 'recordsServer'));
		        $this.jqGrid('setGridParam', {
		            page: $this.jqGrid('getGridParam', 'pageServer'),
		            records: $this.jqGrid('getGridParam', 'recordsServer'),
		            lastpage: $this.jqGrid('getGridParam', 'lastpageServer')
		        });
		        gridobj.updatepager(false, true);
		    }
		}

		//Added for VPKBE-273 column width customization
		function saveGridWidthParameters(gridId){
			var cookieGridId = $("input."+gridId).val();
			if(typeof cookieGridId == "undefined"){
				cookieGridId = gridId;
			}
		    var gridWidthInfo = new Object();
		    var grid = $('#'+gridId);
		    createJqGridCookieDataObject(cookieGridId, grid);	
		    
		    var colModel = grid.jqGrid("getGridParam", "colModel");
		    var colsWidth = [];
		    
		    $.each(colModel, function(i) {
				colsWidth=colsWidth.concat(this.width);   	
			}); 
		    
		    gridWidthInfo.colsWidth = colsWidth;
		    $.cookie(cookieGridId+'_gridWidthInfo',JSON.stringify(gridWidthInfo),{path:'/vportal',expires: 365});
		}


		function saveGridParameters(gridId, pageSetter,colWidthFlag) { 
			var cookieGridId = $("input."+gridId).val();
			if(typeof cookieGridId == "undefined"){
				cookieGridId = gridId;
			}
			var gridInfo = new Object();
		    var gridColModelInfo = new Object();
		    var gridHideColModelInfo = new Object();
		    var gridWidthInfo = new Object();
		    var grid = $('#'+gridId);
		    createJqGridCookieDataObject(cookieGridId, grid);
		    //gridInfo.url = grid.jqGrid('getGridParam', 'url');
		    gridInfo.sortname = grid.jqGrid('getGridParam', 'sortname');
		    gridInfo.sortorder = grid.jqGrid('getGridParam', 'sortorder');
		    gridInfo.selrow = grid.jqGrid('getGridParam', 'selrow');
		    gridInfo.page = grid.jqGrid('getGridParam', 'page');
		    gridInfo.pager = grid.jqGrid('getGridParam', 'pager');
		    gridInfo.rowNum = grid.jqGrid('getGridParam', 'rowNum');
		    gridInfo.remapColumns =grid.jqGrid("getGridParam", "remapColumns");
		    var colModel = grid.jqGrid("getGridParam", "colModel");
		    var colNames = grid.jqGrid("getGridParam", "colNames");
		    var orderCols = grid.jqGrid("getGridParam", "remapColumns");
		    var colMap = {}, fixedCols = [],colsWidth = [],hideorderCols=[];
		    if(typeof(grid.jqGrid('getGridParam', 'hideCol')) == 'undefined' 
		    	|| grid.jqGrid('getGridParam', 'hideCol') == null)
		    {
		    	$.each(colModel, function(i) {
		        	colMap[this.name] = i;
		            if (this.hidden)
		            {
		            	if(this.name!="")
		            	{   
		            		fixedCols=fixedCols.concat(this.name);  
		            	}
		            }
		            //colsWidth=colsWidth.concat(this.width);
		         }); 
		        grid.jqGrid('setGridParam', { hideCol: fixedCols });
		    }
		    var width;
			$.each(colModel, function(i) {
				width = $("#" + gridId).parents(".ui-jqgrid-view").find(".ui-jqgrid-labels > th:eq("+i+")").css("width");
				width = width.slice(0,-2);
				colsWidth=colsWidth.concat(width);
			}); 
		   // grid.jqGrid('setGridParam', { remapColumns: colMap });
		    gridHideColModelInfo.hideCol = grid.jqGrid('getGridParam', 'hideCol');
		    replaceColumnName(gridHideColModelInfo.hideCol,cookieGridId);
		    gridInfo.remapColumns =grid.jqGrid('getGridParam', 'remapColumns');
		    //gridInfo.remapColumns = "";
		   // alert("colsWidth :-" + colsWidth);
		    gridWidthInfo.colsWidth = colsWidth;
		    var gridSettings = JSON.stringify(gridInfo);
		    var gridModelSettings = JSON.stringify(gridColModelInfo);    
		    $('#gridParams').val(gridSettings);
		    $('#gridParams').val(gridModelSettings);
		    if (gridModelSettings!=null) { 
		    	//alert("gridInfo="+JSON.stringify(gridInfo));
		    	//alert("gridColModelInfo="+JSON.stringify(gridColModelInfo));
		    	//alert("gridHideColModelInfo="+JSON.stringify(gridHideColModelInfo));
		    	//alert("in saveGridParameters"+gridId +'_gridInfo');
		    	$.cookie(cookieGridId+'_gridInfo',JSON.stringify(gridInfo),{path:'/vportal',expires: 365});
		    	//$.cookie(cookieGridId+'_gridColModel',JSON.stringify(gridColModelInfo),{path:'/'});
		    	var gridhideCol = JSON.parse($.cookie(cookieGridId +'_hidegridColModel'));
		    	if(colWidthFlag){
		    		$.cookie(cookieGridId+'_gridWidthInfo',JSON.stringify(gridWidthInfo),{path:'/vportal',expires: 365});
		    	}else if((pageSetter) && gridhideCol == null ){
		    		$.cookie(cookieGridId+'_hidegridColModel',JSON.stringify(gridHideColModelInfo),{path:'/vportal',expires: 365});
		    	}else if(!pageSetter){
		    		$.cookie(cookieGridId+'_hidegridColModel',JSON.stringify(gridHideColModelInfo),{path:'/vportal',expires: 365});
		    	}
		    }
		}

		//loads the jqgrids state from before save
		function loadGridParameters(gridId, gridParams) 
		{	
		    if (gridParams !=null && gridParams!="")
		    {                            
		        var gridInfo = $.parseJSON(gridParams);
		        
		        var grid = $('#'+gridId);                           

		        //grid.jqGrid('setGridParam', { url: gridInfo.url });
		        grid.jqGrid('setGridParam', { sortname: gridInfo.sortname });
		        grid.jqGrid('setGridParam', { sortorder: gridInfo.sortorder });
		        grid.jqGrid('setGridParam', { selrow: gridInfo.selrow });
		        grid.jqGrid('setGridParam', { page: gridInfo.page });
		        grid.jqGrid('setGridParam', { rowNum: gridInfo.rowNum });
		        //grid.jqGrid('setGridParam', { postData: gridInfo.postData });
		        grid.jqGrid('setGridParam', { search: gridInfo.search });
		        grid.jqGrid('setGridParam', { datatype : "local"});
		        gridParams = '';
		        $('#'+gridId).trigger('reloadGrid');                           
		    }                                               
		}

		function loadGridParametersFromCookie(gridId,datatype) 
		{
			//alert("gridId :-" + gridId + " 		|| 		datatype :-" + datatype);
			var cookieGridId = $("input."+gridId).val();
			var gridPager;
			if(typeof cookieGridId == "undefined"){
				cookieGridId = gridId;
			}
			var grid = $('#' + gridId);
			createJqGridCookieDataObject(cookieGridId, grid);
			var gridInfo = JSON.parse($.cookie(cookieGridId +'_gridInfo'));
			var gridWidthInfo = JSON.parse($.cookie(cookieGridId +'_gridWidthInfo'));
			var colsWidth;
			if(gridInfo!=null)
			{
				var currentPage = gridInfo.page, currentsortname = gridInfo.sortname, currentsortorder = gridInfo.sortorder, currentrowNum = gridInfo.rowNum;
				var currentreordercolmn = gridInfo.remapColumns;
				gridPager = gridInfo.pager;
			}
			var gridModel = JSON.parse($.cookie(cookieGridId +'_gridColModel'));
			if(gridModel!=null)
			{
				var currentselrow = gridModel.selrow;
			}
			var gridhideCol = JSON.parse($.cookie(cookieGridId +'_hidegridColModel'));
			if (gridInfo != null) {	
				if (datatype == 'json') {
					isCookieLoad = false;
					var totalRows = grid.getGridParam("records");
			       	var rowsPerPage = grid.getGridParam("rowNum");
			       	var isFirstPage = false;
			       	// calculate what last page SHOULD be
			       	var lastPage = Math.ceil(eval(totalRows) / eval(rowsPerPage));
			       	// start changes done for VPKBE-3480
			       	if(typeof activeTabId != "undefined"){
			       		if($("#"+activeTabId).find('#simpSearchForm').length > 0){
			       			isFirstPage = true;
			       		}
			    	}
			       	// changes done for VP-161
			       	var currentPageNo = 1;
		       		if($.cookie(gridId +'_gridPageNo') != null && $.cookie(gridId +'_gridPageNo') != 0)
					{
		       			currentPageNo = $.cookie(gridId +'_gridPageNo');
					}
			       	/*if(currentPageNo > lastPage || isFirstPage){
			       		//currentPage = 1;
			       		//currentGridPage = 1;
			       	}*/
		       		if(cookieGridId == 'gridSessionList' || cookieGridId == 'transactionGridList')
		        	{
		       			currentPageNo = 1;
		        	}
		       		else if(currentPageNo > lastPage || flagReloadOnSearch)
		        	{
			       		currentPageNo = 1;
			       	}
			       	// end changes done for VPKBE-3480
					setTimeout(
							function() {
								//jQuery(gridPager + '.ui-pg-selbox').val(currentrowNum).attr('selected', true);
								//gridPager.find(".ui-pg-selbox").val(currentrowNum);
								$(gridPager).find(".ui-pg-selbox").val(currentrowNum).attr('selected', true);
								grid.setGridParam({
									datatype : "local",
									//page : currentPage,
									page : currentPageNo,
									sortname : currentsortname,
									sortorder : currentsortorder,
									selrow : currentselrow,
									rowNum : currentrowNum,
									remapColumns : currentreordercolmn
								});
								grid.trigger("reloadGrid");
								/*grid.setGridParam({
									datatype : "json"
								});*/
							}, 50);
					
						//jQuery("#" + gridId).jqGrid("remapColumns", currentreordercolmn, true);

					if (gridhideCol != null) {
						replaceKeyByValue(gridhideCol,cookieGridId);
						var colNamesG = gridhideCol.hideCol;
						var colMap = {}, fixedCols = [];
						$.each(colNamesG, function(i) {
							jQuery("#" + gridId).hideCol(colNamesG);
							//jQuery("#"+gridId).sortData
						});
						var colModel = grid.jqGrid("getGridParam", "colModel");
						$.each(colModel, function(i) {
							if (this.hidden && !this.hidedlg)
							{
								if(!checkHiddenNameToShow(colNamesG , this.name)){
									jQuery("#" + gridId).showCol(this.name);
								}
							}
						 }); 
						//Start changes for VP-671 : Browse by Rec Group grid - cannot remove unwanted column
						if((cookieGridId == 'recognitionGridId' || cookieGridId == 'conditionLinkGridId')
							&& $("#"+activeTabId).find('#simpSearchForm').length == 0)
						{
							jQuery("#" + gridId).hideCol("deletedInTxt");
							jQuery("#" + gridId).hideCol("conActiveIn");
							jQuery("#" + gridId).hideCol("clDeletedInTxt");
			       		}
						//End changes for VP-671 : Browse by Rec Group grid - cannot remove unwanted column
					}
					//$.cookie(gridId +'_gridPageNo', null);
				}			
			}else{
				// changes done for VP-161
				$.cookie(gridId +'_gridPageNo', null);
				flagReloadOnSearch = false;
			}
			
			//Added for VPKBE-273 column width customization
			if(gridWidthInfo != null)
			{
				var colsWidth = gridWidthInfo.colsWidth;	
				var colModel = grid.jqGrid("getGridParam", "colModel");
				//alert("colsWidth"+colsWidth);
				$.each(colsWidth, function(i,width) {
					$("#" + gridId).parents(".ui-jqgrid-view").find(".ui-jqgrid-labels > th:eq("+i+")").css("width",width+"px");
					$("#" + gridId +" tr").find("td:eq("+i+")").each(function(){
						$(this).css('width',width+"px");
					});
					$.each(colModel, function(j) {
						if (j==i) {
							//this.width=width;
							$("#" + gridId).jqGrid('getGridParam','colModel')[j].width = parseInt(width); 
						}
					});
				});		
			}	
		}
		// Modified for VPKBE-3014  
		function exportToExcel(gridCode, gridId, excludedColumns, multiselect){
			var x=new Array();
		    x=$(gridId).getDataIDs();  // Get All IDs from Page 1
		    
		    // Capture excluded column indices
		    data=$(gridId).getRowData(x[0]);
		    var colIndexNames=new Array();
		    var ii=0;
		    if (multiselect!=null && multiselect) {
		    	colIndexNames[0]="";
		    	ii=1;
		    }
		    for (var i in data) {
		    	colIndexNames[ii++]=i; 
		    }
		    
		    var exclColIndx=new Array();
		    for(var j=0;j<colIndexNames.length;j++)
		    {
		    	if (j==0 && multiselect!=null && multiselect) {
		    		exclColIndx.push(j);
		    	}
		    	if ($.inArray(colIndexNames[j],excludedColumns)!=-1) {
		    		exclColIndx.push(j);
		    	}
		    }
		    
		    // Capture Col Names
		    var colNames = $(gridId)[0].p.colNames;
		    var html="";
		    for(var q=0;q<colNames.length;q++)
		    {
		    	if ((colNames[q]!="") && ($.inArray(q,exclColIndx)==-1)) {
		    		html=html+colNames[q]+"\t";     // output each Column as tab delimited
		    	}
		    }
		    html=html+"\n";                    // Output header with end of line
		    
		    // Do not change the name of the below variable 'z' as minification renames it to 'j' which is also
		    // used in the inner loop. Bug in minify exe!!
		    var z = $(gridId).jqGrid('getGridParam','data');
		    var str="";
		    var griddatalen = z.length;
		    // Capture Grid data
		    for(var i=0;i<griddatalen;i++)
		    {
		    	rowdata = z[i]; // get each row
		        for(var j=0;j<colIndexNames.length;j++)
		        {
		        	if (j==0 && multiselect!=null && multiselect) {
		        		continue;
		        	} else if ($.inArray(colIndexNames[j],excludedColumns)==-1) {
		        		var celldata = rowdata[colIndexNames[j]];        		
		        		if (celldata==="" || celldata==null || celldata=="undefined") {
		        			//celldata = " ";
		        			str=" ";
		        		}else{
		        			//changes done for defect -VPKBE-3014
		        			str=String(celldata);
		        			str=str.replace(/\n|\r|\r\n/g, "<br/>");
		        			str=str.replace(/\t|\r|\r\t/g, "");
		        		}
		        		html=html+str+"\t"; // output each Row as tab delimited
		        	}
		        }
		        html=html+"\n";  // output each row with end of line
		    }
		    html=html+"\n";  // end of line at the end
		    if(typeof activeTabId == "undefined"){
		    	$('#gridForm').find("#gridData").val(html);
		        $('#gridForm').find("#gridCode").val(gridCode);
		        $('#gridForm').attr('action','exportGridToExcel.html');
		        $('#gridForm').attr('method','POST');
		    	$('#gridForm').submit();
		    }else{
		    	$("#"+activeTabId).find('#gridForm').find("#gridData").val(html);
		        $("#"+activeTabId).find('#gridForm').find("#gridCode").val(gridCode);
		        $("#"+activeTabId).find('#gridForm').attr('action','exportGridToExcel.html');
		        $("#"+activeTabId).find('#gridForm').attr('method','POST');
		    	$("#"+activeTabId).find('#gridForm').submit();
		    }
		}

		// Encode HTML content
		function customHtmlEncode(cellval, opts, action) 
		{
		    if (cellval) 
		    {
		        return $.jgrid.htmlEncode(cellval + "");
		    };
		    return "";
		}

		/**
		 * Added as part of FIX of JIRA# 2052.
		 * Created By	: Arpit Jariwala
		 * Created on	: 22-09-2014
		 * Description	: This funtion will check the boolean value for 'Y' and 'N' and will replace that to Yes or No respectively.
		 * @param cellval
		 * @param opts
		 * @param action
		 * @returns {String}
		 */
		function customBooleanValue(cellval, opts, action)
		{
			var returnValue = "";
			
			if( cellval == 'Y' )
				returnValue = "Yes";
			else if( cellval == 'N' )
				returnValue = "No";

			return returnValue;
		}

		function resizeGrid(gridId) {
			var containerDivId = $("#"+activeTabId).find("#gbox_"+gridId).parent().attr('id');
			
			// Get width of parent container
		    var width = $("#"+activeTabId).find("#"+containerDivId).attr('clientWidth');
		   
		    if (width == null || width < 1){
		        // For IE, revert to offsetWidth if necessary
		        width = $("#"+activeTabId).find("#"+containerDivId).attr('offsetWidth');
		    }
		    width = width - 2; // Fudge factor to prevent horizontal scrollbars
		    if (width > 0 &&
		        // Only resize if new width exceeds a minimal threshold
		        // Fixes IE issue with in-place resizing when mousing-over frame bars
		        Math.abs(width - $("#"+activeTabId).find("#"+gridId).width()) > 5)
		    {
		    	$("#"+activeTabId).find("#"+gridId).setGridWidth(width);
		    }
		}

		// This method is used to sort right panel of the 'Column Chooser' in jqGrid.
		function sortColumn()
		{
		    var $list = $('.available ul'); 
		    var $listLi = $('li',$list); 
		    $listLi.sort(function(a, b){ 
		        var keyA = $(a).text(); 
		        var keyB = $(b).text(); 
		        return (keyA > keyB) ? 1 : 0; 
		    }); 
		    $.each($listLi, function(index, row){ 
		        $list.append(row); 
		    }); 
		}

		// Replace grid name by grid header label. It is used to display in the filter criteria.
		function getDisplaySummaryQuery(gridId, gridSummaryQuery)
		{
			var colModel = $("#"+activeTabId).find("#"+gridId).jqGrid('getGridParam', "colModel");
			// Ignore the first element. It is not required
			for ( var i = 1; i < colModel.length; i++) 
			{
				var colName = colModel[i];
				
				// Ignore for hidden fields (where label is not provided.
				if (colName.label == '')
				{
					continue;
				}
				
				// Don't remove this SPACE.
				var colNameToSearch = colName.name + ' ';
				if (gridSummaryQuery.indexOf(colNameToSearch) != -1)
				{
					gridSummaryQuery = gridSummaryQuery.replace(colNameToSearch, colName.label + ' '); 
				}
			}
			
			return gridSummaryQuery;
		}

		// This method is used to set grid search filter criterias (JSON format) in cookie. 
		function setFilterCriteriaInCookie(jsonFilters)
		{
			// Set for Answer FAQ category Start
			var treeType = $("#"+activeTabId).find('#treeType').val();
			if (treeType=="MFC" || treeType=="SFC") 
			{
				// $.cookie(treeType + '_gridViewFilter', jsonFilters, { path: '/' });
				setCookie(treeType + '_gridViewFilter', jsonFilters);
			}
			// Set for Answer FAQ category End
			
			// Add other functioanlity below (if applicable)
		}

		function getKeyByValue(byValue,cookieGridId){
			returnKey = "";
			cookieGridColumn = jqgridCookieData.cookieGridId;
			$.each(cookieGridColumn, function(key, value) {
				if(value == byValue){
					returnKey = key;
				} 
			});
			return returnKey;
		}

		function getValueByKey(byKey,cookieGridId){
			var cookieGridColumn = jqgridCookieData.cookieGridId;
			return cookieGridColumn[byKey];
		}

		function replaceColumnName(hideCol,cookieGridId)
		{
			for(i = 0; i < hideCol.length; i++){
				value = getValueByKey(hideCol[i],cookieGridId);
				//if(value.length > 0){
					hideCol[i] = value;
				//}
			}
		}

		function replaceKeyByValue(gridhideCol,cookieGridId){
			for(i = 0; i < gridhideCol.hideCol.length; i++){
				key = getKeyByValue(gridhideCol.hideCol[i]);
				if(typeof key != "undefined" && key.length > 0){
					gridhideCol.hideCol[i] = key;
				}
			}
		}

		function createJqGridCookieDataObject(cookieGridId, grid){
			var colModel = grid.jqGrid("getGridParam", "colModel");
			var newMap = {};
			 $.each(colModel, function(i) {
				 newMap[this.index] = i;
			 });
			jqgridCookieData.cookieGridId = newMap;
		}

		function checkHiddenNameToShow(colNamesG , name){
			var flag = false;
			for(i = 0; i < colNamesG.length; i++){
				if(colNamesG[i] == name){
					flag = true;
				}
			}
			return flag;
		}
// new js End
});
</script>
</head>
<body>
	<table id="gridEmployee"></table>
	<div id="pagingDivEmployee"></div>
</body>
</html>