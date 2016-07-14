<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
     <style type="text/css">
    body{
    color:#000;
    font-size:24px;
    margin:20px auto;
    background:url("i/4820.tmp.jpg");
    background-size:100% 100%;
 
    }
    </style>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
 
  <body>
   <a href="main/getPeotryByName.jsp" target="main_right">通过作者检索</a><br><br>
   <a href="main/getPeotryByTitle.jsp"target="main_right">诗词名称搜索</a><br><br>
   <a href="main/getPeotryByContent.jsp" target="main_right">名句搜索</a><br><br>
   <a href="<%=path%>/loginns/LogoutAction.action" target="_top">退出系统</a>
  
  </body>
</html>
