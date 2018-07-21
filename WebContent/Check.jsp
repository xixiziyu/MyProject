<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*,java.sql.*,com.utils.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>验证</title>


</head>
<body>
<%
   String code=request.getParameter("code");
 
%>

<form action="Check?code=<%=code %>" method="post">
 <table width="400" cellpadding="0" cellspacing="0" border="1px">
 <tr>
 
 <td>请输入你在xx网站的名字：</td>
 <td><input type="text" name="inputname" ></td>
 
 </tr>
 <tr>
 <td colspan="2" align="center">
 <input type="reset" value="重置">
 <input type="submit" value="提交" >
 
 </td>
 
 
 </tr>
 
 </table>   
    
    

</form>



</body>
</html>