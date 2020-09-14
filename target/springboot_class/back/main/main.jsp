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

  </head>
  
  <body >
  	
  	<h1>系统主菜单</h1><hr/>
  	
  	<ul>
  		<li><a href="${app}/student/findAll">学生管理</a></li>
  		<li><a href="${app}/clazz/findAll">班级管理</a></li>
		<li><a href="${app}/grou/findAll">小组管理</a></li>
  		<li><a href="${app}/tag/findAll">标签管理</a></li>
  		<li><a href="${app}/city/findAll">就业城市管理</a></li>
  	</ul>
  
  </body>
</html>
