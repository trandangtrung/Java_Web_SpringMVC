<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <c:url value="/san-pham" var="urlSP" /> --%>
<c:url value="/" var="rootpath" />

<title>Twitter Bootstrap shopping cart</title>

<body>
	
		<!-- 
Body Section 
-->
		<div class="row">
			<div id="sidebar" class="span3">
				<div class="well well-small">
					<ul class="nav nav-list">
						<c:forEach var="lsp" items="${loaisp }">
							<li><a href='<c:url value="san-pham/${lsp.ma_lsp }" />' ><span
									class="icon-chevron-right"></span> ${lsp.ten_loai}</a></li>
						</c:forEach>

						<li style="border: 0">&nbsp;</li>
						<li><a class="totalInCart" href="cart.html"><strong>Tổng
									tiền <span class="badge badge-warning pull-right"
									style="line-height: 18px;"><fmt:formatNumber type="number" groupingUsed="true" value="${ TotalPriceCart }"/> ₫</span>
							</strong></a></li>
					</ul>
				</div>

				<div class="well well-small alert alert-warning cntr">
					<h2>20% Discount</h2>
					<p>
						only valid for online order. <br> <br> <a
							class="defaultBtn" href="#">Click here </a>
					</p>
				</div>
<!-- 				<div class="well well-small"> -->
<%-- 					<a href="#"><img src="<c:url value="${rootpath}assets/img/paypal.jpg" />" --%>
<!-- 						alt="payment method paypal"></a> -->
<!-- 				</div> -->

				<a class="shopBtn btn-block" href="#">Upcoming products <br>
					<small>Click to view</small></a> <br> <br>
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
				<div class="well np">
					<div id="myCarousel" class="carousel slide homCar">
						<div class="carousel-inner">
							<div class="item">
								<img style="width: 100%"
									src="<c:url value="assets/img/banner.png" />"
									alt="bootstrap ecommerce templates">
								<div class="carousel-caption">
									<h4>Bootstrap shopping cart</h4>
									<p>
										<span>Very clean simple to use</span>
									</p>
								</div>
							</div>
							<div class="item">
								<img style="width: 100%"
									src="<c:url value="assets/img/banner2.jpeg" />"
									alt="bootstrap ecommerce templates">
								<div class="carousel-caption">
									<h4>Bootstrap Ecommerce template</h4>
									<p>
										<span>Highly Google seo friendly</span>
									</p>
								</div>
							</div>
							<div class="item active">
								<img style="width: 100%"
									src="<c:url value="assets/img/banner1.jpeg" />"
									alt="bootstrap ecommerce templates">
								<div class="carousel-caption">
									<h4>Twitter Bootstrap cart</h4>
									<p>
										<span>Very easy to integrate and expand.</span>
									</p>
								</div>
							</div>
						</div>
						<a class="left carousel-control" href="#myCarousel"
							data-slide="prev">&lsaquo;</a> <a class="right carousel-control"
							href="#myCarousel" data-slide="next">&rsaquo;</a>
					</div>
				</div>
				<!--
New Products
-->
				<div class="well well-small">
					<h3>Sản phẩm mới</h3>
					<hr class="soften" />
					<div class="row-fluid">
						<div id="newProductCar" class="carousel slide">
							<div class="carousel-inner">
								<c:if test="${lstsp.size() >0  }">
									<div class="item active">
										<ul class="thumbnails">
											<c:forEach var="sp" items="${lstsp }" varStatus="loop">
												<li class="span3">
													<div class="thumbnail">
														<a class="zoomTool" href="product_details.html"
															title="add to cart"><span class="icon-search"></span>
															QUICK VIEW</a> <a href="product_details.html"><img
															src="<c:url value ="/assets/img/${sp.img }" />" alt=""></a>
													</div>
												</li>
												<c:if
													test="${(loop.index +1) %4 ==0 || (loop.index + 1) == lstsp.size() }">
													<%-- 								</c:forEach> --%>
												</ul>
											</div>
										<c:if test="${(loop.index +1 )< lstsp.size()}">
											<div class="item">
												<ul class="thumbnails">
										</c:if>
								</c:if>
								</c:forEach>
							</c:if>
							</div>
							<a class="left carousel-control" href="#newProductCar"
								data-slide="prev">&lsaquo;</a> <a class="right carousel-control"
								href="#newProductCar" data-slide="next">&rsaquo;</a>
						</div>
					</div>

				</div>
				<!--
	Featured Products
	-->			
				<div class="well well-small">
					<h3>
						<a class="btn btn-mini pull-right" href="products.html"
							title="View more">VIew More<span class="icon-plus"></span></a>
						Sản phẩm nổi bật
					</h3>
					<hr class="soften" />
					<div class="row-fluid">
						<c:if test="${lstsp1.size() >0}">
							<ul class="thumbnails">
								<c:forEach var="sp" items="${lstsp1 }" varStatus="loop">
									<li class="span4">
										<div class="thumbnail">
											<a class="zoomTool" href="product_details.html"
												title="add to cart"><span class="icon-search"></span>
												QUICK VIEW</a> <a href="chi-tiet-san-pham/${sp.ma_sp }"><img
												src="<c:url value ="/assets/img/${sp.img }" />"
												alt=""></a>
											<div class="caption">
												<h5>${sp.ten_sp}</h5>
												<h4>
													<a class="defaultBtn" href="product_details.html"
														title="Click to view"><span class="icon-zoom-in"></span></a>
													<a class="shopBtn" href="<c:url value="/AddCart/${sp.ma_sp }" />" title="add to cart"><span
														class="icon-plus"></span></a> <span class="pull-right"><fmt:formatNumber
															type="number" groupingUsed="true" value="${sp.gia_moi } " />
														₫</span>
												</h4>
											</div>
										</div>
									</li>
									 <c:if
										test="${(loop.index +1) %3 ==0 || (loop.index + 1) == lstsp1.size() }">
										<%-- 								</c:forEach> --%>
								</ul>
							<c:if test="${(loop.index +1 )< lstsp1.size()}">
								<ul class="thumbnails">
							</c:if>
						</c:if>
						</c:forEach>
						</c:if>
					</div>
				</div>
				<hr>
				<div class="well well-small">
					<a class="btn btn-mini pull-right" href="#">Xem thêm <span
						class="icon-plus"></span></a> Tất cả sản phẩm
				</div>
				<hr>
			</div>
		</div>
</body>
