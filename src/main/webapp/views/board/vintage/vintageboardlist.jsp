<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
    
<%@ page import="java.util.List" %>
<%@ page import="board.vintage.dto.response.VintageBoardListResponse" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vintage</title>
<!-- 아래 CSS랑 헤더부분은 import로 대채될 예정 -->
<%@ include file="/views/common/header_v2.jsp"%>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/board_template/temp_list.css">
<!-- 아래 css는 상세게시글 경로의 a 태그 속성 
a{
	text-decoration:none;
	color: black;
}  -->
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/board/vintage/vintageboardlist.css">
</head>
<body>

<%List<VintageBoardListResponse> list = (List<VintageBoardListResponse>)request.getAttribute("boardlist"); %>
<!-- 메인 컨텐츠 -->
	<div class="contents_body">
		<div class="contents">
			<!-- 정렬 영역(미구현) -->
			<!-- <div class="board_sort">
			<div class="sortbtn"></div>
			<div class="sortbtn"></div>
			<div class="sortbtn"></div>
			</div> -->

            <!-- 게시글 영역 -->
			<div class="board_post">
			
<%
	//for 반복문으로 div에 태그 추가
	for(VintageBoardListResponse dto : list){
	//out.println("dto " + dto);
%>
				<a href="<%= request.getContextPath() %>/vintage/detail?boardId=<%= dto.getBoardId()%>">
                <!-- 게시글 1개 영역 -->
	                <div class="post">
	                    <!-- 게시글 미리보기 이미지 영역 -->
	                    <div class="boardimg">
	                        <img class="img" src="<%=dto.getImgSrc() %>/<%=dto.getImgName() %>">
	                    </div>
	                    <!-- 게시글 내용 부분 -->
	                    <div class="profile">
	                        <!-- 프로필 + 게시글 제목 + 작성자 영역 -->
	                        <div class="pro_textbox">
	                            <!-- 프로필 이미지 + 작성자 영역 -->
	                            <div class="pro_img">
	                                <img class="proimg" src="<%=dto.getUserImgSrc()%>/<%=dto.getUserImgName()%>"/>
	                            </div><!-- pro_img -->
	                            <!-- 작성자 닉네임 영역 -->
	                            <div class="pro1"><%=dto.getNickname()%></div>
	                            <!-- 게시글 제목 영역 -->
	                            <div class="text1"><%=dto.getTitle()%></div>
	                        </div><!-- pro_textbox -->
	                    </div><!-- profile -->
	                </div><!-- post -->
                </a>
<%
}
%>

		
<%-- 			<div class="vimg-frame">
				<img src="<%=dto.getImgSrc() %>/<%=dto.getImgName() %>" class="vgallery-img">
				<div class="vcontent-frame">
					<h3 class="vcontent-title"><%=dto.getNickname()%></h3>
					<hr/>
					<p class="vgallery-content"><%=dto.getTitle()%></p>
				</div>
			</div> --%>
		

			</div><!-- board_post -->

            <!-- 목록 번호 + 글작성 영역 -->
            <div class="board_bottom">
                <div class="board_num">
                    <div class="num">◀</div>
                    <div class="num">1</div>
                    <div class="num">2</div>
                    <div class="num">3</div>
                    <div class="num">4</div>
                    <div class="num">5</div>
                    <div class="num">▶</div>
                </div><!-- board_num -->
            </div><!-- board_bottom -->
        </div><!-- contents -->
    </div><!-- contents_body -->
	<button class="vwritebutton">
		<a href="<%= request.getContextPath() %>/vintage/write">
		<img src="<%= request.getContextPath() %>/resources/image/board/vintage/write_icon.jpg" class="vwritebutton-icon">
		</a>
	</button>

	   <script>
        // 게시글 수에 따른 그리드 행 조정
        function adjustGridRows() {
            // 게시글 영역 선택
            const boardPost = document.querySelector('.board_post');
            
            // 게시글 수 확인
            const postCount = boardPost.children.length;
            
            // 한 행에 포함되는 게시글 수
            const columnsPerRow = 4; // 그리드의 열 수
            
            // 행의 수 계산
            const rowCount = Math.ceil(postCount / columnsPerRow);
            
            // grid-template-rows 속성 조정
            boardPost.style.gridTemplateRows = `repeat(${rowCount}, 1fr)`;
        }

        // 페이지 로드 후 그리드 행 조정
        window.onload = function() {
            adjustGridRows();
        };
    </script>

</body>
</html>