<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
out.print("<meta http-equiv=refresh content=1;url=login.jsp> ");
%>

<title>message</title>
</head>
<body>
    <center>
    <%
    request.setAttribute("username",session.getAttribute("username"));
    %>
        <h2><%=	request.getAttribute("message").toString()%></h2>
    </center>
</body>
</html>