<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="js/jquery/bootstrap/css/bootstrap.min.css" /> 
<script src="js/jquery/bootstrap/jquery/jquery-2.1.1.min.js" ></script>
<script src="js/jquery/bootstrap/js/bootstrap.min.js" > </script>
<link id="bootstrap_221" rel="stylesheet" type="text/css"
	class="library"
	href="http://sandbox.runjs.cn/js/sandbox/bootstrap-2.2.1/css/bootstrap.min.css">	
<script id="jquery_172" type="text/javascript" class="library"
	src="http://sandbox.runjs.cn/js/sandbox/jquery/jquery-1.7.2.min.js"></script>
<script id="bootstrap_221" type="text/javascript" class="library"
	src="http://sandbox.runjs.cn/js/sandbox/bootstrap-2.2.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="js/jquery/my.css">
<script type="text/javascript" src="js/jquery/tree2/my.js"></script>
    <link rel="stylesheet" type="text/css" href="js/jquery/easyui/themes/default/easyui.css">  
<link rel="stylesheet" type="text/css" href="js/jquery/easyui/themes/icon.css">  
<link rel="stylesheet" type="text/css" href="js/jquery/easyui/demo/demo.css">  
<script type="text/javascript" src="js/jquery/easyui/jquery.min.js"></script>  
<script type="text/javascript" src="js/jquery/easyui/jquery.easyui.min.js"></script>  
	<script type="text/javascript" src="js/jquery/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/jquery/easyui/jquery.edatagrid.js"></script>
    <link rel="stylesheet" type="text/css" href="js/jquery/zTree/zTreeStyle/zTreeStyle.css"/>
    <script type="text/javascript" src="js/jquery/zTree/jquery.ztree.min.js"></script>
<title>防伪溯源</title>
<style>
.divsearch{float:right }
</style>
</head>
<body >
<%if (session.getAttribute("username")==null){response.sendRedirect("companyLogin.html");} %>
<div class="container-fluid" >
		<div class="row clearfix" >
			<div class="col-md-12 column">
					<h1 class="text-center">欢迎您来到防伪溯源系统
					</h1>
						<!--  table id="Bq"><tr><td id="stWrap"></td></tr></table><script src="//www.speedtest.cn/assets/js/api/speedtest.light_nobg.min.js">
</script-->						
					
				 	<p class="text-right"><i class="icon-user"></i><%=" "+ session.getAttribute("username")%>
				 <a href="exit.jsp">退出登录</a>
				 <!--  <img alt="1x1" src="lib/fangwei.png" class="img-rounded" width=200px
					height=200px />-->
				 </p>
			</div>
			</div>
				<div class="row clearfix" style="HEIGHT: 100%">
			<div class="col-md-12  column" style="BORDER-RIGHT: 3px outset;BORDER-LEFT: 3px outset; BORDER-TOP: 3px outset;  BORDER-BOTTOM: 3px outset;HEIGHT:1000px">
				<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%;' src="demo.html"></iframe>
			</div>
		</div>
</div>
</body>
</html>