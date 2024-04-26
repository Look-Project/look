<!DOCTYPE html> 
<html>
    <head>
    <meta charset="UTF-8">
    <!-- 아래 CSS랑 헤더부분은 import로 대채될 예정 -->
    <!-- <%@ include file="./common.jsp"%> -->
  	<%@ include file="/views/common/header_v2.jsp"%>	
	 <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/board/board_template/temp_update.css">
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
            <a href="<%= request.getContextPath()%>/main"><img class="logo" src="../../../resources/image/common/Logo.png" id="login-contents-logo"></a>
            <div style="width: 80px;"><a href="<%= request.getContextPath() %>/views/board/formal/formal_list.jsp" class="bMenu">Formal</a></div>
            <div style="width: 70px;"><a href="<%= request.getContextPath() %>/views/board_street/street.jsp" class="bMenu">Street</a></div>
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
      <!-- -------------------------------------------------------------------------------------------------------------- -->
      <!-- 메인 컨텐츠 영역 -->
      <div class="vwrite-container">
        <!-- 폼 태그 시작부분 -->
        <form action="<%=request.getContextPath() %>/vintage/write" method = "post" class="submit" enctype="multipart/form-data">
          <!-- 게시글 제목 작성영역 -->
          <div class="container">
                <div class="col-25">
                  <!-- area title -->
                <label for="title">제목</label>
                </div>
                <div class="col-75">
                <input type="text" id="title" name="title" placeholder="여기에 제목을 입력하세요."></input>
                </div>
            </div>
            <!-- 내용 작성 영역 -->
            <div class="container">
              <!-- area title -->
              <div class="col-25">
                <label for="content">내용</label>
              </div>
              <!-- text write area -->
              <div class="col-75">
                <!-- 편집기 -->
                <textarea id="contents" name="contents" placeholder="여기에 내용을 입력하세요." style="height:400px"></textarea>
              </div>
            </div>
            <!-- 이미지 업로드 영역 -->
            <div class="container">
              <!-- area title -->
               <div class="col-25">
                   <label for="upload">파일 첨부</label>
              </div>
              <!-- img upload area -->
              <div class="col-75">
              <input type="file" name="uploadFile" accept="image/*" multiple></input>
            </div>
            </div>
            <!-- 글수정 버튼 -->
          <div class="container" id="btn">
            <input type="submit" value="완료"></input>
            <input type="submit" value="삭제"></input>
          </div>
        </form>
      </div>
    </body>
</html>