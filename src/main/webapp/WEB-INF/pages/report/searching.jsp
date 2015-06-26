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
</head>

<body>
<br/>
<center>
<div id="wait"><h1>查询中 请稍后...</h1></div>	
<img src="${contextPath}/images/loading.jpg"/>
<div id="url" style="display:none;"><c:out value="${url }"></c:out></div>
</center>
<script type="text/javascript">
$(function(){
	//查询
	window.location.href = "${contextPath}" + $("#url").html();
});
</script>
</body>
</html>
