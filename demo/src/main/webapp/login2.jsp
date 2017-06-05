<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="js/jquery/login/css/demo.css" />
<link rel="stylesheet" type="text/css"
	href="js/jquery/login/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="js/jquery/login/css/animate-custom.css" />
</head>
<body>
	<div class="container">
		<header>
			<h1>
				防伪溯源大数据平台<span>登录和注册</span>
			</h1>
		</header>
		<section>
			<div id="container_demo">
				<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor"
					id="tologin"></a>
				<div id="wrapper">
					<div id="login" class="animate form">
						<form action="CheckUser" method="post">
							 <h1>企业用户</h1>
							<p>
								<label for="username" class="uname" data-icon="u"> Your
									email or username </label> <input id="username" name="username"
									required="required" type="text"
									placeholder="myusername or mymail@mail.com" />
							</p>
							<p>
								<label for="password" class="youpasswd" data-icon="p">
									Your password </label> <input id="password" name="password"
									required="required" type="password" placeholder="eg. X8df!90EO" />
										 <input  name="type"  value="demo" 
									 type="hidden"  />
									  <input  name="usertype"  value="companyUser" 
									 type="hidden"  />
							<!--  p>
								<label for="exampleInputFile">File input</label>
								<input name="file" type="file" enctype="multipart/form-data"/>
							</p-->
							<p class="keeplogin">
								<input type="checkbox" name="loginkeeping" id="loginkeeping"
									value="loginkeeping" /> <label for="loginkeeping">Keep
									me logged in</label>
							</p> 
							<p class="login button">
								<input type="submit" value="Login" />
							</p>
							<p class="change_link">
								commonUser ? <a href="login.jsp" class="to_register">
									Click here</a>
							</p>
								
							
							<p class="change_link">
							<a href="login.jsp" class="to_register">
									commonUser</a>
									<a href="login3.jsp" class="to_register">
									admin</a>
										&nbsp Not a member yet ? <a href="#toregister" class="to_register">Join
									us</a>
							</p>
						</form>
					</div>

					<div id="register" class="animate form">
						<form action="RegistServlet" method="post">
							<h1>Sign up</h1>
							<p>
								<label for="usernamesignup" class="uname" data-icon="u">Your
									username</label> <input id="usernamesignup" name="usernamesignup"
									required="required" type="text"
									placeholder="mysuperusername690" />
							</p>
							<p>
								<label for="emailsignup" class="youmail" data-icon="e">
									Your email</label> <input id="emailsignup" name="emailsignup"
									required="required" type="email"
									placeholder="mysupermail@mail.com" />
							</p>
							<p>
								<label for="passwordsignup" class="youpasswd" data-icon="p">Your
									password </label> <input id="passwordsignup" name="passwordsignup"
									required="required" type="password" placeholder="eg. X8df!90EO" />
							</p>
							<p>
								<label for="passwordsignup_confirm" class="youpasswd"
									data-icon="p">Please confirm your password </label> <input
									id="passwordsignup_confirm" name="passwordsignup_confirm"
									required="required" type="password" placeholder="eg. X8df!90EO" />
							</p>
							
				<p class="signin button">
									<input type="submit" value="Sign up" />
							</p>

                                <p class="change_link">  
									Already a member ?
									<a href="#login.jsp" class="to_register"> Go and log in </a>
								</p>
                            </form>
                        </div>
						
                    </div>
                </div>  
            </section>
        </div>
  
    </body>
</html>