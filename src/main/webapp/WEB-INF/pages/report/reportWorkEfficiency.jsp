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
		<table width="768" border="1" align="center" bordercolor="#000000">
			<tr>
				<td width="210">出院患者平均住院日</td>
				<td width="210">&nbsp;<fmt:formatNumber type="number" value="${chuYuanPingJunZhuYuanRi }" maxFractionDigits="2"/></td>
				<td width="160">平均每张床位工作日</td>
				<td width="160">&nbsp;<fmt:formatNumber type="number" value="${chuYuanZongChuangRi / 1061 }" maxFractionDigits="0"/></td>
			</tr>
			<tr>
				<td>床位使用率</td>
				<td>&nbsp;<fmt:formatNumber type="number" value="${(shiYongChuangWeiTotal / 1061) * 100 }" maxFractionDigits="2"/>%</td>
				<td>床位周转次数</td>
				<td>&nbsp;<fmt:formatNumber type="number" value="${chuangWeiZhouZhuanCiShu }" maxFractionDigits="0"/></td>
			</tr>
		</table>
		<br/>
		<div align="center"><c:out value="${dateStart }"/> &nbsp;to&nbsp;<c:out value="${dateEnd }"/></div>
	</div>
	<div style="float:left; margin-left: 40px;">
		<br/>
		<p style="font-size:80%">出院患者平均住院日：出院患者占用总床日数÷出院人数。</p>
		<p style="font-size:80%">病床工作日：实际占用总床日数÷平均开放病床数。</p>
		<p style="font-size:80%">床位使用率=实际占用床日数÷实际开放床日数。</p>
		<p style="font-size:80%">病床周转次数=出院病人数÷平均开放床位数。</p>
	</div>
</div>
<br/>
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
			var url = "${contextPath }/report/search/dateStart/" + $("#dateStart").val() + "/dateEnd/" + $("#dateEnd").val() + "/parm/5";
			window.location.href = url;
		}
	});
	
	//打印
	$("input#biuuu_button").click(function(){
		$("#myPrintArea").printArea(); 
	});
});
</script>
</body>
</html>
