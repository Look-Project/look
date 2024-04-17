<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="/views/common/header.jsp"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/board/workwear/workwearWrite.css">
    <title></title>
</head>
<body>
    <div class="card">
        <div class="card-header1">
        </div>

        <div class="card-write">
            <!-- 폼 추가 -->
            <form id="workwearForm">
                <div class="title-w">
                    <h1>제목</h1>
                    <input type="text" name="title" placeholder="제목을 입력하세요.">
                </div>

                <div class="msg">
                    <h1>내용</h1>
                    <textarea name="contents" placeholder="내용을 입력하세요."></textarea>
                    <input type="file" name="file" id="file">
                </div>
            </form>
        </div>
        <!-- 제출 버튼에 이벤트 리스너 추가 -->
        <div class="btn-w"><button onclick="submitForm()">작성</button></div>
    </div>

    <script>
        // 폼 데이터를 얻어와서 백엔드에 전송하는 함수
        function submitForm() {
            var form = document.getElementById('workwearForm');
            var formData = new FormData(form);

            // 서버로 데이터 전송
            fetch('/workwear/write', {
                method: 'POST',
                body: formData
            })
            .then(response => response.json())
            .then(data => {
                console.log(data); // 백엔드로부터 받은 응답 처리
            })
            .catch(error => {
                console.error('Error:', error);
            });
        }
    </script>
</body>
</html>
