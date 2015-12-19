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
            font-size: small;
        }
-->
</style>
</head>
<body>
<div align="center">选择查询日期：<input id="dateStart" value="${dateStart }"/>&nbsp;<input id="dateEnd" value="${dateEnd }"/>&nbsp;<button id="search" type="button">查询</button><input id="biuuu_button" type="button" value="打印"></input></div>
<div id="myPrintArea">
	<div align="center">
	<h2>手术明细表 愈合 乙</h2>
	<table width="754" border="1" align="center" bordercolor="#000000">
		<tr>
			<td width="81">住院号</td>
			<td width="81">姓名</td>
			<td width="100">科室</td>
			<td width="150">出院日期</td>
			<td width="201">已行手术</td>
			<td width="61">手术级别</td>
			<td width="34">愈合</td>
		</tr>
		<c:forEach items="${operationDetailList }" var="operationDetailList">
		<tr>
			<td>&nbsp;<c:out value="${operationDetailList.zhuYuanHao }"/></td>
			<td>&nbsp;<c:out value="${operationDetailList.xingMing }"/></td>
			<td>&nbsp;<c:out value="${operationDetailList.keShi }"/></td>
			<td>&nbsp;<fmt:formatDate value="${operationDetailList.chuYuanRiQi }" type="both"/></td>
			<td>&nbsp;<c:out value="${operationDetailList.yiXingShouShu }"/></td>
			<td>&nbsp;<c:out value="${operationDetailList.shouShuJiBie }"/></td>
			<td>&nbsp;<c:out value="${operationDetailList.yuHe }"/></td>
		</tr>
		</c:forEach>
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
			var url = "${contextPath }/report/search/dateStart/" + $("#dateStart").val() + "/dateEnd/" + $("#dateEnd").val() + "/parm/42";
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
