<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();

%>

<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
    <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
    
  <TITLE>考勤管理系统</TITLE>
	
	<script type="text/javascript">
 function login(){
   var th = document.form;
   if(th.id.value==""){
      alert("账户不能为空哦");
      th.username.focus();
      return ;
   }
   if(th.psw.value==""){
      alert("密码不能为空哦");
      th.psw.focus();
      return ;
   }
   th.action="<%=path%>/servlet/LoginAction";
   th.submit();
 }
</script>
<%
	String errorInfo = (String)request.getAttribute("loginError");         // 获取错误属性
	if(errorInfo != null) {
%>
	<script type="text/javascript" language="javascript">
		alert("<%=errorInfo%>");                                            // 弹出错误信息
		                    
	</script>	
<%
	}
%>
  </head><body style="width: 128px; font-size: 18px; font-family: Verdana, Arial, Sans-Serif; text-align: center"><strong>
    
  </strong><big>登录页面<br></big></body>
		<form name="form" action="" method="post"><br>
  		 
  			账户
  			<input name="id" ><br>
  			
  			密码
  			<input name="psw" type="password"><br>
  				  <a href="javascript:login();"  id="button-1" data-role="button" data-icon="home">登录</a>
  				 
  		</form>
  	
  
</html>
