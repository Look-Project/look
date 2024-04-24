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
				<div class="profile-selector-box">
					<div>
						<h2>관리자 모드</h2>
					</div>
					<div class="profile-selector-box-main">
						<p>회원 관리</p>
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
						<!-- 테이블 상단 타이틀공간 -->
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
						<tr class="tr">
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
						/* 세로 열 개수 */
						const rowCnt = 5;
						/* 가로 행 개수 */
						const columnCnt = 7;
						/* 출력 반복문 == "세로열,가로행" */
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
				<!-- 검색창 영역 -->
				<div class="searchbar">
					<!-- 텍스트 입력공간 -->
					<div class="bar">
						<input style="height:100%;" type="text" placeholder="검색어 입력">
					</div>
					<!-- 검색버튼 공간 -->
					<div class="btn">
						<button style="width:100%;">검색</button>
					</div>
				</div>
				<%-- 목록번호 영역 --%>
				<div class="board_num">
					<%-- 목록번호 개채당 속성 --%>
					<div class="num">◀</div>
					<div class="num">1</div>
					<div class="num">2</div>
					<div class="num">3</div>
					<div class="num">4</div>
					<div class="num">5</div>
					<div class="num">▶</div>
				</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/member/mypage_profile.js"></script>
</body>
</html>