<%@page import="member.dto.response.AdminMemberResponse"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
						<a class="mypage-non-selector" href= "<%= request.getContextPath()%>/mypage/profile"><p>프로필</p></a>
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
					<p class="mypage-selector">회원 관리</p>
					</div>
				</div>
    			</c:if>
			</div>
			<%
				List<AdminMemberResponse> memberList = (List<AdminMemberResponse>)request.getAttribute("memberList"); 
			%>
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
							<th>LOGIN_ID</th>
							<th>ADMIN_YN</th>
							<th>NICKNAME</th>
							<th>CREATE_AT</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<!--  차트 내용 부분 -->
					<tbody>
					<%
					for(AdminMemberResponse member : memberList) {
					%>
					<tr>
							<td><%= member.getNo() %></td>
							<td><%= member.getLoginId() %></td>
							<td>        <!-- adminYn 드롭다운 -->
					        <select id="adminYn_<%= member.getNo() %>">
					            <option value="Y" <%= member.getAdminYn().equals("Y") ? "selected" : "" %>>Y</option>
					            <option value="N" <%= member.getAdminYn().equals("N") ? "selected" : "" %>>N</option>
					        </select></td>
							<td><input type="text" id="nickname_<%= member.getNo() %>" value="<%= member.getNickname() %>"></td>
							<td><%= member.getCreateAt() %></td>
							<td> <button onclick="modifyMember('<%= member.getMemberId() %>', '<%= member.getNo() %>')">수정</button></td>
							<td>
								<form action="<%= request.getContextPath() %>/mypage/admin/member-delete" method="post">
						            <input type="hidden" name="userId" value="<%= member.getMemberId() %>">
						            <button type="submit">삭제</button>
	        					</form>
        					</td>
					</tr>
					<%
					}
					%>
					</tbody>
				</table>
				<!-- 검색창 영역 -->
				<div class="searchbar">
					<form action="<%= request.getContextPath() %>/mypage/admin-member" method = "get">
					<!-- 텍스트 입력공간 -->
					<div class="bar">
						<input style="height:100%;" name="searchWord" type="text" placeholder="검색어 입력">
					</div>
					<!-- 검색버튼 공간 -->
					<div class="btn">
						<button type="submit" style="width:100%;">검색</button>
					</div>
					</form>
				</div>
				<%-- 목록번호 영역 --%>
				<!-- 하단 메뉴 (바로가기, 글쓰기) -->
				<table style="width:90%" border="1">
				<tr align="center">
				<td>
				${map.pagingImg }
				</td>
				</tr>
				</table>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/member/member_manage.js"></script>
</body>
</html>