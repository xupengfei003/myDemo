<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XuPengFei
  Date: 2017/8/3
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>私人老师库-分页查询</title>
    <script text="javascript">

        function deleteT(id){
            var tId;
            alert(id);
            var flag = window.confirm("确定要删除吗？");
            if(flag){
                window.location.href="deleteTeacher?tId="+ id;
            }
        }

        function updateT(id){
            var tId;
            alert(id);
            var flag = window.confirm("确定要重新编辑吗？");
            if(flag){
                window.location.href="updateTeacher?tId="+ id;
            }
        }
    </script>
</head>
<body>
<c:if test="${empty pageT}">
    ${msg}
</c:if>
<br/>
<hr>

<c:if test="${not empty pageT}">
<table border="1" align="center" width="100%">
    <tr>
        <th>老师编号</th>
        <th>老师姓名</th>
        <th>老师课程</th>
        <th>选课号码</th>
        <th>编辑操作</th>
    </tr>
    <c:forEach items="${pageT}" var="tt">

            <tr>
            <th>${tt.tId}</th>
            <th>${tt.tName}</th>
            <th>${tt.tLesson}</th>
            <th>${tt.tNo}</th>
            <th><input type="submit" value="删除"  onclick="deleteT(${tt.tId})">&nbsp;&nbsp;
                <input type="submit" value="修改"  onclick="updateT(${tt.tId})"></th>
            </tr>
    </c:forEach>
<table/>
</c:if>

</body>
</html>
