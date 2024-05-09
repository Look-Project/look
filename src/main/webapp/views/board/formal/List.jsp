<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html> 
<html>
    <head>
    <!-- 아래 CSS랑 헤더부분은 import로 대채될 예정 -->
   	<%@ include file="/views/common/header_v2.jsp"%>	
   	<script></script>
	 <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/board_template/temp_list.css">
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
                <!-- 게시글 1개 영역 -->
                <div class="post">
                    <!-- 게시글 미리보기 이미지 영역 -->
                    <div class="boardimg">
                        <img class="img" src="<%= request.getContextPath() %>/resources/image/board/formal/Formal_21.jpg">
                    </div>
                    <!-- 게시글 내용 부분 -->
                    <div class="profile">
                        <!-- 프로필 + 게시글 제목 + 작성자 영역 -->
                        <div class="pro_textbox">
                            <!-- 프로필 이미지 + 작성자 영역 -->
                            <div class="pro_img">
                                <img class="proimg" src="<%= request.getContextPath() %>/resources/image/common/profile_test.webp">
                            </div>
                            <!-- 작성자 닉네임 영역 -->
                            <div class="pro1">여기가 내가 묻힐 자리인가</div>
                            <!-- 게시글 제목 영역 -->
                            <div class="text1">#Freedom #자유 #해방<br>우리는 여기있다</div>
                        </div>
                    </div>
                </div>
                <!-- 게시글 1개 영역 -->
                <div class="post">
                    <!-- 게시글 미리보기 이미지 영역 -->
                    <div class="boardimg">
                        <img class="img" src="<%= request.getContextPath() %>/resources/image/board/formal/Formal_22.jpg">
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
                
                <!-- 게시글 10개 보충용 자바스크립트 -->
                <script>
                <%@include file="/WEB-INF/lib/jquery-3.7.1.min.js" %>
                  // 게시글을 추가할 클래스 선택
                  const postContainer = document.querySelector('.board_post');
                  
                  // HTM 생성
                  function createPost(imageNumber) {
                	    return '<div class="post">' +
                        '<div class="boardimg">' +
                            '<img class="img" src="<%= request.getContextPath() %>/resources/image/board/formal/Formal' + imageNumber + '.jpg">' +
                        '</div>' +
                        '<div class="profile">' +
                            '<div class="pro_textbox">' +
                                '<div class="pro_img">' +
                                    '<img class="proimg" src="<%= request.getContextPath() %>/resources/image/common/profile_test.webp">' +
                                '</div>' +
                                '<div class="pro1">작성자 닉네임</div>' +
                                '<div class="text1">#Freedom #자유 #해방<br>우리는 여기있다</div>' +
                            '</div>' +
                        '</div>' +
                    '</div>';
                  };
          
                  // 반복 
                  for (let i = 3; i <= 12; i++) {
                      const postHTML = createPost(i);
                      postContainer.innerHTML += postHTML;
                  }
              </script>
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
	<a href="">
	<img src="<%= request.getContextPath() %>/resources/image/board/vintage/write_icon.jpg" class="vwritebutton-icon">
	</a>
</button>

</body>
</html>
