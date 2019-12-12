<%@ page language="java" import="java.util.*,java.text.*"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>添加留言</title>
<meta content="" name=keywords />
<meta content="" name=description />

</head>
<body style='background: transparent'>

	<table width="900" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td align="left" valign="top"><jsp:include flush="fasle"
					page="top.jsp" /></td>
		</tr>
		<tr>
			<td height="100"></td>
		</tr>

		<tr>
			<td align="center" valign="top" height="400">
				<form method="post" action="${pageContext.request.contextPath }/boardServlet?action=add&&username=${sessionScope.user.name}" 
								name="form1" onsubmit="return verifyLogin()">
				<table border="0" cellspacing="0" width="100%">
				
					<tr>
						<td class="line_table" align="right" width="10%"><span
							class="left_bt2">留言板内容：</span></td>
						<td class="line_table" width="90%"><textarea rows="14"
								name="content" cols="105">${requestScope.board.content }</textarea></td>
					</tr>
					<tr>
						<td class="line_table" height="25" align="center" colspan="2">
						
								
								<input type="submit" value="添加">
							
						</td>
					</tr>
				</table>
				</form>
		<tr>
			<td height="10px" align="center" valign="middle">
			<a href="${pageContext.request.contextPath }/boardServlet?action=showAll" target="_self"><input type="submit" value="返回"></a>
			</td>
		</tr>
		<tr>
			<td height="50" align="center" valign="middle">&nbsp;<jsp:include
					flush="fasle" page="copyright.jsp" /></td>
		</tr>
	</table>
</body>
</html>