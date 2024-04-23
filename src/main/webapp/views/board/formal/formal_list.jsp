<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <%@ include file="/views/common/header.jsp"%> --%>
<%@ include file="/views/common/header_v2.jsp"%>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/board/formal/formal_list.css">
</head>
<body>

	<!-- 메인 컨텐츠 -->
	<div class="contents_body">
	<div class="contents">
		<!-- 정렬 영역 -->
		<div class="board_sort">
			<div class="sortbtn">최신순</div>
			<div class="sortbtn">||</div>
			<div class="sortbtn">추천순</div>
		</div>

		<!-- 게시글 영역 -->
		<div class="board_post">
			<%-- 게시글 1개 영역 --%>
			<div class="post">
				<%-- 게시글 미리보기 이미지 영역 --%>
				<div class="img">11</div>
				<%-- 게시글 내용 부분 --%>
				<div class="profile">
					<%-- 프로필 이미지 영역 --%>
					<div class="pro_img"></div>
					<div class="pro_textbox">
						<%-- 작성자 이름 영역 --%>
						<div class="pro1"></div>
						<%-- 게시글 내용 --%>
						<div class="text1"></div>
					</div>
				</div>
			</div>
			<div class="post">2</div>
			<div class="post">3</div>
			<div class="post">4</div>
			<div class="post">5</div>
			<div class="post">6</div>
			<div class="post">7</div>
			<div class="post">8</div>
		</div>

		<!-- 목록 번호 + 글작성 영역 -->
		<div class="board_bottom">
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
			<%-- 글작성 버튼 영역 --%>
			<div class="board_writebtn">
				<div class="btn">글작성</div>
			</div>
	</div>
	</div>
</body>
</html>