<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="Js/jquery-1.7.1.js"></script>
<script src="Js/bootstrap.min.js"></script>
<link href="Js/bootstrap.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
    	function commitDNA(){
    		var DNA1 = document.getElementById("DNA1").value;
			var DNA2 = document.getElementById("DNA2").value;
			
			if(DNA1==""||DNA2==""){
				alert("请输入必要数据");
				return;
			}
			
			$.ajax({
			type : "post",
			dataType : "html",
			url : "servlet/DNAServlet",
			data : {
				DNA1 : DNA1,
				DNA2 : DNA2,
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
    #couseTable {
    	width: 25%
    }
    
    </style>

<title>DNA</title>
</head>
<body>
	<div>
		<span>DNA1</span> <input id="DNA1" type="text"> <span>DNA2</span>
		<input id="DNA2" type="text"> <input type="button" value="提交"
			onClick="commitDNA()">
	</div>
	<div style="padding-top: 20px">
		<span>分数参照</span>
		<table class="table table-bordered" id="couseTable">

			<thead>
				<tr>
					<th> </th>
					<th>A</th>
					<th>G</th>
					<th>C</th>
					<th>T</th>
					<th>-</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>A</th>
					<th>5</th>
					<th>-1</th>
					<th>-2</th>
					<th>-1</th>
					<th>-3</th>
				</tr>
				<tr>
					<th>C</th>
					<th>-1</th>
					<th>5</th>
					<th>-3</th>
					<th>-2</th>
					<th>-4</th>
				</tr>
				<tr>
					<th>G</th>
					<th>-2</th>
					<th>-3</th>
					<th>5</th>
					<th>-2</th>
					<th>-2</th>
				</tr>
				<tr>
					<th>T</th>
					<th>-1</th>
					<th>-2</th>
					<th>-2</th>
					<th>5</th>
					<th>-1</th>
				</tr>
				<tr>
					<th>-</th>
					<th>-3</th>
					<th>-4</th>
					<th>-2</th>
					<th>1</th>
					<th>*</th>
				</tr>

			</tbody>

		</table>
	</div>


	<div id="ContentDiv"></div>


</body>
</html>