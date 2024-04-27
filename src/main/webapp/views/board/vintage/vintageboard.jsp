<%@page import="member.dto.response.MemberResponse"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, 
board.vintage.dto.response.VintageBoardResponse,
comment.vintage.dto.response.VintageCommentResponse,
board.vintage.controller.VintageBoardController" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/views/common/header_v2.jsp"%>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/board/vintage/vintageboard.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/board_template/temp_read.css">
</head>
<body>
<%VintageBoardResponse vbr = (VintageBoardResponse)request.getAttribute("boarddetail"); %>
<%List<VintageCommentResponse> list = (List<VintageCommentResponse>)request.getAttribute("commentslist"); %>
<!-- 중반부 전체를 감싸는 div 태그-->
<div class="container_body"> 
  <div class="container">
  <!--왼쪽, 업로드 이미지 표현 구역-->
    <div class="left_contents">
    	<img src="<%=vbr.getImgSrc() %>/<%=vbr.getImgName() %>" class="board_img">
	</div>
	
	<!--우측 게시글 + 댓글 보이는 구역-->
    <div class="right_contents"> 
      <div class="contents_body">
      <!-- ----------------------------------- -->
      <!-- 글 제목 담는곳 -->
      <div class="title_area">
        <p class="board_title"><%=vbr.getTitle() %></p>
      </div>
      
      <!-- 글 내용 담기는곳 -->
      <div class="board_content">
        <p ><%=vbr.getContents() %></p>                 
      </div>
      <!-- ----------------------------------- -->
      
       <!-- 리뷰 제목 area -->
      <div  class="reviewnav">
        <p>리뷰</p>
      </div>
      
      <div class="commentarea">        
<%
	//for 반복문으로 span에 태그 추가
	for(VintageCommentResponse dto : list){
		//out.println("dto " + dto);
%><!-- comment class는 각각 하나의 댓글을 담아냄 -->
            <!-- 댓글 1개 달리는 구역 -->
			<div class="comment">
              <span class="id"><%=dto.getNickName() %></span>
              <span class="ment"><%=dto.getComment() %></span>
              
<%
	if (session.getAttribute("LOGIN_USER") != null) {
	if (((MemberResponse)session.getAttribute("LOGIN_USER")).getMemberId() == dto.getMemberId()) {
%>
				
				<button class="button_del">삭제</button>
<%  // 실행할 내용
			}
		}
	}
%>
				<form action="<%=request.getContextPath() %>/vintage/comment/write" method = "post" class="submit">
					<div class="writer_review">
						<input type="hidden" name="boardId" value="<%=vbr.getBoardId() %>"></input>
						<input type="hidden" name="nickName" value="<%=vbr.getNickname() %>"></input>
						<input type="text" name="comment"placeholder="리뷰를 입력해주세요" class="reviewcomment">
						<input type="submit" value="입력" class="button"></input>
					</div>
				</form>               
            </div>
            <!-- 리뷰 작성 + 작성완료 버튼 -->
      	</div> <!--댓글 부분 종료-->
    </div><!--내용 컨텐츠 크기 조정-->
    </div><!--내용 컨텐츠 위치 조정-->
  </div><!--본문 컨텐츠 크기조정-->
</div><!--본문 컨텐츠 위치조정-->
<div class="edit-delete-button"><!-- 본문 수정 및 삭제 -->
			<!-- 글쓴이 본인에게만 수정하기 삭제하기 버튼 보임  -->
			<c:if test="${authMember}">
			<input type="button" value="글삭제" class="ed-de" onclick="location.href='<%=request.getContextPath() %>/controller/delete?boardId=<%=vbr.getBoardId() %>'"/>
			<input type="button" value="글수정" class="ed-de" onclick="location.href='<%=request.getContextPath() %>/controller/edit?boardId=<%=vbr.getBoardId() %>'"/>
			</c:if>
</div>
</body>
</html>