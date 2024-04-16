 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html> 
    <html>
    <head>
    <meta charset="UTF-8">
    	<%@ include file="./common.jsp"%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
        </head>
        <link rel="stylesheet" href="Mainpage.css">
        <script src="Mainpage_slideshow.js"></script>
        <body>
          <!-- 상단메뉴 영역 -->
          <div class="top_body">
            <div class="top_base">
              <!-- 마이메뉴 영역 -->
              <div class="personal_menu">
                <div><a href="" class="tMenu">고객센터</a></div>
                <div><a href="<%= request.getContextPath() %>/member/login" class="tMenu">로그인</a></div>
                <div><a href="" class="tMenu">마이페이지</a></div>
              </div>
              <!-- 로고 + 영역 -->
              <div class="logo_board">
                <a href="<%= request.getContextPath()%>/main"><img class="logo" src="<%= request.getContextPath() %>/resources/image/common/Logo.png" id="login-contents-logo"></a>
                <div><a href="" class="bMenu">Formal</a></div>
                <div><a href="" class="bMenu">Street</a></div>
                <div><a href="" class="bMenu">Workwear</a></div>
                <div><a href="" class="bMenu">Vintage</a></div>
                <div><a href="" class="bMenu">Freecycling</a></div>
                </div>
              </div>	 
              <!-- 게시판 이미지로 작성할 때 사용될것 -->
              <!-- <div class="logo_board">
                <img class="logo" src="../../resources/image/common/Logo.png" />
                <img class="boardselect"   src="../../resources/image/common/Formal_T.jpg" alt="Formal">
                <img class="boardselect"   src="../../resources/image/common/Street_T.jpg" alt="Street">
                <img class="boardselect"  src="../../resources/image/common/Workwear_T.jpg" alt="Workwear">
                <img class="boardselect"  src="../../resources/image/common/Vintage_T.jpg" alt="Activewear">
                <img class="boardselect"  src="../../resources/image/common/Free_T.jpg" alt="Freecycling">
              </div>  -->
            </div>
          </div>
        </body>
    </html>