<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="app" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
  <head>
    <title>login</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
    <link rel="stylesheet" type="text/css" href="${app}/statics/css/styles.css">
    <script src="${app}/statics/js/jquery-3.4.1.min.js"></script>
    <script>
        $(function () {
            //登录请求
            $("#inputForm").submit(function () {
                //1.获取表单数据
                var serialize = $(this).serialize();
                //2.发送登录请求
                $.post("${pageContext.request.contextPath}/student/login",serialize,function (result) {
                    if(result.success){
                        location.href="${pageContext.request.contextPath}/back/main/main.jsp";
                    }else {
                        alert(result.message);
                    }
                },"JSON");
                return false;
            });
           $("#img_vcode").click(function () {
               $(this).attr("src","${app}/student/imageCode?abc="+Math.random());
           });

        });
    </script>
  </head>
  
  <body style="text-align: center;">
  	
  	<h1>用户登录</h1>
  	
  	<form action="" method="post" id="inputForm">
  	
  		用户名:<input type="text" name="username"><br/><br/>
  		
  		密&nbsp;&nbsp;码:<input type="text" name="password"><br/><br/>
  		
  		验证码:<input type="text" name="code"><img src="${app}/student/imageCode" id="img_vcode"/><br/><br/>
  		
  		<input type="submit" value="提交"/>
  		
  		<input type="button" value="注册"/>
  	</form>
  
  </body>
</html>
