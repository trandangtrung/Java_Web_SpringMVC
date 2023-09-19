<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/" var="rootpath" />

	<!--
Lower Header Section 
-->
		<header id="header">
			<div class="row">
				<div class="span4">
					<h1>
						<a class="logo1" href="index.html" width="10%"><span></span> <img
							src="${rootpath }assets/img/logo-ao-bong-da-lop-doi-vuong-mien.png"
							alt="bootstrap sexy shop"> </a>
					</h1>
				</div>
				<div class="span4">
					<div class="offerNoteWrapper">
						<h1 class="dotmark">
							<i class="icon-cut style="text-upper" "></i> SHOP QUẦN ÁO BÓNG ĐÁ
						</h1>
					</div>
				</div>
				<div class="span4 alignR">
					<p>
						<br> <strong> Hotline : 01234 6789 </strong><br> <br>
					</p>
					<span class="btn btn-mini">[ ${TotalQuantyCart } ] <span
						class="icon-shopping-cart"></span></span> <span
						class="btn btn-warning btn-mini">$</span> <span
						class="btn btn-mini">&pound;</span> <span class="btn btn-mini">&euro;</span>
				</div>
			</div>
		</header>

		<!--
Navigation Bar Section 
-->
		<div class="navbar">
			<div class="navbar-inner">
				<div class="container">
					<a data-target=".nav-collapse" data-toggle="collapse"
						class="btn btn-navbar"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a>
					<div class="nav-collapse">
						<ul class="nav">
							<c:forEach var="lstm" items="${lstmn }">
								<li class="active"><a href="index.html">${lstm.name} </a></li>
							</c:forEach>

							<!-- 							<li class=""><a href="four-col.html">Four Column</a></li>
							<li class=""><a href="general.html">General Content</a></li> -->
						</ul>
						 <form action="${rootpath }search2" method="get" class="navbar-search pull-left">
							<input type="text" value="${s}" name="search" maxlength="50" placeholder="Tìm kiếm"
								class="search-query span2">
								<input type="submit" value="Tìm kiếm"/>
						</form> 
						
						<ul class="nav pull-right">
							<c:if test="${empty loginInfor }">
							<li class="dropdown"><a data-toggle="dropdown"
								class="dropdown-toggle" href="${rootpath }dang-ky">
									Đăng nhập <b class="caret"></b></a>
  </li> 
								</c:if>
							<c:if test="${not empty loginInfor }">
								<li><a href="#" >${loginInfor.display_name } <b class="caret"></b> </a> </li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
