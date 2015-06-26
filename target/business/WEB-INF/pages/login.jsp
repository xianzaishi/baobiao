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
<script language="javascript" type="text/javascript" src="${contextPath}/script/json.js"></script>
</head>

<body>

    <div class="yh_dl">
        <div class="yh_dl_a"><a href="${contextPath}/index">回到首页</a></div>
        <div class="yh_dl_c">
            <div class="yh_dl_b">
                <div class="yh_dl_d">登录</div>
                <div class="yh_dl_line">|</div>
                <div class="yh_dl_e"><a href="javascript:void(0)">注册</a></div> 
                <form id="loginForm" method="post" name="Login" action="${contextPath}/j_spring_security_check">
                    <div class="yh_dl_f">        
                       <ul>
                            <li>
                                <div class="yh_dl_f">用户名</div>
                                <div ><input type="text"  class="yh_dl_g" id="j_username" name="j_username" value="" /></div>
                             </li>
                            <li>
                                <div class="yh_dl_f">密码</div>
                                <div ><input type="password"  class="yh_dl_g" id="j_password" name="j_password" value="" /></div>
                             </li>
                        </ul>
                     </div>
                 </form>
               <div class="yh_dl_w" ><span class="yh_dl_wa" ><input type="checkbox" /></span> <span class="yh_dl_wb">记住密码</span><span class="yh_dl_wc"><a href="javascript:void(0)">忘记密码？</a></span></div>  
               <div class="yh_dl_j"><a id="loginSubmit" href="javascript:void(0)">登录</a></div>
                
               
            </div>
         
        </div>
      <div class="clear"></div>
    </div>

<!--登录-->

</body>
<script type="text/javascript">
$(function(){
	$("#loginSubmit").click(function(){
		$("#loginForm").submit();
	});
});
</script>
</html>