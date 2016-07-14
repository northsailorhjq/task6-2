
<%@page import="com.jikexueyuan.model.Poetries"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showTitle.jsp' starting page</title>
    <style type="text/css">
     body{
    background:url("i/1025.jpg");
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
  request.setCharacterEncoding("UTF-8");
  //从session获取poetries
  List<Poetries> poetries=(List<Poetries>)session.getAttribute("poetries");
  //迭代打印。
 Iterator iterator=poetries.iterator();	

 	
  	%>
  	<table align="center" border="1" cellspacing="0" cellpadding="5" bordercolor="siliver" style="height:50px; width: 400px; ">
  			<tr>
  				<td>诗名</td>
  				<td>作者</td>
  			</tr>
  <% 
   int i=0;
  while(iterator.hasNext()){
  	Poetries p=(Poetries)iterator.next();
  
  	%>		
 			  <tr>
 			  	<td><%=p.getTitle() %></td>
  			 <td><%=p.getName() %></td> 
  				
  			</tr>
  <%
  i++;
  } %>
  	</table>
  </body>
</html>
