<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html> 
<html>
    <head>
    <meta charset="UTF-8">
    <!-- 아래 CSS랑 헤더부분은 import로 대채될 예정 -->
   	<%@ include file="/views/common/header_v2.jsp"%>	
	 <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/board/freecyclingCss/temp_list.css">
    </head>
    <body>
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
    <c:forEach var="listdto" items="${listdto}">
	<a href="<%=request.getContextPath() %>/controller/FreecyclingOneContentCon?num=${listdto.boardId }">
	
                <!-- 게시글 1개 영역 -->
                <div class="post">
                    <!-- 게시글 미리보기 이미지 영역 -->
                    <div class="boardimg">
						<img class="img" src="${listdto.imgSrc}/${listdto.imgName}" >           
			        </div>
                    <!-- 게시글 내용 부분 -->
                    <div class="profile">
                        <!-- 프로필 + 게시글 제목 + 작성자 영역 -->
                        <div class="pro_textbox">
                            <!-- 프로필 이미지 + 작성자 영역 -->
                            <div class="pro_img">
                                <img class="proimg" src="${listdto.profileSrc}/${listdto.profileName}">
                            </div>
                            <!-- 작성자 닉네임 영역 -->
                            <div class="pro1">${listdto.nickname}</div>
                            <!-- 게시글 제목 영역 -->
                            <div class="text1">${listdto.title}</div>
                        </div>
                    </div>
                </div>
                </a>
                </c:forEach>
                
      <%-- <!--             
                <!-- 게시글 1개 영역 -->
                <div class="post">
                    <!-- 게시글 미리보기 이미지 영역 -->
                    <div class="boardimg">
                        <img class="img" src="<%= request.getContextPath() %>/resources/image/board/vintage/vintage4.jpg">
                    </div>
                    <!-- 게시글 내용 부분 -->
                    <div class="profile">
                        <!-- 프로필 + 게시글 제목 + 작성자 영역 -->
                        <div class="pro_textbox">
                            <!-- 프로필 이미지 + 작성자 영역 -->
                            <div class="pro_img">
                                <img class="proimg" src="<%= request.getContextPath() %>/resources/image/common/profile_test2.webp">
                            </div>
                            <!-- 작성자 닉네임 영역 -->
                            <div class="pro1">메밀꽃 필무렵</div>
                            <!-- 게시글 제목 영역 -->
                            <div class="text1">#장돌뱅이 #허생원<br>애시당초 글러서</div>
                        </div>
                    </div>
                </div>
       -->  --%>
<%--  <!-- 여기 건드리지 말기 -->
                <!-- 게시글 10개 보충용 자바스크립트 -->
            
 --%>
            </div>
 
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
                </div>
            </div>
        </div>
    </div>
<button class="vwritebutton">
	<a href="<%=request.getContextPath() %>/controller/FreeInsertCon"> 	
	<img src="<%= request.getContextPath() %>/resources/image/board/freecycling/freecyclingicon.png" class="vwritebutton-icon">
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
