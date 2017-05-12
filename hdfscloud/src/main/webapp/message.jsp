<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
String type=null;
String tmptype=(String)request.getParameter("type");
if (tmptype!=null){
	type=tmptype;
if (type.equals("file") ){
	out.print( "<meta http-equiv=refresh content=1;url=fileLogin.jsp>");
}else if(type.equals("demo")){
	out.print("<meta http-equiv=refresh content=1;url=login.jsp> ");
	}
}
else {
	%>
	<meta http-equiv=refresh content=2;url=toFileTree.jsp?dirname=<%=request.getAttribute("dirname")%>>
	<%
}
%>

<title>文件处理结果</title>
</head>
<body>
    <center>
    <%System.out.println("message dirname: "+request.getAttribute("dirname"));
    request.setAttribute("username",session.getAttribute("username"));
    %>
        <h2><%=	request.getAttribute("message").toString()%></h2>
    </center>
</body>
</html>