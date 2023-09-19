<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="/" var="rootpath" />
<head>

<title>Chi tiết sản phẩm</title>
<style >
	.product-content {
		overflow-x: hidden;
	}

</style>
</head>
<body>
	<!-- 
Body Section 
-->

<!-- 
	Upper Header Section 
-->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="topNav">
			<div class="container">
				<div class="alignR">
					<div class="pull-left socialNw">
						<a href="#"><span class="icon-twitter"></span></a> <a href="#"><span
							class="icon-facebook"></span></a> <a href="#"><span
							class="icon-youtube"></span></a> <a href="#"><span
							class="icon-tumblr"></span></a>
					</div>
					<a class="active" href="index.html"> <span class="icon-home"></span>
						Home
					</a> 
					<c:if test="${not empty loginInfor }">
						<a href="#"><span class="icon-user"></span>${loginInfor.display_name } </a>
						<a href='<c:url value="/dang-xuat" />'><span class= "icon-edit"></span>Đăng xuất</a>
					</c:if>
					
					<c:if test="${empty loginInfor }">
						<a href='<c:url value="/dang-ky" />'><span class= "icon-edit"></span>Đăng ký</a>
					
					</c:if>
					
					 <a href="${rootpath }admin/login"><span class="icon-envelope"></span>
						Admin</a> <a href="<c:url value="/gio-hang" />"><span
						class="icon-shopping-cart"></span> ${ TotalQuantyCart } Sản phẩm - <span
						class="badge badge-warning"><fmt:formatNumber type="number" groupingUsed="true" value="${ TotalPriceCart }"/> ₫</span></a>
				</div>
			</div>
		</div>
	</div>



	<div class="row product-content">
<div id="sidebar" class="span3">
<div class="well well-small">
	<ul class="nav nav-list">
		<li><a href="products.html"><span class="icon-chevron-right"></span>Fashion</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Watches</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Fine Jewelry</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Fashion Jewelry</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Engagement & Wedding</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Men's Jewelry</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Vintage & Antique</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Loose Diamonds </a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Loose Beads</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>See All Jewelry & Watches</a></li>
		<li style="border:0"> &nbsp;</li>
		<li> <a class="totalInCart" href="cart.html"><strong>Tổng tiền  <span class="badge badge-warning pull-right" style="line-height:18px;"><fmt:formatNumber type="number" groupingUsed="true" value="${ TotalPriceCart }"/> ₫</span></strong></a></li>
	</ul>
</div>

			  <div class="well well-small alert alert-warning cntr">
				  <h2>50% Discount</h2>
				  <p> 
					 only valid for online order. <br><br><a class="defaultBtn" href="#">Click here </a>
				  </p>
			  </div>
			
			<a class="shopBtn btn-block" href="#">Upcoming products <br><small>Click to view</small></a>
			<br>
			<br>
			<ul class="nav nav-list promowrapper">
			<li>
			  <div class="thumbnail">
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<img src="${rootpath}assets/img/g1.jpeg" alt="bootstrap ecommerce templates">
				<div class="caption">
				  <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span class="pull-right">320.000 ₫</span></h4>
				</div>
			  </div>
			</li>
			<li style="border:0"> &nbsp;</li>
			<li>
			  <div class="thumbnail">
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<img src="${rootpath}assets/img/manu.jpeg" alt="shopping cart template">
				<div class="caption">
				  <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span class="pull-right">160.000 ₫</span></h4>
				</div>
			  </div>
			</li>
			<li style="border:0"> &nbsp;</li>
			<li>
			  <div class="thumbnail">
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<img src="${rootpath}assets/img/ni1.jpeg" alt="bootstrap template">
				<div class="caption">
				  <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span class="pull-right">320.000 ₫</span></h4>
				</div>
			  </div>
			</li>
		  </ul>

	</div>
	<div class="span9">
    <ul class="breadcrumb">
    <li><a href="${rootpath }">Trang chủ</a> <span class="divider">/</span></li>
    <li><a href="products.html">Sản phẩm</a> <span class="divider">/</span></li>
    <li class="active">Chi tiết sản phẩm</li>
    </ul>	
	<div class="well well-small">
	<div class="row-fluid">
			<div class="span5">
			<div id="myCarousel" class="carousel slide cntr">
                <div class="carousel-inner">
                  <div class="item active">
                   <a href="#"> <img src='<c:url value="/assets/img/${lstdao.img }" />' alt="" style="width:100%"></a>
                  </div>
                </div>
                <a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next">›</a>
            </div>
			</div>
			<div class="span7">
				<h3><h1>${lstdao.ten_sp }</h1></h3>
				<hr class="soft"/>
				
				<form class="form-horizontal qtyFrm" method="get" action="<c:url value="/AddCart/${lstdao.ma_sp }" />"> 
				  <div class="control-group">
					<label class="control-label"><span>Giá: <fmt:formatNumber
															type="number" groupingUsed="true" value="${lstdao.gia_moi } " />
														₫</span></label>
					<div class="controls">
					<input type="number" min="0" value="0" class="span6">
					</div>
				  </div>
				<h3>Trạng thái: </h3>
				<p>${(lstdao.trang_thai==1) ? "Còn hàng" : "Hết hàng"}</p>
				  
				  <h4>Lượt xem</h4>	
				  <p>${lstdao.luot_xem }
				  </p>
				  <button type="submit" class="shopBtn"><span class=" icon-shopping-cart" href="<c:url value="/AddCart/${lstdao.ma_sp }" />"></span>Thêm giỏ hàng </button>
				</form>
			</div>
			</div>
				<hr class="softn clr"/>


            <ul id="productDetail" class="nav nav-tabs">
              <li class="active"><a href="#home" data-toggle="tab">Chi tiết sản phẩm</a></li>
              <li class=""><a href="#profile" data-toggle="tab">Sản phẩm liên quan</a></li>
            </ul>
            <div id="myTabContent" class="tab-content tabWrapper">
	            <div class="tab-pane fade active in" id="home">
					<table class="table table-striped">
					<tbody>
					<tr class="techSpecRow"><td class="techSpecTD1">Color:</td><td class="techSpecTD2">Black</td></tr>
					<tr class="techSpecRow"><td class="techSpecTD1">Style:</td><td class="techSpecTD2">Apparel,Sports</td></tr>
					<tr class="techSpecRow"><td class="techSpecTD1">Season:</td><td class="techSpecTD2">spring/summer</td></tr>
					<tr class="techSpecRow"><td class="techSpecTD1">Usage:</td><td class="techSpecTD2">fitness</td></tr>
					<tr class="techSpecRow"><td class="techSpecTD1">Sport:</td><td class="techSpecTD2">122855031</td></tr>
					<tr class="techSpecRow"><td class="techSpecTD1">Brand:</td><td class="techSpecTD2">Shock Absorber</td></tr>
					</tbody>
					</table>
					<p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
					<p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
					<p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
					<p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
					<p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
					<p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
					<p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
					<p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
				</div>
				
				
				<div class="tab-pane fade1" id="profile">
				
					<c:set var="countList" value="${lstdao1.size() }"/>
					<c:if test="${lstdao1.size() } > 5">
						<c:set var="countList" value="5" />
					</c:if>
					
					<c:forEach var="lsp1" items="${lstdao1 }" begin="1" end="${countList}" varStatus="loop">
								<div class="row-fluid">
									<div class="span2">
										<img src="<c:url value="/assets/img/${lsp1.img }" />" alt="">
									</div>
									<div class="span6">
										<h5>${lsp1.ten_sp }</h5>
										
										<p>Lượt xem: ${lsp1.luot_xem }</p>
									</div>
									<div class="span4 alignR">
										<form class="form-horizontal qtyFrm">
											<h3><fmt:formatNumber
	 															type="number" groupingUsed="true" value="${lsp1.gia_moi } " />₫</h3> 
											<div class="btn-group">
												<a href="<c:url value="/AddCart/${lsp1.ma_sp }" />" class="defaultBtn"><span 
													class=" icon-shopping-cart"></span> Add to cart</a> <a 
													href="product_details.html" class="shopBtn">VIEW</a> 
											</div> 
										</form> 
									</div> 
	 							</div> 
								<hr class="soft" /> 
					</c:forEach> 
			
			 	</div> 
              
           </div>

 </div> 
 </div> 
</div>
<!--  Body wrapper -->
</body>

