<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/views/common/header_v2.jsp"%>
</head>
<body>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/board/formal/formal_write.css">

    <!-- 메인 내용 영역 -->
    <div class="contents_body">
    <div class="contents">
        <!-- 글 제목 위 카테고리명 -->
        <div class="category">카테고리 Formal</div>
        <!-- 글 제목영역 -->
        <div class="post_title">글 제목입니다</div>
        <%-- 글 내용 영역 --%>
        <div class="post_contents">글 내용입니다.</div>
        <!-- 이미지 등록 영역 -->
        <div class="img">
            <div class="img_upload"> 이미지 업로드 아이콘</div>
            <div class="img_list"> 업로드 리스트</div>
        </div>
        <!-- 글 작성 / 글 수정 버튼 -->
        <div class="btn_write"> 글 버튼</div>
    </div>
    </div>
</body>
</html>