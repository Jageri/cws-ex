<%@page import="pra.tec.table.table"%>
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

<title>教师用户端</title>

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
   if(th.cno.value==""){
      alert("课程号不能为空哦");
      th.username.focus();
      return ;
   }if(th.tno.value==""){
      alert("课序号不能为空哦");
      th.username.focus();
      return ;
   }if(th.ctime.value==""){
      alert("上课时间不能为空哦");
      th.username.focus();
      return ;
   }
   th.action="<%=path%>/servlet/tecSearchAction";   
   th.submit();
 }
</script>
<script type="text/javascript">
 function update(v){
   var th2 = document.form2;
   th2.tag.value=v;
   th2.action="<%=path%>/servlet/tecUpdateAction";   
   th2.submit();
 }
</script>

<%
	String resu = (String)request.getAttribute("resu");         // 获取错误属性
	if(resu != null) {
%>
<script type="text/javascript" language="javascript">
		
		alert("<%=resu%>"); // 弹出结果信息
</script>
<%
	}
%>
</head>

<%
	List<table> resu2=(List<table>) request.getAttribute("resu1");
	if(resu2 != null) {
%>
<form name="form2" action="" method="post">
<table border="1" id="table" > 
        <tr> 
            <th>名字</th>
            <th>课程名</th> 
            <th>课程号</th> 
            <th>上课时间</th>
             <th>是否缺勤(0/1)</th>
            <th>更改考勤信息</th> 
        </tr> 
        <% 
            for (table table : resu2) { 
        %> 
        <tr> 
            <td><%=table.getName()%></td> 
			
            <td><%=table.getCname() %></td> 
			
            <td><%=table.getCno()%></td> 
			
            <td><%=table.getCtime() %></td> 
			
            <td><%=table.getIsabsence() %></td> 
			
            <td>
            	<a href="javascript:update(<%=table.getNo()%>)"  data-role="button" data-theme="b" >
            		更改考勤信息
            	</a>
            </td>
            
        </tr> 
        <% 
            } 
        %> 
        
<%
	}
%>

      </table>
      
      <input type="hidden" name="tag"
			value="">
			<%
			if((String)request.getAttribute("teclog") != null) {
		%>
		<input type="hidden" name="idd"
			value=<%=(String)request.getAttribute("teclog")%>>
		<%}%>
		<%
			if((String)request.getAttribute("teclog2") != null) {
		%>
		<input type="hidden" name="idd"
			value=<%=(String)request.getAttribute("teclog2")%>>
		<%}%>
      </form>
	<form name="form" action="" method="post">
		<br>
		<label id="label1">您的工号是：</label>
		<%
			String msg1 = (String)request.getAttribute("teclog"); String
			msg2 = (String)request.getAttribute("teclog2"); if(msg1 !=
			null && msg2 == null) {
		%>
		<script type="text/javascript" language="javascript">
			alert("欢迎登陆！");
		</script>
		<label id="id">
			<%=(String)request.getAttribute("teclog")%>
		</label>
		<br>
		<%}else{%>
		<label id="id">
			<%=(String)request.getAttribute("teclog2")%>
		</label>
		<br>
		<%}%>
		<div >
			<label for="text-1">课程号</label><br>
			<input name="cno" 
				value="" type="text" />
		</div>
		<div >
			<label for="text-1">课序号</label><br>
			<input name="tno" 
				value="" type="text" />
		</div>
		<div >
			<label for="text-1">上课时间</label><br>
			<input name="ctime"
				value="" type="text" />
		</div>
		<br>
		<a href="javascript:search();" id="button-1" data-role="button" data-theme="b" >
			查询此课有无旷课学生
		</a>
		<%
			if((String)request.getAttribute("teclog") != null) {
		%>
		<input type="hidden" name="idd"
			value=<%=(String)request.getAttribute("teclog")%>>
		<%}%>
		<%
			if((String)request.getAttribute("teclog2") != null) {
		%>
		<input type="hidden" name="idd"
			value=<%=(String)request.getAttribute("teclog2")%>>
		<%}%>
	</form>
</html>

