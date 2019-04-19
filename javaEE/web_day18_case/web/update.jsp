<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>

<div class="container">
    <%@include file="header.jsp" %>
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <h3 style="text-align: center;">修改联系人</h3>
            <form action="${pageContext.request.contextPath}/update" method="post">

                <%--添加一个隐藏域,隐藏域中保存的是用户的ID数据--%>
                <input type="hidden" value="${user.id}" name="id">

                <div class="form-group">
                    <label for="name">姓名：</label>
                    <input type="text" class="form-control" id="name" name="name" readonly="readonly"
                           placeholder="请输入姓名" value="${user.name}"/>
                </div>

                <div class="form-group">
                    <label>性别：</label>
                    <input type="radio" name="gender" value="男"
                           <c:if test="${user.gender == '男'}">checked</c:if> />男
                    <input type="radio" name="gender" value="女"
                           <c:if test="${user.gender == '女'}">checked</c:if> />女
                </div>

                <div class="form-group">
                    <label for="age">年龄：</label>
                    <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄"
                           value="${user.age}"/>
                </div>

                <div class="form-group">
                    <label for="address">籍贯：</label>
                    <select id="address" name="address" class="form-control">
                        <option value="广东"
                                <c:if test="${user.address == '广东'}">selected</c:if>  >广东
                        </option>
                        <option value="广西"
                                <c:if test="${user.address == '广西'}">selected</c:if>   >广西
                        </option>
                        <option value="湖南"
                                <c:if test="${user.address == '湖南'}">selected</c:if>   >湖南
                        </option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="qq">QQ：</label>
                    <input id="qq" type="text" class="form-control" name="qq" placeholder="请输入QQ号码" value="${user.qq}"/>
                </div>

                <div class="form-group">
                    <label for="email">Email：</label>
                    <input id="email" type="text" class="form-control" name="email" placeholder="请输入邮箱地址"
                           value="${user.email}"/>
                </div>

                <div class="form-group" style="text-align: center">
                    <input class="btn btn-primary" type="submit" value="提交"/>
                    <input class="btn btn-default" type="reset" value="重置"/>
                    <input class="btn btn-default" type="button" value="返回"/>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
