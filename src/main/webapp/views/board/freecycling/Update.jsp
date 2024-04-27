<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
    <head>
    <meta charset="UTF-8">
    <!-- 아래 CSS랑 헤더부분은 import로 대채될 예정 -->

  	<%@ include file="/views/common/header_v2.jsp"%>	
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/board/freecyclingCss/temp_update.css">
   </head>
    <body>
       <!-- 메인 컨텐츠 영역 -->
      <div class="vwrite-container">
        <!-- 폼 태그 시작부분 -->
        <form action="<%=request.getContextPath() %>/controller/FreeEditCon" method = "post" class="submit" enctype="multipart/form-data">
          <!-- 게시글 제목 작성영역 -->
          <div class="container">
             <c:set var="onecondto" value="${onecondto}" />
             <input type="hidden" name="boardId" id="boardId" value="${onecondto.boardId }">
             
                <div class="col-25">
                  <!-- area title -->
                <label for="title">제목</label>
                </div>
                <div class="col-75">
                <input type="text" id="title" name="title" value="${onecondto.title}" placeholder="여기에 제목을 입력하세요."></input>
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
                <textarea id="contents" name="contents" placeholder="여기에 내용을 입력하세요." style="height:400px">${onecondto.contents}</textarea>
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
          </div>
        </form>
      </div>
    </body>
</html>