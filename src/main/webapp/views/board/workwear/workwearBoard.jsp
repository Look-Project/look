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
<div class="container" id="one"> <!-- 중반부 전체를 감싸는 div 태그-->
            
            <div class="img"> <!--중반부 를 두개의 div태그로 나누어 왼쪽 절반의 구역으로 나눠줌-->
                <img src="<%=wbr.getImgSrc() %>/<%=wbr.getImgName() %>"  
                		alt="">
            </div>

            <div class="second"> <!--중반부 를 두개의 div태그로 나누어 오른쪾 절반의 구역으로 나눠줌-->
                    <br>
                    <div id="fifth">
                        <div class="emojiright">
                            <p class="boardname"><%=wbr.getTitle() %></p>
                        </div>
                    </div>

                    <p class="seconddetail">
                    	<%=wbr.getContents() %>
                    <p class="reviewnav">리뷰</p>
 <%List<CommentResponse> list = (List<CommentResponse>)request.getAttribute("commentlist"); %>
                    <div class="Allcomment"> <!--모든 댓글 내용을 담아내는 div 태그-->
                            <%for(CommentResponse dto : list){%>
					<div class="comment"> <!-- comment class는 각각 하나의 댓글을 담아냄 -->
							<span class="id"><%=dto.getNickname()%></span>
                            <span class="ment"><%=dto.getContents()%></span>
                        </div>
                    <%}%>
                    </div>
            
                    <input text="" placeholder="리뷰를 입력해주세요" class="reviewcomment">
                    <button class="reviewbutton">작성</button>
                    
                    
			</div></div>

</body>
</html>