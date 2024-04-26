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
</head>
<body>
<%VintageBoardResponse vbr = (VintageBoardResponse)request.getAttribute("boarddetail"); %>
<%List<VintageCommentResponse> list = (List<VintageCommentResponse>)request.getAttribute("commentslist"); %>
<div class="container"> <!-- 중반부 전체를 감싸는 div 태그-->
	<div class="left_img"> <!--중반부 를 두개의 div태그로 나누어 왼쪽 절반의 구역으로 나눠줌-->
		<img src="<%=vbr.getImgSrc() %>/<%=vbr.getImgName() %>" class="img">
	</div>
	<div class="right_content"> <!--중반부 를 두개의 div태그로 나누어 오른쪽 절반의 구역으로 나눠줌--><br>
		<div class="content_container">
			<div><%=vbr.getBoardId() %></div>
			<div class="title">
				<p><%=vbr.getTitle() %></p>
			</div>
			<div class="contents">
				<p><%=vbr.getContents() %></p>
			</div>
			<!-- 글쓴이 본인에게만 수정하기 삭제하기 버튼 보임  -->
			<div class="button">
			<c:if test="${authMember}">
			<input type="button" value="수정" onclick="location.href='<%=request.getContextPath() %>/controller/edit?boardId=<%=vbr.getBoardId() %>'"/>
			<input type="button" value="삭제" onclick="location.href='<%=request.getContextPath() %>/controller/delete?boardId=<%=vbr.getBoardId() %>'"/>
			<br/>
			</c:if>
			</div>
		</div>
		<p class="review">리뷰</p>
		<div class="Allcomment">
			<!--모든 댓글 내용을 담아내는 div 태그-->
			<div class="comment"> 
<%
	//for 반복문으로 span에 태그 추가
	for(VintageCommentResponse dto : list){
		//out.println("dto " + dto);
%><!-- comment class는 각각 하나의 댓글을 담아냄 -->
				<span class="nickname"><%=dto.getNickName() %></span>
				<span class="comment_text"><%=dto.getComment() %></span>
				<button class="deletebutton">삭제</button>
				<a href="#" class="commentheart"><i class="far fa-heart"></i></a>
				</br>
<%
}
%>
			</div>
		</div>
		<form action="<%=request.getContextPath() %>/vintage/comment" method = "post" class="submit">
			<div class="input_container">
				<input type="hidden" name="boardId" value="<%=vbr.getBoardId() %>"></input>
				<input type="hidden" name="nickName" value="<%=vbr.getNickname() %>"></input>
				<%-- <%=vbr.getNickname() %> --%>
				<input type="text" placeholder="리뷰를 입력해주세요" class="inputcomments" name = "comment"></input>
				<input type="submit" value="입력" class="submit_button"></input>
			</div>
		</form>
	</div>
</div>
</body>
</html>