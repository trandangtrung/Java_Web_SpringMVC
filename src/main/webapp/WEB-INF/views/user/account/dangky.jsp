<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="/" var="rootpath" />
<head>
<title>Đăng ký, đăng nhập tài khoản</title>
<style type="text/css">
.box {
	color: red;
}

.box-ok {
	color: blue;
}
</style>
</head>
<body>
	<!-- 
Body Section 
-->
	<div class="row">
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
		<li> <a class="totalInCart" href="cart.html"><strong>Total Amount  <span class="badge badge-warning pull-right" style="line-height:18px;"><fmt:formatNumber type="number" groupingUsed="true" value="${ TotalPriceCart }"/> ₫</span></strong></a></li>
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
			<li style="border:0"> &nbsp;</li>
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
		<li class="active">Người dùng</li>
    </ul>
	<h3> Người dùng</h3>	
	<hr class="soft"/>
	<div class="row">
		<div class="span4">
			<div class="well">
			<h5>Đăng ký tài khoản</h5>
			<span class="box-ok">${msg}</span>
	        <span class="box">${msgErr }</span>
	<br>
			<form:form action="dang-ky" method="POST" modelAttribute="user">
			  <div class="control-group">
				<label class="control-label" for="inputEmail">Email</label>
				<div class="controls">
				  <form:input type="email" class="span3" placeholder="Mời nhập email" path="ten" required="required"/>
				</div>
			  </div>
			  <div class="control-group">
				<label class="control-label" for="inputPassword">Password</label>
				<div class="controls">
				  <form:input type="password" class="span3" placeholder="Mời nhập password" path="pass_word" required="required"/>
				</div>
			  </div>
			  
			  <div class="control-group">
				<label class="control-label" for="inputDisplayName">Họ và tên</label>
				<div class="controls">
				   <form:input type="text" class="span3" placeholder="Mời nhập họ và tên" path="display_name" required="required"/>
				</div>
			  </div>
			  
			  <div class="control-group">
				<label class="control-label" for="inputPassword">Địa chỉ</label>
				<div class="controls">
				   <form:input type="text" class="span3" placeholder="Mời nhập địa chỉ" path="address" required="required"/>
				</div>
			  </div>
			  <div class="control-group">
				<div class="controls">
				  <button type="submit" class="defaultBtn">Đăng ký thành viên</button>
				</div>
			  </div>
			</form:form>
		</div>
		</div>
	
	<div class="span1"> &nbsp;</div>
		<div class="span4">
			<div class="well">
			<h5>Đăng nhập hệ thống</h5>
			<span class="box-ok">${loginInfor}</span>
	        <span class="box">${msgEr }</span>
			 <br/>
			<form:form action="dang-nhap" method="POST" modelAttribute="user" >
			  <div class="control-group">
				<label class="control-label" for="inputEmail">Email</label>
				<div class="controls">
				 <form:input type="email" class="span3" placeholder="Mời nhập email" path="ten" required="required"/>
				</div>
			  </div>
			  <div class="control-group">
								<label class="control-label" for="inputPassword">Mật
									khẩu</label>
								<div class="controls">
									<form:input type="password" class="span3"
										placeholder="Mời nhập mật khẩu" path="pass_word" required="required"/>
								</div>
							</div>
			  <div class="control-group">
				<div class="controls">
					<button type="submit" class="defaultBtn">Đăng nhập</button>
					<a href="#">Quên mật khẩu?</a>
				</div>
			  </div>
			</form:form>
		</div>
		</div>
	</div>	
	
</div>
</div>
</body>
