<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html> 
    <html>
    <head>
    <meta charset="UTF-8">
    	<%@ include file="./common.jsp"%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
        </head>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/common/Mainpage.css">
        <script src="Mainpage_slideshow.js"></script>
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
				        <div><a href="<%= request.getContextPath() %>/member/logout" class="tMenu">로그아웃</a></div>
				    </c:otherwise>
				</c:choose>
                
                <div><a href="<%= request.getContextPath()%>/mypage/profile" class="tMenu">마이페이지</a></div>
              </div>
              <!-- 로고 + 영역 -->
              <div class="logo_board">
                <a href="<%= request.getContextPath()%>/main"><img class="logo" src="<%= request.getContextPath() %>/resources/image/common/Logo.png" id="login-contents-logo"></a>
                <div style="width: 80px;"><a href="<%= request.getContextPath() %>/views/board/formal/List.jsp" class="bMenu">Formal</a></div>
                <div style="width: 70px;"><a href="<%= request.getContextPath() %>/views/board/street/street.jsp" class="bMenu">Street</a></div>
                <div style="width: 118px;"><a href="<%= request.getContextPath() %>/workwear/boardlist" class="bMenu">Workwear</a></div>
                <div style="width: 90px;"><a href="<%= request.getContextPath() %>/vintage/boardlist" class="bMenu">Vintage</a></div>
                <div style="width: 130px;"><a href="<%= request.getContextPath()%>/controller/freecyclingListCon" class="bMenu">Freecycling</a></div>      
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