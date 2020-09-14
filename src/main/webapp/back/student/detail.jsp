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
			/* test-align: center; */
		}
		select{
			width:173px;
		}
    </style>
  </head>
  
  <body >
  	
  	<h1>学生详细信息展示</h1><hr/>

  	<ul>
  		<li>学生姓名:${student.name}</li>
  		<li>学生年龄:${student.age}</li>
  		<li>学生班级:${student.clazz.name}</li>
		<li>学生小组:${student.grou.name}</li>
  		<li>学生就业城市:${student.city.name}</li>
  		<li>学生标签:${student.tag.name}</li>
  	</ul><hr/>
    <br/><br/>
    <input type="button" value="返回上级" onclick="history.go(-1);"/>

  </body>
</html>
