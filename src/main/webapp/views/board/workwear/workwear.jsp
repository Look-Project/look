<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="/views/common/header_v2.jsp"/>
    <link rel="stylesheet" type="text/css" 
            href="<%= request.getContextPath() %>/resources/css/board/workwear/workwear.css">
    <title></title>
</head>
<body>

    <!-- 글쓰기 버튼 -->
    <a href="<%= request.getContextPath() %>/views/board/workwear/workwearWrite.jsp" class="write-button">
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
        // 기본 동작(링크 이동)을 방지합니다.
        event.preventDefault();

        // 버튼의 href 속성에 지정된 URL로 페이지 이동
        window.location.href = this.getAttribute('href');
    });
});
</script>

</body>
</html>
