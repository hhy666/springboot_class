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
  	
  	<h1>学生信息录入</h1><hr/>
  	
  	
  	<form action="${app}/student/save" method="post">
  	
  		学生名称:<input type="text" name="name"/><br/>
        学生账户:<input type="text" name="username"/><br/>
        学生密码:<input type="text" name="password"/><br/>
  		学生年龄:<input type="text" name="age"/><br/>
  		学生生日:<input type="text" name="bir"/><br/>
  		学生小组:
  		<select name="grou.id">
            <c:forEach var="gr" items="${sessionScope.grous}">

                    <option value="${gr.id}">${gr.name}</option>
            </c:forEach>
  		</select><br/>
  		学生班级:
  		<select name="clazz.id">
            <c:forEach var="cl" items="${sessionScope.clazzes}">

                    <option value="${cl.id}">${cl.name}</option>

            </c:forEach>
  		</select><br/>
  		学生就业城市:
  		<select name="city.id">
            <c:forEach var="ci" items="${sessionScope.cities}">

                    <option value="${ci.id}">${ci.name}</option>

            </c:forEach>
  		</select><br/>
  		学生标签:
        <c:forEach var="ta" items="${sessionScope.tags}">
        <c:if test="${ta.tagtype.equals('学生标签')}">
  		<input type="checkbox" name="tag.id" value="${ta.id}">${ta.name}
        </c:if>
        </c:forEach>
  		<br/><br/>
  		<input type="submit" value="提交"/>
		<input type="button" value="返回上级" onclick="history.go(-1);"/>
  	</form>
  
    	
  </body>
</html>
