<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>index</title>
    <script src="Js/jquery-1.7.1.js"></script>
    <script src="Js/bootstrap.min.js"></script>
    <link href="Js/bootstrap.css" rel="stylesheet" type="text/css" />
    <script>
    	function commitParms(){
			var k = document.getElementById("k").value;
			var row = document.getElementById("row").value;
			var col = document.getElementById("col").value;
			
			if(k==""||row==""||col==""){
				alert("请输入必要参数");
				return;
			}
		$.ajax({
			type : "post",
			dataType : "html",
			url : "servlet/ChessBoardServlet",
			data : {
				k : k,
				row : row,
				col : col
			},
			success : function(value) {
				$("#ContentDiv").html(value);
			
			},
			error : function() {
				alert("ERROR");
			}
		});			
			
			
			
    	}
    
    </script>
    <style type="text/css">
    </style>
    
  </head>
  
  <body>
	<div id = "InputDiv">
		<span>棋盘规模K:</span> <input id = "k" type = "text">
		<span>特殊棋子所在行:</span> <input id = "row" type = "text">
		<span>特殊棋子所在列:</span> <input id = "col" type = "text">
		<input type="button" value = "提交" onClick = "commitParms()">
	</div>
	<div id = "ContentDiv">
		<!-- 
		
		<table id = 'table' class = 'table table-border' style='height: 60px;width: 60px'>
			
			<tr>
				<td style='height:20px;width:20px' >123<td>
				<td style='background:#000;height:20px;width:20px' >123<td>
				<td style='background:#000;height:20px;width:20px' >123<td>
			</tr>
			<tr>
				<td style='background:#000;height:20px;width:20px' >123<td>
				<td style='background:#000;height:20px;width:20px' >123<td>
				<td style='background:#000;height:20px;width:20px' >123<td>
			</tr>
			<tr>
				<td style='background:#000;height:20px;width:20px' >123<td>
				<td style='background:#000;height:20px;width:20px' >123<td>
				<td style='background:#000;height:20px;width:20px' >123<td>
			</tr>
		</table>
	 -->
	
	</div>
	
  </body>
</html>
