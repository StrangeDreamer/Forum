<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>login</title>
  	<link rel="stylesheet" href="css/model.css" type="text/css"></link>
  	<script type="text/javascript" src="js/jquery-1.4.1.js"></script>
  	<script type="text/javascript">
		function checkUsername(){
			var username=$("#username").val();
			if(username==""){
				$(".error").text("用户名不能为空");
				return false;
			}else{
				$(".error").text("");
				return true;
			}			
		}
		
		
		
		$(function(){
			$("#username").blur(checkUsername);
			
			
			/* 
			$("#password").blur(checkPassword);
			$("#btnSubmit").click(function(){
				return checkUsername();
			}); */
		});
  	</script> 
  </head>
  
  <body>
    <div id="main">
    	<%@ include file="shared/header.jsp" %>
    	
    	<div id="main_content">
    		<div id="main_table">
    			<form action="UserCheckServlet" method="post">
		    		<table>
		    			<caption align="top">登录</caption>
		    			<tr style="height: 35px"><td>&nbsp;用户：</td><td style="text-align: left;"><input type="text" name="username" id="username"/></td></tr>
		    			<tr style="height: 35px"><td>&nbsp;密码：</td><td style="text-align: left;"><input type="text" name="password" id="password"/></td></tr>
		    			
		    			<tr style="height: 20px"><td></td><td style="text-align: left;"><label class="error"></label></td></tr>
		    			<tr>
		    				<td colspan="2">
		    				<input type="submit" name="btnSubmit" value="提交"/>
		    				<input type="reset" value="清空"/>
		    				</td>
		    			</tr>
		    		</table>
		    	</form>
    		</div>
    	</div>
    	
    	<%@ include file="shared/footer.jsp" %>
    
    </div>
  </body>
</html>
