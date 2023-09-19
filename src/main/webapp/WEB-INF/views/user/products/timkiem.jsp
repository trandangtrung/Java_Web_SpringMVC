<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="/" var="rootpath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
New Products
-->

<div class="well well-small">
	<h3><a class="h3"  href="${rootpath }">Trang chủ</a> </h2>
					<h3>
						<a class="btn btn-mini pull-right" href="products.html"
							title="View more">VIew More<span class="icon-plus"></span></a>
						Sản phẩm tìm kiếm
					</h3>
					<hr class="soften" />
					<div class="row-fluid">
						<c:if test="${lstsp.size() >0}">
							<ul class="thumbnails">
								<c:forEach var="sp" items="${lstsp }" varStatus="loop">
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
										test="${(loop.index +1) %3 ==0 || (loop.index + 1) == lstsp.size() }">
										<%-- 								</c:forEach> --%>
								</ul>
							<c:if test="${(loop.index +1 )< lstsp.size()}">
								<ul class="thumbnails">
							</c:if>
						</c:if>
						</c:forEach>
						</c:if>
					</div>
				</div>

</body>
</html>