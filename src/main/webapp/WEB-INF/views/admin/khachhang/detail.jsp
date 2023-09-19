<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết</title>
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
	<h1>Chi tiết khách hàng</h1>
	<span class="box-ok">${msg}</span>
	<span class="box-error">${msgErr}</span>
		<table border="1">
			<tr>
				<th>Tên khách hàng</th>
				<td>${kh.ho_ten }</td>
			</tr>
			<tr>
				<th>Tài khoản</th>
				<td>${kh.tai_khoan }
				</td>
			</tr>
			<tr>
				<th>Mật khẩu</th>
				<td>${kh.mat_khau }
				</td>
			</tr>
			<tr>
				<th>Địa chỉ</th>
				<td>${kh.dia_chi }
				</td>
			</tr>
			<tr>
				<th>Điện thoại</th>
				<td>${kh.dien_thoai }
				</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${kh.email }
				</td>
			</tr>
			<tr>
				<th>Ngày sinh</th>
				<td>${kh.ngay_sinh }
				</td>
			</tr>
			<tr>
				<th>Ngày cập nhật</th>
				<td>${kh.ngay_cap_nhat }
				</td>
			</tr>
			<tr>
				<th>Giới tính</th>
				<td>${kh.gioi_tinh }
					</td>
			</tr>
			<tr>
				<th>Tích điểm</th>
				<td>${kh.tich_diem }
				</td>
			</tr>	
			<tr>
				<th>Trạng thái</th>
				<td>${(kh.trang_thai==1)? "Còn hoạt động" : "Không hoạt động" }
				</td>
			</tr>
		</table>
	<hr>
	<a href="${rootPath }admin/khachhang">Trang quản lí khách hàng</a>
</body>
</html>