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
	  <script src="${app}/js/jquery-3.4.1.min.js"></script>

  </head>
  
  <body >
  	
  	<h1>班级添加</h1><hr/>
  	
  	
  	<form action="${app}/clazz/save" method="post">
  		班级名称:<input type="text" name="name"/><br/>
  		选择标签:
  		<select name="tag.id" >
			<c:forEach var="ta" items="${sessionScope.tags}">
				<c:if test="${ta.tagtype.equals('班级标签')}">
				<option value="${ta.id}">${ta.name}</option>
				</c:if>
			</c:forEach>
  		</select><br/><br/>
  		<input type="submit" value="提交"/>
		<input type="button" value="返回上级" onclick="history.go(-1);"/>
  	</form>
  
    	
  </body>
</html>
