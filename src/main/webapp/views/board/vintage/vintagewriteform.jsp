<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/views/common/header_v2.jsp"%>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/board_template/temp_write.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/board/vintage/vintagewriteform.css">
</head>
<body>
<!-- -------------------------------------------------------------------------------------------------------------- -->
<!-- 메인 컨텐츠 영역 -->
<div class="vwrite-container">
	<!-- 폼 태그 시작부분 -->
	<form action="<%=request.getContextPath() %>/vintage/write" method = "post" class="submit" enctype="multipart/form-data">
		<!-- 게시글 제목 작성영역 -->
		<div class="container">
      		<div class="col-25">
      		<!-- area title -->
        	<label for="title">제목</label>
      		</div>
      		<div class="col-75">
        	<input type="text" id="title" name="title" placeholder="제목"></input>
      		</div>
    	</div>
    	<!-- 내용 작성 영역 -->
		<div class="container">
			<!-- area title -->
      		<div class="col-25">
        		<label for="content">내용</label>
      		</div>
      		<!-- text write area -->
      		<div class="col-75">
        		<textarea id="contents" name="contents" placeholder="내용을 입력하세요" style="height:200px"></textarea>
    		</div>
    	</div>
    	<!-- 이미지 업로드 영역 -->
    	<div class="container">
    		<!-- area title -->
   			<div class="col-25">
       			<label for="upload">파일 첨부</label>
    		</div>
    		<!-- img upload area -->
    		<div class="col-75">
				<input type="file" name="uploadFile" accept="image/*" multiple></input>
			</div>
		</div>
	<!-- 글쓰기 버튼 -->
    <div class="container">
      <input type="submit" value="글쓰기"></input>
    </div>
  </form>
</div>

</body>
</html>