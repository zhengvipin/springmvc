<%--
  Created by IntelliJ IDEA.
  User: Zheng
  Date: 2018\4\10 0010
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Single Upload</title>
    <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
</head>
<body>

<div class="container border mt-4 pb-2">
    <h1>Single Upload</h1>
    <form action="single_upload.action" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${car.id}">
        <label>车名:</label>
        <input type="text" class="form-control" value="${car.name}"/>
        <label>价格:</label>
        <input type="text" class="form-control" value="${car.price}"/>
        <label>生产日期:</label>
        <input type="text" class="form-control" value="${car.createDate}"/>
        <c:if test="${!empty car.img}">
            <label>图片:</label>
            <img class="ml-2 mt-2" src="/pic/${car.img}" width=300 height=200">
        </c:if>
        <input type="file" name="singleFile"/>
        <button type="submit" class="btn btn-success">上传</button>
    </form>
</div>

<div class="container border mt-4 pb-2">
    <h1>Multipart Upload</h1>
    <form action="multipart_upload.action" method="post" enctype="multipart/form-data" multiple="">
        <label class="">选择文件:</label>
        <input type="file" name="multipartFile"/>
        <input type="file" name="multipartFile"/>
        <input type="file" name="multipartFile"/>
        <button type="submit" class="btn btn-success">上传</button>
    </form>
</div>
</body>
</html>

    
    
    