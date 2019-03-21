<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>login</title>
<link rel="stylesheet" href="${path }/css/login.css" type="text/css">
<script type="text/javascript" src="${path }/js/login.js?v=${v}"></script>
</head>
<body>
<input type="hidden" name="path" id="path" value="${path }">
<form action="${path }/login" name="loginForm" method="post" id="loginForm">
	<div class="wrap" id="wrap">
		<div class="logGet">
			<!-- 头部提示信息 -->
			<div class="logD logDtip">
				<p class="p1">登录</p>
			</div>
           <!-- 输入框 -->
           <div class="lgD">
				<img src="${path }/image/login_user.png" width="30" height="30" alt="" /> 
				<input type="text" id="number" name="number" placeholder="输入登录名" />
			</div>

			<div class="lgD">
				<img src="${path }/image/login_pwd.png" width="30" height="30" alt="" /> 
				<input type="password" id="password" name="password" placeholder="输入用户密码" />
			</div>
			<div class="lgE">
				<img id="imageCode" src="${pageContext.request.contextPath }/getImageCode" alt="" onclick="changCodeImage();"/> 
				<input type="text" id="imageCode" name="imageCode" placeholder="输入验证码" />
			</div>
			<div class="logC">
				<a href="javascript:login();" target="_self"><button>登 录</button></a>
			</div>
		</div>
	</div>
	</form>
</body>

</html>
