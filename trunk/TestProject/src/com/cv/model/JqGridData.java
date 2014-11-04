package com.cv.model;

import java.util.List;

public class JqGridData
{
	/**
	 * Total pages for the query
	 */
	private String					total;
	/**
	 * Current page of the query
	 */
	private String					page;

	/**
	 * Total number of records for the query
	 */
	private String					records;
	/**
	 * An array that contains the actual data
	 */
	private List					rows;
	/**
	 * User data to be passed to the grid
	 */
	private JqGridUserDataVO	userdata;

	public JqGridData()
	{
	}

	public String getPage()
	{
		return page;
	}

	public void setPage(String page)
	{
		this.page = page;
	}

	public String getTotal()
	{
		return total;
	}

	public void setTotal(String total)
	{
		this.total = total;
	}

	public String getRecords()
	{
		return records;
	}

	public void setRecords(String records)
	{
		this.records = records;
	}

	public JqGridUserDataVO getUserdata()
	{
		return userdata;
	}

	public void setUserdata(JqGridUserDataVO userdata)
	{
		this.userdata = userdata;
	}

	public List getRows()
	{
		return rows;
	}

	public void setRows(List rows)
	{
		this.rows = rows;
	}
}
