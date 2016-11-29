<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<jsp:include page="_menu.jsp" />
	<h2>Social Login</h2>

	<a href="${pageContext.request.contextPath}/auth/facebook">Facebook</a>
	<br />
	<a href="${pageContext.request.contextPath}/auth/google">Google</a>
	<br />

	<h2>Normal Login</h2>
	<c:if test="${param.error == 'true'}">
		<div style="color: red; margin: 10px 0px;">
			Login Failed!!!<br /> Reason :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
	<form action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="submit" /></td>
				<td style="text-align: right;"><a href="${pageContext.request.contextPath}/signup">Create new account?</a></td>
			</tr>
		</table>
	</form>
	
</body>
</html>