<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/member/member_manage.css">
</head>
<body>
	<%@ include file="/views/common/header_v2.jsp"%>
	<div id="width-100">
		<div id="profile-contents">
		<!-- 좌측 컨텐츠 영역 -->
			<div id="profile-contents-left">
				<div class="profile-selector-box">
					<div>
						<h2>내 정보</h2>
					</div>
					<div class ="profile-selector-box-main">
						<p>프로필</p>
						<p class="profile-selector-box-main-menu">계정 관리</p>
					</div>
				</div>
				<div class="profile-selector-box">
					<div>
						<h2>내 활동</h2>
					</div>
					<div class="profile-selector-box-main">
						<p>내 게시글</p>
						<p class="profile-selector-box-main-menu">내 댓글</p>
					</div>
				</div>
			</div>
			<!-- 우측 컨텐츠 영역 -->
			<div id="profile-contents-right">
				<!-- 테이블 영역구분 -->
				<div class="member_manage_table">	
				<table>
					<!-- 차트 컬럼 구분  -->
					<thead>
						<!-- 상단 타이틀공간 -->
						<tr>
							<th>No.</th>
							<th>ADMIN_YN</th>
							<th>USER_ID</th>
							<th>LOGIN_ID</th>
							<th>NICKNAME</th>
							<th>LOGIN_AT</th>
							<th>UPDATE_AT</th>
						</tr>
					</thead>
					<!--  차트 내용 부분 -->
					<tbody>
						<tr>
							<td>1</td>
							<td>Y</td>
							<td>admin</td>
							<td>administrator</td>
							<td>어드민</td>
							<td>1111-11-11</td>
							<td>2222-22-22</td>
						</tr>
						<tr>
							<td>2</td>
							<td>Y</td>
							<td>admin</td>
							<td>administrator</td>
							<td>어드민</td>
							<td>1111-11-11</td>
							<td>2222-22-22</td>
						</tr>
						<tr>
							<td>3</td>
							<td>Y</td>
							<td>admin</td>
							<td>administrator</td>
							<td>어드민</td>
							<td>1111-11-11</td>
							<td>2222-22-22</td>
						</tr>
						<tr>
							<td>4</td>
							<td>Y</td>
							<td>admin</td>
							<td>administrator</td>
							<td>어드민</td>
							<td>1111-11-11</td>
							<td>2222-22-22</td>
						</tr>
						<tr>
							<td>5</td>
							<td>Y</td>
							<td>admin</td>
							<td>administrator</td>
							<td>어드민</td>
							<td>1111-11-11</td>
							<td>2222-22-22</td>
						</tr>
						<script>
						const rowCnt = 5;
						const columnCnt = 7;
						
						for (let i = 0; i < rowCnt; i++) {
						  document.write('<tr>');
						  for (let j = 0; j < columnCnt; j++)  {
						    document.write('<td>');
						    document.write(i + ", " + j);
						    document.write('</td>');
						  }
						  document.write('</tr>')
						}
						document.write('</table>');
					
						</script>
					</tbody>
				</table>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/member/mypage_profile.js"></script>
</body>
</html>