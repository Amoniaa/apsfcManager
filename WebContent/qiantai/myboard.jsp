<%@ page language="java" import="java.util.*,java.text.*"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/"> 
<title>我的留言</title>
<meta content="" name=keywords />
<meta content="" name=description />
<link href="qiantai/css/skin.css" rel="stylesheet" type="text/css" />
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

		<tr class="mytr">
			<td align="center" valign="top" height="420px">

				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td align="left" valign="top">


							<div align="center">
								<table id="table2" class="line_table"
									style="width: 700px; margin: 0; padding: 0" cellSpacing="0"
									cellPadding="0">
									<tbody style="margin: 0; padding: 0">
										<tr>
											<td class="line_table" align="center" colspan="4"><span
												class="left_bt2">我的留言列表</span></td>
										</tr>
										<c:choose>
										<c:when test="${not empty page}">
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
											<td class="line_table" align="center" width="60%"><span
												class="left_bt2">留言内容</span></td>
											<td class="line_table" align="center" width="15%"><span
												class="left_bt2">时间</span></td>
											<td class="line_table" align="center" width="5%"><span
												class="left_bt2">&nbsp;</span></td>
											<td class="line_table" align="center" width="5%"><span
												class="left_bt2">&nbsp;</span></td>
										</tr>
								
										
										
										<c:forEach items="${page.list }" var="board" >
										<tr>
											<td class="line_table" align="center"><span
												class="left_txt">${board.username }</span></td>
											<td class="line_table" align="center"><span
												class="left_txt">${board.content }</span></td>
											<td class="line_table" align="center"><span
												class="left_txt">${board.times }</span></td>
											<td class="line_table" align="center"><a
												href="${pageContext.request.contextPath }/boardServlet?action=updatePre&&id=${board.id}&&curPage=${page.curPage}">修改</a></td>
											<td class="line_table" align="center"><a
												href="${pageContext.request.contextPath }/boardServlet?action=delete&&username=${board.username}&&id=${board.id}&&curPage=${page.curPage}">删除</a></td>
							
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
									<a href="${pageContext.request.contextPath }/boardServlet?action=show&&curPage=1&&username=${sessionScope.user.name}">[首页]</a>
								</c:otherwise>
								</c:choose>
								 
								<c:choose>
								<c:when test="${page.curPage eq page.totalPage }">
									<span style="font-size: 12px; color: gray">[尾页]</span>&nbsp;&nbsp;
								</c:when>
								<c:otherwise>
									<a href="${pageContext.request.contextPath }/boardServlet?action=show&&curPage=${page.totalPage}&&username=${sessionScope.user.name}">[尾页]</a>&nbsp;&nbsp; 
								</c:otherwise>
								</c:choose>
								
								<c:choose>
								<c:when test="${page.curPage eq 1 }">
									<span style="font-size: 12px; color: gray">[上一页]</span>
								</c:when>
								<c:otherwise>
									<a href="${pageContext.request.contextPath }/boardServlet?action=show&&curPage=${page.curPage-1}&&username=${sessionScope.user.name}">[上一页]</a>
								</c:otherwise>
								</c:choose>
								
								<c:choose>
								<c:when test="${page.curPage eq page.totalPage }">
									<span style="font-size: 12px; color: gray">[下一页]</span>
								</c:when>
								<c:otherwise>
									<a href="${pageContext.request.contextPath }/boardServlet?action=show&&curPage=${page.curPage+1}&&username=${sessionScope.user.name}">[下一页]</a>
								</c:otherwise>
								</c:choose>

								</td>
							</tr>
							</table>
							</div>
									</c:when>
									<c:otherwise>
										<tr>
											<td class="line_table" align="center" colspan="8" rowspan="2">
											<span class="left_bt2" style="font-size:14px">您还没有留言</span>
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
			<td height="10">&nbsp;</td>
		</tr>
		<tr>
			<td height="10px" align="center" valign="middle">
			<a href="${pageContext.request.contextPath }/boardServlet?action=showAll" target="_self"><input type="submit" value="返回"></a>
			</td>
		</tr>
		<tr>
			<td height="50" align="center" valign="middle" >&nbsp; <jsp:include
					flush="fasle" page="copyright.jsp" />
			</td>
		</tr>
		
	</table>



</body>
</html>
