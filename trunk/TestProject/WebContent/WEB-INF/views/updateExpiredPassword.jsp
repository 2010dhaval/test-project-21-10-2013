
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="script.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Password expired</title>
<script>
	function checkPassword() {
		if (document.getElementById("newPassword").value != document
				.getElementById("confirmPassword").value
				|| document.getElementById("newPassword").value == "") {
			alert("Please ensure the passwords match");
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>
	<h1>Update Expired password</h1>
	<form:form commandName="password" method="POST"
		onsubmit="return checkPassword();">
            Change password for User: ${password.username}(${password.userId})<br />
		<br />
            Old Password: <form:password path="oldPassword" />
		<br />
            New Password: <form:password path="newPassword" />
		<br />
            Confirm New Password: <input type="password"
			id="confirmPassword" />
		<br />
		<input type="submit" name="_update" value="Update" />&nbsp;&nbsp;<a
			href="j_spring_security_logout">log out</a>

		<spring:hasBindErrors name="password">
			<div class="error">
				<form:errors path="*" />
			</div>
		</spring:hasBindErrors>
	</form:form>
</body>
</html>
