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
		<table width="817" border="1" align="center" bordercolor="#000000">
		  <tr>
		    <td colspan="2">手术冰冻与石蜡诊断符合例数</td>
		    <td width="479">&nbsp;</td>
		  </tr>
		  <tr>
		    <td colspan="2">恶性肿瘤手术前诊断与术后病理诊断符合例数</td>
		    <td>&nbsp;</td>
		  </tr>
		  <tr>
		    <td colspan="2">住院患者死亡例数</td>
		    <td>&nbsp;<fmt:formatNumber type="number" value="${zhuYuanSiWangShu }" maxFractionDigits="0"/></td>
		  </tr>
		  <tr>
		    <td colspan="2">住院患者自动出院例数</td>
		    <td>&nbsp;</td>
		  </tr>
		  <tr>
		    <td width="162" rowspan="2">住院手术</td>
		    <td width="154">例数</td>
		    <td>&nbsp;<fmt:formatNumber type="number" value="${zhuYuanShouShuLiShu }" maxFractionDigits="0"/></td>
		  </tr>
		  <tr>
		    <td>死亡例数</td>
		    <td>&nbsp;<fmt:formatNumber type="number" value="${zhuYuanShouShuSiWangShu }" maxFractionDigits="0"/></td>
		  </tr>
		  <tr>
		    <td rowspan="2">住院危重抢救</td>
		    <td>例数</td>
		    <td>&nbsp;<fmt:formatNumber type="number" value="${zhuYuanWeiZhongQiangQiu }" maxFractionDigits="0"/></td>
		  </tr>
		  <tr>
		    <td>死亡例数</td>
		    <td>&nbsp;<fmt:formatNumber type="number" value="${zhuYuanWeiZhongQiangQiuSiWang }" maxFractionDigits="0"/></td>
		  </tr>
		  <tr>
		    <td rowspan="2">急诊科危重抢救</td>
		    <td>例数</td>
		    <td>&nbsp;<fmt:formatNumber type="number" value="${jiZhenWeiZhongQiangJiu }" maxFractionDigits="0"/></td>
		  </tr>
		  <tr>
		    <td>死亡例数</td>
		    <td>&nbsp;<fmt:formatNumber type="number" value="${jiZhenWeiZhongQiangJiuSiWang }" maxFractionDigits="0"/></td>
		  </tr>
		  <tr>
		    <td rowspan="3">新生儿患者</td>
		    <td>出院人数</td>
		    <td>&nbsp;<fmt:formatNumber type="number" value="${xinShengErChuYuanShu }" maxFractionDigits="0"/></td>
		  </tr>
		  <tr>
		    <td>死亡人数</td>
		    <td>&nbsp;<fmt:formatNumber type="number" value="${xinShengErSiWangShu }" maxFractionDigits="0"/></td>
		  </tr>
		  <tr>
		    <td>死亡率</td>
		    <td>&nbsp;<fmt:formatNumber type="number" value="${xinShengErSiWangShu/xinShengErChuYuanShu * 100 }" maxFractionDigits="0"/>%</td>
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
		
		if(dateStart == "" || dateEnd == "" || dateStart > dateEnd){
			alert("请输入正确的查询时间段");
		}else{
			var url = "${contextPath }/report/search/dateStart/" + $("#dateStart").val() + "/dateEnd/" + $("#dateEnd").val() + "/parm/4";
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
