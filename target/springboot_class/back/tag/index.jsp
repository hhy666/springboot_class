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
  	
  	<h1>标签管理</h1><hr/>
  	
  	<h4>标签信息展示:</h4><hr/>
  	
  	<c:forEach items="${tags}" var="tag">
  	<ul>
  		<li>标签名:${tag.name}</li>
  		<li>创建时间:<fmt:formatDate value="${tag.creatdate}" pattern="yyyy-MM-dd"></fmt:formatDate> </li>
  		<li>是否是班级标签:<c:if test="${tag.tagtype.equals('班级标签')}">是</c:if>
			               <c:if test="${tag.tagtype.equals('学生标签')}">否</c:if>
		</li>
  	</ul>
	</c:forEach>
	<hr/>


  	
  	<input type="button" value="添加标签" onclick="location.href='${app}/back/tag/add.jsp'"/>
  	
  	
  </body>
</html>
