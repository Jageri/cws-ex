<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
<base href="<%=basePath%>">

<title>学生用户端</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">
 function search(){
   var th = document.form;
   th.action="<%=path%>/servlet/SearchAction";   
   th.submit();
 }
</script>

<%
	String resu = (String)request.getAttribute("resu");         // 获取错误属性
	if(resu != null) {
%>
<script type="text/javascript" language="javascript">
		
		alert("<%=resu%>"); // 弹出错误信息
</script>
<%
	}
%>
</head>

<form name="form" action="" method="post">
	<br> <label id="label1">你的学号是：</label>
	 
	<%
		String msg1 = (String)request.getAttribute("stulog");
		String msg2 = (String)request.getAttribute("stulog2");
		if(msg1 != null && msg2 == null) {
	%>
	<script type="text/javascript" language="javascript">
		alert("欢迎登陆！");
	</script>
	<label id="id" ><%= (String)request.getAttribute("stulog")%></label> <br>
	<%
		}else{
	%>
<label id="id" ><%= (String)request.getAttribute("stulog2")%></label> <br>
<%
	}
%>
	<br> <a href="javascript:search();" id="button-1"
		data-role="button" data-theme="b"> 查询有无旷课 </a>
	<%
		if((String)request.getAttribute("stulog") != null) {
	%>
	<input type="hidden" name="idd"
		value=<%=(String)request.getAttribute("stulog")%>>

	<%
		}
	%>
	<%
		if((String)request.getAttribute("stulog2") != null) {
	%>
	<input type="hidden" name="idd"
		value=<%=(String)request.getAttribute("stulog2")%>>
	<%
		}
	%>
</form>


</html>
