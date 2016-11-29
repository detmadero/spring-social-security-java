<%@ taglib uri="http://www.springframework.org/security/tags"
    prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<html>
<head>
<meta charset="UTF-8">
<title>User Info</title>
</head>
<body>
    <jsp:include page="_menu.jsp" />
    <h2>User Info Page</h2>
    <span>Welcome : ${pageContext.request.userPrincipal.name}</span>
</body>
</html>