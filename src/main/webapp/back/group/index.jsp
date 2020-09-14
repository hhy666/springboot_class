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
  	
  	<h1>小组管理</h1><hr/>
  	
  	
  	<h4>小组展示:</h4><hr/>
  	<c:forEach var="go" items="${grous}">
  	<ul>

  		<li>小组id:${go.id}</li>
  		<li>小组名称:${go.name}</li>
  		<li>创建日期:<fmt:formatDate value="${go.creatdate}" pattern="yyyy-MM-dd"></fmt:formatDate> </li>
		<li>所属班级:${go.clazz.name}</li>
  		<li>目前标签:${go.clazz.tag.name}</li>

  	</ul>
	</c:forEach>
		<hr/>
  	
  	
  	<%-- <ul>
  		<li>С��id:22</li>
  		<li>С������:2��</li>
  		<li>����ʱ��:2015-10-15</li>
  		<li>�����༶:80��</li>
		<li>Ŀǰ��ǩ:ţ�ư�</li>
  	</ul><hr/>
	
	<ul>
  		<li>С��id:23</li>
  		<li>С������:2��</li>
  		<li>����ʱ��:2015-10-15</li>
  		<li>�����༶:81��</li>
		<li>Ŀǰ��ǩ:����</li>
  	</ul><hr/> --%>
  	
	<input type="button" value="添加小组" onclick="location.href='${app}/back/group/add.jsp'"/>
	<input type="button" value="返回上级" onclick="location.href='${app}/back/main/main.jsp'"/>
  </body>
</html>
