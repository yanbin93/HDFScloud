<%@page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<html><!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="http://static.runoob.com/assets/js/jquery-treeview/jquery.treeview.css" />
<link rel="stylesheet" href="http://static.runoob.com/assets/js/jquery-treeview/screen.css" />
	<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
	<script src="http://static.runoob.com/assets/js/jquery-treeview/jquery.cookie.js"></script>
	<script src="http://static.runoob.com/assets/js/jquery-treeview/jquery.treeview.js" type="text/javascript"></script>
	<script type="text/javascript">
	$(document).ready(function(){
  		$("#FindUser").click(function(){
   			 $("#content").load("FindUser");
   			 });
    	$("#AddUser").click(function(){
    		$("#content").load("User.jsp");
    		});
    	$("#FindProduct").click(function(){
   			 $("#content").load("FindProduct");
   			 });
    	$("#AddProduct").click(function(){
    		$("#content").load("ProductInfo.jsp");
    		});
		$("#browser").treeview({
			toggle: function() {
				console.log("%s was toggled.", $(this).find(">span").text());
			}
		});
		$("#add").click(function(){
			var branches = $("<li><span class='folder'>New Sublist</span><ul>" +
				"<li><span class='file'>Item1</span></li>" +
				"<li><span class='file'>Item2</span></li></ul></li>").appendTo("#browser");
			$("#browser").treeview({
				add: branches});
		});
		});
	</script>
	<style type="text/css">
	div#container{
	width:1000px;height:800px;
		}
	div#main{
		height:800px;width:300px;float:left;
		}
	div#content{
		height:800px;width:600px;float:left;
		}
	</style>
</head>
<body>
<div id="container">
	<div id="main" >
		<h1 id="banner">数据管理系统</h1>
	<ul id="browser" class="filetree treeview-famfamfam">
		<li><span class="folder">大棚数据管理系统</span>
			<ul>
				<li><span id="User" class="folder">用户基本信息</span>
					<ul>
						<li><span id="FindUser" class="file">查询/删除</span></li>
						<li><span id="AddUser" class="file">添加</span></li>
					</ul>
				</li>
				<li><span id="User" class="folder">产品信息</span>
				<ul>
				<li><span class="folder">产品1信息</span>
					<ul>
						<li><span id="FindProduct" class="file">查询/删除</span>
						</li>
						<li><span id="AddProduct" class="file">添加</span>
						</li>
					</ul>
				</li>
				<li><span class="folder">产品2信息</span>
					<ul>
						<li><span id="FindProduct" class="file">查询/删除</span>
						</li>
						<li><span id="AddProduct" class="file">添加</span>
						</li>
					</ul>
				</li>
				<li><span class="folder">产品3信息</span>
					<ul>
						<li><span id="FindProduct" class="file">查询/删除</span>
						</li>
						<li><span id="AddProduct" class="file">添加</span>
						</li>
					</ul>
				</li>
			</ul>
			</ul>
		</li>
		<li><a href="login.jsp">退出登录</a></li>
	</ul>
			</div>
	<div id="content"></div>
</div>
</body>
</html>