<!DOCTYPE html> 
<html>
    <head>
    <meta charset="UTF-8">
    <!-- css불러오는 부분 -->
    <link rel="stylesheet" type="text/css" href="../../../resources/css/common/Mainpage.css">
        
    </head>
    <body>
        <!-- 상단메뉴 영역 -->
        <div class="top_body">
          <div class="top_base">
            <!-- 마이메뉴 영역 -->
            <div class="personal_menu">
              <div><a href="" class="tMenu">고객센터</a></div>
              <c:choose>
                  <c:when test="${empty sessionScope.LOGIN_USER}">
                      <!-- 세션이 없는 경우 로그인 링크를 표시 -->
                      <div><a href="<%= request.getContextPath() %>/member/login" class="tMenu">로그인</a></div>
                  </c:when>
                  <c:otherwise>
                      <!-- 세션이 있는 경우 로그아웃 링크를 표시 -->
                      <!-- <div><a href="<%= request.getContextPath() %>/member/logout" class="tMenu">로그아웃</a></div> -->
                  </c:otherwise>
              </c:choose>
              
              <div><a href="" class="tMenu">마이페이지</a></div>
            </div>
            <!-- 로고 + 영역 -->
            <div class="logo_board">
              <!-- 로고 이미지 -->
              <a href="<%= request.getContextPath()%>/main"><img class="logo" src="../../../resources/image/common/Logo.png" id="login-contents-logo"></a>
              <!-- 각 게시판 타이틀 -->
              <div><a href="<%= request.getContextPath() %>/views/board/formal/formal_list.jsp" class="bMenu"> Formal</a></div>
              <div><a href="<%= request.getContextPath() %>/views/board_street/street.jsp" class="bMenu">Street</a></div>
              <div><a href="<%= request.getContextPath() %>/workwear/boardlist" class="bMenu">Workwear</a></div>
              <div><a href="<%= request.getContextPath() %>/vintage/boardlist" class="bMenu">Vintage</a></div>
              <div><a href="<%= request.getContextPath()%>/controller/freecyclingListCon" class="bMenu">Freecycling</a></div>      
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