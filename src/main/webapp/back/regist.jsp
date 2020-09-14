<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="app" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
  <head>
    <title>index.html</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
    <link rel="stylesheet" type="text/css" href="${app}/statics/css/styles.css">
	<style>
		body{ text-align:center} 
		#dd{margin:0 auto;border:1px solid #fff; width:340px;height:600px} 
	</style>
  </head>
  
  <body >
  	
  	<h1>用户注册</h1>
  	
  	<div id="dd">
  		<form action="" method="post">
  			<div style="margin-top:70px;">
	  			<div style="float: left; width:100px;">
	  				选择头像:
	  			</div>
	  			<div style="float: left; width:120px;">
		  			<input type="file" name=""/>
	  			</div>
	  		</div><br/>
	  		<div style="margin-top:15px;">
	  			<div style="float: left; width:100px;">
	  				用户名:
	  			</div>
	  			<div style="float: left; width:120px;">
		  			<input type="text" name="" />
	  			</div>
	  		</div><br/>
	  		<div style="margin-top:15px;">
	  			<div style="float: left; width:100px;">
	  				密&nbsp;&nbsp;码:
	  			</div>
	  			<div style="float: left;width:120px;">
		  			<input type="text" name="" />
	  			</div>
	  		</div><br/>
	  		<div style="margin-top:15px;">
	  			<div style="float: left; width:100px;">
	  				手机号:
	  			</div>
	  			<div style="float: left;width:120px;">
		  			<input type="text" name="" />
	  			</div>
	  		</div><br/>
	  		<div style="margin-top:30px;">
	  			<div style="float: left; width:400px;">
	  				<input type="submit" value="提交" />&nbsp;&nbsp;
	  				<input type="reset" value="重置" />&nbsp;&nbsp;
	  				<input type="button" value="登录" />&nbsp;&nbsp;
	  			</div>
	  		</div><br/>
  		</form>
  	</div>
  
  </body>
</html>
