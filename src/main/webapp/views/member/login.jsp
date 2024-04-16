<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/views/common/common.jsp"%>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/member/login.css">
</head>
<body>
	<div id="login-outer">
		<div id="login-inner">
			<div id="login-contents">
				<div id="login-contents-logos">
					<a href="<%= request.getContextPath()%>/views/common/header.jsp"><img src="<%= request.getContextPath() %>/resources/image/common/Logo.png" id="login-contents-logo"></a>
					<p>Everyone look at me</p>
				</div>
				<div id="login-contents-form">
					<form id="login-form">
						<div id="login-form-id-div">
							<div>
								<span class="login-span-font">아이디</span>
							</div>
							<div>
								<input type="text"  name="userLoginId"  id="login-form-id-input" class="login-input" required="required"/>
							</div>
						</div>
						<div id="login-form-password-div">
							<div>
								<span class="login-span-font">비밀번호</span>
							</div>
							<div>
								<input type="password" name="userPw"   id="login-form-pw-input" class="login-input" required="required"/>
							</div>
						</div>
						<div id="login-form-button-div">
							<input type="button" id="login-button" value="로그인" />
						</div>
					</form>
				</div>
				<div id="login-contents-menulist">
					<a id="signup-link" class="login-menu" href="<%= request.getContextPath() %>/member/signup">회원가입</a>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/member/login.js"></script>
</body>
</html>