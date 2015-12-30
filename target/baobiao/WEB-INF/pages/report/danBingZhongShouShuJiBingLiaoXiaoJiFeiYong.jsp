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
	<h2>单病种手术疾病疗效及费用</h2>
	<table width="903" border="1">
  <tr>
    <td width="65" rowspan="2">疾病编码</td>
    <td width="65" rowspan="2">疾病名称</td>
    <td colspan="5">出院病人数</td>
    <td colspan="6">病人付款方式(人)</td>
    <td width="33" rowspan="2">平均住院日数</td>
    <td colspan="5">平均每一出院病人住院医疗费(元)</td>
    <td width="50" rowspan="2">治愈病人医疗费</td>
  </tr>
  <tr>
    <td width="35">计</td>
    <td width="32">治愈</td>
    <td width="33">好转</td>
    <td width="29">未愈</td>
    <td width="27">死亡</td>
    <td width="39">计</td>
    <td width="32">社保</td>
    <td width="28">公疗</td>
    <td width="31">统筹</td>
    <td width="35">商保</td>
    <td width="25">自费</td>
    <td width="47">合计</td>
    <td width="40">床位费</td>
    <td width="44">药费</td>
    <td width="44">手术费</td>
    <td width="45">检查治疗费</td>
  </tr>
  <c:forEach items="${danBingZhongShouShuJiBingLiaoXiaoDtoList }" var="danBingZhongShouShuJiBingLiaoXiaoDtoList">
  <tr>
    <td>&nbsp;${danBingZhongShouShuJiBingLiaoXiaoDtoList.bianMa }</td>
    <td>&nbsp;${danBingZhongShouShuJiBingLiaoXiaoDtoList.mingCheng }</td>
    <td>&nbsp;${danBingZhongShouShuJiBingLiaoXiaoDtoList.bingRenShu }</td>
    <td>&nbsp;${danBingZhongShouShuJiBingLiaoXiaoDtoList.zhiYu }</td>
    <td>&nbsp;${danBingZhongShouShuJiBingLiaoXiaoDtoList.haoZhuan }</td>
    <td>&nbsp;${danBingZhongShouShuJiBingLiaoXiaoDtoList.weiYu }</td>
    <td>&nbsp;${danBingZhongShouShuJiBingLiaoXiaoDtoList.siWang }</td>
    <td>&nbsp;${danBingZhongShouShuJiBingLiaoXiaoDtoList.bingRenShu }</td>
    <td>&nbsp;${danBingZhongShouShuJiBingLiaoXiaoDtoList.sheBao }</td>
    <td>&nbsp;${danBingZhongShouShuJiBingLiaoXiaoDtoList.gongLiao }</td>
    <td>&nbsp;${danBingZhongShouShuJiBingLiaoXiaoDtoList.tongChou }</td>
    <td>&nbsp;${danBingZhongShouShuJiBingLiaoXiaoDtoList.shangBao }</td>
    <td>&nbsp;${danBingZhongShouShuJiBingLiaoXiaoDtoList.ziFei }</td>
    <td>&nbsp;<fmt:formatNumber type="number" value="${danBingZhongShouShuJiBingLiaoXiaoDtoList.chuangRiShu / danBingZhongShouShuJiBingLiaoXiaoDtoList.bingRenShu }" maxFractionDigits="2"/></td>
    <td>&nbsp;<fmt:formatNumber type="number" value="${danBingZhongShouShuJiBingLiaoXiaoDtoList.feiYongZongJi / danBingZhongShouShuJiBingLiaoXiaoDtoList.bingRenShu }" maxFractionDigits="2"/></td>
    <td>&nbsp;<fmt:formatNumber type="number" value="${danBingZhongShouShuJiBingLiaoXiaoDtoList.chuangWeiFei / danBingZhongShouShuJiBingLiaoXiaoDtoList.bingRenShu }" maxFractionDigits="2"/></td>
    <td>&nbsp;<fmt:formatNumber type="number" value="${danBingZhongShouShuJiBingLiaoXiaoDtoList.yaoFei / danBingZhongShouShuJiBingLiaoXiaoDtoList.bingRenShu }" maxFractionDigits="2"/></td>
    <td>&nbsp;<fmt:formatNumber type="number" value="${danBingZhongShouShuJiBingLiaoXiaoDtoList.shouShuFei / danBingZhongShouShuJiBingLiaoXiaoDtoList.bingRenShu }" maxFractionDigits="2"/></td>
    <td>&nbsp;<fmt:formatNumber type="number" value="${danBingZhongShouShuJiBingLiaoXiaoDtoList.jianChaFei / danBingZhongShouShuJiBingLiaoXiaoDtoList.bingRenShu }" maxFractionDigits="2"/></td>
    <td>&nbsp;${danBingZhongShouShuJiBingLiaoXiaoDtoList.zhiYuFei }</td>
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
			var url = "${contextPath }/report/search/dateStart/" + $("#dateStart").val() + "/dateEnd/" + $("#dateEnd").val() + "/parm/53";
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
