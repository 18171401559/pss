<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function deleteUser(id) {
            //弹出一个确认框
            var flag = confirm("您确定删除该用户吗?"); //true 用户点击确定  false用户点击取消
            if (flag) {
                //使用JS跳转页面
                window.location.href = "${pageContext.request.contextPath}/delete?id=" + id;
            }
        }

        //页面加载完成之后
        window.onload = function () {
            document.getElementById("btn_del").onclick = function () {

                var flag = false ;

                //获取所有的复选框
                var chs = document.getElementsByName("id");
                for (var i = 0; i < chs.length; i++) {
                    //如果有需要删除的数据,设置标记为true
                    if(chs[i].checked){
                        flag = true;
                        break ;
                    }
                }

                if(flag){
                    //提示用户是否需要删除,如果确定删除数据
                    if(confirm("您确定要删除选中数据码?")){
                        //使用JS提交表单
                        document.getElementById("selectForm").submit();
                    }

                }
            }

            //给全选按钮绑定点击事件
            document.getElementById("checkAll").onclick = function () {
                //获取所有的复选框
                var chs = document.getElementsByName("id");
                for (var i = 0; i < chs.length; i++) {
                    //设置复选框的选择状态与全选按钮一致
                    chs[i].checked = this.checked ;
                }
            }
        }



    </script>
</head>
<body>
<div class="container">

    <%@include file="header.jsp" %>
    <h3 style="text-align: center">用户信息列表</h3>
    <!--搜索栏-->
    <div style="float: left;">
        <form class="form-inline" action="${pageContext.request.contextPath}/search">
            <div class="form-group">
                <label for="name">姓名</label>
                <input type="text" class="form-control" id="name" name="name" value="${condition.name}">
            </div>
            <div class="form-group">
                <label for="address">籍贯</label>
                <input type="text" class="form-control" id="address" name="address" value="${condition.address}">
            </div>

            <div class="form-group">
                <label for="email">邮箱</label>
                <input type="text" class="form-control" id="email" name="email" value="${condition.email}">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <!--按钮-->
    <div style="float: right;margin: 5px;">
        <a class="btn btn-primary" href="add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="btn_del">删除选中</a>
    </div>

    <form action="${pageContext.request.contextPath}/deleteList"  id="selectForm" >
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="checkAll"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${pb.list}" var="user" varStatus="vs">
                <tr>
                    <td><input type="checkbox" name="id" value="${user.id}"></td>
                    <td>${vs.count}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}</td>
                    <td>
                        <a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/findById?id=${user.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:void(0);"
                           onclick="deleteUser(${user.id})">删除</a>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </form>

    <!--分页条-->
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <!--上一页-->
                <!--当前页为第一页,上一页不能点击-->
                <c:if test="${pb.currentPage == 1}">
                    <li class="disabled">
                        <a href="javascript:void(0);" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>

                <!--当前页不为第一页,上一页可以点击-->
                <c:if test="${pb.currentPage != 1}">
                    <li>
                        <a href="${pageContext.request.contextPath}/search?currentPage=${pb.currentPage - 1}&rows=5&name=${condition.name}&address=${condition.address}&email=${condition.email}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>

                <!--页码-->
                <c:forEach begin="1" end="${pb.totalPage}" var="i" >
                    <c:if test="${pb.currentPage == i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/search?currentPage=${i}&rows=5&name=${condition.name}&address=${condition.address}&email=${condition.email}">${i}</a></li>
                    </c:if>
                    <c:if test="${pb.currentPage != i}">
                        <li><a href="${pageContext.request.contextPath}/search?currentPage=${i}&rows=5&name=${condition.name}&address=${condition.address}&email=${condition.email}">${i}</a></li>
                    </c:if>
                </c:forEach>

                <!--下一页-->
                <!--当前页为最后一页,下一页不可点-->
                <c:if test="${pb.currentPage == pb.totalPage}">
                    <li class="disabled">
                        <a href="javascript:void(0);" aria-label="Previous">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <!--当前页不为最后一页,下一页可点-->
                <c:if test="${pb.currentPage != pb.totalPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/search?currentPage=${pb.currentPage + 1}&rows=5&name=${condition.name}&address=${condition.address}&email=${condition.email}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>

                <span style="font-size: 25px;margin-left: 5px;">
                共${pb.totalCount}条记录，共${pb.totalPage}页
            </span>

            </ul>
        </nav>
    </div>
</div>
</body>
</html>

