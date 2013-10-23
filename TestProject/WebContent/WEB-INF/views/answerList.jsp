<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Answer List</title>
</head>
<body>
${param.msg}
<c:if test="${!empty answerList}">
		<table align="left" border="1">
			<tr>
				<th>ID</th>
				<th>Description</th>
				
			</tr>

			<c:forEach items="${answerList}" var="items">
				<tr>
					<td><c:out value="${items.answerId}" /></td>
					<td><c:out value="${items.answer}" /></td>
				
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>