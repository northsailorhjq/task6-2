<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用诗名搜索</title>
 <style type="text/css">
  body{
  background:url("i/123.jpg");
 background-size:100% 100%;
  }
  </style> 
  <script type="text/javascript">
  function check(form){
  if(document.forms.titleForm.title.value==""){
  alert("请输入诗歌名");
  document.forms.titleForm.title.focus();
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
 <jsp:include page="/service/isLogin.jsp"></jsp:include>
  <body>
     <form action="<%=path%>/controls/GetPeoByTitleAction.action" method="post" name="titleForm">
    <table>
    		<tr>
    			<td>请输入诗名</td>
    			<td><input type="text" name="title" ></td>
    			<td><input  type="submit" value="搜索" 	onclick="return check(this);"></td>
    		</tr>
    </table>
 </form>
  </body>
</html>
