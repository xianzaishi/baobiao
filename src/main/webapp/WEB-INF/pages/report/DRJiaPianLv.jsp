<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>日报</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css" href="${contextPath}/css/business.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/css/datepicker.css" />

<script language="javascript" type="text/javascript" src="${contextPath}/script/jquery-1.7.2.min.js"></script>
<script language="javascript" type="text/javascript" src="${contextPath}/script/datepicker.js"></script>
<script language="javascript" type="text/javascript" src="${contextPath}/script/jquery.PrintArea.js"></script>
<script language="javascript" type="text/javascript" src="${contextPath}/script/highcharts/highcharts.js"></script>
<!-- <script language="javascript" type="text/javascript" src="${contextPath}/script/highcharts/highcharts-3d.js"></script> -->
<script language="javascript" type="text/javascript" src="${contextPath}/script/highcharts/exporting.js"></script>
<style type="text/css">
<!--
table
        {
            border-collapse: collapse;
            border: none;
            text-align:left;
        }
        td
        {
            border: solid #000 1px;
            font-size: large;
			font-weight: bold;
        }
-->
</style>
</head>
<body>
<div align="center">选择查询日期：<input id="dateStart" value="${dateStart }"/>&nbsp;<input id="dateEnd" value="${dateEnd }"/>&nbsp;<button id="search" type="button">查询</button><input id="biuuu_button" type="button" value="打印"></input></div>
<div id="myPrintArea">
	<div align="center">
	<table width="316" border="1" align="center" bordercolor="#000000">
		<tr>
			<td width="150">月份</td>
			<td width="150">dr甲片率(%)</td>
		</tr>
		<c:forEach items="${equipmentPositiveRateList }" var="equipmentPositiveRateList">
		<tr>
			<td>&nbsp;${equipmentPositiveRateList.month }</td>
			<td>&nbsp;<fmt:formatNumber type="number" value="${equipmentPositiveRateList.dr }" maxFractionDigits="2"/></td>
		</tr>
		</c:forEach>
	</table>
	
	
		<br/>
		<div align="center"><c:out value="${dateStart }"/></div>
	</div>
</div>
<div>
</div>
<div id="container" style="min-width: 300px; height: 400px; margin: 0 auto"></div>
<br/>
<div style="float:left; margin-left: 40px;">
	<br/>
	<p style="font-size:80%">大型设备检查阳性率=检查阳性人数÷检查人数。</p>
</div>
<script type="text/javascript">
$(function(){
	$("#dateStart").datepicker();
	$("#dateEnd").datepicker();
	
	//查询
	$("#search").click(function(){
		var dateStart = $("#dateStart").val();
		var dateEnd = $("#dateEnd").val();
		
		if(dateStart == "" || dateEnd == ""){
			alert("请输入正确的查询时间段");
		}else{
			var url = "${contextPath }/report/search/dateStart/" + $("#dateStart").val() + "/dateEnd/" + $("#dateEnd").val() + "/parm/15";
			window.location.href = url;
		}
	});
	
	//打印
	$("input#biuuu_button").click(function(){
		$("#myPrintArea").printArea(); 
	});
});

$(function () {
	$('#container').highcharts({ 
		chart: { 
			type: 'column' 
		}, 
		title: { 
			text: '大型设备阳性率' 
		}, 
		subtitle: { 
			text: '' 
		}, 
		xAxis: { 
			categories: [ '一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月' ] 
		}, 
		yAxis: { 
			min: 0, 
			title: { 
				text: 'Rainfall (mm)' 
			} 
		}, 
		plotOptions: { 
			column: { 
				pointPadding: 0.2, 
				borderWidth: 0 
			}
		}, 
		series: [${data }] 
	});
});
</script>
</body>
</html>
