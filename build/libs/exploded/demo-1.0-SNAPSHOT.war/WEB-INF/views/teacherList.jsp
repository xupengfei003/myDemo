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
    <title>私人老师库</title>
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
你的私人老师库: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="addTeacher">添加私人助教</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="/area/getAll">看看我的三级联动</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="/teacher/pageT">我的-分页-私人助教</a>
<br/>
<hr>
<c:if test="${empty teacherList}">
    ${msg}
</c:if>

<c:if test="${not empty teacherList}">
<table border="1" align="center" width="100%">
    <tr style="background: #16ff14">
        <th>老师编号</th>
        <th>老师姓名</th>
        <th>老师课程</th>
        <th>选课号码</th>
        <th>编辑操作</th>
    </tr>
    <c:forEach items="${teacherList}" var="tt">

            <tr style="background: #ff8d33">
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
