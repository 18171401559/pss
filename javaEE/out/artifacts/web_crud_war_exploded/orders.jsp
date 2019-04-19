<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单</title>

   <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="crud/order.js"></script>
</head>
<body>

<div class="container">


	
  <div class="row">
    <!-- 彈框 -->
	<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal_add">
  	订单添加
	</button>
  </div>
  
  
  <!-- 表格数据 -->
  <div>
  <table class="table table-hover" id="order_tb">
<!--   <tr>
  <td>订单编号</td>
  <td>订单名称</td>
  <td>订单数量</td>
  <td>订单价格</td>
  <td>操作</td>
</tr> -->
  
</table>
  </div>
  
  
</div>







<!-- 添加的Modal -->
<div class="modal fade" id="myModal_add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="addModalLabel">添加订单</h4>
      </div>
      <div class="modal-body">
        	<form>
			  <div class="form-group">
			    <label for="exampleInputordername">商品名称</label>
			    <input type="text" class="form-control" id="exampleInputordernum" placeholder="订单编号">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputordernum">厂家</label>
			    <input type="text" class="form-control" id="exampleInputordername" placeholder="订单名称">
			  </div>
			  
			    <div class="form-group">
				    <label for="exampleInputorderprices">价格</label>
				    <input type="text" class="form-control" id="exampleInputordercount" placeholder="订单数量">
			  	</div>
			  	
			  	 <div class="form-group">
				    <label for="exampleInputordercount">数量</label>
				    <input type="text" class="form-control" id="exampleInputorderprices" placeholder="订单价格">
			  	</div>
			  

			  <button type="button" class="btn btn-default" onclick="addOrders()">提交订单</button>
			 
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>


<!-- 修改的Modal -->

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="updateModalLabel">修改订单</h4>
      </div>
      <div class="modal-body">
        	<form>
			  <div class="form-group">
			    <label for="exampleInputordernum_update">订单编号</label>
			    <input type="text" class="form-control" id="exampleInputordernum_update" placeholder="订单编号">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputordername_update">订单名称</label>
			    <input type="text" class="form-control" id="exampleInputordername_update" placeholder="订单名称">
			  </div>
			  
			    <div class="form-group">
				    <label for="exampleInputordercount_update">订单数量</label>
				    <input type="text" class="form-control" id="exampleInputordercount_update" placeholder="订单数量">
			  	</div>
			  	
			  	 <div class="form-group">
				    <label for="exampleInputorderprices_update">订单价格</label>
				    <input type="text" class="form-control" id="exampleInputorderprices_update" placeholder="订单价格">
			  	</div>
			  

			  <button type="button" class="btn btn-default" id="updateorder">修改订单</button>
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>