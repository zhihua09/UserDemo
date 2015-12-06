<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<title>我的网站</title>
	</head>
	<body>
		<div
			style="height: 40px; background-color: green; color: white; font-family: cursive; font-size: x-large; margin-bottom: 50px;">
			我的网站
		</div>
		<div align="center">
			<c:if test="${sessionScope.user==null}">
  欢迎光临！游客。
			<a href="${pageContext.request.contextPath }/Login.jsp">登录</a>
			<a href="${pageContext.request.contextPath }/Regist.jsp">注册</a>
			</c:if>
			<c:if test="${sessionScope.user!=null}">
  欢迎回来！${sessionScope.user.username}!
				<a href="${pageContext.request.contextPath }/servlet/LogoutServlet">注销</a>
			</c:if>
		</div>
	</body>
</html>
