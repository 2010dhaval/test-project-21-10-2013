package com.cv.model;


public class GridDataVO
{
	// Current page of the query
	private int	currentPageNum;

	// Rows to be displayed per page
	private int rowsPerPage;

	// Total number of records for the query
	private int	totalRecordCount;
	
	// Column on which data is to be sorted
	private String sortCol;
	
	// Sort order
	private String sortOrder;

	public GridDataVO()
	{
	}

	public int getCurrentPageNum()
	{
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum)
	{
		this.currentPageNum = currentPageNum;
	}

	public int getRowsPerPage()
	{
		return rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage)
	{
		this.rowsPerPage = rowsPerPage;
	}

	public int getTotalRecordCount()
	{
		return totalRecordCount;
	}

	public void setTotalRecordCount(int totalRecordCount)
	{
		this.totalRecordCount = totalRecordCount;
	}
	
	public int getFirstRecordNum() {
		return ((currentPageNum-1) * rowsPerPage);
	}

	public String getSortCol()
	{
		return sortCol;
	}

	public void setSortCol(String sortCol)
	{
		this.sortCol = sortCol;
	}

	public String getSortOrder()
	{
		return sortOrder;
	}

	public void setSortOrder(String sortOrder)
	{
		this.sortOrder = sortOrder;
	}
}
