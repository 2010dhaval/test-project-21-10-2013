package com.cv.model;

import java.util.List;

public class JqGridHelper
{
	private static final int	RECORDS_PER_PAGE	= 10;
	private static final int	CURRENT_PAGE		= 1;

	/**
	 * To create a representation of JqGrid using the input data list
	 * @param gridDataList
	 * @return
	 */
	public static JqGridData createJqGridDataObject(@SuppressWarnings("rawtypes") List gridDataList)
	{
		int numOfPages = 1;
		JqGridData jqGridData = new JqGridData();
		int listSize = gridDataList.size();
		jqGridData.setRows(gridDataList);
		jqGridData.setRecords(String.valueOf(listSize));
		jqGridData.setPage(String.valueOf(CURRENT_PAGE));
		if (listSize > RECORDS_PER_PAGE)
		{
			numOfPages = listSize / RECORDS_PER_PAGE;
		}
		jqGridData.setTotal(String.valueOf(numOfPages));

		return jqGridData;
	}

	/**
	 * To create a representation of JqGrid using the input data list
	 * @param gridDataList
	 * @return
	 */
	public static JqGridData createJqGridDataObject(@SuppressWarnings("rawtypes") List gridDataList,GridDataVO gridDataVO)
	{
		int numOfPages = 1;
		JqGridData jqGridData = new JqGridData();
		jqGridData.setRows(gridDataList);
		int totalRecordCount = gridDataVO.getTotalRecordCount();
		int currentPageNum = gridDataVO.getCurrentPageNum();
		int rowsPerPage = gridDataVO.getRowsPerPage();
		jqGridData.setRecords(String.valueOf(totalRecordCount));
		jqGridData.setPage(String.valueOf(currentPageNum));
		if (totalRecordCount > rowsPerPage)
		{
			if (totalRecordCount % rowsPerPage == 0)
			{
				numOfPages = totalRecordCount / rowsPerPage;
			}
			else
			{
				numOfPages = totalRecordCount / rowsPerPage + 1;
			}
		}
		jqGridData.setTotal(String.valueOf(numOfPages));

		return jqGridData;
	}
}
