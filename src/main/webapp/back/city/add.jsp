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
    </style>
  </head>
  
  <body >
  	
  	<h1>就业城市添加</h1><hr/>
  	
  	
  	<form action="${app}/city/save" method="post">
  		城市名称:<input type="text" name="name"/>
  		<input type="submit" value="提交"/>
		<input type="button" value="返回上级" onclick="history.go(-1);"/>
  	</form>
  
    	
  </body>
</html>
