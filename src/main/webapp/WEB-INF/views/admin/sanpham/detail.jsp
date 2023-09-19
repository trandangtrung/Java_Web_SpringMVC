<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết sản phẩm</title>
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
	<h1 class="a1">Chi tiết sản phẩm</h1>
	<span class="box-ok">${msg}</span>
	<span class="box-error">${msgErr}</span>
		<table class="sf" border="1">
			<tr>
				<th>Tên sản phẩm</th>
				<td>${sp.ten_sp }</td>
			</tr>
			<tr>
				<th>Thông tin</th>
				<td>${sp.thong_tin }
				</td>
			</tr>
			<tr>
				<th>Giá nhập</th>
				<td>${sp.gia_nhap }
				</td>
			</tr>
			<tr>
				<th>Giá cũ</th>
				<td>${sp.gia_cu }
				</td>
			</tr>
			<tr>
				<th>Giá mới</th>
				<td>${sp.gia_moi }
				</td>
			</tr>
			<tr>
				<th>Lượt xem</th>
				<td>${sp.luot_xem }
				</td>
			</tr>
			<tr>
				<th>Ngày cập nhật</th>
				<td>${sp.ngay_cap_nhat }
				</td>
			</tr>
			<tr>
				<th>Trạng thái</th>
				<td>${sp.trang_thai==1? "Còn hàng" : "Hết hàng" }
				</td>
			</tr>
			<tr>
				<th>Mã loại sp</th>
				<td>${sp.loaiSanPham.ten_loai }
					</td>
			</tr>
			<tr>
				<th>Mã nhãn hiệu</th>
				<td>${sp.nhanHieu.ten_nhan_hieu }
				</td>
			</tr>	
		</table>
	<a href="${rootPath }admin/sanpham">Trang quản lí sản phẩm</a>
</body>
</html>