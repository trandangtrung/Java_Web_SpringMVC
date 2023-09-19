<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="/" var="rootpath" />
<!DOCTYPE html>
<html>
<head>
<title>Danh sách sản phẩm</title>
<style>
	.pagination {
		display: flex;
		justify-content: center;
	}
	
	.pagination a {
		color: black;
		float: left;
		padding: 8px 16px;
		text-decoration: none;
		transition: background-color .3s;
		border: 1px solid #ddd;
	}
	
	.pagination a.active {
		background-color: #4CAF50;
		color: white;
		border: 1px solid #4CAF50;
	}
	
	.pagination a:hover:not(.active) {
		background-color: #ddd;
	}
</style>
</head>
<body>

		<div class="well well-small">
			<div class="row">
				<span style="margin-left: 25px;">Danh sách sản phẩm</span> <select
					class="pull-right">
					<option>A - Z</option>
					<option>Cao - Thấp</option>
				</select>
			</div>
			<a href="${rootpath }">Trang chủ</a> <hr>
			<c:if test="${sanphamPaginate .size() >0}">
				<div class="row-fluid">
					<ul class="thumbnails">
						<c:forEach var="sp1" items="${sanphamPaginate }" varStatus="loop">
							<li class="span4">
								<div class="thumbnail">
									<a class="zoomTool" href="product_details.html"
										title="add to cart"><span class="icon-search"></span>
										QUICK VIEW</a> <a href="<c:url value="/chi-tiet-san-pham/${sp1.ma_sp }" />"><img
										src="<c:url value="/assets/img/${sp1.img }" />" alt=""></a>
									<div class="caption cntr">
										<p>${sp1.ten_sp }</p>
										<p>
											<strong><fmt:formatNumber type="number"
													groupingUsed="true" value="${sp1.gia_moi } " /> ₫</strong>
										</p>
										<h4>
											<a class="shopBtn" href="<c:url value="/AddCart/${sp1.ma_sp }" />" title="add to cart"> add to
												cart </a>
										</h4>

									</div>
								</div>
							</li>
							<c:if
								test="${(loop.index +1) %3 ==0 || (loop.index + 1) == sanphamPaginate.size() }">
					</ul>
				</div>
				<c:if test="${(loop.index +1 )< sanphamPaginate.size()}">
					<div class="row-fluid">
						<ul class="thumbnails">
				</c:if>
			</c:if>
			</c:forEach>
			</c:if>
 		</div> 
		<div class="pagination">
			<c:forEach var="sp" begin="1" end="${paginateInfo.totalPage }"
				varStatus="loop">
				<c:if test="${(loop.index) == paginateInfo.currentPage}">
					<a href="<c:url value="/san-pham/${ma_lsp }/${ loop.index}" />"
						class="active">${loop.index }</a>

				</c:if>
				<c:if test="${(loop.index) != paginateInfo.currentPage}">
					<a href="<c:url value="/san-pham/${ma_lsp }/${ loop.index}" />">${loop.index }</a>
				</c:if>
			</c:forEach>
		</div>

</body>
</html>