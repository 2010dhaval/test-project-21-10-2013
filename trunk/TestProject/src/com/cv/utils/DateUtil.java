package com.cv.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateUtil
{
	public static final String			DATE_FORMAT_MYSQL									= "yyyy-MM-dd";
	public static final String			DATE_FORMAT											= "dd/MM/yyyy";
	public static final String			TIMESTAMP_DISPLAY_FORMAT						= "dd-MM-yyyy HH:mm:ss z";
	public static final String			TIMESTAMP_DISPLAY_FORMAT_WITHOUT_TIMEZONE	= "dd-MM-yyyy HH:mm:ss";
	public static final String			DATE_DISPLAY_FORMAT								= "dd-MM-yyyy";

	public static final String			DATE_TASK_DEADLINE_DISPLYA_FORMAT			= "MM/dd/yyyy HH:mm:ss";
	public static final String			DATE_VALIDITY_DISPLYA_FORMAT					= "MM/dd/yyyy HH:mm:ss";
	public static final String			DATE_OBJECT_DIFF_REPORT_FORMAT				= "yyyy-MM-dd HH:mm:ss";

	public static final String			MIN_DATE_STR										= "01/01/1011";
	public static final String			MAX_DATE_STR										= "01/01/3011";
	public static final Date			MIN_DATE												= convertStringToUtilDate(	MIN_DATE_STR,
																																			DATE_FORMAT);
	public static final Date			MAX_DATE												= convertStringToUtilDate(	MAX_DATE_STR,
																																			DATE_FORMAT);

	private static DatatypeFactory	datatypeFactory									= null;
	static
	{
		try
		{
			datatypeFactory = DatatypeFactory.newInstance();
		}
		catch (DatatypeConfigurationException dce)
		{
			
		}
	}

	public static Date getCurrentDate()
	{
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR, 0);
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		today.set(Calendar.MILLISECOND, 0);

		return today.getTime();
	}

	public static long getCurrentTime()
	{
		java.util.Date date = new java.util.Date();
		return date.getTime();
	}

	public static Timestamp getCurrentTimestamp()
	{
		java.util.Date date = new java.util.Date();
		return new Timestamp(date.getTime());
	}

	public static String getCurrentTimestampString()
	{
		SimpleDateFormat formatter = new SimpleDateFormat(TIMESTAMP_DISPLAY_FORMAT);
		Date date = new Date();
		return formatter.format(date);
	}

	public static Timestamp getCurrentTimestamp(Date date)
	{
		return new Timestamp(date.getTime());
	}

	public static Date addDaysToDate(String str_date, int daysToAdd)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_MYSQL);
		Date date = null;
		try
		{
			date = sdf.parse(str_date);
		}
		catch (ParseException e)
		{
			// Ignore this exception

		}
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		cal.add(Calendar.DAY_OF_MONTH, daysToAdd);
		return cal.getTime();
	}

	public static Date addDaysToDate(Date date, int daysToAdd)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		cal.add(Calendar.DAY_OF_MONTH, daysToAdd);
		return cal.getTime();
	}

	public static Date addHoursToDate(Date date, int hours)
	{
		Calendar timeCal = Calendar.getInstance();
		timeCal.setTime(date);
		timeCal.add(Calendar.HOUR, hours);
		return timeCal.getTime();
	}

	public static Date addMinutesToDate(Date date, int minutes)
	{
		Calendar timeCal = Calendar.getInstance();
		timeCal.setTime(date);
		timeCal.add(Calendar.MINUTE, minutes);
		return timeCal.getTime();
	}

	public static boolean isExpireSoon(Date expireDate, int expireSoonDays)
	{

		Date currtDate = new Date();
		Calendar cal = Calendar.getInstance();

		cal.setTime(expireDate);
		cal.add(Calendar.DAY_OF_MONTH, -expireSoonDays);
		Date expireSoonDate = cal.getTime();

		if (currtDate.after(expireSoonDate) && currtDate.before(expireDate))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static int getDiffDays(Date startDate, Date endDate)
	{
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(startDate);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(endDate);
		long daysBetween = 0;
		while (cal1.before(cal2))
		{
			cal1.add(Calendar.DAY_OF_MONTH, 1);
			daysBetween++;
		}
		return (int) daysBetween;
		// int diffDays = (int) diff / (24 * 60 * 60 * 1000);
		// return diffDays;
	}

	public static float getTimeElapsedInMinutes(Date startDate)
	{
		long msec = (new java.util.Date()).getTime() - startDate.getTime();
		float timeDiffInMin = 0;
		if (msec > 0)
		{
			timeDiffInMin = msec / (1000 * 60);
		}
		return timeDiffInMin;
	}

	public static int compareDates(Date firstDate, Date secondDate)
	{
		Calendar firstCal = Calendar.getInstance();
		firstCal.setTime(firstDate);
		firstCal.set(Calendar.HOUR, 0);
		firstCal.set(Calendar.HOUR_OF_DAY, 0);
		firstCal.set(Calendar.MINUTE, 0);
		firstCal.set(Calendar.SECOND, 0);
		firstCal.set(Calendar.MILLISECOND, 0);

		Calendar secondCal = Calendar.getInstance();
		secondCal.setTime(secondDate);
		secondCal.set(Calendar.HOUR, 0);
		secondCal.set(Calendar.HOUR_OF_DAY, 0);
		secondCal.set(Calendar.MINUTE, 0);
		secondCal.set(Calendar.SECOND, 0);
		secondCal.set(Calendar.MILLISECOND, 0);

		if (firstCal.getTime().compareTo(secondCal.getTime()) < 0)
		{
			return -1;
		}
		else if (firstCal.getTime().compareTo(secondCal.getTime()) > 0)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}

	public static boolean isBetweenTwoDates(Date dateToBeCompared, Date firstDate, Date secondDate)
	{
		if (((DateUtil.compareDates(firstDate, dateToBeCompared) < 0) && (DateUtil.compareDates(	secondDate,
																																dateToBeCompared) < 0))
				|| ((DateUtil.compareDates(firstDate, dateToBeCompared) > 0) && (DateUtil.compareDates(secondDate,
																																	dateToBeCompared) > 0)))
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public static Date getDateFromString(String strDate)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		try
		{
			if ((null != strDate) && !strDate.isEmpty())
			{
				Date formattedDate = dateFormat.parse(strDate);
				return formattedDate;
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			return null;
		}

	}

	public static Date getDateFromStringFormatMySql(String strDate)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_MYSQL);
		try
		{
			if ((null != strDate) && !strDate.isEmpty())
			{
				Date formattedDate = dateFormat.parse(strDate);
				return formattedDate;
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			return null;
		}

	}

	public static String getStringFromDate(Date dtDate)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		try
		{
			if (null != dtDate)
			{
				String strDate = dateFormat.format(dtDate);
				return strDate;
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			return null;
		}
	}

	public static Date setTimeInDate(Date dateToSet, Date timeToSet)
	{
		Calendar dateCal = Calendar.getInstance();
		dateCal.setTime(dateToSet);

		Calendar timeCal = Calendar.getInstance();
		timeCal.setTime(timeToSet);

		dateCal.set(Calendar.HOUR, timeCal.get(Calendar.HOUR));
		dateCal.set(Calendar.HOUR_OF_DAY, timeCal.get(Calendar.HOUR_OF_DAY));
		dateCal.set(Calendar.MINUTE, timeCal.get(Calendar.MINUTE));
		dateCal.set(Calendar.SECOND, timeCal.get(Calendar.SECOND));
		dateCal.set(Calendar.MILLISECOND, timeCal.get(Calendar.MILLISECOND));

		return dateCal.getTime();
	}

	public static String convertUtilDateToString(Date utilDate, String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if (utilDate == null)
		{
			return "";
		}
		else
		{
			return sdf.format(utilDate);
		}
	}

	public static Date convertStringToUtilDate(String dateString, String format)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date utilDate = null;
		try
		{
			utilDate = dateFormat.parse(dateString);
		}
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return utilDate;
	}

	public static Date TimeZoneConverter(Date date)
	{
		TimeZone tz = TimeZone.getDefault();
		Date ret = new Date(date.getTime() - tz.getRawOffset());

		// if we are now in DST, back off by the delta. Note that we are checking the GMT date, this is the KEY.
		if (tz.inDaylightTime(ret))
		{
			Date dstDate = new Date(ret.getTime() - tz.getDSTSavings());

			// check to make sure we have not crossed back into standard time
			// this happens when we are on the cusp of DST (7pm the day before the change for PDT)
			if (tz.inDaylightTime(dstDate))
			{
				ret = dstDate;
			}
		}

		return ret;
	}

	public static Date getLocalDateFromGMTDate(Date formattedDate, Float offset, String dateType)
	{
		try
		{
			if (null != formattedDate)
			{
				if ((formattedDate.getTimezoneOffset() * -1) != offset.intValue() * 6)
				{
					int decimalValue = StringUtil.getDecimalValue(offset);
					if (decimalValue > 0)
					{
						if ((offset.intValue() < 0) && (dateType != null) && dateType.equalsIgnoreCase("SERVER"))
						{
							decimalValue = decimalValue * -6;
						}
						else
						{
							decimalValue = decimalValue * 6;
						}
						int minutes = formattedDate.getMinutes();
						minutes += decimalValue;
						formattedDate.setMinutes(minutes);
					}
					int hours = formattedDate.getHours();
					hours += offset.intValue();
					formattedDate.setHours(hours);
				}
				return formattedDate;
			}
			else
			{
				return null;
			}
		}
		catch (Exception e)
		{
			return null;
		}

	}

	public static boolean compareDate(Date date, int days)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, -days);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		Calendar lastLoginCal = Calendar.getInstance();
		lastLoginCal.setTime(date);
		lastLoginCal.add(Calendar.DAY_OF_MONTH, -days);
		lastLoginCal.set(Calendar.HOUR, 0);
		lastLoginCal.set(Calendar.HOUR_OF_DAY, 0);
		lastLoginCal.set(Calendar.MINUTE, 0);
		lastLoginCal.set(Calendar.SECOND, 0);
		lastLoginCal.set(Calendar.MILLISECOND, 0);

		if (lastLoginCal.before(cal))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static Date getPreviousDate(int days)
	{

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -days);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();
	}

	// Add method to convert local date to server
	public static String convertLocalStringDateToServerStringDate(String dateString, String format, Float offset)
	{
		Date utilDate = null;
		String serverDate = null;
		Float serverOffset = null;
		try
		{
			if ((dateString != null) && (dateString.trim().length() > 0))
			{
				serverOffset = (float) new Date().getTimezoneOffset() / 60;
				utilDate = DateUtil.convertStringToUtilDate(dateString, format);
				// utilDate = DateUtil.TimeZoneConverter(utilDate);
				if (offset * -1 != serverOffset)
				{
					utilDate = DateUtil.getLocalDateFromGMTDate(utilDate, offset * -1, "SERVER");
					utilDate = DateUtil.getLocalDateFromGMTDate(utilDate, serverOffset * -1, "SERVER");
				}
				serverDate = convertUtilDateToString(utilDate, format);
			}
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return serverDate;
	}

	public static XMLGregorianCalendar convertDateToGregorianCalendar(java.util.Date date)
	{
		if (date == null)
		{
			return null;
		}
		else
		{
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTimeInMillis(date.getTime());
			XMLGregorianCalendar returnXMLGregorianCalendar = datatypeFactory.newXMLGregorianCalendar(gc);
			return returnXMLGregorianCalendar;
		}
	}

	public static String getLocalTimeZone(String timeZoneName)
	{
		return TimeZone.getTimeZone(timeZoneName).getDisplayName(false, TimeZone.SHORT);
	}
	
	/**
	 * Added as the part of FIX of JIRA# 1892.
	 * Created By	: Arpit Jariwala
	 * Created On	: 21/05/2014
	 * Description	: This method is used to clear the time from the given date.
	 * @param date
	 * @return
	 */
	public static Date clearTime(Date date)
	{
		Calendar today = Calendar.getInstance();
		today.setTime(date);
		today.set(Calendar.HOUR, 0);
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		today.set(Calendar.MILLISECOND, 0);

		return today.getTime();
	}
	
	/*
    * Converts XMLGregorianCalendar to java.util.Date in Java
    */
   public static Date toDate(XMLGregorianCalendar calendar){
       if(calendar == null) {
           return null;
       }
       return calendar.toGregorianCalendar().getTime();
   }
   
   //added by yogesh 
   public static long getDateDiff(Date startDate,Date endDate,String diffIn){
   	
   	long diff = startDate.getTime() - endDate.getTime();
   	if(diffIn.equalsIgnoreCase("days")){
   		diff = TimeUnit.MILLISECONDS.toDays(diff);
   	}else if(diffIn.equalsIgnoreCase("hours")){
   		diff = TimeUnit.MILLISECONDS.toHours(diff);
   	}else if(diffIn.equalsIgnoreCase("minutes")){
   		diff = TimeUnit.MILLISECONDS.toMinutes(diff);
   	}else{
   		diff = TimeUnit.MILLISECONDS.toSeconds(diff);
   	}
   	return diff;
   }
}
