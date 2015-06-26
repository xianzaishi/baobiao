<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="cssBasePath" value="${contextPath}/css" />
<c:set var="scriptBasePath" value="${contextPath}/script" />
<c:set var="imagesBasePath" value="${contextPath}/images" />

<script language="javascript" type="text/javascript" src="${contextPath}/script/jquery-1.7.2.min.js"> </script> 
<body>
<c:out value="${contextPath}"></c:out> 
add
<div id="a">asda</div>
<img src="${contextPath }/images/1.jpg"></img>
</body>
<script type="text/javascript">
$(document).ready(function(){
  $("#a").click(function(){
    $("#a").hide();
  });
});
</script>