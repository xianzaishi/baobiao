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
		<table width="845" height="125" border="1" align="center" bordercolor="#000000">
		  <tr>
		    <td width="125" height="40">门诊人次</td>
		    <td width="125">&nbsp;<fmt:formatNumber type="number" value="${menZhenRenCiTotal }" maxFractionDigits="0"/></td>
		    <td width="125">健康体检人次</td>
		    <td width="125">&nbsp;<fmt:formatNumber type="number" value="${tiJianRenCi }" maxFractionDigits="0"/></td>
		    <td width="180">急诊人次</td>
		    <td width="125">&nbsp;<fmt:formatNumber type="number" value="${jiZhenRenCiTotal }" maxFractionDigits="0"/></td>
		  </tr>
		  <tr>
		    <td height="39">留观人次</td>
		    <td>&nbsp;<fmt:formatNumber type="number" value="${liuGuanRenCi }" maxFractionDigits="0"/></td>
		    <td>住院患者入院例数</td>
		    <td>&nbsp;<fmt:formatNumber type="number" value="${ruYuanRenShu }" maxFractionDigits="0"/></td>
		    <td>住院患者出院例数</td>
		    <td>&nbsp;<fmt:formatNumber type="number" value="${chuYuanRenShu }" maxFractionDigits="0"/></td>
		  </tr>
		  <tr>
		    <td height="36">出院患者实际占用总床日</td>
		    <td>&nbsp;<fmt:formatNumber type="number" value="${chuYuanZongChuangRi }" maxFractionDigits="0"/></td>
		    <td>住院手术例数</td>
		    <td>&nbsp;<fmt:formatNumber type="number" value="${zhuYuanShouShuLiShu }" maxFractionDigits="0"/></td>
		    <td>门诊手术例数</td>
		    <td>&nbsp;<fmt:formatNumber type="number" value="${menZhenShouShuLiShu }" maxFractionDigits="0"/></td>
		  </tr>
		  <tr>
		  	<td>心电彩超例数</td>
		  	<td>${xinDianCaiChaoLiShu }</td>
		  	<td></td>
		  	<td></td>
		  	<td></td>
		  	<td></td>
		  </tr>
		</table>
		<br/>
		<div align="center"><c:out value="${dateStart }"/> &nbsp;to&nbsp;<c:out value="${dateEnd }"/></div>
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
			var url = "${contextPath }/report/search/dateStart/" + $("#dateStart").val() + "/dateEnd/" + $("#dateEnd").val() + "/parm/3";
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
