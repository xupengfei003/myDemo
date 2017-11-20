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
    <title>三级联动练习</title>

    <script>
        function proFindCity() {
            var pId = document.getElementById("province").value;

        }
    </script>

</head>
<body>

<center>
    省：<select id="province" onchange="proFindCity()">
    <option value="">---请选择---</option>
    <c:forEach items="${map.pro}" var="pp">
        <option value="${pp.id}">${pp.name}</option>
    </c:forEach>
</select>
    市：<select id="city">
    <option value="">---请选择---</option>
    <c:forEach items="${map.city}" var="city">
        <option value="${city.id}">${city.name}</option>
    </c:forEach>
</select>
    县：<select id="county">
    <option value="">---请选择---</option>
    <c:forEach items="${map.county}" var="county">
        <option value="${county.id}">${county.name}</option>
    </c:forEach>

</select>
</center>

</body>

</html>
