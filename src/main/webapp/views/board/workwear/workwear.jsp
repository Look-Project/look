<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="/views/common/header.jsp"/>
    <link rel="stylesheet" type="text/css" 
    		href="<%= request.getContextPath() %>/resources/css/board/workwear/workwear.css">
    <title></title>
</head>
<body>

	<!-- 글쓰기 버튼 -->
	<a href="#" class="write-button">
    	<img src="<%= request.getContextPath() %>/resources/image/board/workwear/Writing.png" 
    			alt="Write" class="write-icon">
	</a>


   <div id="wrap">
        <ul id="gallery">
            <li><a href="<%= request.getContextPath() %>/views/board/workwear/workwearBoard01.jsp">
                    <img src="<%= request.getContextPath() %>/resources/image/board/workwear/03.jpg" alt="1">
                    <div class="text-overlay">글쓴이: 아무개</div>
                </a></li>
        </ul>
    </div>

<script>
document.addEventListener('DOMContentLoaded', function() {
    // 글쓰기 버튼을 클릭했을 때의 동작을 정의합니다.
    document.querySelector('.write-button').addEventListener('click', function(event) {
        event.preventDefault(); // 기본 동작(링크 이동)을 방지합니다.
        
        // AJAX 요청을 보내는 fetch API를 사용합니다.
        fetch('/board/workwear/workwearWrite', {
            method: 'GET', // GET 메서드를 사용하여 요청합니다.
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); // 응답을 JSON 형식으로 파싱합니다.
        })
        .then(data => {
            // 성공적으로 응답을 받았을 때 할 일을 정의합니다.
            console.log(data); // 받은 데이터를 콘솔에 출력합니다.
            // 여기에 받은 데이터를 처리하는 로직을 작성하세요.
        })
        .catch(error => {
            // 오류가 발생했을 때 처리하는 부분입니다.
            console.error('There has been a problem with your fetch operation:', error);
        });
    });
});
</script>

</body>
</html>
