<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>日报</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css" href="${contextPath}/css/business.css" />
<script language="javascript" type="text/javascript" src="${contextPath}/script/jquery-1.7.2.min.js"></script> 
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
<br/>
<div id="myPrintArea">
	<div align="center">
	  <table width="790" height="137" border="1" align="center" bordercolor="#000000">
	    <tr>
	      <td width="125">实际开放床位</td>
	      <td width="125">&nbsp;1061</td>
	      <td width="125">重症医学科实际开放床位</td>
	      <td width="125">&nbsp;12</td>
	      <td width="125">急诊留观实际开放床位</td>
	      <td width="125">&nbsp;10</td>
	    </tr>
	    <tr>
	      <td>全院员工总数</td>
	      <td colspan="5">&nbsp;</td>
	    </tr>
	    <tr>
	      <td rowspan="3">卫生技术人员数</td>
	      <td>医师</td>
	      <td colspan="4">&nbsp;</td>
	    </tr>
	    <tr>
	      <td>护理</td>
	      <td colspan="4">&nbsp;</td>
	    </tr>
	    <tr>
	      <td>医技</td>
	      <td colspan="4">&nbsp;</td>
	    </tr>
	    <tr>
	      <td>医院医用建筑面积</td>
	      <td colspan="5">&nbsp;</td>
	    </tr>
	  </table>
	</div>
</div>
<br/>
<div align="center"><input id="biuuu_button" type="button" value="打印"></input></div>
<script type="text/javascript">
$(function(){
	$("input#biuuu_button").click(function(){
		$("#myPrintArea").printArea(); 
	});	
});
</script>
</body>
</html>
