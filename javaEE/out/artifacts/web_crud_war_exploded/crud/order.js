$(function () {
    findAll();
})

//查询所有商品
function findAll() {
    $.post("/web_crud/OrderServlet?method=findAll", function (data) {
        var html = " <tr><td>序号</td><td>商品名称</td><td>商品厂家</td><td>商品价格</td><td>商品数量</td><td>操作</td></tr>";
        for (var i = 0; i < data.length; i++) {
            html += " <tr><td>" + (i + 1) + "</td><td>" + data[i].ordernum + "</td><td>" + data[i].ordername + "</td><td>" + data[i].ordercount + "</td><td>" + data[i].orderprices + "</td><td><button type='button' class='btn btn-primary btn-lg' data-toggle='modal' onclick='delOrder(" + data[i].id + ")'>删除</button></td></tr>"
        }
        $("#order_tb").html(html);
    }, "json")
}

//删除订单的方法
function delOrder(id) {
    $.post("/web_crud/OrderServlet?method=delOrder", {"id": id}, function (data) {
        if (data.type == 1) {
            alert(data.msg);
        } else {
            alert(data.msg);
        }
        findAll();
    }, "json")
}


function addOrders() {
    $("#myModal_add").modal("hide");
    var num = $("#exampleInputordernum").val();
    var name = $("#exampleInputordername").val();
    var count = $("#exampleInputordercount").val();
    var prices = $("#exampleInputorderprices").val();
    $("#exampleInputordernum").val("");
    $("#exampleInputordername").val("");
    $("#exampleInputordercount").val("");
    $("#exampleInputorderprices").val("");
    $.post("/web_crud/OrderServlet?method=addOrders", {
        "num": num,
        "name": name,
        "count": count,
        "prices": prices
    }, function (data) {
        if (data.type == 1) {
            alert(data.msg);
        } else {
            alert(data.msg);
        }
        findAll();
    }, "json")
}