<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>关于我们</title>
<meta content="" name=keywords />
<meta content="" name=description />

</head> 
<body style='background:transparent'>

<table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top">
  
    
  <jsp:include flush="fasle" page="top.jsp"/>
    
    </td>
  </tr>
  <tr >
  <td height="50"></td>
  
</tr>
  
  <tr>
    <td align="center" valign="top" height="400">
    
    <table border="0" cellspacing="0"  width="100%">
    
		<tr>
		  <td  align="center" vlign="top"  >
			 <strong><span style="font-family: Helvetica, sans-serif;font-size: 20px;">${ours.name }</span></strong>
			 <br>
			 <span style=" font-size: 10px;">${ours.times }</span>
		  </td>
		</tr>
		<tr>
		  <td  align="left" vlign="top" >
			
             <span style=" font-size: 14px;"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ours.content }</span><br><br>
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
			<a href="index.jsp" target="_self"><input type="submit" value="返回"></a>
			</td>
		</tr>
  <tr>
    <td height="50" align="center" valign="middle">&nbsp;   
        <jsp:include flush="fasle" page="copyright.jsp"/>
    </td>
  </tr>
  
</table>


 
</body>
</html>
