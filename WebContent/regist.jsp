<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>
</head>
<body>
<h1>注册页面</h1>
<form action="RegistServlet" method="post">
<table width="300" border="1px" cellpadding="1" cellspacing="0">
<tr>
<td>用户名</td>
<td><input type="text" name="username"></td>
</tr>
<tr>
<td>密码</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td>昵称</td>
<td><input type="text" name="nickname"></td>
</tr>
<tr>
<td>邮箱</td>
<td><input type="text" name="email"></td>
</tr>

<tr align="center">

<td colspan="2"><input type="reset" value="重置"><input type="submit" value="注册"></td>

</tr>
</table>



</form>


</body>
</html>