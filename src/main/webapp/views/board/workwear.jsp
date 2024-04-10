<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="/views/common/header.jsp"%>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/borad/workwear/workwear.css">
	
<title></title>
</head>
<body>
   <div id="wrap">
        <ul id="gallery">
            <a>
                <li>
                    <img src="<%= request.getContextPath() %>/resources/image/board/workwear/01.jpg" alt="1">
                    <div class="text-overlay">글쓴이: 아무개</div>
                    <div class="additional-text">추가 텍스트 내용</div>
                </li></a>
            <a>
                <li>
                    <img src="<%= request.getContextPath() %>/resources/image/board/workwear/02.jpg" alt="2">
                    <div class="text-overlay">글쓴이: 아무개</div>
                    <div class="additional-text">추가 텍스트 내용</div> 
                </li></a>
        </ul>
    </div>
</body>
</html>