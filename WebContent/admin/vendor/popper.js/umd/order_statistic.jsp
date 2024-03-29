<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/admin/">
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
-->
</style>
</head>

<body>
	<table width="100%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td valign="top" bgcolor="#F7F8F9">
				<div align="center">
					<table id="table2" class="line_table"
						style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
						cellPadding="0">
						<tbody style="margin: 0; padding: 0">
							<tr>
								<td class="line_table" align="center" colspan="8" height="20">
									<span class="left_bt2">本日销售额统计</span>
								</td>
							</tr>
						
							
							<c:choose>
							<c:when test="${not empty requestScope.statistic}">
								<tr>
								<td class="line_table" align="center" width="25%"><span
									class="left_bt2">菜品名称</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_bt2">订购数量</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_bt2">单价</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_bt2">合计</span></td>
							</tr>
							<c:forEach items="${requestScope.statistic }" var="statistic">
					
							<tr>
								<td class="line_table" align="center" width="25%"><span
									class="left_txt">${statistic.menuname }	</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_txt"><fmt:formatNumber type="number" value="${statistic.sum}" maxFractionDigits="0"/></span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_txt">${statistic.price }</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_txt"><fmt:formatNumber type="number" value="${statistic.price*statistic.sum}" maxFractionDigits="0"/></span></td>
							</tr>
							<c:set var="sums" value="${sums+statistic.sum*statistic.price }"></c:set>
							</c:forEach>
							
							<tr>
								<td class="line_table" align="center" colspan="8"><span
									class="left_bt2">本日销售总额：<fmt:formatNumber type="number" value="${sums}" maxFractionDigits="0"/>元
								</span></td>
							</tr>
							</c:when>
							<c:otherwise>
								<tr>
									<td class="line_table" align="center" colspan="8" rowspan="2">
										<span class="left_bt2" style="font-size:14px">今日无订单</span>
									</td>
								</tr>
								<tr height="50px"></tr>
							</c:otherwise>
							</c:choose>
							
					</table>
				</div>

			</td>

		</tr>
	</table>
</body>
</html>
