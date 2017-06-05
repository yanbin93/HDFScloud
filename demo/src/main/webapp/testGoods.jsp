<%@ page language="java"  import="com.demo.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Basic DataGrid - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="js/jquery/easyui/themes/default/easyui.css">  
<link rel="stylesheet" type="text/css" href="js/jquery/easyui/themes/icon.css">  
<link rel="stylesheet" type="text/css" href="js/jquery/easyui/demo/demo.css">  
<script type="text/javascript" src="js/jquery/easyui/jquery.min.js"></script>  
<script type="text/javascript" src="js/jquery/easyui/jquery.easyui.min.js"></script>  
    <script type="text/javascript" src="js/jquery/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="js/jquery/easyui/jquery.edatagrid.js"></script>
            <script type="text/javascript" src="js/jquery/d3/d3.js"></script>
                 <script type="text/javascript" src="js/jquery/d3/d3.layout.cloud.js"></script>
                 <script type="text/javascript" src="js/jquery/qrcode/jquery.qrcode.min.js"></script> 
    <script>
  
 	   $(function(){
 			 $('#dg').edatagrid({
            url: 'testGoodsServlet?type=list',
            saveUrl: 'testGoodsServlet?type=save',
            updateUrl: 'testGoodsServlet?type=save',
            destroyUrl: 'testGoodsServlet?type=delete'
        });
 			 $('#PageRefresh').click(function() {
 		         location.reload();});
 	   });
 	   
  	  function searchId(){
  		 var searchid=$("#searchid").val();
  		 if (searchid==""){$.messager.alert("系统提示","请输入批次号！！！");return;}
  		  $('#dg').datagrid({
  	           url: 'testGoodsServlet?type=idsearch&searchid='+searchid
  	       });
  	  }
 	  function searchName(){
   		 var searchname=$("#searchname").val();
   		 if (searchname==""){$.messager.alert("系统提示","请输入产品名称！！！");return;}
   		  $('#dg').datagrid({
   	           url: 'testGoodsServlet?type=namesearch&searchname='+searchname
   	       });
   	  }

 	  function avg(){
 			$.getJSON("testGoodsServlet?type=avg", function(result){
 	 			$.each(result.rows,function(i,items) {
 	 				$.messager.alert("批次平均销量为",items.average);
 	 				});
 			});
 
 	  }
 	  function variance(){
			$.getJSON("testGoodsServlet?type=var", function(result){
	 			$.each(result.rows,function(i,items) {
	 				$.messager.alert("批次销量方差为",items.vari);
	 				});
			});

	  }
 	 function qrCode(){
 		var row = $("#dg").datagrid('getSelected');
 		var searchid = row.productid;
 		var qrcontent = "http://www.fangwei.com?productid="+searchid;
 	   $('#dlg').dialog({  
           title: '二维码',  
           width: 400,  
           height:400,  
           resizable:true,  
           closed: false,  
           cache: false,  
           modal: true  
       });  
 	 	$('#code').qrcode(qrcontent);
 	 }
    </script>
   
    <style> 
body{ text-align:center} 
.div{ margin:0 auto; width:400px; height:100px; border:1px solid #F00} 
/* css注释：为了观察效果设置宽度 边框 高度等样式 */ 
</style>
</head>
<body >
    <table id="dg" title="用户管理" class="easyui-datagrid"
            toolbar="#toolbar" pagination="true" idField="id" 
            rownumbers="true" fitColumns="true" singleSelect="true"  sortOrder="asc" >
        <thead>
            <tr>
            	<th data-options="field:'ck',checkbox:true"></th>
            	<th field="id" width="50" sortable="true" editor="{type:'validatebox',options:{required:true}}" editor="{type:'validatebox',options:{required:true}}" >商品id</th>
                <th field="productname" width="50" sortable="true" editor="{type:'validatebox',options:{required:true}}" editor="{type:'validatebox',options:{required:true}}" >商品名称</th>
                <th field="productid" width="50" editor="{type:'validatebox',options:{required:false}}">产品批次号</th>
                <th field="productno" width="50" editor="{type:'validatebox',options:{required:false}}">货号</th>
        </thead>
        </tr>
    </table>
     <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$('#dg').edatagrid('addRow')">添加</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:$('#dg').edatagrid('destroyRow')">删除</a>
         <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="deleteRows()">批量删除</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:$('#dg').edatagrid('saveRow')">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#dg').edatagrid('cancelRow')">撤销</a>
         <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="qrCode()">生成二维码</a>
        	<button id="PageRefresh" class="easyui-linkbutton" iconCls="icon-reload">重新加载</button>
        	<div>
        	<input id="searchid" name="searchid" class="easyui-validatebox" value="1" required="true"  style="width: 200px;" onkeyup="this.value=this.value.replace(/\D/g,'')"
    onafterpaste="this.value=this.value.replace(/\D/g,'')">
         <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="javascript:searchId()">批次号查询</a>
         <input id="searchname" name="searchname" class="easyui-validatebox" required="true"  style="width: 200px;" >
         <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="javascript:searchName()">产品名称查询</a>
                    <input id="n" name="searchname" class="easyui-validatebox" required="true"  style="width: 200px;" >
      <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="javascript:topN()">TopN</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="javascript:topNlist()">TopNList</a>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="javascript:avg()">批次平均销量</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="javascript:variance()">批次销量方差</a>
         </div>
          
    </div>
<div id="dlg" class="easyui-dialog" style="width:400px;height:250px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons"><div id="code"></div> </div>
   <div  style="width:100%;height:50%; padding:100px;">
   <div id="pic" ></div>
       
   </div>
	 <script type="text/javascript">
	  function topNlist(){
 		 var n=$("#n").val();
 		 if (n==""){$.messager.alert("系统提示","请输入topN！！！");return;}
 		  $('#dg').datagrid({
 	           url: 'testGoodsServlet?type=topnlist&n='+n
 	       });
 	  }
	 function topN(){
		 $("#pic").empty();
		 var n=$("#n").val();
		 if (n==""){$.messager.alert("系统提示","请输入topN！！！");return;}
    var fill = d3.scale.category20();
    var topurl="testGoodsServlet?type=topn&n="+n;
    d3.json(topurl, function(data) {
    	 // alert(data.result);
        d3.layout.cloud().size([500, 500]).words(
          data.result
          )
          .rotate(function() {
            return ~~(Math.random() * 2) * 90;
          })
          .font("Impact")
          .fontSize(function(d) {
            return d.size*0.25;
          })
          .on("end", draw)
          .start();

        function draw(words) {
          console.log(words);
          d3.select("#pic").append("svg")
            .attr("width", 800)jjjj
            .attr("height", 800)
            .append("g")
            .attr("transform", "translate(150,150)")
            .selectAll("text")
            .data(words)
            .enter().append("text")
             .style("border","3px solid blue")
            .style("font-size", function(d) {
              return d.size + "px";
            })
            .style("font-family", "Impact")
            .style("fill", function(d, i) {
              return fill(i);
            })
            .attr("text-anchor", "middle")
            .attr("transform", function(d) {
              return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
            })
            .text(function(d) {
              return d.text;
            });
        }
      });
          }
  </script>
</body>
</html>