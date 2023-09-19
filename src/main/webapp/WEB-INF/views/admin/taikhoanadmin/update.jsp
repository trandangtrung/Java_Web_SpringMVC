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
	<h1 class="a1">Cập nhật tài khoản</h1>
	<span class="box-ok">${msg}</span>
	<span class="box-error">${msgErr}</span>
	<sf:form class="sf" action="${rootPath }admin/taikhoan/update" method="post" modelAttribute="qt">
		<table border="1">
			<tr>
				<th>Mã tài khoản</th>
				<td><sf:input type="number" path="id" readonly="true" /></td>
			</tr>
			<tr>
				<th>Tên tài khoản</th>
				<td><sf:input type="text" path="tai_khoan" /></td>
			</tr>
			<tr>
				<th>Mật khẩu</th>
				<td><sf:input type="text" path="mat_khau" /></td>
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
	<a href="${rootPath }admin/taikhoan">Trang quản lí tài khoản</a>
</body>
</html>