<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật khách hàng</title>
<style type="text/css">
.box-error {
	color: red;
}

.box-ok {
	color: blue;
}
</style>
</head>
<body>
	<h1>Cập nhật sản phẩm</h1>
	<span class="box-ok">${msg}</span>
	<span class="box-error">${msgErr}</span>
	<sf:form action="${rootPath }admin/khachhang/update" method="post" modelAttribute="kh">
		<table border="1">
			<tr>
				<th>Mã khách hàng</th>
				<td><sf:input type="number" path="ma_kh" readonly="true" /></td>
			</tr>
			<tr>
				<th>Họ và tên khách</th>
				<td><sf:input type="text" path="ho_ten" /></td>
			</tr>
			<tr>
				<th>Tài khoản</th>
				<td><sf:input type="text" path="tai_khoan" /></td>
			</tr>
			<tr>
				<th>Mật khẩu</th>
				<td><sf:input type="text" path="mat_khau" /></td>
			</tr>
			<tr>
				<th>Địa chỉ</th>
				<td><sf:input type="text" path="dia_chi" /></td>
			</tr>
			<tr>
				<th>Điện thoại</th>
				<td><sf:input type="text" path="dien_thoai" /></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><sf:input type="text" path="email" /></td>
			</tr>
			<tr>
				<th>Ngày sinh</th>
				<td><sf:input type="date" path="ngay_sinh" /></td>
			</tr>
			<tr>
				<th>Ngày cập nhật</th>
				<td><sf:input type="date" path="ngay_cap_nhat" /></td>
			</tr>
			<tr>
				<th>Giới tính</th>
				<td><sf:input type="text" path="gioi_tinh" /></td>
			</tr>
			<tr>
				<th>Tích điểm</th>
				<td><sf:input type="number" step="1" path="tich_diem" /></td>
			</tr>
			<tr>
				<th>Trạng thái</th>
				<td><sf:checkbox path="trang_thai" value="1" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Cập nhật khách hàng" /></td>
			</tr>		
		</table>
	</sf:form>
	<hr>
	<a href="${rootPath }admin/khachhang">Trang quản lí khách hàng</a>
</body>
</html>