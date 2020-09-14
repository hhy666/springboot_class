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
      <script src="${app}/statics/js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${app}/statics/css/styles.css">
      <link rel="stylesheet" type="text/css" href="${app}/statics/css/style.css">
  <script>

  </script>
  </head>
  
  <body >
  <h1>欢迎${student.username}访问</h1>
  <div >
      <div style="float: right;padding-top: 10px">
           <fmt:formatDate value="${Date()}" pattern="yyyy-MM-dd:hh:mm:ss"/>
          <a href="${app}/back/login.jsp" style="color: blue">安全退出</a>
      </div>
      <div style="float: left;padding-top: 10px">
      <h1 >系统主菜单</h1>
      </div>
      <div style="color: #669A16;padding-top: 30px">
          <hr />
      </div>
  </div>

  	<ul>
  		<li><a href="${app}/student/findAll">学生管理</a></li>
  		<li><a href="${app}/clazz/findAll">班级管理</a></li>
		<li><a href="${app}/grou/findAll">小组管理</a></li>
  		<li><a href="${app}/tag/findAll">标签管理</a></li>
  		<li><a href="${app}/city/findAll">就业城市管理</a></li>
  	</ul>
  
  </body>
</html>
