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
	<table width="947" border="1">
  <tr>
    <td width="174" rowspan="2"><div align="center">疾病名称</div></td>
    <td colspan="5"><div align="center">出院病人数</div></td>
    <td colspan="6"><div align="center">病人付款方式(人)</div></td>
    <td width="33" rowspan="2"><div align="center">平均住院日数</div></td>
    <td colspan="5"><div align="center">平均每一出院病人住院医疗费(元)</div></td>
    <td width="48" rowspan="2"><div align="center">治愈病人医疗费</div></td>
  </tr>
  <tr>
    <td width="40"><div align="center">计</div></td>
    <td width="31"><div align="center">治愈</div></td>
    <td width="33"><div align="center">好转</div></td>
    <td width="31"><div align="center">未愈</div></td>
    <td width="35"><div align="center">死亡</div></td>
    <td width="32"><div align="center">计</div></td>
    <td width="30"><div align="center">社保</div></td>
    <td width="29"><div align="center">公疗</div></td>
    <td width="28"><div align="center">统筹</div></td>
    <td width="30"><div align="center">商保</div></td>
    <td width="37"><div align="center">自费</div></td>
    <td width="45"><div align="center">合计</div></td>
    <td width="43"><div align="center">床位费</div></td>
    <td width="44"><div align="center">药费</div></td>
    <td width="45"><div align="center">手术费</div></td>
    <td width="41"><div align="center">检查治疗费</div></td>
  </tr>
  <c:forEach items="${zhongDianShouShuLiaoXiaoList }" var="zhongDianShouShuLiaoXiaoList">
  <tr>
    <td>&nbsp;${zhongDianShouShuLiaoXiaoList.mingCheng }</td>
    <td>&nbsp;${zhongDianShouShuLiaoXiaoList.bingRenShu }</td>
    <td>&nbsp;${zhongDianShouShuLiaoXiaoList.zhiYu }</td>
    <td>&nbsp;${zhongDianShouShuLiaoXiaoList.haoZhuan }</td>
    <td>&nbsp;${zhongDianShouShuLiaoXiaoList.weiYu }</td>
    <td>&nbsp;${zhongDianShouShuLiaoXiaoList.siWang }</td>
    <td>&nbsp;${zhongDianShouShuLiaoXiaoList.bingRenShu }</td>
    <td>&nbsp;${zhongDianShouShuLiaoXiaoList.sheBao }</td>
    <td>&nbsp;${zhongDianShouShuLiaoXiaoList.gongLiao }</td>
    <td>&nbsp;${zhongDianShouShuLiaoXiaoList.tongChou }</td>
    <td>&nbsp;${zhongDianShouShuLiaoXiaoList.shangBao }</td>
    <td>&nbsp;${zhongDianShouShuLiaoXiaoList.ziFei }</td>
    <td>&nbsp;${zhongDianShouShuLiaoXiaoList.chuangRiShu / zhongDianShouShuLiaoXiaoList.bingRenShu }</td>
    <td>&nbsp;${zhongDianShouShuLiaoXiaoList.feiYongZongJi / zhongDianShouShuLiaoXiaoList.bingRenShu }</td>
    <td>&nbsp;${zhongDianShouShuLiaoXiaoList.chuangWeiFei / zhongDianShouShuLiaoXiaoList.bingRenShu }</td>
    <td>&nbsp;${zhongDianShouShuLiaoXiaoList.yaoFei / zhongDianShouShuLiaoXiaoList.bingRenShu }</td>
    <td>&nbsp;${zhongDianShouShuLiaoXiaoList.shouShuFei / zhongDianShouShuLiaoXiaoList.bingRenShu }</td>
    <td>&nbsp;${zhongDianShouShuLiaoXiaoList.jianChaFei / zhongDianShouShuLiaoXiaoList.bingRenShu }</td>
    <td>&nbsp;${zhongDianShouShuLiaoXiaoList.zhiYuFei }</td>
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
