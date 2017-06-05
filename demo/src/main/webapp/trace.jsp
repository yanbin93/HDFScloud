<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.io.*,java.util.*,java.util.regex.*,java.text.DecimalFormat" import="com.demo.model.*"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8" />
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
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=d22c4b3625d3123a6f5b02c7d8f0fecd"></script> 
     <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <style>
        input[type="text"] {
            height: 100px;
            outline: none;
            border: 0;
            border: 1px solid #CCCCCC;
            padding: 0 4px;
        }
#container {width:300px; height: 180px; } 
    </style>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
    <script>   
    $("#img").bind("click",function(){
    	var width = $(this).width();
    	    if(width==100)
    	    {
    	        $(this).width(300);
    	        $(this).height(300);
    	    }
    	    else
    	    {
    	        $(this).width(100);
    	        $(this).height(100);
    	    }

    	});

    function enlarger(obj){
    	$('#dlg').dialog({  
            title: '图片预览',  
            width: 600,  
            height:750,  
            resizable:true,  
            closed: false,  
            cache: false,  
            modal: true  
        });  
 	   var imgpath = obj.src;

        $("#simg").attr("src",imgpath);
    	
   }</script>
   </head>
   <body>
   <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
		
			<div class="jumbotron">
				<h1>
					欢迎进入防伪溯源大数据平台
				</h1>

			</div>
		</div>
	</div>
	<div class="row clearfix">
		<nav class="navbar navbar-default" role="navigation">

				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<form class="navbar-form navbar-left" role="search" action="productsList?type=goodsidsearch" method="post">
						<div class="form-group">
							<input id="searchid" name="goodscode"  required="true"  onkeyup="value=value.replace(/[^\w\.]/ig,'')" type="text" class="form-control" />
						</div> <button type="submit" class="btn btn-default">查找</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-user"></i><%=session.getAttribute("username")%><strong class="caret"></strong></a>
							<ul class="dropdown-menu">
							<%if (session.getAttribute("username")!=null) 
								out.print("<li><a href='user.html'>修改信息</a></li>");%>
								<li>
									 <a href="exit.jsp">退出</a>
								</li>
							
							</ul>
						</li>
					</ul>
				</div>
				
			</nav>
	            <%
        List<String> list=(List<String>)request.getAttribute("list");
        if (list==null||list.size()<1){
        out.print("<h3>没有数据</h3>");
        }
        else 
        {
        %>
		<div class="col-md-3 column">
			<h2 class="text-primary">
				批次信息
			</h2>
			<p><h2>
<%
out.print("<br>");
out.print("商品id: " +list.get(0)+"<br>");
out.print("商品名称: " +list.get(1)+"<br>");
out.print("商品备注: " +list.get(2)+"<br>");
out.print("生产商id: " +list.get(3)+"<br>");
out.print("销售商id: " +list.get(4)+"<br>");
out.print("供应商id: " +list.get(5)+"<br>");
out.print("===============<br>");
out.print("检验报告: <br>");
out.print("检验项: " +list.get(36)+"<br>");
out.print("检验结果: " +list.get(37)+"<br>");
%>
</h2>
			</p>
			<p>
			
				 <a class="btn" href="#">View details »</a>
			</p>
		</div>
		<div class="col-md-3 column">
			<h2 class="text-primary">
				生产商信息
			</h2>
			<p><h2>
			<%
			 out.print("生产商id: " +list.get(6)+"<br>");
	        out.print("厂商名称: " +list.get(7)+"<br>");
	        out.print("厂商编号: " +list.get(8)+"<br>");
	        out.print("厂商类型: " +list.get(9)+"<br>");
	       	out.print("厂商生产许可开始时间: " +list.get(10)+"<br>");
	       	out.print("厂商生产许可结束时间: " +list.get(11)+"<br>");
	        out.print("厂商经营范围: " +list.get(12)+"<br>");
	        out.print("生产许可证: <img id='img' onclick=enlarger(this) src="+list.get(13)+" width=50px weight=50px/><br>");
	        out.print("厂商备注: " +list.get(14)+"<br>");
	        out.print("销售商id: " +list.get(15)+"<br>");
	        out.print("供应商id: " +list.get(16)+"<br>");
			%>
			</h2></p>
			<p>
				 <a class="btn" href="#">View details »</a>
			</p>
		</div>
		<div class="col-md-3 column">
			<h2 class="text-primary">
				销售商信息
			</h2>
			<p><h2>
<%
out.print("销售商id: " +list.get(17)+"<br>");
out.print("销售商名称: " +list.get(18)+"<br>");
out.print("销售许可号: " +list.get(19)+"<br>");
out.print("销售商编码: " +list.get(20)+"<br>");
out.print("销售商地址: <a  href='javascript:void(0);' onclick='GaodeMap2()'>" +list.get(21)+"</a><br>");
out.print("<input  id='cityName2' type='hidden' value="+list.get(21)+"  />");
out.print("销售商联系电话: "+list.get(22)+"<br>");
out.print("销售商邮箱: " +list.get(23)+"<br>");
out.print("销售商联系人: " +list.get(24)+"<br>");
out.print("销售商备注: " +list.get(25)+"<br>");
%>
		</h2>	</p>
			<p>
				 <a class="btn" href="javascript:void(0);" onclick="GaodeMap2()">View details »</a>
			</p>
						<div class="col-md-3 column">
		<div id="container2"  ></div>
<div class="button-group">
</div>
</div>
		</div>
				<div class="col-md-3 column">
			<h2 class="text-primary">
				供应商信息
			</h2>
			<p><h2>
<%
out.print("供应商id: " +list.get(26)+"<br>");
out.print("供应商名称: " +list.get(27)+"<br>");
out.print("供应商许可号: " +list.get(28)+"<br>");
out.print("供应商编码: " +list.get(29)+"<br>");
out.print("供应商地址: <a  href='javascript:void(0);' onclick='GaodeMap()'>" +list.get(30)+"</a><br>");
out.print("<input  id='cityName' type='hidden' value="+list.get(30)+"  />");
out.print("供应商联系电话: " +list.get(31)+"<br>");
out.print("供应商邮箱: " +list.get(32)+"<br>");
out.print("供应商联系人: " +list.get(33)+"<br>");
out.print("供应商备注: " +list.get(34)+"<br>");
}
%>
			</h2></p>
			<p>
				 <a class="btn" href="#">View details »</a>
			</p>

		</div>
		</div>
			<div class="row clearfix">
			<div class="col-md-12 column">
			<div class="col-md-4 column"></div>
			<div class="col-md-4 column">
		<div id="container"  ></div>
<div class="button-group">
</div>
		</div>
		<div class="col-md-4 column"></div>
</div>
	</div>
</div>
            <div id="product">
			</div>
			      <div id="dlg" class="easyui-dialog" style="width:400px;height:250px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
            <img id="simg"/></div>

<script>

    //设置城市
    function GaodeMap2() {
        var map = new AMap.Map('container', {
            resizeEnable: true
        });
        var cityName = document.getElementById('cityName2').value;
        if (!cityName) {
            cityName = '广州市';
        }
        map.setCity(cityName);
    };
    function GaodeMap() {
        var map = new AMap.Map('container', {
            resizeEnable: true
        });
        var cityName = document.getElementById('cityName').value;
        if (!cityName) {
            cityName = '广州市';
        }
        map.setCity(cityName);
    };
</script>
</body>

</html>
