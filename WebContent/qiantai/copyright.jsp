<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<style>
#fontset{font-size:0.7vw;}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta content="" name=keywords />
<meta content="" name=description />
</head>
<body style='background:transparent'>
<div id="bottommenu" style="height: 50px;line-height: 50px; vertical-align:top; text-align: center; ">

<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  	<tr>
    	<td style="margin: 0px;padding: 0px;">
    	


		
 	<div id="fontset">

      
    	<c:choose>
		<c:when test="${empty user}">
		<a href="qiantai/login.jsp" target="_self">配送说明</a>|
		</c:when>
		<c:otherwise>
		<a href="deliveryServlet?action=findDelivery" target="_self">配送说明</a>|
		</c:otherwise>
		</c:choose> 
		
		<a href="${pageContext.request.contextPath }/oursServlet?action=findOur" target="_self">关于我们</a>|
		<a href="http://www.12377.cn/" target="_self">中国互联网举报中心</a>|
		<a href="http://www.12377.cn/node_548446.htm" target="_self">网络举报APP下载</a>

		<br>
		<span> 公司地址:山东省青岛市皇家每羊学院  邮编:266100 Email:765070548@qq.com 客户服务热线:10086/10010</span><br>
    	<span> Copyright(C)2019-2020 皇家每羊私房菜有限公司hjmyxy.xyz版权所有</span><br>
		
	
	</div>

		
		
  	</tr>
	</table>
	</div>

</body>
</html>
