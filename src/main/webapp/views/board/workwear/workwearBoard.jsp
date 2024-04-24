<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="board.workwear.dto.response.WorkwearBoardResponse" %>
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

                    <div class="Allcomment"> <!--모든 댓글 내용을 담아내는 div 태그-->
                        <div class="comment"> <!-- comment class는 각각 하나의 댓글을 담아냄 -->
                            <span class="id">SuRa</span>
                            <span class="ment">너무 멋져요!</span>
                            <button class="deletebutton">삭제</button>
                            <a href="#" class="commentheart"><i class="far fa-heart"></i></a>
                        </div>

                        <div class="comment">
                            <span class="id">Amen</span>
                            <span class="ment">점프수트 구매처 알수 있을까요???</span>
                            <button class="deletebutton">삭제</button>
                            <a href="#" class="commentheart"><i class="far fa-heart hearts"></i></a>
                        </div>

                        <div class="comment">
                            <span class="id">legend_dev</span>
                            <span class="ment">진짜 전설이다.
                            </span>
                            <button class="deletebutton">삭제</button>
                            <a href="#" class="commentheart"><i class="far fa-heart"></i></a>
                        </div>
                    </div>
                    <input text="" placeholder="리뷰를 입력해주세요" class="reviewcomment"
                            onkeyup="if(window.event.keyCode==13){test()}"> <!--후반부에 구현할 댓글 입력을 위한 input 태그-->
			</div></div>

</body>
</html>