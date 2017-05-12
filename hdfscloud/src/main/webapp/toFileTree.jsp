<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
System.out.println("toFileTree");
//String tmpdir=request.getAttribute("dirname").toString();
if (request.getAttribute("dirname")!=null){
	System.out.println("toFileTree dirname"+request.getAttribute("dirname"));
request.setAttribute("dirname",request.getAttribute("dirname"));
System.out.println("toFileTree"+request.getAttribute("dirname"));}
%>
<jsp:forward page="FindFile"></jsp:forward>
</body>
</html>