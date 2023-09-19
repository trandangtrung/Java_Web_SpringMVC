<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="/" var="rootpath" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title><decorator:title default="WebShops" /> Twitter Bootstrap shopping cart</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap styles -->
<link href="${rootpath }assets/css/bootstrap.css" rel="stylesheet" />
<!-- Customize styles -->
<link href="${rootpath }assets/css/style.css"  rel="stylesheet" />
<!-- font awesome styles -->
<link href="${rootpath }assets/font-awesome/css/font-awesome.css"
	rel="stylesheet">


<!-- Favicons -->
<link rel="shortcut icon"
	href="${rootpath }/assets/ico/favicon.ico" />
<decorator:head />
</head>
<body>
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

	<!--
Lower Header Section 
-->
	<div class="container">
		<div id="gototop"></div>
		
		<%@include file="/WEB-INF/views/layouts/user/header.jsp" %>
		
		<decorator:body/>
		
		<%@include file="/WEB-INF/views/layouts/user/footer.jsp" %>
		
	</div>
	<!-- /container -->


	<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="${rootpath }assets/js/jquery.js" ></script>
	<script src="${rootpath }assets/js/bootstrap.min.js"></script>
	<script src="${rootpath }assets/js/jquery.easing-1.3.min.js"></script>
	<script
		src="${rootpath }assets/js/jquery.scrollTo-1.4.3.1-min.js" ></script>
	<script src="${rootpath }assets/js/shop.js" ></script>
	<decorator:getProperty property="page.script"></decorator:getProperty>
</body>
</html>