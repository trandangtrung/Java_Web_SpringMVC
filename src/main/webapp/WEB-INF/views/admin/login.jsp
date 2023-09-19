<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<s:url value="/" var="rootpath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="${rootpath }assets/css/bootstrap.css" rel="stylesheet" />
<!-- Customize styles -->
<link href="${rootpath }assets/css/style.css"  rel="stylesheet" />
<!-- font awesome styles -->
<link href="${rootpath }assets/font-awesome/css/font-awesome.css"
	rel="stylesheet">


<!-- Favicons -->
<link rel="shortcut icon"
	href="${rootpath }/assets/ico/favicon.ico" />
<style type="text/css">
.box {
	color: red;
}

.box-ok {
	color: blue;
}

body {
    background: #222D32;
    font-family: 'Roboto', sans-serif;
}

.login-box {
    margin-top: 75px;
    height: auto;
    background: #1A2226;
    text-align: center;
    box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
}

.login-key {
    height: 100px;
    font-size: 50px;
    line-height: 100px;
     background: -webkit-linear-gradient(#27EF9F, #0DB8DE); 
    -webkit-background-clip: text;
    -webkit-text-fill-color: red;
}

.login-title {
    margin-top: 15px;
    text-align: center;
    font-size: 30px;
    letter-spacing: 2px;
    margin-top: 15px;
    font-weight: bold;
    color: #ECF0F5;
}

.login-form {
    margin-top: 25px;
    text-align: left;
}

input[type=text] {
    background-color: #1A2226;
    border: none;
    border-bottom: 2px solid #0DB8DE;
    border-top: 0px;
    border-radius: 0px;
    font-weight: bold;
    outline: 0;
    margin-bottom: 20px;
    padding-left: 0px;
    color: #ECF0F5;
}

input[type=password] {
    background-color: #1A2226;
    border: none;
    border-bottom: 2px solid #0DB8DE;
    border-top: 0px;
    border-radius: 0px;
    font-weight: bold;
    outline: 0;
    padding-left: 0px;
    margin-bottom: 20px;
    color: #ECF0F5;
}

.form-group {
    margin-bottom: 40px;
    outline: 0px;
}

.form-control:focus {
    border-color: inherit;
    -webkit-box-shadow: none;
    box-shadow: none;
    border-bottom: 2px solid #0DB8DE;
    outline: 0;
    background-color: #1A2226;
    color: #ECF0F5;
}

input:focus {
    outline: none;
    box-shadow: 0 0 0;
}

label {
    margin-bottom: 0px;
}

.form-control-label {
    font-size: 10px;
    color: #6C6C6C;
    font-weight: bold;
    letter-spacing: 1px;
}

.btn-outline-primary {
    border-color: #0DB8DE;
    color: #0DB8DE;
    border-radius: 0px;
    font-weight: bold;
    letter-spacing: 1px;
    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
}

.btn-outline-primary:hover {
    background-color: #0DB8DE;
    right: 0px;
}

.login-btm {
    float: right;
}

.login-button {
    padding-right: 0px;
    text-align: right;
    margin-bottom: 25px;
}

.login-text {
    text-align: left;
    padding-left: 0px;
    color: #A2A4A4;
}

.loginbttm {
    padding: 0px;
}
.mt{
	text-align: center;
}

</style>
</head>
<body>
	
	<div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-3 col-md-2"></div>
            <div class="col-lg-6 col-md-8 login-box">
                <div class="col-lg-12 login-key">
                <span style="color: red; font-weight: bold;">${msg }</span>
                    <i class="fa fa-key" aria-hidden="true"></i>
                </div>
                <div class="col-lg-12 login-title">
                    ADMIN PANEL
                </div>
                
                <div class="col-lg-12 login-form">
                    <div class="col-lg-12 login-form">
                        <form class="mt"  action="${rootpath }admin/login" method="post">
                            <div class="form-group">
                                <label for="tai_khoan" class="form-control-label">USERNAME</label>
                                <input type="text" name= "tai_khoan" value="${tai_khoan}" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="mat_khau" class="form-control-label">PASSWORD</label>
                                <input type="password" name= "mat_khau" class="form-control" >
                            </div>

                            <div class="col-lg-12 loginbttm">
                                <div class="col-lg-6 login-btm login-text">
                               
                                </div>
                                <div class="col-lg-6 login-btm login-button">
                                    <button type="submit" class="btn btn-outline-primary">LOGIN</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-lg-3 col-md-2"></div>
            </div>
        </div>
	
	
	
<!-- 	<div class="container"> -->
<!-- 		<div class="row justify-content-center"> -->
<!-- 			<div class="col-md-6"> -->
<!-- 				<div class="card"> -->
<!-- 				 	<div class="card-body"> -->
<%-- 					<form class="mt" action="${rootpath }admin/login" method="post"> --%>
<!-- 					 <div class="form-group"> -->
<!-- 						<label for="tai_khoan">Tài Khoản</label>  -->
<%-- 						<input type="text"  class="form-control" placeholder="Tài khoản"  value="${tai_khoan}" --%>
<!-- 							name="tai_khoan" required="required" /> -->
<!-- 							 </div><br>  -->
<!-- 							  <div class="form-group"> -->
<!-- 							<label -->
<!-- 							for="mat_khau">Mật khẩu</label>  -->
<!-- 							<input type="password" -->
<!-- 							name="mat_khau"  class="form-control" placeholder="Mật khẩu" required="required" /> <br>  -->
<!-- 							</div> -->
<!-- 							<input -->
<!-- 							type="submit" class="btn btn-primary" value="Đăng nhập" /> -->
							
 

<!-- 					</form> -->
<!-- 					 </div> -->
<!-- 					  </div> -->
<!--     </div> -->
  </div>



</body>
</html>