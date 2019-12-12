<%@ page language="java" import="java.util.*,java.text.*"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>搜索结果</title>
<meta content="" name=keywords />
<meta content="" name=description />
<link href="qiantai/css/skin.css" rel="stylesheet" type="text/css" /> 
<script src="js/date.js" type="text/javascript"></script>
</head>

<body style='background: transparent'>
	<table width="900" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td align="left" valign="top"><jsp:include flush="fasle"
					page="top.jsp" /></td>
		</tr>
		<tr>
			<td height="50px"></td>

		</tr>

		<tr>
			<td align="center" valign="top" height="420px">

				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
				

					<tr>
						<td align="left" valign="top">


							<div align="center">
								<table id="table2" class="line_table"
									style="width: 900px; margin: 0; padding: 0" cellSpacing="0"
									cellPadding="0">
									<tbody style="margin: 0; padding: 0">
										<tr>
											<td class="line_table" align="center" colspan="9"><span
												class="left_bt2">查询结果信息列表</span></td>
										</tr>
									<c:choose>
									<c:when test="${not empty page}">
										<tr>
											<tr>
												<td class="line_table" align="center" width="10%"><span
													class="left_bt2">菜单名称</span></td>
												<td class="line_table" align="center" width="10%"><span
													class="left_bt2">展示图片</span></td>
												<td class="line_table" align="center" width="10%"><span
													class="left_bt2">原料</span></td>
												<td class="line_table" align="center" width="5%"><span
													class="left_bt2">类型</span></td>
												<td class="line_table" align="center" width="30%"><span
													class="left_bt2">说明</span></td>
												<td class="line_table" align="center" width=8%"><span
													class="left_bt2">市场价格</span></td>
												<td class="line_table" align="center" width="8%"><span
													class="left_bt2">会员单价</span></td>
												<td class="line_table" align="center" width="10%"><span
													class="left_bt2">&nbsp;</span></td>
												<td class="line_table" align="center" width="9%"><span
													class="left_bt2">&nbsp;</span></td>
								
							<c:forEach items="${requestScope.page.list }" var="menus">
							<tr>
								<td class="line_table" align="center"><span
									class="left_txt">${menus.name }</span></td>
								<td class="line_table" align="center"><a
									href="${pageContext.request.contextPath }/${menus.imgpath }"><img src="${pageContext.request.contextPath }/${menus.imgpath }"
										width="30" height="30"></a></td>
								<td class="line_table" align="center"><span
									class="left_txt">${menus.burden }</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${menus.typename }</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${menus.brief }</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${menus.price }</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${menus.price1 }</span></td>
								<td class="line_table" align="center"><a
									href="${pageContext.request.contextPath }/menusTwoServlet?action=searchMenusTwo&&menunameSearch=${menunameSearch}&&id=${menus.id}&&curPage=${page.curPage}">点击查看详情</a></td>
								<td class="line_table" align="center"><a
									href="${pageContext.request.contextPath }/shoppingCartServlet?action=addTwo&&menunameSearch=${menunameSearch}&&menuid=${menus.id}&&curPage=${page.curPage}">加入餐车</a></td>
							</tr>
							</c:forEach>
							<tr>
								<td class="line_table" align="center" colspan="11" height="20">
								<span class="left_bt2">第${page.curPage }页
										&nbsp;&nbsp;共${page.totalPage }页
								</span>&nbsp;&nbsp; 
								<c:choose>
								<c:when test="${page.curPage eq 1 }">
									<span style="font-size: 12px; color: gray">[首页]</span>
								</c:when>
								<c:otherwise>
									<a href="${pageContext.request.contextPath }/searchMenuServlet?action=search&&curPage=1">[首页]</a>
								</c:otherwise>
								</c:choose>
								 
								<c:choose>
								<c:when test="${page.curPage eq page.totalPage }">
									<span style="font-size: 12px; color: gray">[尾页]</span>&nbsp;&nbsp;
								</c:when>
								<c:otherwise>
									<a href="${pageContext.request.contextPath }/searchMenuServlet?action=search&&curPage=${page.totalPage}">[尾页]</a>&nbsp;&nbsp; 
								</c:otherwise>
								</c:choose>
								
								<c:choose>
								<c:when test="${page.curPage eq 1 }">
									<span style="font-size: 12px; color: gray">[上一页]</span>
								</c:when>
								<c:otherwise>
									<a href="${pageContext.request.contextPath }/searchMenuServlet?action=search&&curPage=${page.curPage-1}">[上一页]</a>
								</c:otherwise>
								</c:choose>
								
								<c:choose>
								<c:when test="${page.curPage eq page.totalPage }">
									<span style="font-size: 12px; color: gray">[下一页]</span>
								</c:when>
								<c:otherwise>
									<a href="${pageContext.request.contextPath }/searchMenuServlet?action=search&&curPage=${page.curPage+1}">[下一页]</a>
								</c:otherwise>
								</c:choose>

								</td>
							</tr>
							</c:when>
							<c:otherwise>
							<tr>
								<td class="line_table" align="center" colspan="8" rowspan="2">
								<span class="left_bt2" style="font-size:14px">亲，无结果</span>
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
			</td>
		</tr>
		<tr>
			<td height="10px">&nbsp;</td>
		</tr>
		<tr>
			<td height="10px" align="center" valign="middle">
			<a href="index.jsp" target="_self"><input type="submit" value="返回"></a>
			</td>
		</tr>
		<tr>
			<td height="10px" align="center" valign="middle">&nbsp;<jsp:include
					flush="fasle" page="copyright.jsp" /></td>
		</tr>
	</table>
</body>
</html>
