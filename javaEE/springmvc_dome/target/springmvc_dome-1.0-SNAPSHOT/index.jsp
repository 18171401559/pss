<%--
  Created by IntelliJ IDEA.
  User: PengSS
  Date: 2018/9/15
  Time: 1:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- <a href="hello">点击入门</a>--%>
<form action="hello" method="post">
    用户名:<input type="text" name="username"><br>
    密码：<input type="text" name="password"><br>
    年龄：<input type="text" name="age"><br>
    <input type="submit" value="提交">
</form>

<h3>原始文件上传</h3>
<form action="upload1" method="post" enctype="multipart/form-data">
    选择上传文件：<input type="file" name="upload">
    <input type="submit" value="上传">
</form>

<h3>SpringMVC文件上传</h3>
<form action="upload2" method="post" enctype="multipart/form-data">
    选择上传文件：<input type="file" name="upload">
    <input type="submit" value="上传">
</form>

<h3>SpringMVC跨域文件上传</h3>
<form action="upload3" method="post" enctype="multipart/form-data">
    选择上传文件：<input type="file" name="upload">
    <input type="submit" value="上传">
</form>

</body>
</html>
