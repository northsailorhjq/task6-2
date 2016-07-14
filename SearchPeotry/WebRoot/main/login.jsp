<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>welcome</title>
    <style type="text/css">
  body{
  background:url("i/123.jpg");
 background-size:100% 100%;
  }
  </style> 
  <script type="text/javascript">
  //判断是否输入空值，如果为空提示输入。
  function check(form){
  if(document.forms.loginForm.username.value==""){
  alert("请输入用户名");
  document.forms.loginForm.username.focus();
  return false;
  }
   if(document.forms.loginForm.password.value==""){
  alert("请输入密码");
  document.forms.loginForm.password.focus();
  return false;
  }
  }
  </script>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
 
    <form action="<%=path%>/loginns/LoginAction.action"  method="post" name="loginForm" >
    <table align="center" border="1" cellspacing="0" cellpadding="5" bordercolor="siliver" style="width: 550px; height: 257px">
    	<tr>
    		<td  colspan="2" align="center" >用户登录</td>
    	<tr >
    		<td style="height: 47px; width: 201px; ">用户名：</td>
    		<td style="height: 41px; width: 246px; "><input type="text" name="username" style="width: 237px; "></td>
    	</tr>
    	<tr>
    		<td >密码：</td>
    		<td><input type="password" name="password" style="width: 241px; "></td>
    	</tr>
    	<tr>
    		<td colspan="2" align="center" style="height: 34px; width: 517px; "><input type="submit" name="submit" value="登录" 
    		onclick="return check(this);" style="width: 96px; ">
    		<input type="reset" value="重置" style="width: 93px; "/>
    		</td>
    	</tr>
    </table>
    </form>
  </body>
</html>
