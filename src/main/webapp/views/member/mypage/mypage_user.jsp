<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/member/mypage_user.css">
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
						<a class="mypage-non-selector" href= "<%= request.getContextPath()%>/mypage/profile"><p>프로필</p></a>
						<p class="mypage-selector profile-selector-box-main-menu">계정 관리</p>
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
			</div>
			<div id="profile-contents-right">
				<form id="mypage-user-pw-form">
					<div>
						<h3 class="mypage-user-h3">비밀번호</h3>
					</div>
					<div>
						<div>
							<span class="profile-span-font">현재 비밀번호</span>
						</div>
						<div id="mypage-current-password-inputlist">
							<input type="password" id="mypage-current-pw"  name="currentPw"  class="profile-user-password-input" required="required"/>
						</div>
					</div>
					<div class="mypage-margin-top">
						<div>
							<span class="profile-span-font">새 비밀번호</span>
						</div>
						<div id="mypage-password-inputlist">
							<input type="password" id="mypage-new-pw" name="newPw"  class="profile-user-password-input" required="required"/>
						</div>
					</div>
					<div class="mypage-margin-top">
						<div>
							<span class="profile-span-font">새 비밀번호 확인</span>
						</div>
						<div id="mypage-password-check-inputlist">
							<input type="password" id="mypage-new-pw-check" name="newPwCheck"  class="profile-user-password-input" required="required"/>
							<button id="profile-password-send-btn" type="button">변경</button>
						</div>
					</div>
				</form>
				<div>
					<div>
						<h3 class="mypage-user-h3">회원탈퇴</h3>
					</div>
					<div id="mypage-user-signout-guide-div">
						<p>회원탈퇴를 진행하면 모든 개인정보는 완전히 삭제되며 더 이상 <strong>복구</strong>할 수 없습니다.</p>
						<p>작성한 게시물과 댓글 또한 전부 삭제가 되어  <strong>복구</strong>가  <strong>불가능</strong>합니다.</p>
					</div>
					<div>
						<form id="mypage-member-delete-form" action="<%= request.getContextPath() %>/mypage/user-delete" method="post">
							<button id="mypage-member-delete-send-btn" type="submit">회원탈퇴</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/member/mypage_user.js"></script>
</body>
</html>