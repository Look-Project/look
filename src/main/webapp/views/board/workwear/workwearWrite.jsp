<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <div class="title-w">
                <h1>제목</h1>
                <input type="text" placeholder="제목을 입력하세요.">
            </div>

            <div class="msg">

                <!-- 내용을 입력하기 위해 textarea tag를 이용 -->
                <h1>내용</h1>
                <textarea placeholder="내용을 입력하세요."></textarea>
                <input type="file" name="" id="">
            </div>
        </div>
        <div class="btn-w"><a href="#">작성</a></div>
    </div>
</body>
</html>