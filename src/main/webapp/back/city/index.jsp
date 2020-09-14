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
  	
  	<h1>就业城市管理</h1><hr/>
  	
  	<h4>城市信息展示:</h4><hr/>
  	<c:forEach var="ci" items="${cities}">
  	<ul>
  		<li>城市名:${ci.name}</li>
  		<li>创建时间:<fmt:formatDate value="${ci.creatdate}" pattern="yyyy-MM-dd"></fmt:formatDate> </li>
  	</ul>
    </c:forEach>
        <hr/>
  	
  	
  	<%-- <ul>
  		<li>������:����</li>
  		<li>����ʱ��:2013-12-12</li>
  	</ul><hr/> --%>
  		
  	<input type="button" value="添加城市" onclick="location.href='${app}/back/city/add.jsp'"/>
    <input type="button" value="返回上级" onclick="location.href='${app}/back/main/main.jsp'"/>
  	
  </body>
</html>
