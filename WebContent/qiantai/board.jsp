<%@ page language="java" import="java.util.*,java.text.*"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>留言板</title>
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

							<div align="center" width="120">
								<form action="${pageContext.request.contextPath }/boardServlet?action=showAll"
									name="form1" method="post">
									<table id="table1" class="line_table"
										style="width: 500px; margin: 0; padding: 0" cellSpacing="0"
										cellPadding="0">
										<tbody style="margin: 0; padding: 0">

											<tr>
												<td class="line_table" align="center" colspan="3"><a
													href="qiantai/board_add.jsp"><font size="3px">添加留言</font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
													href="${pageContext.request.contextPath }/boardServlet?action=show&&username=${sessionScope.user.name}"><font
														size="3px">我的留言</font></a></td>
											</tr>
									</table>
								</form>
							</div>
						</td>
					</tr>
					<tr>
						<td align="left" valign="top" height="10px"></td>
					</tr>
					<tr>
						<td align="left" valign="top">


							<div align="center">
								<table id="table2" class="line_table"
									style="width: 900px; margin: 0; padding: 0" cellSpacing="0"
									cellPadding="0">
									<tbody style="margin: 0; padding: 0">

										<tr>
											<td class="line_table" align="center" width="15%"><span
												class="left_bt2">用户名</span></td>
											<td class="line_table" align="center" width="70%"><span
												class="left_bt2">留言内容</span></td>
											<td class="line_table" align="center" width="15%"><span
												class="left_bt2">时间</span></td>
										</tr>



										<c:forEach items="${page.list }" var="board">
											<tr>
												<td class="line_table" align="center"><span
													class="left_txt">${board.username }</span></td>
												<td class="line_table" align="center"><span
													class="left_txt">${board.content }</span></td>
												<td class="line_table" align="center"><span
													class="left_txt">${board.times }</span></td>

											</tr>
										</c:forEach>
										<tr>
											<td class="line_table" align="center" colspan="11"
												height="20"><span class="left_bt2">第${page.curPage }页
													&nbsp;&nbsp;共${page.totalPage }页 </span>&nbsp;&nbsp; <c:choose>
													<c:when test="${page.curPage eq 1 }">
														<span style="font-size: 12px; color: gray">[首页]</span>
													</c:when>
													<c:otherwise>
														<a
															href="${pageContext.request.contextPath }/boardServlet?action=showAll&&curPage=1">[首页]</a>
													</c:otherwise>
												</c:choose> <c:choose>
													<c:when test="${page.curPage eq page.totalPage }">
														<span style="font-size: 12px; color: gray">[尾页]</span>&nbsp;&nbsp;
								</c:when>
													<c:otherwise>
														<a
															href="${pageContext.request.contextPath }/boardServlet?action=showAll&&curPage=${page.totalPage}">[尾页]</a>&nbsp;&nbsp; 
								</c:otherwise>
												</c:choose> <c:choose>
													<c:when test="${page.curPage eq 1 }">
														<span style="font-size: 12px; color: gray">[上一页]</span>
													</c:when>
													<c:otherwise>
														<a
															href="${pageContext.request.contextPath }/boardServlet?action=showAll&&curPage=${page.curPage-1}">[上一页]</a>
													</c:otherwise>
												</c:choose> <c:choose>
													<c:when test="${page.curPage eq page.totalPage }">
														<span style="font-size: 12px; color: gray">[下一页]</span>
													</c:when>
													<c:otherwise>
														<a
															href="${pageContext.request.contextPath }/boardServlet?action=showAll&&curPage=${page.curPage+1}">[下一页]</a>
													</c:otherwise>
												</c:choose></td>
										</tr>
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
			<a href="boardServlet?action=showAll" target="_self" target="_self"><input type="submit" value="刷新"></a>
			</td>
		</tr>
		<tr>
			<td height="50" align="center" valign="middle">&nbsp;<jsp:include
					flush="fasle" page="copyright.jsp" /></td>
		</tr>
	</table>
</body>
</html>