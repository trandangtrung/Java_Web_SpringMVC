<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="/" var="rootpath" />
<head>
<title>Giỏ hàng</title>
</head>
<body>
	<!-- 
Body Section 
-->
	<div class="row">
	<div class="span12">
    <ul class="breadcrumb">
		<li><a href="${rootpath }">Trang chủ</a> <span class="divider">/</span></li>
		<li class="active">Giỏ hàng</li>
    </ul>
	<div class="well well-small">
		<h1>Giỏ hàng <small class="pull-right"> ${TotalQuantyCart } sản phẩm trong giỏ hàng </small></h1>
	<hr class="soften"/>	

	<table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>Hình ảnh</th>
                  <th>Thông tin</th>
                   <th>Trạng thái</th>
				  <th>Giá bán </th>
                  <th>Số lượng</th>
                  <th>Chỉnh sửa</th>
                  <th>Xóa</th>
                  <th>Tổng tiền</th>
				</tr>
              </thead>
              <tbody>
            
              	<c:forEach var="lsp" items="${Cart }">
					<tr>
	                  <td><img width="100" src="assets/img/${lsp.value.sanpham.img }" alt=""></td>
	                  <td>Sản phẩm mới nhập</td>
	                  <td>${(lsp.value.sanpham.trang_thai==1) ? "Còn hàng" : "Hết hàng"}</td>
	                  <td><fmt:formatNumber type="number" groupingUsed="true" value="${lsp.value.sanpham.gia_moi }"/> ₫</td>
	                  <td>
						<input type="number" min="0" max="100" class="span1" style="max-width:34px" placeholder="1" id="quanty-cart-${lsp.key }" size="16" type="text" value="${lsp.value.quanty }">
						</td>
						<td>
						 <button data-id="${lsp.key }" class="btn btn-mini btn-danger edit-cart" type="button" >
						 	<span class="icon-edit"></span>
						 </button>
						 </td>
						 <td>
					  <a  href="<c:url value="/DeleteCart/${lsp.key }" />" class="btn btn-mini btn-danger" type="button">
					  		<span class="icon-remove"></span>
					  	</a>	
					</td>
	                  <td><fmt:formatNumber type="number" groupingUsed="true" value="${lsp.value.totalPrice }"/> ₫</td>
	                </tr>
			  	</c:forEach>

				</tbody>
            </table><br/>
		
		
           
	<a href="${rootpath }" class="shopBtn btn-large"><span class="icon-arrow-left"></span> Tiếp tục mua sắm </a>
	<a href="${rootpath }thanhtoan" class="shopBtn btn-large pull-right">Thanh Toán <span class="icon-arrow-right"></span></a>

</div>
</div>
</div>

<content tag="script">
<script >
	$(".edit-cart").on("click", function(){
		var id = $(this).data("id");
		var quanty = $("#quanty-cart-" + id).val();
		window.location = "EditCart/"+id+"/"+quanty;
		});

</script>
</content>


</body>
