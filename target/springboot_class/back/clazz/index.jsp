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
  	
  	<h1>班级管理</h1><hr/>
  	
  	
  	<h4>班级信息展示:</h4><hr/>
  	<c:forEach items="${clazzes}" var="cl">
  	<ul>
  		<li>班级名称:${cl.name}</li>
  		<li>班级标签:${cl.tag.name}</li>
  	</ul>
    </c:forEach>
        <hr/>
  	
  	<%-- <ul>
  		<li>�༶����:90��</li>
  		<li>�༶��ǩ:��֪�ڶ���</li>
  	</ul><hr/> --%>
  	
  	
  	
  	<input type="button" value="添加班级" onclick="location.href='${app}/back/clazz/add.jsp'"/>
  		
  </body>
</html>
