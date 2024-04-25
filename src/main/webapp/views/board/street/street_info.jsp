<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<%@ include file="../../common/common.jsp"%>
	<%@ include file="../../common/header_v2.jsp"%>
	
<link href="../../../resources/css/board/street/street_info.css" rel="stylesheet" type="text/css">

<title></title>
</head>
<body>
<div class="container" id="one"> <!-- 중반부 전체를 감싸는 div 태그-->
            
            <div class="first"> <!--중반부 를 두개의 div태그로 나누어 왼쪽 절반의 구역으로 나눠줌-->
                 <img src="<%= request.getContextPath() %>/resources/image/board/street/street.jpg" 
                		alt="">
            </div>

            <div class="second"> <!--중반부 를 두개의 div태그로 나누어 오른쪾 절반의 구역으로 나눠줌-->
                    <div id="fifth">
                        <div class="emojiright">
                            <p class="boardname">Street</p><br/>
                        </div>
                    </div>

                    <p class="seconddetail">날씨완벽 <br><br/> <p style "font-size : 15px" >#스트릿룩 #간지 #일본

                    <div class="Allcomment"> <!--모든 댓글 내용을 담아내는 div 태그-->
                        <div class="comment"> <!-- comment class는 각각 하나의 댓글을 담아냄 -->
                            <br/><span class="id">### : </span>
                            <span class="ment">상의 정보좀 알려주세요!</span>
                            <button class="deletebutton">삭제</button>
                            <a href="#" class="commentheart"><i class="far fa-heart"></i></a>
                        </div>

                        <div class="comment">
                            <span class="id">### : </span>
                            <span class="ment">멋있어요~</span>
                            <button class="deletebutton">삭제</button>
                            <a href="#" class="commentheart"><i class="far fa-heart hearts"></i></a>
                        </div>

                        <div class="comment">
                            <span class="id">### : </span>
                            <span class="ment">전체 착장 정보좀 알려주세요.</span>
                            <button class="deletebutton">삭제</button>
                            <a href="#" class="commentheart"><i class="far fa-heart"></i></a>
                        </div>
                    </div>
                    <input text="" placeholder="리뷰를 입력해주세요" class="reviewcomment"
                            onkeyup="if(window.event.keyCode==13){test()}"> <!--후반부에 구현할 댓글 입력을 위한 input 태그-->
					<button class="completebutton">확인</button>
			</div>
			
			</div>
			
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