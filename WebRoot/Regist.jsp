<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
	<head>
		<title>注册</title>
		<script type="text/javascript">
		function changeImg(img){
		img.src=img.src+"?id="+Math.random();
		}
		</script>
	</head>

	<body>
		<div
			style="height: 40px; background-color: green; color: white; font-family: cursive; font-size: x-large; medium; margin-bottom: 50px;">
			欢迎注册
		</div>
		<p align="center" style="color: red">${msg }</p>
		<form action="${pageContext.request.contextPath}/servlet/RegistServlet" method="post">
			<table align="center">
				<tr>
					<td align="right" height="30px">用户名：</td>
					<td><input name="username" type="text" /></td>
				</tr>
				<tr>
					<td align="right" height="30px">请设置密码：</td>
					<td><input name="password1" type="password" /></td>
				</tr>
				<tr>
					<td align="right" height="30px">请确认密码：</td>
					<td><input name="password2" type="password" /></td>
				</tr>
				<tr>
					<td align="right" height="30px">手机号：</td>
					<td><input name="phonenumber" type="text"  /></td>
				</tr>
				<tr>
					<td align="right" height="30px">邮箱：</td>
					<td><input name="email" type="text"  /></td>
				</tr>
				<tr>
					<td align="right" height="30px">验证码：</td>
					<td><input name="valicode" type="text"  /></td>
					<td><img src="${pageContext.request.contextPath}/servlet/ValiCode" 
					style="cursor:pointer;" onclick="changeImg(this)"/></td>
				</tr>
				<tr>
					<td>
					</td>
					<td align="left" height="50px"><input value="立即注册" type="submit"
							style="height: 35px; width: 80px; color: green" /></td>
				</tr>
			</table>
		</form>
	</body>
</html>
