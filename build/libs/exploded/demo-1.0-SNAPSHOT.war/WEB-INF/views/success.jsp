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
    <title>SSM</title>
  </head>
  <body>
 Request Success.jsp ！
 <c:if test="${requestScope.user == null}">
    ${message}
     <form action="/user/login" method="get">
         请输入用户名：<input type="text" name="userName">
         <input type="submit" value="提交">
     </form>
 </c:if>


   <div style="background: #21e1ff">
       <c:if test="${requestScope.user != null}">
           欢迎： ${user.userName},到访时间：${user.userDate}!
           <hr/>
           <h3>HttpServletRequest对象中存的用户信息如下：</h3>
        <div style="background: #f4a7ff">
            用户编号：${requestScope.user.userId}
            <br>
            用户 名：${requestScope.user.userName}
            <br>
            用户性别：${requestScope.user.userSex}
        </div>
       </c:if>
   </div>

 <br>
 <hr/>
  <c:if test="${requestScope.user != null}">
    <a href="/teacher/teacherList">进入你的私人老师库</a>
  </c:if>
 <br>
 <hr/>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <p>我的Local上传图片:E:\demo\build\libs\exploded\demo-1.0-SNAPSHOT.war\upload<p/>&nbsp;&nbsp;&nbsp;
 <form method="post" action="/upload/loadToLocal" enctype="multipart/form-data">
     <input type="file" name="file">&nbsp;&nbsp;&nbsp;${localMsg}
     <input type="submit" value="确定">
 </form>

 <br>
 <hr/>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <p>我的ftp上传图片<p/>
 <form method="post" action="/upload/loadToFTP" enctype="multipart/form-data">
     <input type="file" name="file">&nbsp;&nbsp;&nbsp; ${ftpMsg}
     <input type="submit" value="确定">
 </form>
 <hr/>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <p>我的-IO-上传图片:E:\TEST\upload<p/>
 <form method="post" action="/upload/ioUpload" enctype="multipart/form-data">
     <input type="file" name="file">&nbsp;&nbsp;&nbsp; ${ftpMsg}
     <input type="submit" value="确定">
 </form>
 <hr/>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <p>我的-springUpload-上传图片:E:/TEST/upload/<p/>
 <form method="post" action="/upload/springUpload" enctype="multipart/form-data">
     <input type="file" name="file">&nbsp;&nbsp;&nbsp; ${ftpMsg}
     <input type="submit" value="确定">
 </form>
  </body>
</html>
