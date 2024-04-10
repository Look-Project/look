<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <jsp:include page="/views/common/header.jsp"/>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/board/workwear/workwearBoard.css">
    
<title></title>
</head>
<body>
	<div class="container" id="one"> <!-- 중반부 전체를 감싸는 div 태그-->
            
            <div class="first"> <!--중반부 를 두개의 div태그로 나누어 왼쪽 절반의 구역으로 나눠줌-->
                <img src="<%= request.getContextPath() %>/resources/image/board/workwear/05.jpg" 
                		alt="콜드브루">
            </div>

            <div class="second"> <!--중반부 를 두개의 div태그로 나누어 오른쪾 절반의 구역으로 나눠줌-->
                    <br>
                    <div id="fifth">
                        <div class="emojiright">
                            <p class="boardname">여행룩</p>
                        </div>
                    </div>

                    <p class="seconddetail">기본 모자 <br/>
                    젠틀몬스터 선글라스<br/>
                    스투시나이키 아노락<br/>
                    스투시 블랙카고바지 </p>
                    <p class="reviewnav">리뷰</p>

                    <div class="Allcomment"> <!--모든 댓글 내용을 담아내는 div 태그-->
                        <div class="comment"> <!-- comment class는 각각 하나의 댓글을 담아냄 -->
                            <span class="id">SuRa</span>
                            <span class="ment">너무 멋져요!</span>
                            <button class="deletebutton">삭제</button>
                            <a href="#" class="commentheart"><i class="far fa-heart"></i></a>
                        </div>

                        <div class="comment">
                            <span class="id">성현아 사랑해</span>
                            <span class="ment">아노락 가격 알수 있을까요?</span>
                            <button class="deletebutton">삭제</button>
                            <a href="#" class="commentheart"><i class="far fa-heart hearts"></i></a>
                        </div>

                        <div class="comment">
                            <span class="id">legend_dev</span>
                            <span class="ment">진짜 젠클몬스터는 전설이다.
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