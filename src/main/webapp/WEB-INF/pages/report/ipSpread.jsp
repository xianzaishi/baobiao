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
<div id="myPrintArea">
	<div align="center">
		<h1>在院病人分布</h1>
		<table width="622" border="1" align="center" bordercolor="#000000">
		  <tr>
		    <td width="200">名称</td>
		    <td width="200">人数</td>
		    <td width="200">比例</td>
		  </tr>
		  <c:forEach items="${zaiYuanBingRenFenBuList }" var="zaiYuanBingRenFenBuList">
			  <tr>
			    <td>&nbsp;${zaiYuanBingRenFenBuList.name }</td>
			    <td>&nbsp;<fmt:formatNumber type="number" value="${zaiYuanBingRenFenBuList.count }" maxFractionDigits="2"/></td>
			    <td>&nbsp;<fmt:formatNumber type="number" value="${zaiYuanBingRenFenBuList.scale }" maxFractionDigits="2"/></td>
			  </tr>
		   </c:forEach>
		   		<tr>
			    <td>&nbsp;总计</td>
			    <td>&nbsp;<fmt:formatNumber type="number" value="${sum }" maxFractionDigits="2"/></td>
			    <td>&nbsp;</td>
			  </tr>
		</table>	
			
		<br/>
		<div align="center"><c:out value="${dateStart }"/></div>
	</div>
</div>
<div id="container" style="min-width: 300px; height: 400px; margin: 0 auto"></div>
<br/>
<script type="text/javascript">
$(function(){
	//打印
	$("input#biuuu_button").click(function(){
		$("#myPrintArea").printArea(); 
	});
});

$(function () {
    $('#container').highcharts({
        chart: {
            type: 'column',
            margin: 75,
            options3d: {
                enabled: true,
                alpha: 10,
                beta: 25,
                depth: 70
            }
        },
        title: {
            text: '在院病人分布'
        },
        plotOptions: {
            column: {
                depth: 25
            }
        },
        xAxis: {
        	type: 'category'
        },
        yAxis: {
            title: {
                text: '人数'
            }
        },
        series: [{
            name: ' ',
            data: [${data}]
        }]
    });
});
</script>
</body>
</html>
