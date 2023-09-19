<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật sản phẩm</title>
<style type="text/css">
.box-error {
	color: red;
}

.box-ok {
	color: blue;
}
.sf{
text-align: -webkit-center;
margin-top: 30px
}
.a1{
text-align: center;
}
</style>
</head>
<body>
	<h1 class="a1">Cập nhật sản phẩm</h1>
	<span class="box-ok">${msg}</span>
	<span class="box-error">${msgErr}</span>
	<sf:form class="sf" action="${rootPath }admin/sanpham/update" method="post" modelAttribute="sp">
		<table border="1">
			<tr>
				<th>Mã sản phẩm</th>
				<td><sf:input type="number" path="ma_sp" readonly="true" /></td>
			</tr>
			<tr>
				<th>Tên sản phẩm</th>
				<td><sf:input type="text" path="ten_sp" /></td>
			</tr>
			<tr>
				<th>Thông tin</th>
				<td><sf:input type="text" path="thong_tin" /></td>
			</tr>
			<tr>
				<th>Giá nhập</th>
				<td><sf:input type="number" step="500" path="gia_nhap" /></td>
			</tr>
			<tr>
				<th>Giá cũ</th>
				<td><sf:input type="number" step="500" path="gia_cu" /></td>
			</tr>
			<tr>
				<th>Giá mới</th>
				<td><sf:input type="number" step="500" path="gia_moi" /></td>
			</tr>
			<tr>
				<th>Ngày cập nhật</th>
				<td><sf:input type="date" path="ngay_cap_nhat" /></td>
			</tr>
			<tr>
				<th>Trạng thái</th>
				<td><sf:checkbox path="trang_thai" value="1" /></td>
			</tr>
			<tr>
				<th>Ảnh minh họa</th>
				<td><sf:input type="file" path="img" /></td>
			</tr>
			<tr>
				<th>Mã loại sp</th>
				<td><sf:input type="number" step="1" path="ma_lsp" /></td>
			</tr>
			<tr>
				<th>Mã nhãn hiệu</th>
				<td><sf:input type="number" step="1" path="ma_nh" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Cập nhật sản phẩm" /></td>
			</tr>		
		</table>
	</sf:form>
	<a href="${rootPath }admin/sanpham">Trang quản lí sản phẩm</a>
</body>
</html>