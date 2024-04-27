<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
    <head>
    <meta charset="UTF-8">
    <!-- 아래 CSS랑 헤더부분은 import로 대채될 예정 -->
    <%@ include file="/views/common/header_v2.jsp"%>	
	 <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/board_template/temp_read.css">
    </head>
    <body>

<!-- 중반부 전체를 감싸는 div 태그-->
<div class="container_body"> 
  <div class="container">
    <!--왼쪽, 업로드 이미지 표현 구역-->
    <div class="left_contents">
      <img class="board_img" src="<%= request.getContextPath() %>/resources/image/board/workwear/03.jpg" alt="">
    </div>
  
  <!--우측 게시글 + 댓글 보이는 구역-->
    <div class="right_contents"> 
      <div class="contents_body">
      <!-- ----------------------------------- -->
      <!-- 글 제목 담는곳 -->
      <div class="title_area">
        <p class="board_title">여기에 글제목이 들어갑니다.</p>
      </div>
      
      <!-- 글 내용 담기는곳 -->
      <div class="board_content">
        <p >여기에 글이 들어가는거 같은데요??<%--  <!-- <%=wbr.getContents() %> --> --%></p>                 
      </div>
      <!-- ----------------------------------- -->
      
      <!-- 리뷰 제목 area -->
      <div  class="reviewnav">
        <p>리뷰</p>
      </div>
      <!-- ----------------------------------- -->
     <%--  <!-- <%List<CommentResponse> list = (List<CommentResponse>)request.getAttribute("commentlist"); %> --> --%>
        <!--모든 댓글 내용을 담아내는 div 태그-->
        <div class="Allcomment"> 
       <%--    <!--    <%for(CommentResponse dto : list){%>--> --%>
          <!-- comment class는 각각 하나의 댓글을 담아냄 -->

          <!-- 댓글 달리는 구역 -->
          <div class="commentarea"> 
            <!-- 댓글 1개 달리는 구역 -->
            <div class="comment">
              <span class="id">김헌종<%-- <!--<%=dto.getNickname()%>--> --%></span>
              <span class="ment">댓글내용<%-- <!--<%=dto.getContents()%>--> --%></span>
              <button class="button_del">삭제</button>   
            </div>
            <div class="comment">
              <span class="id">임성현<%-- <!--<%=dto.getNickname()%>--> --%></span>
              <span class="ment">성현아 사랑해<%-- <!--<%=dto.getContents()%>--> --%></span>
              <button class="button_del">삭제</button>   
            </div>
          </div>
        <%--   <!-- <%}%> --> --%>
        <!-- 리뷰 작성 + 작성완료 버튼 -->
          <div class="writer_review">
            <input text="" placeholder="리뷰를 입력해주세요" class="reviewcomment">
            <button class="button">글수정</button>        
            <button class="button">리뷰작성</button>     
            
          </div>  
      </div> <!--댓글 부분 종료-->
    </div><!--내용 컨텐츠 크기 조정-->
    </div><!--내용 컨텐츠 위치 조정-->
  </div><!--본문 컨텐츠 크기조정-->
</div><!--본문 컨텐츠 위치조정-->
    </body>
</html>