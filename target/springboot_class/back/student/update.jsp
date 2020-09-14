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
    <style type="text/css">
		body{
			text-align: center;
		}
		select{
			width:173px;
		}
    </style>
  </head>
  
  <body >
  	
  	<h1>学生信息修改</h1><hr/>
  	
  	
  	<form action="" method="post">
  	
  		学生名称:<input type="text" name=""/><br/>
  		学生年龄:<input type="text" name=""/><br/>
  		学生生日:<input type="text" name=""/><br/>
  		学生班级:
  		<select name="">
  			<option></option>
  			<option></option>
  			<option></option>
  		</select><br/>
  		学生小组:
  		<select name="">
  			<option></option>
  			<option></option>
  			<option></option>
  		</select><br/>
  		学生就业城市:
  		<select name="">
  			<option></option>
  			<option></option>
  			<option></option>
  		</select><br/>
  		学生标签:
  		<input type="checkbox" name="">
  		<input type="checkbox" name="">
  		<input type="checkbox" name=""><br/><br/>
  		<input type="submit" value="提交"/>
  	</form>
  
    	
  </body>
</html>
