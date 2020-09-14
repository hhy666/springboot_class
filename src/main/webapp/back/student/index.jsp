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
		table {
			border-right: 1px solid black;
			border-bottom: 1px solid black;
		}
		
		table td {
			width:200px;
			text-align:center;
			border-left: 1px solid black;
			border-top: 1px solid black;
		}
</style>
  </head>
  
  <body >
  	
  	<h1>学生管理</h1><hr/>
  	
  	<div style="margin: 0 auto; width:500px; height:30px" >
	  	<select>
	  		<option>姓名</option>
	  		<option>班级</option>
	  		<option>标签</option>
	  	</select>
	  	<input  type="text" placeholder="请输入查询条件" name=""/>
	  	<input  type="button" value="搜索"/>
  	</div>
  	<hr/>
  	<table border="0" cellspacing="0" cellpadding="0" >
  		<thead  STYLE="background-color: #669A16">

		<td>学生姓名</td>
		<td>学生年龄</td>
		<td>学生生日</td>
		<td>学生小组</td>
		<td>学生班级</td>
		<td>学生就业城市</td>
		<td>学生标签</td>
		<td>操作</td>
  		</thead>
		<c:forEach var="stu" items="${students}">

  		<tr >
  			<td>${stu.name}</td>
			<td>${stu.age}</td>
			<td><fmt:formatDate value="${stu.bir}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
			<td>${stu.grou.name}</td>
			<td>${stu.clazz.name}</td>
			<td>${stu.city.name}</td>
			<td>
            ${stu.tag.name}
            </td>

			<td><a href="${app}/student/findOne?id=${stu.id}">查看详情</a>|<a href="${app}/student/delete?id=${stu.id}">删除</a>|<a href="${app}/student/find?id=${stu.id}">修改</a></td>
  		</tr>
		</c:forEach>
  		<%-- <tr>
  			<td>����</td>
			<td>24</td>
			<td>80��</td>
			<td>����</td>
			<td>ѧ��,С��</td>
			<td><a href="detail.jsp">�鿴��ϸ</a>|<a href="">ɾ��</a>|<a href="./update.jsp">�޸�</a></td>
  		</tr> --%>
  	</table>
  	
  	<hr/>
  	<a href="">导出学生信息</a>
  	<a href="${app}/back/student/add.jsp">添加学生信息</a>
	<input type="button" value="返回上级" onclick="location.href='${app}/back/main/main.jsp'"/>
  </body>
</html>
