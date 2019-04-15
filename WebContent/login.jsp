<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>登录</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
	<div class="login_head">
		<div class="container">
			<img src="images/logo.png">
		</div>
	</div>

	<div class="login_banner">
		<div class="container">
			<div class="login">
				<div class="login_in">
					<div class="login_h">后台登录</div>
					<form action="login" method="post">
						<div class="user_login">
							<input type="text" name="userName" placeholder="账号"> 
							<input type="text" name="userPwd" placeholder="密码">
						</div>
						<div class="img_code">
							<input type="text" placeholder="验证码"> 
							<img src="images/img_code.jpg" alt="">
						</div>
						<!-- <div class="login_btn"><a href="index.jsp">登录</a></div> -->
						<!-- <div class="login_btn">登录</div> -->
						<div class="login_btn"><input type="submit" value="登录"></div>
					</form>
				</div>

			</div>
		</div>
	</div>

	<div class="login_end text_center">版权所有&copy;：新开普电子股份有限公司
		豫ICP备08102576号 未经授权本站内容禁止私自转载使用！
	</div>
</body>
</html>