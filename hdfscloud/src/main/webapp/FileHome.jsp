<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
   <meta charset="utf-8"> 
   <title>Bootstrap 实例 - 嵌套列</title>
   <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
   <script src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
   <script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <link id="bootstrap_221" rel="stylesheet" type="text/css" class="library" href="http://sandbox.runjs.cn/js/sandbox/bootstrap-2.2.1/css/bootstrap.min.css">
   <script id="jquery_172" type="text/javascript" class="library" src="http://sandbox.runjs.cn/js/sandbox/jquery/jquery-1.7.2.min.js"></script>
   <script id="bootstrap_221" type="text/javascript" class="library" src="http://sandbox.runjs.cn/js/sandbox/bootstrap-2.2.1/js/bootstrap.min.js"></script>
   <link rel="stylesheet" type="text/css" href="js/jquery/my.css">
<script type="text/javascript" src="js/jquery/tree2/my.js"></script>
</head>
<body>

<div class="container">
   <div class="row clearfix">
      <div class="col-md-3 column">
        <div class="tree well">
    <ul>
        <li>
            <span><i class="icon-folder-open"></i> Parent</span> <a href="">Goes somewhere</a>
            <ul>
                <li>
                  <span><i class="icon-minus-sign"></i> Child</span> <a href="">Goes somewhere</a>
                    <ul>
                        <li>
                           <span><i class="icon-leaf"></i> Grand Child</span> <a href="">Goes somewhere</a>
                        </li>
                    </ul>
                </li>
                <li>
                  <span><i class="icon-minus-sign"></i> Child</span> <a href="">Goes somewhere</a>
                    <ul>
                        <li>
                           <span><i class="icon-leaf"></i> Grand Child</span> <a href="">Goes somewhere</a>
                        </li>
                        <li>
                           <span><i class="icon-minus-sign"></i> Grand Child</span> <a href="">Goes somewhere</a>
                            <ul>
                                <li>
                                   <span><i class="icon-minus-sign"></i> Great Grand Child</span> <a href="">Goes somewhere</a>
                                  <ul>
                                      <li>
                                         <span><i class="icon-leaf"></i> Great great Grand Child</span> <a href="">Goes somewhere</a>
                                      </li>
                                      <li>
                                         <span><i class="icon-leaf"></i> Great great Grand Child</span> <a href="">Goes somewhere</a>
                                      </li>
                                   </ul>
                                </li>
                                <li>
                                   <span><i class="icon-leaf"></i> Great Grand Child</span> <a href="">Goes somewhere</a>
                                </li>
                                <li>
                                   <span><i class="icon-leaf"></i> Great Grand Child</span> <a href="">Goes somewhere</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                           <span><i class="icon-leaf"></i> Grand Child</span> <a href="">Goes somewhere</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>
        <li>
            <span><i class="icon-folder-open"></i> Parent2</span> <a href="">Goes somewhere</a>
            <ul>
                <li>
                  <span><i class="icon-leaf"></i> Child</span> <a href="">Goes somewhere</a>
              </li>
          </ul>
        </li>
    </ul>
</div>
      </div>
      <div class="col-md-9 column">
         <nav class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">Brand</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
               <ul class="nav navbar-nav">
                  <li class="active">
                      <a href="#">Link</a>
                  </li>
                  <li>
                      <a href="#">Link</a>
                  </li>
                  <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
                     <ul class="dropdown-menu">
                        <li>
                            <a href="#">Action</a>
                        </li>
                        <li>
                            <a href="#">Another action</a>
                        </li>
                        <li>
                            <a href="#">Something else here</a>
                        </li>
                        <li class="divider">
                        </li>
                        <li>
                            <a href="#">Separated link</a>
                        </li>
                        <li class="divider">
                        </li>
                        <li>
                            <a href="#">One more separated link</a>
                        </li>
                     </ul>
                  </li>
               </ul>
               <form class="navbar-form navbar-left" role="search">
                  <div class="form-group">
                     <input class="form-control" type="text" />
                  </div> <button type="submit" class="btn btn-default">Submit</button>
               </form>
               <ul class="nav navbar-nav navbar-right">
                  <li>
                      <a href="#">Link</a>
                  </li>
                  <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
                     <ul class="dropdown-menu">
                        <li>
                            <a href="#">Action</a>
                        </li>
                        <li>
                            <a href="#">Another action</a>
                        </li>
                        <li>
                            <a href="#">Something else here</a>
                        </li>
                        <li class="divider">
                        </li>
                        <li>
                            <a href="#">Separated link</a>
                        </li>
                     </ul>
                  </li>
               </ul>
            </div>
         </nav>
         <table class="table">
            <thead>
               <tr>
                  <th>
                     编号
                  </th>
                  <th>
                     产品
                  </th>
                  <th>
                     交付时间
                  </th>
                  <th>
                     状态
                  </th>
               </tr>
            </thead>
            <tbody>
               <tr>
                  <td>
                     1
                  </td>
                  <td>
                     TB - Monthly
                  </td>
                  <td>
                     01/04/2012
                  </td>
                  <td>
                     Default
                  </td>
               </tr>
               <tr class="success">
                  <td>
                     1
                  </td>
                  <td>
                     TB - Monthly
                  </td>
                  <td>
                     01/04/2012
                  </td>
                  <td>
                     Approved
                  </td>
               </tr>
               <tr class="error">
                  <td>
                     2
                  </td>
                  <td>
                     TB - Monthly
                  </td>
                  <td>
                     02/04/2012
                  </td>
                  <td>
                     Declined
                  </td>
               </tr>
               <tr class="warning">
                  <td>
                     3
                  </td>
                  <td>
                     TB - Monthly
                  </td>
                  <td>
                     03/04/2012
                  </td>
                  <td>
                     Pending
                  </td>
               </tr>
               <tr class="info">
                  <td>
                     4
                  </td>
                  <td>
                     TB - Monthly
                  </td>
                  <td>
                     04/04/2012
                  </td>
                  <td>
                     Call in to confirm
                  </td>
               </tr>
            </tbody>
         </table>
      </div>
   </div>
</div>

</body>
</html>