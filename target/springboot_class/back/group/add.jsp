<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="app" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
  <head>
    <title>add.html</title>
	
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
  	
  	<h1>添加小组</h1><hr/>
  	
  	
  	<form action="${app}/grou/save" method="post">
  		小组名称:<input type="text" name="name"/><br/>
		小组昵称:<input type="text" name="nickname"/><br/>
  		选择班级:
  		<select name="clazz.id">
			<c:forEach var="ca" items="${sessionScope.clazzes}">

					<option value="${ca.id}">${ca.name}</option>

			</c:forEach>
  		</select><br/><br/>
  		<input type="submit" value="提交"/>
		<input type="button" value="返回上级" onclick="history.go(-1);"/>
  	</form>
  
    	
  </body>
</html>
