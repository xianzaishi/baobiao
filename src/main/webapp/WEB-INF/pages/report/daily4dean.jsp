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
<fmt:setLocale value="zh"/>
<style type="text/css">
<!--
.STYLE1 {
	font-size: xx-large;
	font-weight: bold;
}
.STYLE2 {font-size: large}
.STYLE3 {font-size: x-large}
.STYLE5 {font-size: large; font-weight: bold; }
.STYLE6 {font-size: x-large; font-weight: bold; }
table
        {
            border-collapse: collapse;
            border: none;
            text-align:left;
        }
        td
        {
            border: solid #000 1px;
        }
-->
</style>
</head>

<body>
<div align="center">
<div>选择查询日期：<input id="dateStart" value="${dateStart }"/>&nbsp;<input id="dateEnd" value="${dateEnd }"/>&nbsp;<button id="search" type="button">查询</button><input id="biuuu_button" type="button" value="打印"></input></div>
<div id="myPrintArea">
<table width="834" height="636" border="1" bordercolor="#000000">
  <tr>
    <td colspan="11"><div align="center" class="STYLE1">院长日报</div></td>
  </tr>
  <tr>
    <td height="29" colspan="2"><span class="STYLE5">总收入</span></td><td width="183"><span class="STYLE5">￥<fmt:formatNumber type="number" value="${sum }" maxFractionDigits="2"/></span></td>
    <td colspan="8"><div align="right"><strong><span class="STYLE2"><c:out value="${dateStart }"/> &nbsp;to&nbsp;<c:out value="${dateEnd }"/></span></strong></div></td>
  </tr>
  <tr>
    <td height="28" colspan="11"><div align="center"><strong><span class="STYLE3">门诊部分</span></strong></div></td>
  </tr>
  <tr>
    <td colspan="2" rowspan="2"><span class="STYLE5">门诊收入</span></td><td rowspan="2"><span class="STYLE5">￥<fmt:formatNumber type="number" value="${opTotal }" maxFractionDigits="2"/></span></td>
    <td colspan="3"><span class="STYLE5">药品收入</span></td><td colspan="5"><span class="STYLE5">￥<fmt:formatNumber type="number" value="${opDrugsTotal }" maxFractionDigits="2"/></span></td>
  </tr>
  <tr>
    <td height="28" colspan="3"><span class="STYLE5">诊疗收入</span></td><td colspan="5"><span class="STYLE5">￥<fmt:formatNumber type="number" value="${opTreatmentTotal }" maxFractionDigits="2"/></span></td>
  </tr>
  <tr>
    <td colspan="2" rowspan="2"><span class="STYLE5">医保收入</span></td><td rowspan="2"><span class="STYLE5">￥<fmt:formatNumber type="number" value="${opBaoXianTotal }" maxFractionDigits="2"/></span></td>
    <td colspan="3"><span class="STYLE5">现金收入</span></td><td colspan="5"><span class="STYLE5">￥<fmt:formatNumber type="number" value="${opBaoXianTotal - opTongChouTotal }" maxFractionDigits="2"/></span></td>
  </tr>
  <tr>
    <td height="24" colspan="3"><span class="STYLE5">医保收入</span></td><td colspan="5"><span class="STYLE5">￥<fmt:formatNumber type="number" value="${opTongChouTotal }" maxFractionDigits="2"/></span></td>
  </tr>
  <tr>
    <td colspan="2" rowspan="2"><span class="STYLE5">门急诊人次</span></td><td rowspan="2"><span class="STYLE5"><fmt:formatNumber type="number" value="${menJiZhenRenCiTotal }" maxFractionDigits="0"/></span></td>
    <td colspan="2"><span class="STYLE5">门诊人次</span></td><td><span class="STYLE5"><fmt:formatNumber type="number" value="${menZhenRenCiTotal }" maxFractionDigits="0"/></span></td>
    <td colspan="2"><span class="STYLE5">医保人次</span></td><td colspan="3"><span class="STYLE5"><fmt:formatNumber type="number" value="${menZhenYiBaoTotal }" maxFractionDigits="0"/></span></td>
  </tr>
  <tr>
    <td colspan="2"><span class="STYLE5">急诊人次</span></td><td><span class="STYLE5"><fmt:formatNumber type="number" value="${jiZhenRenCiTotal }" maxFractionDigits="0"/></span></td>
    <td colspan="2"><span class="STYLE5">自费人次</span></td><td colspan="3"><span class="STYLE5"><fmt:formatNumber type="number" value="${menZhenZiFeiTotal }" maxFractionDigits="0"/></span></td>
  </tr>
  <tr>
    <td height="28" colspan="2"><span class="STYLE5">出诊医生</span></td><td><span class="STYLE5"><fmt:formatNumber type="number" value="${chuZhenYiShengTotal }" maxFractionDigits="0"/></span></td>
    <td colspan="2"><span class="STYLE5"></span></td><td width="89"><span class="STYLE5"></span></td>
    <td colspan="2"><span class="STYLE5">医保自费比例</span></td><td colspan="3"><span class="STYLE5"><fmt:formatNumber type="number" value="${(menZhenYiBaoTotal / menJiZhenRenCiTotal) * 100}" maxFractionDigits="2"/>%</span></td>
  </tr>
  <tr>
    <td height="27" colspan="2"><span class="STYLE5">平均费用</span></td><td><span class="STYLE5">￥<fmt:formatNumber type="number" value="${opTotal / menJiZhenRenCiTotal }" maxFractionDigits="2"/></span></td>
    <td colspan="2"><span class="STYLE5">处方数量</span></td><td><span class="STYLE5"><fmt:formatNumber type="number" value="${chuFangTotal }" maxFractionDigits="0"/></span></td>
    <td colspan="2"><span class="STYLE5">退费金额</span></td><td colspan="3"><span class="STYLE5">￥<fmt:formatNumber type="number" value="${menZhenTuiFeiTotal }" maxFractionDigits="2"/></span></td>
  </tr>
  <tr>
    <td height="28" colspan="2"><span class="STYLE5">人均药费</span></td><td><span class="STYLE5">￥<fmt:formatNumber type="number" value="${opDrugsTotal / menJiZhenRenCiTotal }" maxFractionDigits="2"/></span></td>
    <td colspan="3"><span class="STYLE5">抗菌素人次比</span></td><td colspan="5"><span class="STYLE5"><fmt:formatNumber type="number" value="${menZhenKangShengSuTotal / menJiZhenRenCiTotal }" maxFractionDigits="2"/></span></td>
  </tr>
  <tr>
    <td height="29" colspan="11"><div align="center" class="STYLE6">住院部分</div></td>
  </tr>
  <tr>
    <td height="38" colspan="2"><span class="STYLE5">入院人数</span></td><td><span class="STYLE5"><fmt:formatNumber type="number" value="${ruYuanTotal }" maxFractionDigits="0"/></span></td>
    <td colspan="2"><span class="STYLE5">在院人数</span></td><td><span class="STYLE5"><fmt:formatNumber type="number" value="${zaiYuanTotal }" maxFractionDigits="0"/></span></td>
    <td colspan="2"><span class="STYLE5">出院人数</span></td><td colspan="3"><span class="STYLE5"><fmt:formatNumber type="number" value="${chuYuanTotal }" maxFractionDigits="0"/></span></td>
  </tr>
  <tr>
    <td width="30" rowspan="3"><span class="STYLE5">其中</span></td>
    <td width="105" height="33"><span class="STYLE5">医保人数</span></td><td><span class="STYLE5"><fmt:formatNumber type="number" value="${ruYuanAndYiBaoTotal }" maxFractionDigits="0"/></span></td>
    <td width="28" rowspan="3"><span class="STYLE5">其中</span></td>
    <td width="84"><span class="STYLE5">医保人数</span></td><td><span class="STYLE5"><fmt:formatNumber type="number" value="${zaiYuanAndYiBaoTotal }" maxFractionDigits="0"/></span></td>
    <td width="28" rowspan="3"><span class="STYLE5">其中</span></td>
    <td width="84"><span class="STYLE5">医保人数</span></td><td colspan="3"><span class="STYLE5"><fmt:formatNumber type="number" value="${chuYuanAndYiBaoTotal }" maxFractionDigits="0"/></span></td>
  </tr>
  <tr>
    <td width="105" height="32" rowspan="2"><span class="STYLE5">自费人数</span></td><td rowspan="2"><span class="STYLE5"><fmt:formatNumber type="number" value="${ruYuanAndZiFeiTotal }" maxFractionDigits="0"/></span></td>
    <td width="84"><span class="STYLE5">自费人数</span></td><td><span class="STYLE5"><fmt:formatNumber type="number" value="${zaiYuanAndZiFeiTotal }" maxFractionDigits="0"/></span></td>
    <td width="84" rowspan="2"><span class="STYLE5">自费人数</span></td><td colspan="3" rowspan="2"><span class="STYLE5"><fmt:formatNumber type="number" value="${chuYuanAndZiFeiTotal }" maxFractionDigits="0"/></span></td>
  </tr>
  <tr>
    <td><span class="STYLE5">血透人数</span></td>
    <td><span class="STYLE5"><fmt:formatNumber type="number" value="${zaiYuanAndXueTouTotal }" maxFractionDigits="2"/></span></td>
  </tr>
  <tr>
    <td height="36" colspan="2"><span class="STYLE5">开放床位</span></td><td><span class="STYLE5">1061</span></td>
    <td colspan="2"><span class="STYLE5">使用床位</span></td><td><span class="STYLE5"><fmt:formatNumber type="number" value="${shiYongChuangWeiTotal }" maxFractionDigits="2"/></span></td>
    <td colspan="2"><span class="STYLE5">床位使用率</span></td><td colspan="3"><span class="STYLE5"><fmt:formatNumber type="number" value="${(shiYongChuangWeiTotal / 1061) * 100 }" maxFractionDigits="2"/>%</span></td>
  </tr>
  <tr>
    <td height="32" colspan="2"><span class="STYLE5">住院收入</span></td><td><span class="STYLE5">￥<fmt:formatNumber type="number" value="${ipTotal }" maxFractionDigits="2"/></span></td>
    <td colspan="2"><span class="STYLE5">药品收入</span></td><td><span class="STYLE5">￥<fmt:formatNumber type="number" value="${ipDrugsTotal }" maxFractionDigits="2"/></span></td>
    <td colspan="2"><span class="STYLE5">诊疗收入</span></td><td colspan="3"><span class="STYLE5">￥<fmt:formatNumber type="number" value="${ipTreatmentTotal }" maxFractionDigits="2"/></span></td>
  </tr>
  <tr>
    <td height="32" colspan="2"><span class="STYLE5">医保收入</span></td><td><span class="STYLE5">￥<fmt:formatNumber type="number" value="${ipBaoXianTotal }" maxFractionDigits="2"/></span></td>
    <td colspan="2"><span class="STYLE5">医保支付</span></td><td><span class="STYLE5">￥<fmt:formatNumber type="number" value="${ipTongChouTotal }" maxFractionDigits="2"/></span></td>
    <td colspan="2"><span class="STYLE5">现金收入</span></td><td colspan="3"><span class="STYLE5">￥<fmt:formatNumber type="number" value="${ipBaoXianXianJinTotal }" maxFractionDigits="2"/></span></td>
  </tr>
  <tr>
    <td height="33" colspan="2"><span class="STYLE5">药品比例</span></td><td><span class="STYLE5"><fmt:formatNumber type="number" value="${(ipDrugsTotal / ipTotal) * 100 }" maxFractionDigits="2"/>%</span></td>
    <td colspan="2"><span class="STYLE5">医保自费比例</span></td><td><span class="STYLE5"><fmt:formatNumber type="number" value="${(ipBaoXianXianJinTotal / ipBaoXianTotal) * 100 }" maxFractionDigits="2"/>%</span></td>
    <td colspan="2"><span class="STYLE5">血透收入</span></td><td colspan="3"><span class="STYLE5">￥<fmt:formatNumber type="number" value="${queryXueTouShouRu }" maxFractionDigits="2"/></span></td>
  </tr>
  <!-- 
  <tr>
    <td height="31" colspan="2"><span class="STYLE5">血透收入</span></td><td colspan="9"><span class="STYLE5"></span></td>
  </tr>
   -->
</table>
	<div style="float:left; margin-left: 40px;">
		<br/>
		<p style="font-size:80%">医疗收入占业务收入的比重=医疗收入÷（医疗收入+药品收入+其他收入）×100%。</p>
	</div>
</div>
</div>
</body>
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
			var url = "${contextPath }/report/search/dateStart/" + $("#dateStart").val() + "/dateEnd/" + $("#dateEnd").val() + "/parm/1";
			window.location.href = url;
		}
	});
	
	//打印
	$("input#biuuu_button").click(function(){
		$("#myPrintArea").printArea(); 
	}); 
});
</script>
</html>
