<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/views/common/common.jsp"%>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/member/signup.css">
</head>
<body>
	<div id="signup-outer">
		<div id="signup-inner">
			<div id="signup-contents">
				<div id="signup-contents-logos">
					<a href="<%= request.getContextPath()%>/main"><img src="<%= request.getContextPath() %>/resources/image/common/Logo.png" id="signup-contents-logo"></a>
					<p>Everyone look at me</p>
				</div>
				<div id="signup-contents-form">
					<form id="signup-form">
						<div id="signup-form-id-div">
							<div>
								<span class="signup-span-font">아이디</span>
							</div>
							<div id="signup-form-id-inputlist">
								<input type="text"  name="userLoginId"  id="signup-form-id-input" class="signup-input" required="required"/>
								<button id="signup-form-id-duplicate-check" type="button">중복 확인</button>
							</div>
						</div>
						<div id="signup-form-nickname-div" class="signup-margin">
							<div>
								<span class="signup-span-font">닉네임</span>
							</div>
							<div id="signup-form-nickname-inputlist">
								<input type="text"  name="nickname"  id="signup-form-nickname-input" class="signup-input" required="required"/>
								<button id="signup-form-nickname-duplicate-check" type="button">중복 확인</button>
							</div>
						</div>
						<div id="signup-form-password-div" class="signup-margin">
							<div>
								<span class="signup-span-font">비밀번호</span>
							</div>
							<div id="signup-form-password-inputlist">
								<input type="password" name="userPw" id="signup-form-pw-input" class="signup-input" required="required"/>
							</div>
						</div>
						<div id="signup-form-password-check-div" class="signup-margin">
							<div>
								<span class="signup-span-font">비밀번호 확인</span>
							</div>
							<div id="signup-form-password-check-inputlist">
								<input type="password" name="userPwCheck"   id="signup-form-pw-check-input" class="signup-input" required="required"/>
							</div>
						</div>
						<div id="signup-form-button-div">
							<input type="button" id="signup-button" value="회원가입" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	 <script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/member/memberSignup.js"></script>
</body>
</html>