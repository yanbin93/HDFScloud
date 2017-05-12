<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.io.*,java.util.*"  import="com.hdfscloud.model.File"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="js/jquery/bootstrap/css/bootstrap.min.css" />
<script src="js/jquery/bootstrap/jquery/jquery-2.1.1.min.js" />
<script src="js/jquery/bootstrap/js/bootstrap.min.js" />
<link id="bootstrap_221" rel="stylesheet" type="text/css" class="library" href="http://sandbox.runjs.cn/js/sandbox/bootstrap-2.2.1/css/bootstrap.min.css">
	<script id="jquery_172" type="text/javascript" class="library" src="http://sandbox.runjs.cn/js/sandbox/jquery/jquery-1.7.2.min.js"></script>
	<script id="bootstrap_221" type="text/javascript" class="library" src="http://sandbox.runjs.cn/js/sandbox/bootstrap-2.2.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="js/jquery/my.css">
<script type="text/javascript" src="js/jquery/tree2/my.js"></script>
</head>
<body>
<<div class="container">
<div class="row clearfix">
<div class="col-md-12 column">
      <h3>
        Hadoop云盘系统
      </h3>
    </div>
    </div>
    <div class="row clearfix">
<div class="col-md-3">
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

<div class="col-md-9 ">
<%
    	List<File> list=(List<File>)request.getAttribute("list");
    	if (list==null||list.size()<1){
    	out.print("没有数据！");
    	}
    	else {
    	%> 
			<table class="table">
				<thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							名称
						</th>
						<th>
							类型
						</th>
						<th>
							大小
						</th>
					</tr>
				</thead>
				<tbody>
				<%
		String[] classes={"error","success","error","warning","error","info"};
		String cla;
    	for(int i=0;i<list.size();i++)
    		
    	{
    		File file = list.get(i);
    		cla=classes[i%6];
    	%>
					<tr class=<%=cla%>>
						<td>
							<%=i+1%>
						</td>
						<td>
						<%=file.getName()%>
						</td>
						<td>
						<%=file.getType()%>
						</td>
						<td>
						<%=Long.toString(file.getSize())+" KB"%>
						</td>
					</tr>
					<%
					}
    	}
					%>
				</tbody>
			</table>
			<%
				int pageNow = Integer.parseInt(request.getAttribute("pageNow").toString());
				int pageCount = Integer.parseInt(request.getAttribute("pageCount").toString());
				out.println("<ul class=pagination>");
				if (pageNow != 1) {
					out.println("<li><a href=FindFile?pageNow=" + (pageNow - 1) + ">Prev</a></li>");
				}
				for (int i = 1; i <= pageCount; i++) {
					out.println("<li><a href=FindFile?pageNow=" + i + ">" + i + "</a></li>");
				}
				if (pageNow != pageCount) {
					out.println("<li><a href=FindFile?pageNow=" + (pageNow + 1) + ">Next</a></li>");
				}
				out.println("</ul>");
			%>
</div>
</div>
</div>
</body>
</html>