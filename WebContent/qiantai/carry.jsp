<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>配送说明</title>
<meta content="" name=keywords />
<meta content="" name=description />
</head>
<body >
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
    <td align="center" valign="top" height="250">
    
    <table border="0" cellspacing="0"  width="100%">
    
		<tr>
		  <td  align="center" valign="top">
			 <strong><span style="font-family: Helvetica, sans-serif;font-size: 20px;">
			     ${delivery.name }
			 </span></strong>
			 <br>
		  </td>
		</tr>
		<tr>
		  <td  align="left" valign="top" >
             <p style=" font-size: 14px;">
              <br><br>
             <strong>午餐时间：</strong><span style="color:#F00">${delivery.lunchtime }</span><br><br>
             <strong>晚餐时间：</strong><span style="color:#F00">${delivery.dinnertime }</span> <br><br>
             <strong>联系电话：</strong><span style="color:#F00">${delivery.phone }</span> <br><br>
             <strong>联系人：</strong><span style="color:#F00">${delivery.contacts }</span> <br><br>
             <strong>注：</strong>
             <span style="color:#F00">${delivery.content}</span> <br><br>
             </p>

             
            
		  </td>
		</tr>

   </table>
     </td>
  </tr>
  <tr>
    <td height="100">&nbsp;</td>
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
