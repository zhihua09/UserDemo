<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
	<head>
		<title>登录</title>
	</head>

	<body>
		<div
			style="height: 40px; background-color: green; color: white; font-family: cursive; font-size: x-large; medium; margin-bottom: 50px;">
			欢迎登录
		</div>
		<p align="center" style="color: red">
			${msg}
		</p>
		<form action="${pageContext.request.contextPath}/servlet/LoginServlet"
			method="post">
			<table align="center">
				<tr>
					<td align="right">
						用户名：
					</td>
					<td>
						<input name="username" type="text" />
					</td>
				</tr>
				<tr>
					<td align="right">
						密码：
					</td>
					<td>
						<input name="password" type="password" />
					</td>
				</tr>
				<tr>
					<td>
					</td>
					<td align="left" height="50px">
						<input value="登录" type="submit"
							style="height: 35px; width: 80px; color: green" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
