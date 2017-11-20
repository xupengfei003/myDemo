<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XuPengFei
  Date: 2017/8/1
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片上传</title>


</head>
<body>
你的私人图片库: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<br/>
<hr>
<c:if test="${empty upload}">
    ${msg}
</c:if>

<c:if test="${not empty upload}">
<table border="1" align="center" width="100%">
    <tr>
        <th>图片名</th>
        <th>图片url</th>
        <th>图片type</th>
        <th>图片size</th>
        <th>图片baseUrl</th>
    </tr>
    <tr>
            <th>${upload.fileName}</th>
            <th>${upload.url}</th>
            <th>${upload.type}</th>
            <th>${upload.size}</th>
            <th>${upload.baseUrl}</th>
    </tr>
<table/>
</c:if>

</body>
</html>
