<%@page import="com.jikexueyuan.model.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	User user=(User)session.getAttribute("user");
	if(user==null)
	{%>
	<jsp:forward page="login.jsp"></jsp:forward>
	<%} %>



