<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="js/jquery/bootstrap/css/bootstrap.min.css" /> 
<script src="js/jquery/bootstrap/jquery/jquery-2.1.1.min.js" ></script>
<script src="js/jquery/bootstrap/js/bootstrap.min.js" > </script>
    <link rel="stylesheet" type="text/css" href="js/jquery/easyui/themes/default/easyui.css">  
<link rel="stylesheet" type="text/css" href="js/jquery/easyui/themes/icon.css">  
<link rel="stylesheet" type="text/css" href="js/jquery/easyui/demo/demo.css">  
<script type="text/javascript" src="js/jquery/easyui/jquery.min.js"></script>  
<script type="text/javascript" src="js/jquery/easyui/jquery.easyui.min.js"></script>  
    <script type="text/javascript" src="js/jquery/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="http://www.jeasyui.com/easyui/datagrid-detailview.js"></script>
    <script type="text/javascript" src="js/jquery/easyui/jquery.edatagrid.js"></script>
<title>Insert title here</title>
</head>
<body>
<form action="productsList?type=goodsidsearch" method="post"> 
<input id="searchid" name="goodscode" class="easyui-validatebox" value="1" required="true"  style="width: 200px;" onkeyup="value=value.replace(/[^\w\.]/ig,'')">
<button type="submit" value="查找">查找</button>
</form>

</body>
</html>