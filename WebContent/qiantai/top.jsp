<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/"> 
<link href="qiantai/css/common.css" rel="stylesheet" type="text/css" />
<link href="qiantai/css/A.css" rel="stylesheet" type="text/css" />
<link href="qiantai/css/topmenu_bk.css" rel="stylesheet" type="text/css" />
</head>
<body style='background: transparent'>


	<div id='contain'
		style='width: 900px; background: rgb(255, 255, 255); margin: 0px auto; padding: 0px'>

		<div id='top'
			style='width: 900px; height: 108px; background: none transparent scroll repeat 0% 0%'>


			<!-- 顶部菜单(一级) -->

			<div id='pdv_3607' class='pdv_class'
				style='width: 395px; height: 25px; top: 0px; left: 495px; z-index: 4'>
				<div id='spdv_3607' class='pdv_top'
					style='overflow: hidden; width: 100%; height: 100%'>
					<div class="pdv_border"
						style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">

						<div style="padding: 0px">
							<div id="topmenu">

								<a href="${empty user ? 'qiantai/login.jsp' : '#'}" target="_self">会员登录</a>| 
								<a href="${empty user ? 'qiantai/reg.jsp' : '#'}" target="_self">会员注册</a>| 
								<c:choose>
								<c:when test="${empty user}">
								<a href="#">注销退出</a>|
								</c:when>
								<c:otherwise>
								<a href="${pageContext.request.contextPath }/usersServlet?action=logout">注销退出</a>|
								</c:otherwise>
								</c:choose>
								
								<c:choose>
								<c:when test="${empty user}">
								<a href="qiantai/login.jsp" target="_self">配送说明</a>|
								</c:when>
								<c:otherwise>
								<a href="deliveryServlet?action=findDelivery" target="_self">配送说明</a>|
								</c:otherwise>
								</c:choose> 
								
								<a href="${pageContext.request.contextPath }/oursServlet?action=findOur" target="_self">关于我们</a>
							</div>

						</div>
					</div>

				</div>
			</div>

			<!-- 二级导航菜单 -->

			<div id='pdv_3605' class='pdv_class'
				style='width: 898px; height: 41px; top: 65px; left: 0px; z-index: 6'>
				<div id='spdv_3605' class='pdv_top'
					style='overflow: hidden; width: 100%; height: 100%'>
					<div class="pdv_border"
						style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">
						<div
							style="height: 25px; margin: 1px; display: none; background:;">
							<div
								style="float: left; margin-left: 12px; line-height: 25px; font-weight: bold; color:">

							</div>
							<div style="float: right; margin-right: 10px; display: none">
								<a href="-1" style="line-height: 25px; color:">更多</a>
							</div>
						</div>
						<div style="padding: 0px">
							<div id="menu">
								<div class="mainmenuleft"></div>
								<div class="mainmenuright"></div>

								<div id="mainmenu">
									<ul>

										<li><a href="qiantai/index.jsp" target="_self">首页</a></li>

										<li><a href="qiantai/shoppingcar.jsp" target="_self">我的餐车</a></li>
										
										<c:choose>
										<c:when test="${empty user}">
										<li><a href="qiantai/login.jsp" target="_self">我的订单</a></li>
										</c:when>
										<c:otherwise>
										<li><a href="ordersServlet?action=search&&userid=${sessionScope.user.id}" target="_self">我的订单</a></li>
										</c:otherwise>
										</c:choose>
										<li><a href="${empty user ? 'qiantai/login.jsp' : 'qiantai/center.jsp'}">用户中心</a></li>

										<c:choose>
										<c:when test="${empty user}">
										<li><a href="qiantai/login.jsp" target="_self">留言板</a></li>
										</c:when>
										<c:otherwise>
										<li><a href="boardServlet?action=showAll" target="_self">留言板</a></li>
										</c:otherwise>
										</c:choose>
										
										<c:choose>
										<c:when test="${empty user}">
										<li><a href="qiantai/login.jsp" target="_self">配送说明</a></li>
										</c:when>
										<c:otherwise>
										<li><a href="deliveryServlet?action=findDelivery" target="_self">配送说明</a></li>
										</c:otherwise>
										</c:choose>

										
										
										<c:choose>
										<c:when test="${empty user}">
										<li><a href="#">注销退出</a></li>
										</c:when>
										<c:otherwise>
										<li><a href="${pageContext.request.contextPath }/usersServlet?action=logout">注销退出</a></li>
										</c:otherwise>
										</c:choose>

									</ul>
								</div>

								<div id="smenu">
									<div class="smenuleft"></div>
									<div class="smenuright"></div>
									<ul>

									</ul>

									<ul>
									</ul>

									<ul>
									</ul>

									<ul>
									</ul>

									<ul>
									</ul>

									<ul>
									</ul>

									<ul>
									</ul>

								</div>
							</div>
							<script>
								showMenu(0);
							</script>

						</div>
					</div>

				</div>
			</div>

			<!-- 网站标志 -->
			<div id='pdv_3608' class='pdv_class' title=''
				style='width: 208px; height: 100px; top: -22px; left: 0px; z-index: 9'>
				<div id='spdv_3608' class='pdv_top'
					style='overflow: hidden; width: 100%; height: 100%'>
					<div class="pdv_border"
						style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">
						<div style="padding: 0px">
							<img src="qiantai/images/1257477260.jpg" alt="" width="100%" border="0" />
						</div>
					</div>
				</div>
			</div>

			<!-- 登录后欢迎界面 -->
			<div id='pdv_3699' class='pdv_class' title=''
				style='width: 300px; height: 40; top: -120px; left: 600px; z-index: 10'>
				<div id='spdv_3608' class='pdv_top'
					style='overflow: hidden; width: 100%; height: 100%'>
					<div class="pdv_border"
						style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">
						<div
							style="height: 25px; margin: 1px; display: none; background:;">
							<div
								style="float: left; margin-left: 12px; line-height: 25px; font-weight: bold; color:"></div>
							<div style="float: right; margin-right: 10px; display: none">
								<a href="-1" style="line-height: 25px; color:">更多</a>
							</div>
						</div>
						<div
							style="padding: 0px; font: bold 13px/43px 'Microsoft YaHei', 'SimSun', Arial, Sans-Serif; color: #33a8ff;">
							亲爱的${sessionScope.user.name }用户您好!&nbsp;&nbsp;欢迎光临!</div>
					</div>
				</div>
			</div>


		</div>
	</div>
</body>
</html>
