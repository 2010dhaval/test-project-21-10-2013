<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="script.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body>
        <h1>login<form action="j_spring_security_check" method="post" >
            <p>
                <label for="j_username">username</label>
                <input id="j_username" name="j_username" value="${sessionScope[SPRING_SECURITY_LAST_USERNAME]}" type="text" />
            </p>
            <p>
                <label for="j_password">password</label>
                <input id="j_password" name="j_password" type="password" />
            </p>
            <input  type="submit" value="login"/>
            <br/><br/>
            <c:if test="${param.login_error=='true'}">
                <span style="color: red">${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</span>
            </c:if>
         
        </form>
    </body>
</html>