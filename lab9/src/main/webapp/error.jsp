<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
</head>
<body>
<h1>Access Denied</h1>
<p><%= request.getAttribute("error") %></p>
<img src="img/moder.gif">
<a href="${pageContext.request.contextPath}/login">Back to Login Page</a>

</body>
</html>
