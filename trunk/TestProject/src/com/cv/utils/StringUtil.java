/*
 * Copyright (c) Creative Virtual Ltd. 2014
 * All rights reserved. Confidential and Proprietary.
 */

/**
 * Source: StringUtil.java
 * 
 * Description: String utility file.
 *
 * @author: Mastek
 * @version: 1.0
 * 
 * Changes log
 * ------------------------------------------------------------------------------------------
 * Sr No | Description         	| Date          | By                       | Remarks |.
 * 
 *   1     	Initial Version      				     		Mastek     					Initial Version
 *   2		Code Update					18/02/2014			Dhaval Mehta				To fix jira#390 (Previous code was removing non ascii character from string.)
 * ------------------------------------------------------------------------------------------
 */
package com.cv.utils;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.util.HtmlUtils;

public class StringUtil
{

	static Map<String, String>		suffixMap					= new HashMap<String, String>();

	// changes done for jira defect VP-213 : Local Test fail with HTML Commenting
	private static final String	REGEX_FOR_HTML_COMMENT	= "<!--(.|\\n)*?-->";
	private static final String	REPLACE_HTML_COMMENT		= "";
	private static final String	REGEX_FOR_HTML				= "\\<.*?\\>";

	public static int convertStringToInt(String input)
	{

		if ((input == null) || "".equals(input.trim()))
		{
			return 0;
		}
		else
		{
			return Integer.parseInt(input);
		}
	}

	public static long convertStringToLong(String input)
	{

		if ((input == null) || "".equals(input.trim()))
		{
			return 0;
		}
		else
		{
			return Long.parseLong(input);
		}
	}

	public static char convertStringToChar(String input)
	{

		if ((input == null) || "".equals(input.trim()))
		{
			return ' ';
		}
		else
		{
			return input.charAt(0);
		}
	}

	public static boolean convertCharToBoolean(Character charObj)
	{
		if ((charObj != null) && (charObj == 'Y'))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static String convertBooleanCharToString(Character charObj)
	{
		if ((charObj != null) && (charObj == 'Y'))
		{
			return "True";
		}
		else
		{
			return "False";
		}
	}

	public static Character convertBooleanToChar(Boolean flag)
	{
		if ((flag != null) && flag)
		{
			return 'Y';
		}
		else
		{
			return 'N';
		}
	}

	public static char convertNullCharacterToSpace(Character c)
	{
		if (c == null)
		{
			return ' ';
		}
		else
		{
			return c;
		}
	}

	public static String replaceNullWithBlank(String str)
	{
		if (str != null)
		{
			return str.trim();
		}
		else
		{
			return "";
		}
	}

	public static String replaceBlankWithNull(String str)
	{
		if ((str != null) && str.trim().equals(""))
		{
			return null;
		}
		else
		{
			return str;
		}
	}

	public static String replaceNullWithZero(String str)
	{
		if (str != null)
		{
			return str.trim();
		}
		else
		{
			return "0";
		}
	}

	public static String replaceNullBlankWithZero(String str)
	{
		if (str != null)
		{
			String tmp = str.trim();
			if (!tmp.equals(""))
			{
				return tmp;
			}
			else
			{
				return "0";
			}
		}
		else
		{
			return "0";
		}
	}

	public static boolean isNullOrBlank(String str)
	{

		if ((str == null) || "".equals(str.trim()))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	/**
	 * Escape characters for text appearing as XML data, between tags.
	 * <P>
	 * The following characters are replaced with corresponding character entities :
	 * <table border='1' cellpadding='3' cellspacing='0'>
	 * <tr>
	 * <th>Character</th>
	 * <th>Encoding</th>
	 * </tr>
	 * <tr>
	 * <td><</td>
	 * <td>&lt;</td>
	 * </tr>
	 * <tr>
	 * <td>></td>
	 * <td>&gt;</td>
	 * </tr>
	 * <tr>
	 * <td>&</td>
	 * <td>&amp;</td>
	 * </tr>
	 * <tr>
	 * <td>"</td>
	 * <td>&quot;</td>
	 * </tr>
	 * <tr>
	 * <td>'</td>
	 * <td>&#039;</td>
	 * </tr>
	 * </table>
	 * <P>
	 * Note that JSTL's {@code <c:out>} escapes the exact same set of characters as this method. <span
	 * class='highlight'>That is, {@code <c:out>} is good for escaping to produce valid XML, but not for producing safe
	 * HTML.</span>
	 */
	public static String forXML(String aText)
	{
		final StringBuilder result = new StringBuilder();
		final StringCharacterIterator iterator = new StringCharacterIterator(aText);
		char character = iterator.current();
		while (character != CharacterIterator.DONE)
		{
			if (character == '<')
			{
				result.append("&lt;");
			}
			else if (character == '>')
			{
				result.append("&gt;");
			}
			else if (character == '\"')
			{
				result.append("&quot;");
			}
			else if (character == '\'')
			{
				result.append("&#039;");
			}
			else if (character == '&')
			{
				result.append("&amp;");
			}
			else
			{
				// the char is not a special one
				// add it to the result as is
				result.append(character);
			}
			character = iterator.next();
		}
		return result.toString();
	}

	public static StringOccurrenceVO countOccurrences(String occurenceString, char pattern)
	{
		int count = 0;
		boolean flag = true;
		boolean checkFlag = true;
		StringOccurrenceVO occurrenceVO = new StringOccurrenceVO();
		for (int i = 0; i < occurenceString.length(); i++)
		{
			if ((occurenceString.charAt(i) == pattern) && flag)
			{
				if (count == 0)
				{
					occurrenceVO.setStartindex(i);
				}
				count++;

			}
			else
			{
				if ((occurenceString.charAt(i) != pattern) && flag)
				{
					if (count > 0)
					{
						occurrenceVO.setEndIndex(i);
						checkFlag = false;
						flag = false;

					}
				}

			}
		}
		if (checkFlag && (count > 0))
		{
			occurrenceVO.setEndIndex(occurrenceVO.getStartindex() + count);
		}
		occurrenceVO.setTotalCount(count);
		return occurrenceVO;
	}

	public static String convertPropertyNameToLabel(String propName)
	{
		if (propName == null)
		{
			return null;
		}

		if (suffixMap.size() == 0)
		{
			suffixMap.put("in", " Indicator");
			suffixMap.put("cd", " Code");
			suffixMap.put("desc", " Description");
			suffixMap.put("dt", " Date");
			suffixMap.put("char", " Character");
			suffixMap.put("cnt", " Count");
			suffixMap.put("chk", " Check");
			suffixMap.put("val", " Value");
			suffixMap.put("ts", " Timestamp");
		}

		String[] propNameParts = StringUtils.splitByCharacterTypeCamelCase(propName);
		int propNamePartsLen = propNameParts.length;
		StringBuilder lblBuilder = new StringBuilder();
		for (int i = 0; i < propNamePartsLen; i++)
		{
			if (i == 0)
			{
				lblBuilder.append(StringUtils.capitalize(propNameParts[i]));
				continue;
			}
			lblBuilder.append(" ");
			if (i == propNamePartsLen - 1)
			{
				String modifiedSuffix = suffixMap.get(propNameParts[i].toLowerCase());
				if (modifiedSuffix != null)
				{
					lblBuilder.append(modifiedSuffix);
					continue;
				}
			}
			lblBuilder.append(propNameParts[i]);
		}
		return lblBuilder.toString();
	}

	public static String capitalizeText(String conditionTxt)
	{
		String txt = null;
		if ((conditionTxt != null) && (conditionTxt.trim().length() > 0))
		{
			// changes done for VPKBE-3049
			// Pattern p = Pattern.compile("(%)[-a-zA-Z0-9+]*[-a-zA-Z0-9+]", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
			Pattern p = Pattern.compile("(%)[a-zA-Z0-9_]*[a-zA-Z0-9_]", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
			Matcher m = p.matcher(conditionTxt);

			StringBuffer sb = new StringBuffer();

			while (m.find())
			{
				m.appendReplacement(sb, m.group().toUpperCase());
			}

			m.appendTail(sb);
			txt = sb.toString();
		}
		return txt;
	}

	// Veracode Issue : CWE ID 113
	public static String validateStringForResponseSplitting(String inputText)
	{
		String filteredText = inputText.replaceAll("(\\\\r|\\\\n)", "");
		//updated as FIX of JIRA#390 by Dhaval.
		//filteredText = StringEscapeUtils.escapeHtml(filteredText);
		filteredText = HtmlUtils.htmlEscape(filteredText);
		
		return filteredText;
	}

	public static int getDecimalValue(Float decimalValue)
	{
		String s = String.valueOf(decimalValue);
		int i = 0;
		int index = s.indexOf('.');
		if (index == -1)
		{
			// no decimal
			i = 0;
		}
		else
		{
			i = Integer.parseInt(s.substring(index + 1));
		}
		return i;
	}

	public static String removeHTMLCommentsFromString(String text)
	{
		if (text != null)
		{
			// changes done for jira defect VP-213 : Local Test fail with HTML Commenting
			Pattern p = Pattern.compile(REGEX_FOR_HTML_COMMENT, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
			Matcher m = p.matcher(text);
			text = m.replaceAll(REPLACE_HTML_COMMENT);
		}
		return text;
	}

	public static String removeHTMLFromString(String text)
	{
		if (text != null)
		{
			Pattern p = Pattern.compile(REGEX_FOR_HTML, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
			Matcher m = p.matcher(text);
			text = m.replaceAll(REPLACE_HTML_COMMENT);
		}
		return text;
	}

	public static String removeHTMLTagWithContentFromString(String text, String tagName)
	{
		if (text != null)
		{
			Pattern regex =
					Pattern.compile("<" + tagName + ".*</" + tagName + ">", Pattern.MULTILINE | Pattern.DOTALL
							| Pattern.CASE_INSENSITIVE);
			Matcher match = regex.matcher(text);
			text = match.replaceAll("");
		}
		return text;
	}

	/**
	 * This method ensures that the output String has only valid XML unicode characters as specified by the XML 1.0
	 * standard. For reference, please see <a href="http://www.w3.org/TR/2000/REC-xml-20001006#NT-Char">the standard</a>.
	 * This method will return an empty String if the input is null or empty.
	 * @param in The String whose non-valid characters we want to remove.
	 * @return The in String, stripped of non-valid characters.
	 */
	public static String stripNonValidXMLCharacters(String in)
	{
		StringBuffer out = new StringBuffer(); // Used to hold the output.
		char current; // Used to reference the current character.

		if ((in == null) || "".equals(in))
		{
			return ""; // vacancy test.
		}
		for (int i = 0; i < in.length(); i++)
		{
			current = in.charAt(i); // NOTE: No IndexOutOfBoundsException caught here; it should not happen.
			if ((current == 0x9) || (current == 0xA) || (current == 0xD) || ((current >= 0x20) && (current <= 0xD7FF))
					|| ((current >= 0xE000) && (current <= 0xFFFD)) || ((current >= 0x10000) && (current <= 0x10FFFF)))
			{
				out.append(current);
			}
		}
		return out.toString();
	}

	/**
	 * Removes all <i>HTML</i> tags from the given input text.
	 * @param htmlString Input parameter that may contain <i>HTML</i> tags.
	 * @return Text without <i>HTML</i> tags.
	 */
	public static String removeAllHtmlTags(String htmlString)
	{
		if (isNullOrBlank(htmlString))
		{
			return null;
		}

		// Unescape Html if there are any
		htmlString = StringEscapeUtils.unescapeHtml(htmlString);

		Set<String> htmlEmptyTagsToRemove = new HashSet<String>();
		Set<String> htmlNonEmptyTagsToRemove = new HashSet<String>();

		// Remove special type tag like <br>, </br> etc
		htmlString = htmlString.replaceAll("<br>", "\n");
		htmlString = htmlString.replaceAll("</br>", "\n");

		int length = htmlString.length();
		for (int index = 0; index < length; index++)
		{
			char startTagChar = htmlString.charAt(index);
			if (startTagChar != '<')
			{
				continue;
			}

			// Traverse till next occurance of > and get the complete HTML tag e.g. <i>
			String htmlStartTag = "";
			boolean isEmptyTag = false;
			for (int currIndex = index; currIndex < length; currIndex++)
			{
				char endTagChar = htmlString.charAt(currIndex);
				htmlStartTag = htmlStartTag + endTagChar;
				if (endTagChar == '>')
				{
					isEmptyTag = true;
					break;
				}
				// Scenario : <a href=...>...</a>
				if (endTagChar == ' ')
				{
					htmlStartTag = htmlStartTag.trim();
					break;
				}
			}

			if (htmlEmptyTagsToRemove.contains(htmlStartTag))
			{
				// Already tag identified. So, don't proceed further.
				continue;
			}

			if (htmlNonEmptyTagsToRemove.contains(htmlStartTag))
			{
				// Already tag identified. So, don't proceed further.
				continue;
			}

			// Now create end HTML tag e.g. </i>
			String htmlEndTag = htmlStartTag.replace("<", "</");

			// Remove the first occurance of start and end tag if the input string contains HTML end tag. This is
			// required for non-Html tags like <BOOK>.
			if (htmlString.indexOf(htmlEndTag) > 0)
			{
				if (isEmptyTag)
				{
					htmlEmptyTagsToRemove.add(htmlStartTag);
					htmlEmptyTagsToRemove.add(htmlEndTag);
				}
				else
				{
					htmlNonEmptyTagsToRemove.add(htmlStartTag);
					htmlNonEmptyTagsToRemove.add(htmlEndTag + ">");
				}
			}
		}

		// Remove empty tags
		for (String htmlTagToRemove : htmlEmptyTagsToRemove)
		{
			htmlString = htmlString.replaceAll(htmlTagToRemove, "");
		}

		// Remove non-empty tags
		for (String htmlTagToRemove : htmlNonEmptyTagsToRemove)
		{
			if (htmlTagToRemove.endsWith(">"))
			{
				// Replace end tag. e.g. </a>, </img> etc
				htmlString = htmlString.replaceAll(htmlTagToRemove, "");
			}
			else
			{
				// Replace the contents of non-empty tag e.g. <a ...>, <img ...>
				do
				{
					int beginIndex = htmlString.indexOf(htmlTagToRemove);
					if (beginIndex == -1)
					{
						break;
					}
					int endIndex = htmlString.indexOf(">", beginIndex) + 1;
					htmlString = htmlString.substring(0, beginIndex) + htmlString.substring(endIndex);
				}
				while (true);
			}
		}

		return htmlString;
	}

	public static String getCommaSeparatedStringFromIntegerList(List<Integer> intObjList)
	{
		StringBuffer strBuf = new StringBuffer();
		for (Integer intObj : intObjList)
		{
			strBuf.append(intObj);
			strBuf.append(",");
		}
		if ((strBuf != null) && (strBuf.length() > 0))
		{
			strBuf.deleteCharAt(strBuf.lastIndexOf(","));
		}
		return strBuf.toString();
	}
	
	public static String decodeURIComponent(String encodedURI) {
		char actualChar;

		StringBuffer buffer = new StringBuffer();

		int bytePattern, sumb = 0;

		for (int i = 0, more = -1; i < encodedURI.length(); i++) {
			actualChar = encodedURI.charAt(i);

			switch (actualChar) {
			case '%': {
				actualChar = encodedURI.charAt(++i);
				int hb = (Character.isDigit(actualChar) ? actualChar - '0'
						: 10 + Character.toLowerCase(actualChar) - 'a') & 0xF;
				actualChar = encodedURI.charAt(++i);
				int lb = (Character.isDigit(actualChar) ? actualChar - '0'
						: 10 + Character.toLowerCase(actualChar) - 'a') & 0xF;
				bytePattern = (hb << 4) | lb;
				break;
			}
			case '+': {
				bytePattern = ' ';
				break;
			}
			default: {
				bytePattern = actualChar;
			}
			}

			if ((bytePattern & 0xc0) == 0x80) { // 10xxxxxx
				sumb = (sumb << 6) | (bytePattern & 0x3f);
				if (--more == 0)
					buffer.append((char) sumb);
			} else if ((bytePattern & 0x80) == 0x00) { // 0xxxxxxx
				buffer.append((char) bytePattern);
			} else if ((bytePattern & 0xe0) == 0xc0) { // 110xxxxx
				sumb = bytePattern & 0x1f;
				more = 1;
			} else if ((bytePattern & 0xf0) == 0xe0) { // 1110xxxx
				sumb = bytePattern & 0x0f;
				more = 2;
			} else if ((bytePattern & 0xf8) == 0xf0) { // 11110xxx
				sumb = bytePattern & 0x07;
				more = 3;
			} else if ((bytePattern & 0xfc) == 0xf8) { // 111110xx
				sumb = bytePattern & 0x03;
				more = 4;
			} else { // 1111110x
				sumb = bytePattern & 0x01;
				more = 5;
			}
		}
		return buffer.toString();
	}
}
