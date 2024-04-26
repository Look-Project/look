<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="board.workwear.dto.response.WorkwearBoardResponse" %>
<%@ page import="board.workwear.dto.response.CommentResponse" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <jsp:include page="/views/common/header_v2.jsp"/>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/board/workwear/workwearBoard.css">
    
<title></title>
</head>
<body>
<%WorkwearBoardResponse wbr = (WorkwearBoardResponse)request.getAttribute("boarddetail"); %>
<%List<CommentResponse> list = (List<CommentResponse>)request.getAttribute("commentlist"); %>
<div class="container" id="one"> <!-- 중반부 전체를 감싸는 div 태그-->
            
            <div class="img"> <!--중반부 를 두개의 div태그로 나누어 왼쪽 절반의 구역으로 나눠줌-->
                <img src="<%=wbr.getImgSrc() %>/<%=wbr.getImgName() %>"  
                		alt="">
                	<c:if test="${authMember}">
		 				<input type="button" value="수정하기" onclick="location.href='<%=request.getContextPath() %>/controller/WorkwearEditController?num=<%=wbr.getBoardId() %>'">
		 				<input type="button" value="삭제하기" onclick="location.href='<%=request.getContextPath() %>/controller/WorkwearDeleteController?num=<%=wbr.getBoardId() %>'">
					</c:if>
            </div>

            <div class="second"> <!--중반부 를 두개의 div태그로 나누어 오른쪾 절반의 구역으로 나눠줌-->
                    <br>
                    <div><%=wbr.getBoardId() %></div>
                    <div id="fifth">
                        <div class="emojiright">
                            <p class="boardname"><%=wbr.getTitle() %></p>
                        </div>
                    </div>

                    <p class="seconddetail">
                    	<%=wbr.getContents() %>
                    <p class="reviewnav">리뷰</p>

                    <div class="Allcomment"> 
                    <!--모든 댓글 내용을 담아내는 div 태그-->
                        <div class="comment"> 
<%
	//for 반복문으로 span에 태그 추가
	for(CommentResponse dto : list){
		//out.println("dto " + dto);
%><!-- comment class는 각각 하나의 댓글을 담아냄 -->
                            <span class="id"><%=dto.getNickName() %></span>
                            <span class="ment"><%=dto.getComment() %></span>
                            <button class="deletebutton">삭제</button>
                            <a href="#" class="commentheart"><i class="far fa-heart"></i></a>
                            </br>
<%
}
%>
                        </div>
                    </div>
                    <form action="<%=request.getContextPath() %>/workwear/comment" method = "post" class="submit">
                    <div>
                    <input type="hidden" name="boardId" value="<%=wbr.getBoardId() %>"></input>
                    <input type="hidden" name="nickName" value="<%=wbr.getNickname() %>"></input>
                    <input type="text" placeholder="리뷰를 입력해주세요" class="inputcomments" name = "comment">
                    	<input type="submit" value="입력" class="submit_button"></input>
                    </input>
                   	</div>
                   	</form>
			</div></div>
</body>
</html>