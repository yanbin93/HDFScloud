<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.util.*"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>用户注册</title>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
	<style type="text/css">
		table {
			border: gray 2px;
			border-style: solid;
			margin: 3px;
			margin-left: 25px;
			height: 100px;
			width: 589px;
		}

		td {
			font-stretch: wider;
			font-size: 18px;
			font-style: inherit;
			font-size-adjust: inherit;
			font-variant: small-caps;
		}
		
		.s1 {
			background-color: red;
		}
	</style>
<script>
$(document).ready(function(){
$("#confirmPassword").blur(function(){
if($("#confrimPassword").val()!=$("#password"))
{alert("请输入相同密码！");}
});
})
</script>
	</head>

	<body onload="check()">
		<form action="RegistServlet" method="post" name="form1">
			<table  align="center" border="0px" cellpadding="1px"
				cellspacing="3px" width="600px" height="100px" background="">
				<tr>
					<td>
						用户名：
					</td>
					<td colspan="2">
						<input type="text" id="userName" name="userName" required);"/>
						<span style="font-size: 12" id="checkUserName"></span>
					</td>		
				</tr>
				<tr>
					<td>
						密码：
					</td>
					<td width="70%" colspan="2">
						<input type="password" id="password" required/>
						<span style="font-size: 12" id="checkPassword"></span>
					</td>
				</tr>
				<tr>
					<td>
						确认密码：
					</td>
					<td colspan="2">
						<input type="password" id="confirmPassword" name="password" required />
						<span style="font-size: 12" id="checkConfirmPassword"></span>
					</td>
				</tr>
				<tr>
					<td>
						公司名称：
					</td>
					<td colspan="2">
						<input type="text" id="name" name="name" />
						<span style="font-size: 12" id="checkName"></span>
					</td>
				</tr>
				<tr>
					<td>
						地址：
					</td>
					<td colspan="2">
						<input type="text" id="address" name="address" />
					</td>
				</tr>
				<tr>
					<td>
						联系电话：
					</td>
					<td colspan="2">
						<input type="text" id="phone" name="phone" />
					</td>
				</tr>
				<tr>
					<td>
						邮箱地址：
					</td>
					<td colspan="2">
						<input type="text" id="email" name="email" />
					</td>
				</tr>
				<tr height="80px">
					<td colspan="2" align="center">
						&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
						&nbsp;
						<input type="image" onclick="regist()" src="images/registNew.jpg"
							height="30px">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
