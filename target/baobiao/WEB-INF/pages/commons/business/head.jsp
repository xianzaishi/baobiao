<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<title>日报</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<link rel="stylesheet" type="text/css" href="${contextPath}/css/business.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/css/business-1.css" />

<script src="http://api.map.baidu.com/api?v=1.5&ak=piUetduG3GHlRRRyfaE0CNjm" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="${contextPath}/script/jquery-1.7.2.min.js"></script> 
<script language="javascript" type="text/javascript" src="${contextPath}/script/slide.js"></script> 
<script language="javascript" type="text/javascript" src="${contextPath}/script/json.js"></script>
</head>

<body>
<!-- session -->
<div id="sessionOfUserId" style="display:none;"><c:out value="${sessionScope.id }" /></div>
<div id="sessionOfUserName" style="display:none;"><c:out value="${sessionScope.userName }" /></div>
<div id="sessionOfReadLevel" style="display:none;"><c:out value="${sessionScope.readLevel }" /></div>
<!--顶部-->
    <div class="top">
        <div class="top_a">
            <div class="logo"><img src="${contextPath}/images/business/logo.gif" /></div>
            <div class="dh">
            	<ul id="nav">
                <li class="mainlevel"><a class="nav_1"></a>
                    <ul style="display: none;" >  
                     <li><a href="${contextPath}/repair/index/page/1">智慧社区</a></li>
                     <li><a href="###">智慧社区</a></li>
                     <li><a href="###">智慧社区</a></li>
                    </ul>
                </li>
                <li class="mainlevel"><a class="nav_2"></a>
                    <ul style="display: none;" >  
                     <li><a href="###">智慧产业</a></li>
                     <li><a href="###">智慧产业</a></li>
                     <li><a href="###">智慧产业</a></li>

                    </ul>
                </li>
                <li class="mainlevel"><a class="nav_3"></a>
                    <ul style="display: none;" >  
                     <li><a href="###">智慧就业</a></li>
                     <li><a href="###">智慧就业</a></li>
                     <li><a href="###">智慧就业</a></li>
                    </ul>
                </li>
                <li class="mainlevel"><a class="nav_4"></a>
                    <ul style="display: none;" >  
                     <li><a href="${contextPath}/user/index/page/1">用户管理</a></li>
                     <li><a href="###">商铺管理</a></li>
                     <li><a href="###">用户管理</a></li>
                    </ul>
                </li>                
                </ul>
            </div>
            
            <div class="dl">
                <div class="dl_hy"><security:authentication property="name"/></div>
                <div class="dl_dc"><a href="${contextPath}/j_spring_security_logout">登出</a></div>
                <div class="dl_dc" style="display:none;"><a href="###">消息</a></div>
                <div class="clear"></div> 
            </div>
            <div class="clear"></div> 
        
        </div>
    
    </div>
