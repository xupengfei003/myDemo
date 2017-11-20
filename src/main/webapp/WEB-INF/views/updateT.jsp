<%--
  Created by IntelliJ IDEA.
  User: XuPengFei
  Date: 2017/8/2
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑我的私人助教信息</title>
</head>
<body>
编辑我的私人助教信息如下：
<br><hr/>
<form action="/teacher/submitAddTeacher" method="post">
    <br/>
    老师编号:<input type ="text" name="tId" value ="${teacher.tId}" readonly/>
    <br/>
    老师名称:<input type ="text" name="tName"  value ="${teacher.tName}"/>
    <br/>
    老师课程：<input type="text" name="tLesson" value="${teacher.tLesson}"/>
    <br/>
    课程号码：<input type="text" name="tNo" value ="${teacher.tNo}"/>
    <br/>
    确认提交：<input type="submit" value ="提交数据"/>

</form>
</body>
</html>
