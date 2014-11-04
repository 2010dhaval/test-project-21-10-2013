//package com.cv.controller;
//
//import java.io.IOException;
//import java.io.StringWriter;
//import java.util.StringTokenizer;
//
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import jxl.format.CellFormat;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//
//import org.apache.commons.lang.StringEscapeUtils;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.cv.vportal.common.exception.VportalBaseException;
//import com.cv.vportal.common.logger.LogHelper;
//import com.cv.vportal.common.util.ExcelUtil;
//import com.cv.vportal.common.util.VPortalConstants;
//import com.cv.vportal.common.util.VPortalUtil;
//
//@Controller
//public class GridController
//{
//	/**
//	 * Logger for this class
//	 */
//	private static final LogHelper	logger	= LogHelper.getInstance(GridController.class);
//	
//	@Value("${cellvalue.value.cellId}")
//	String cellInfoId;
//
//	@RequestMapping(value = "exportGridToExcel.html", method = RequestMethod.POST)
//	public void exportGridToExcel(@RequestParam String gridData, @RequestParam String gridCode, @RequestParam(
//	                                                                                                          defaultValue = "") String projectName, HttpServletResponse response, HttpSession session)
//	{
//		if (logger.isDebugEnabled())
//		{
//			logger.debug("exportGridToExcel(String gridData=" + gridData + ", String gridCode=" + gridCode
//			             + ", HttpServletResponse response=" + response + ", HttpSession session=" + session + ") - start");
//		}
//
//		try
//		{
//			String projectNm = (String) session.getAttribute(VPortalConstants.SESSION_ARG_PROJECT_NM);
//
//			// For Task Dashboard grid (viewed outside tabs), project name will be sent by the UI
//			if (!"".equals(projectName))
//			{
//				projectNm = projectName;
//			}
//
//			response.setContentType("Application/csv; charset=windows-1252");
//			response.setHeader(	"Content-Disposition",
//			                   	"attachment; filename=" + VPortalUtil.getGridExcelFileName(gridCode, projectNm) + ".csv");
//
//			StringBuffer strBfr = new StringBuffer();
//			StringTokenizer gridDataTokens = new StringTokenizer(gridData, "\r\n");
//			int rowNum = 0;
//			int colNum = 0;
//			while (gridDataTokens.hasMoreTokens())
//			{
//
//				colNum = 0;
//				String rowData = gridDataTokens.nextToken();
//
//				StringTokenizer rowDataTokens = new StringTokenizer(rowData, "\t");
//				while (rowDataTokens.hasMoreTokens())
//				{
//					String cellData = rowDataTokens.nextToken();
//					
//					/*
//					 * Added/Updated as FIX of JIRA#1776.
//					 * Updated by: Arun Dhumal
//					 * Updated on: 16/06/2014
//					 * Description: Check first column is ID or not 
//					 * START
//				    */
//
//					if( 0 == colNum && 0 == rowNum)
//					{
//					
//						if( cellData.equalsIgnoreCase("ID") )
//						{
//							cellData=cellInfoId;
//						}
//					}
//					
//					/*
//					 * JIRA# 1776.
//					 * END
//				    */
//					
//					StringWriter writer = new StringWriter();
//					StringEscapeUtils.escapeCsv(writer, cellData);
//					strBfr.append(writer);
//					strBfr.append(",");
//					colNum++;
//				}
//				strBfr.deleteCharAt(strBfr.length() - 1);
//				strBfr.append("\r\n");
//				rowNum++;
//			}
//			strBfr.deleteCharAt(strBfr.length() - 1);
//			response.getWriter().print(strBfr);
//		}
//		catch (IndexOutOfBoundsException e)
//		{
//			logger.error("exportGridToExcel(String, String, HttpServletResponse, HttpSession)", e);
//
//		}
//		catch (IOException e)
//		{
//			logger.error("exportGridToExcel(String, String, HttpServletResponse, HttpSession)", e);
//
//		}
//		catch (Exception e)
//		{
//			logger.error("exportGridToExcel(String, String, HttpServletResponse, HttpSession)", e);
//			throw new VportalBaseException(e.getMessage());
//
//		}
//
//		if (logger.isDebugEnabled())
//		{
//			logger.debug("exportGridToExcel(String, String, HttpServletResponse, HttpSession) - end");
//		}
//	}
//
//	// Added for VPKBE-1587 (QTA Export to CSV) STARTS
//	@RequestMapping(value = "exportTableToExcel.html", method = RequestMethod.POST)
//	public void exportTableToExcel(@RequestParam String gridData, @RequestParam String gridCode, @RequestParam(
//	                                                                                                           defaultValue = "") String projectName, HttpServletResponse response, HttpSession session)
//	{
//		if (logger.isDebugEnabled())
//		{
//			logger.debug("exportTableToExcel(String gridData=" + gridData + ", String gridCode=" + gridCode
//			             + ", HttpServletResponse response=" + response + ", HttpSession session=" + session + ") - start");
//		}
//
//		try
//		{
//			String projectNm = (String) session.getAttribute(VPortalConstants.SESSION_ARG_PROJECT_NM);
//
//			// For Task Dashboard grid (viewed outside tabs), project name will be sent by the UI
//			if (!"".equals(projectName))
//			{
//				projectNm = projectName;
//			}
//
//			response.setContentType("Application/csv; charset=windows-1252");
//			response.setHeader(	"Content-Disposition",
//			                   	"attachment; filename=" + VPortalUtil.getGridExcelFileName(gridCode, projectNm) + ".csv");
//
//			StringBuffer strBfr = new StringBuffer();
//			// gridData = gridData.replaceAll("\r\n", "");
//			gridData = gridData.replaceAll("\\s+", "  ");
//			StringTokenizer gridDataTokens = new StringTokenizer(gridData, "^^^");
//			int rowNum = 0;
//			int colNum = 0;
//			while (gridDataTokens.hasMoreTokens())
//			{
//				colNum = 0;
//				String rowData = gridDataTokens.nextToken();
//				StringTokenizer rowDataTokens = new StringTokenizer(rowData, "|||");
//				while (rowDataTokens.hasMoreTokens())
//				{
//					String cellData = rowDataTokens.nextToken();
//					StringWriter writer = new StringWriter();
//					StringEscapeUtils.escapeCsv(writer, cellData);
//					strBfr.append(writer);
//					strBfr.append(",");
//					colNum++;
//				}
//				strBfr.deleteCharAt(strBfr.length() - 1);
//				strBfr.append("\r\n");
//				rowNum++;
//			}
//			strBfr.deleteCharAt(strBfr.length() - 1);
//			response.getWriter().print(strBfr);
//		}
//		catch (IndexOutOfBoundsException e)
//		{
//			logger.error("exportTableToExcel(String, String, HttpServletResponse, HttpSession)", e);
//
//		}
//		catch (IOException e)
//		{
//			logger.error("exportTableToExcel(String, String, HttpServletResponse, HttpSession)", e);
//
//		}
//		catch (Exception e)
//		{
//			logger.error("exportTableToExcel(String, String, HttpServletResponse, HttpSession)", e);
//			throw new VportalBaseException(e.getMessage());
//		}
//
//		if (logger.isDebugEnabled())
//		{
//			logger.debug("exportTableToExcel(String, String, HttpServletResponse, HttpSession) - end");
//		}
//	}
//	// Added for VPKBE-1587 (QTA Export to CSV) ENDS
//
//	public void exportGridExcel(@RequestParam String gridData, @RequestParam String gridCode,
//	                            HttpServletResponse response, HttpSession session)
//	{
//		if (logger.isDebugEnabled())
//		{
//			logger.debug("exportGridToExcel(String gridData=" + gridData + ", String gridCode=" + gridCode
//			             + ", HttpServletResponse response=" + response + ", HttpSession session=" + session + ") - start");
//		}
//
//		WritableWorkbook workbook = null;
//		WritableSheet excelSheet = null;
//		CellFormat contentCF = null;
//
//		try
//		{
//			String projectNm = (String) session.getAttribute(VPortalConstants.SESSION_ARG_PROJECT_NM);
//
//			response.setContentType("application/vnd.ms-excel");
//			response.setHeader(	"Content-Disposition",
//			                   	"attachment; filename=" + VPortalUtil.getGridExcelFileName(gridCode, projectNm) + ".xls");
//			// Initialize the workbook
//			workbook = ExcelUtil.initWorkbook(response.getOutputStream());
//			// Get the sheet reference
//			excelSheet = workbook.getSheet(0);
//			// Create content cell format
//			contentCF = ExcelUtil.createTextCellFormat();
//
//			StringTokenizer gridDataTokens = new StringTokenizer(gridData, "\n");
//			int rowNum = 0;
//			int colNum = 0;
//			while (gridDataTokens.hasMoreTokens())
//			{
//
//				colNum = 0;
//				String rowData = gridDataTokens.nextToken();
//
//				StringTokenizer rowDataTokens = new StringTokenizer(rowData, "\t");
//				while (rowDataTokens.hasMoreTokens())
//				{
//					String cellData = rowDataTokens.nextToken();
//					ExcelUtil.writeCellContent(excelSheet, cellData, rowNum, colNum, "TEXT", contentCF);
//					colNum++;
//				}
//
//				rowNum++;
//			}
//		}
//		catch (IndexOutOfBoundsException e)
//		{
//			logger.error("exportGridToExcel(String, String, HttpServletResponse, HttpSession)", e);
//
//		}
//		catch (IOException e)
//		{
//			logger.error("exportGridToExcel(String, String, HttpServletResponse, HttpSession)", e);
//
//		}
//		catch (Exception e)
//		{
//			logger.error("exportGridToExcel(String, String, HttpServletResponse, HttpSession)", e);
//			throw new VportalBaseException(e.getMessage());
//
//		}
//		finally
//		{
//			ExcelUtil.commitWorkbook(workbook);
//		}
//
//		if (logger.isDebugEnabled())
//		{
//			logger.debug("exportGridToExcel(String, String, HttpServletResponse, HttpSession) - end");
//		}
//	}
//}
