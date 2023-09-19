<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/" var="rootpath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${rootpath }assets/font-awesome/css/font-awesome.css"
	rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" rel="stylesheet" />
<title>Insert title here</title>
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Open+Sans:300,400,700,400italic);
@import url(https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css);
html {
  box-sizing: border-box;
}

*,
*:before,
*:after {
  box-sizing: inherit;
}

body {
  background: #f1f2f7;
  font-family: "Open Sans", arial, sans-serif;
  color: darkslategray;
}

body.login {
  background-color: white;
  max-width: 500px;
  margin: 10vh auto;
  padding: 1em;
  height: auto;
}

.warn {
  color: red;
}

/* header */
header[role="banner"] {
  background: white;
  box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.15);
}
header[role="banner"] h1 {
  margin: 0;
  font-weight: 300;
  padding: 1rem;
}
header[role="banner"] h1:before {
  content: "\e1b0";
  font-family: FontAwesome;
  padding-right: 0.6em;
  color: red;
}
header[role="banner"] .utilities {
  width: 100%;
  background: slategray;
  color: #ddd;
}
header[role="banner"] .utilities li {
  border-bottom: solid 1px rgba(255, 255, 255, 0.2);
}
header[role="banner"] .utilities li a {
  padding: 0.7em;
  display: block;
}

/* header */
.utilities a:before {
  content: "\f248";
  font-family: FontAwesome;
  padding-right: 0.6em;
}

.logout a:before {
  content: "";
}

.users a:before {
  content: "";
}

nav[role="navigation"] {
  background: #2a3542;
  color: #ddd;
  /* icons */
}
nav[role="navigation"] li {
  border-bottom: 1px solid rgba(255, 255, 255, 0.08);
}
nav[role="navigation"] li a {
  color: #ddd;
  text-decoration: none;
  display: block;
  padding: 0.7em;
}
nav[role="navigation"] li a:hover {
  background-color: rgba(255, 255, 255, 0.05);
}
 nav[role="navigation"] li a:before { 
  content: ""; 
     font-family: FontAwesome; 
   padding-right: 0.6em; 
} 
 nav[role="navigation"] .dashboard a:before { 
   content: "\f073"; 
 } 
/*  nav[role="navigation"] .write a:before {  */
/*    content: " ";  */
/*  }  */
 nav[role="navigation"] .edit a:before { 
   content: "\e1b0"; 
 } 
 nav[role="navigation"] .comments a:before { 
   content: "\f03a"; 
 } 
 nav[role="navigation"] .users a:before { 
   content: ""; 
 } 
  nav[role="navigation"] .bills a:before { 
   content: "\f53b"; 
 } 
 nav[role="navigation"] .deatail a:before { 
   content: "\f07a"; 
 } 

/* current nav item */
.current, .dashboard .dashboard a,
.write .write a,
.edit .edit a,
.comments .comments a,
.users .users a {
  background-color: rgba(255, 255, 255, 0.1);
}

footer[role="contentinfo"] {
  background: slategray;
  color: #ddd;
  font-size: 0.8em;
  text-align: center;
  padding: 0.2em;
}

/* panels */
.panel {
  background-color: white;
  color: darkslategray;
  -webkit-border-radius: 0.3rem;
  -moz-border-radius: 0.3rem;
  -ms-border-radius: 0.3rem;
  border-radius: 0.3rem;
  margin: 1%;
}
.panel > h2, .panel > ul {
  margin: 1rem;
}

/* typography */
a {
  text-decoration: none;
  color: inherit;
}

h2,
h3,
h4 {
  font-weight: 300;
  margin: 0;
}

h2 {
  color: #ff1a1a;
}

b {
  color: lightsalmon;
}

.hint {
  color: lightslategray;
}

/* lists */
ul,
li {
  list-style-type: none;
  margin: 0;
  padding: 0;
}

main li {
  position: relative;
  padding-left: 1.2em;
  margin: 0.5em 0;
}
main li:before {
  content: "";
  position: absolute;
  width: 0;
  height: 0;
  left: 0;
  top: 0.3em;
  border-left: solid 10px #dde;
  border-top: solid 5px transparent;
  border-bottom: solid 5px transparent;
}

/* forms */
form input,
form textarea,
form select {
  width: 100%;
  display: block;
  border: solid 1px #dde;
  padding: 0.5em;
}
form input:after,
form textarea:after,
form select:after {
  content: "";
  display: table;
  clear: both;
}
form input[type="checkbox"],
form input[type="radio"] {
  display: inline;
  width: auto;
}
form label,
form legend {
  display: block;
  margin: 1em 0 0.5em;
}
form input[type="submit"] {
  background: #ff1a1a;
  border: none;
  border-bottom: solid 4px #e60000;
  padding: 0.7em 3em;
  margin: 1em 0;
  color: white;
  text-shadow: 0 -1px 0 #e60000;
  font-size: 1.1em;
  font-weight: bold;
  display: inline-block;
  width: auto;
  -webkit-border-radius: 0.5em;
  -moz-border-radius: 0.5em;
  -ms-border-radius: 0.5em;
  border-radius: 0.5em;
}
form input[type="submit"]:hover {
  background: turquoise;
  border: none;
  border-bottom: solid 4px #21ccbb;
  padding: 0.7em 3em;
  margin: 1em 0;
  color: white;
  text-shadow: 0 -1px 0 #21ccbb;
  font-size: 1.1em;
  font-weight: bold;
  display: inline-block;
  width: auto;
  -webkit-border-radius: 0.5em;
  -moz-border-radius: 0.5em;
  -ms-border-radius: 0.5em;
  border-radius: 0.5em;
}

/* feedback */
.error {
  background-color: #ffe9e0;
  border-color: #ffc4ad;
}

label.error {
  padding: 0.2em 0.5em;
}

.feedback {
  background: #fcfae6;
  color: #857a11;
  margin: 1em;
  padding: 0.5em 0.5em 0.5em 2em;
  border: solid 1px khaki;
}
.feedback:before {
  content: "";
  font-family: fontawesome;
  color: #e4d232;
  margin-left: -1.5em;
  margin-right: 0.5em;
}
.feedback li:before {
  border-left-color: #f6f0b9;
}
.feedback.error {
  background: #ffe9e0;
  color: #942a00;
  margin: 1em;
  padding: 0.5em 0.5em 0.5em 2em;
  border: solid 1px lightsalmon;
}
.feedback.error:before {
  content: "";
  font-family: fontawesome;
  color: #ff5714;
  margin-left: -1.5em;
  margin-right: 0.5em;
}
.feedback.error li:before {
  border-left-color: #ffc4ad;
}
.feedback.success {
  background: #98eee6;
  color: #08322e;
  margin: 1em;
  padding: 0.5em 0.5em 0.5em 2em;
  border: solid 1px turquoise;
}
.feedback.success:before {
  content: "";
  font-family: fontawesome;
  color: #1aa093;
  margin-left: -1.5em;
  margin-right: 0.5em;
}
.feedback.success li:before {
  border-left-color: #6ce7db;
}

/* tables */
table {
  border-collapse: collapse;
  width: 96%;
  margin: 2%;
}

th {
  text-align: left;
  font-weight: 400;
  font-size: 13px;
  text-transform: uppercase;
  border-bottom: 1px solid rgba(0, 0, 0, 0.1);
  padding: 0 10px;
  padding-bottom: 14px;
}

tr:not(:first-child):hover {
  background: rgba(0, 0, 0, 0.1);
}

td {
  line-height: 40px;
  font-weight: 300;
  padding: 0 10px;
}

@media screen and (min-width: 600px) {
  html,
  body {
    height: 100%;
  }

  header[role="banner"] {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    z-index: 99;
    height: 75px;
  }
  header[role="banner"] .utilities {
    position: absolute;
    top: 0;
    right: 0;
    background: transparent;
    color: darkslategray;
    width: auto;
  }
  header[role="banner"] .utilities li {
    display: inline-block;
  }
  header[role="banner"] .utilities li a {
    padding: 0.5em 1em;
  }

  nav[role="navigation"] {
    position: fixed;
    width: 200px;
    top: 75px;
    bottom: 0px;
    left: 0px;
  }

  main[role="main"] {
    margin: 75px 0 40px 70px;
  }
  main[role="main"]:after {
    content: "";
    display: table;
    clear: both;
  }



.box-error {
	color: red;
}

.box-ok {
	color: blue;
}
</style>
</head>
<body>
	<header role="banner">
		<h1>Admin WebShop</h1>
		<ul class="utilities">
			<br>
			<li class="users"><a href="#">${login.tai_khoan}</a></li>
			<li class="logout warn"><a href="">Log Out</a></li>
		</ul>
	</header>
	
	<nav role='navigation'>
		<ul class="main">
			<li class="dashboard"><a href="admindashboard">Tổng quan</a></li>
			<li class="edit"><a href="${rootpath }admin/taikhoan">Quản lí Admin</a></li>
			<li class="users"><a href="${rootpath }admin/khachhang">Quản
					lí user</a></li>
			<li class="comments"><a href="${rootpath }admin/sanpham">Danh
					mục sản phẩm</a></li>
			<li class="bills"><a href="${rootpath }admin/hoadon">Đơn
					hàng</a></li>
			<li class="deatail"><a href="#">Chi tiết đơn hàng</a></li>
		</ul>
	</nav>
	
	 <main role="main">
	 
	<h1>Quản lý taì khoản admin</h1> 	
	<span class="box-ok">${msg}</span>
	<span class="box-error">${msgErr}</span>
	<hr>
<%-- 	<a href="${rootpath }khachhang/initInsert">Thêm mới</a> --%>
<!-- 	<hr> -->
	<form action="${rootpath }admin/taikhoan/search2" method="get">
		<input type="text" name="search2" maxlength="50" placeholder="Tên tài khoản" value="${search2 }" />
		<input type="submit" value="Tìm kiếm"/>
	</form>
	<hr>
	<table border="1">
		<tr>
			<th>Mã </th>
			<th>Tài Khoản</th>
			<th>Mật khẩu</th>
			<th>Trạng thái</th>
			<th>Cập nhật</th>
			<th>Xóa</th>
		</tr>
		<c:forEach items="${lstqt }" var="qt">
			<tr>
				<td align="center">
					<a href="${rootpath }admin/taikhoan/detail?id=${qt.id }">${qt.id }</a>
				</td> 
				<td>${qt.tai_khoan }</td>
				<td>${qt.mat_khau }</td>
				<td>${(qt.trang_thai == 1)? "Còn hoạt động": "Không hoạt động" }</td>
				<th align="center">
					<a href="${rootpath }admin/taikhoan/init-update?id=${qt.id }">
						<img src="${rootpath }assets/img/update.png" />
					</a>
				</th>
				<th align="center">
					<a href="${rootpath }admin/taikhoan/delete?id=${qt.id }">
						<img src="${rootpath }assets/img/delete.png" />
					</a>
				</th>
			</tr>
		</c:forEach>
	</table>
	<hr>
	</main> 
</body>
</html>