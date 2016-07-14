<%@page import="com.jikexueyuan.model.Poetries"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showContent.jsp' starting page</title>
   <style type="text/css">
  body{
  background:url("i/456.jpg");
 background-size:100% 100%;

  }
  p{
   font_size:80px;
   font-weight:bolder;
   color: red;
  }
  </style> 
  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
    <jsp:include page="/service/isLogin.jsp"></jsp:include>
  <body>
   <%
   Poetries p=(Poetries)session.getAttribute("p");%>
   <div>
    	<p align="center"><%out.println(p.getTitle());%><br></p>
    	<p align="center"><%out.println(p.getName());%><br></p>
    	<p align="justify"><%out.println(p.getContent());%><br></p>
    </div>
  </body>
</html> 
