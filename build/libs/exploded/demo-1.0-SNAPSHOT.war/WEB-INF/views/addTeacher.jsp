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
    <title>添加你的私人老师</title>
</head>
<body>
${msg}
<hr><br/>
添加你的私人老师信息:
<br/>
<hr>
    <form action="/teacher/addMyTeacher" method="post" >
        <div id="div01" >
        <br/>
        老师名称:<input type ="text" name ="tName" style="background: #ffc934"/>
        <br/>
        老师课程：<input type="text" name="tLesson" style="background: #9aff21"/>
        <br/>
        课程号码：<input type="text" name ="tNo" style="background: #28d8ff"/>
        <br/>
        确认提交：<input type="submit" value ="提交数据" style="background: #6312ff"/>
        </div>
    </form>
</body>
</html>
