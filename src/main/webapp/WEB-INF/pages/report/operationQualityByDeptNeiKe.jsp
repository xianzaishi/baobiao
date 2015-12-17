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
	<h2>分科病人手术操作质量 内科</h2>
	<table width="1000" border="1">
	<tr>
	  <td width="99" rowspan="3"><div align="center">科室</div></td>
	  <td width="50" rowspan="3"><div align="center">手术病人数</div></td>
	  <td width="51" rowspan="3"><div align="center">手术人次数</div></td>
	  <td colspan="9"><div align="center">其中：切口愈合情况分布</div></td>
	  <td colspan="4"><div align="center">麻醉方式</div></td>
	  <td width="42" rowspan="3"><div align="center">无菌切口感染率（%）</div></td>
	  <td width="41" rowspan="3"><div align="center">无菌切口甲级愈合率（%）</div></td>
	  <td width="37" rowspan="3"><div align="center">术前人均住院日（天）</div></td>
	  <td width="54" rowspan="3"><div align="center">人均住院医疗费用（元）</div></td>
	</tr>
	<tr>
	  <td colspan="3"><div align="center">无菌切口（Ⅰ）</div></td>
	  <td colspan="3"><div align="center">无菌切口（Ⅱ）</div></td>
	  <td colspan="3"><div align="center">无菌切口（Ⅲ）</div></td>
	  <td width="29" rowspan="2"><div align="center">全麻</div></td>
	  <td width="30" rowspan="2"><div align="center">局麻</div></td>
	  <td width="30" rowspan="2"><div align="center">持硬</div></td>
	  <td width="30" rowspan="2"><div align="center">其他</div></td>
	</tr>
	<tr>
	  <td width="42"><div align="center">优良愈合（甲）</div></td>
	  <td width="42"><div align="center">愈合欠佳（乙）</div></td>
	  <td width="43"><div align="center">切口化脓（丙）</div></td>
	  <td width="40"><div align="center">优良愈合（甲）</div></td>
	  <td width="42"><div align="center">愈合欠佳（乙）</div></td>
	  <td width="44"><div align="center">切口化脓（丙）</div></td>
	  <td width="43"><div align="center">优良愈合（甲）</div></td>
	  <td width="41"><div align="center">优良愈合（乙）</div></td>
	  <td width="46"><div align="center">切口化脓（丙）</div></td>
	</tr>
	<c:forEach items="${operationQualityList }" var="operationQualityList">
	<tr>
	  <td>&nbsp;<c:out value="${operationQualityList.mingCheng }" /></td>
	  <td>&nbsp;<c:out value="${operationQualityList.bingRenShu }" /></td>
	  <td>&nbsp;<c:out value="${operationQualityList.shouShuCiShu }" /></td>
	  <td>&nbsp;<c:out value="${operationQualityList.jia1 }" /></td>
	  <td>&nbsp;<c:out value="${operationQualityList.yi1 }" /></td>
	  <td>&nbsp;<c:out value="${operationQualityList.bing1 }" /></td>
	  <td>&nbsp;<c:out value="${operationQualityList.jia2 }" /></td>
	  <td>&nbsp;<c:out value="${operationQualityList.yi2 }" /></td>
	  <td>&nbsp;<c:out value="${operationQualityList.bing2 }" /></td>
	  <td>&nbsp;<c:out value="${operationQualityList.jia3 }" /></td>
	  <td>&nbsp;<c:out value="${operationQualityList.yi3 }" /></td>
	  <td>&nbsp;<c:out value="${operationQualityList.bing3 }" /></td>
	  <td>&nbsp;<c:out value="${operationQualityList.quanMa }" /></td>
	  <td>&nbsp;<c:out value="${operationQualityList.juMa }" /></td>
	  <td>&nbsp;<c:out value="${operationQualityList.chiYing }" /></td>
	  <td>&nbsp;<c:out value="${operationQualityList.qiTa }" /></td>
		<c:choose>
			<c:when test="${operationQualityList.jia1+operationQualityList.yi1+operationQualityList.bing1 == 0 }">
				<td>&nbsp;<fmt:formatNumber type="number" value="" maxFractionDigits="2"/></td>
			</c:when>
			<c:otherwise>
				<td>&nbsp;<fmt:formatNumber type="number" value="${operationQualityList.bing1/(operationQualityList.jia1+operationQualityList.yi1+operationQualityList.bing1) *100 }" maxFractionDigits="2"/>%</td>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${operationQualityList.jia1+operationQualityList.yi1+operationQualityList.bing1 == 0 }">
				<td>&nbsp;<fmt:formatNumber type="number" value="" maxFractionDigits="2"/></td>
			</c:when>
			<c:otherwise>
				<td>&nbsp;<fmt:formatNumber type="number" value="${operationQualityList.jia1/(operationQualityList.jia1+operationQualityList.yi1+operationQualityList.bing1) *100 }" maxFractionDigits="2"/>%</td>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${operationQualityList.shouShuCiShu == 0 || operationQualityList.shouShuCiShu == null }">
				<td>&nbsp;<fmt:formatNumber type="number" value="" maxFractionDigits="2"/></td>
			</c:when>
			<c:otherwise>
				<td>&nbsp;<fmt:formatNumber type="number" value="${operationQualityList.shuQianRi/operationQualityList.shouShuCiShu }" maxFractionDigits="1"/></td>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${operationQualityList.bingRenShu == 0 || operationQualityList.bingRenShu == null }">
				<td>&nbsp;<fmt:formatNumber type="number" value="" maxFractionDigits="2"/></td>
			</c:when>
			<c:otherwise>
				<td>&nbsp;<fmt:formatNumber type="number" value="${operationQualityList.feiYong/operationQualityList.bingRenShu }" maxFractionDigits="2"/></td>
			</c:otherwise>
		</c:choose>
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
			var url = "${contextPath }/report/search/dateStart/" + $("#dateStart").val() + "/dateEnd/" + $("#dateEnd").val() + "/parm/43";
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
