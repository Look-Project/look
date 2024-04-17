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
                <img src="<%= request.getContextPath() %>/resources/image/board/workwear/03.jpg" 
                		alt="">
            </div>

            <div class="second"> <!--중반부 를 두개의 div태그로 나누어 오른쪾 절반의 구역으로 나눠줌-->
                    <br>
                    <div id="fifth">
                        <div class="emojiright">
                            <p class="boardname">워크웨어룩</p>
                        </div>
                    </div>

                    <p class="seconddetail">
                    	멜빵 바지로 웨크웨어룩을 꾸며 보았어요 ~ <br/>
                    	처음 입어보는데 좋아요 !<br/>
                    	궁금한거 있으시면 물어봐주세요 ^^<br/></p>
            <!-- 폼 추가 -->
            <form id="workwearDetailForm" action="/workwearDetail" method="GET">
                <input type="hidden" name="boardID" value="123"> <!-- 여기에 실제 boardID 값을 넣어주세요 -->
                <button type="submit">작업복 상세 정보 가져오기</button>
            </form>
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
			
			<script>
        // 폼이 서브밋될 때 실행될 함수 정의
        document.getElementById("workwearDetailForm").addEventListener("submit", function(event) {
            // 기본 동작(폼의 서버 전송) 막기
            event.preventDefault();

            // 폼 데이터 가져오기
            var formData = new FormData(this);

            // 서버로 데이터를 전송할 수 있는 방법 (Ajax 등)을 사용하여 formData를 전송
            // 이 부분을 해당 프로젝트에서 사용하는 방식에 맞게 수정해야 합니다.
            // 아래는 간단한 Ajax 예제입니다.
            var xhr = new XMLHttpRequest();
            xhr.open(this.method, this.action, true);
            xhr.onload = function () {
                // 서버로부터의 응답 처리
                if (xhr.status === 200) {
                    // 성공적으로 데이터를 받았을 때의 처리
                    console.log(xhr.responseText); // 받은 데이터를 콘솔에 출력하거나, 필요한 처리를 진행하세요.
                } else {
                    // 실패했을 때의 처리
                    console.error(xhr.statusText); // 오류 메시지 출력 또는 필요한 처리를 진행하세요.
                }
            };
            xhr.send(formData); // 폼 데이터 전송
        });
    </script>
</body>
</html>