<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/member/mypage_profile.css">
</head>
<body>
	<%@ include file="/views/common/header_v2.jsp"%>
	<div id="width-100">
		<div id="profile-contents">
			<div id="profile-contents-left">
				<div class="profile-selector-box">
					<div>
						<h2>내 정보</h2>
					</div>
					<div class ="profile-selector-box-main">
						<p class="mypage-selector">프로필</p>
						<a class="mypage-non-selector" href="<%=request.getContextPath() %>/mypage/user"><p class="profile-selector-box-main-menu">계정 관리</p></a>
					</div>
				</div>
				<div class="profile-selector-box">
					<div>
						<h2>내 활동</h2>
					</div>
					<div class="profile-selector-box-main">
						<a class="mypage-non-selector" href="/"><p >내 게시글</p></a>
						<a class="mypage-non-selector" href="/"><p class="profile-selector-box-main-menu">내 댓글</p></a>
					</div>
				</div>
				<c:if test="${not empty sessionScope.LOGIN_USER and sessionScope.LOGIN_USER.adminYn eq 'Y'}">
				<div class="profile-selector-box">
					<div>
						<h2>관리자 모드</h2>
					</div>
					<div class="profile-selector-box-main">
						<a class="mypage-non-selector" href="<%=request.getContextPath() %>/mypage/admin-member"><p>회원 관리</p></a>
					</div>
				</div>
    			</c:if>
			</div>
			<div id="profile-contents-right">
				<div id="profile-user-image-div">
					<div>
						<c:if test="${not empty sessionScope.LOGIN_USER}">
					    <c:choose>
					        <c:when test="${not empty sessionScope.LOGIN_USER.profileSrc and not empty sessionScope.LOGIN_USER.profileName}">
					            <img id="profile-user-image" src="${sessionScope.LOGIN_USER.profileSrc}/${sessionScope.LOGIN_USER.profileName}" alt="Profile Image">
					        </c:when>
					        <c:otherwise>
					            <!-- 기본 이미지 경로를 설정해주세요 -->
					            <img id="profile-user-image" src="<%= request.getContextPath() %>/resources/image/member/default_profile.jpg" alt="Default Profile Image">
					        </c:otherwise>
					    </c:choose>
						</c:if>
					</div>
				</div>
				<div id="profile-user-update-btn-div">
					<form action="<%= request.getContextPath() %>/mypage/profile-upload" method="POST" enctype="multipart/form-data">
						<input type="file" name="file" id="profile-user-img-save-btn" accept="image/*" style="display:none"></input>
						<input type="submit" value="변경" id="profile-update-btn" class="profile-common-button"></input>
					</form>
					<form action="<%= request.getContextPath() %>/mypage/profile-delete" method="POST">
						<input type="submit" value="삭제" id="profile-delete-btn" class="profile-common-button"></input>
					</form>
				</div>
				<div id="profile-nickname-div">
					<div>
						<div>
							<span class="profile-span-font">닉네임</span>
						</div>
						<div id="profile-nickname-inputlist">
							<form action="<%= request.getContextPath() %>/mypage/profile-nickname" method="POST">
								<c:if test="${not empty sessionScope.LOGIN_USER}">
									<input type="text"  name="nickname" value="${sessionScope.LOGIN_USER.nickname}"  id="profile-nickname-input" required="required"/>
								</c:if>
								<button id="profile-nickname-send-btn" type="submit">변경</button>
							</form>
						</div>
					</div>
				</div>
				<div id="profile-intro-div">
					<div>
						<div>
							<span class="profile-span-font">소개글</span>
						</div>
						<form id="profile-intro-update-form" action="<%= request.getContextPath() %>/mypage/profile-intro" method="POST">
							<c:if test="${not empty sessionScope.LOGIN_USER}">
								<div id="profile-intro-inputlist">
									<textarea type="text" name="intro"  id="profile-intro-textarea" required="required" maxlength="400">${sessionScope.LOGIN_USER.intro}</textarea>
								</div>
							</c:if>

							<div id="profile-intro-btn-div">
								<button id="profile-intro-send-btn" type="submit">저장</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/member/mypage_profile.js"></script>
</body>
</html>