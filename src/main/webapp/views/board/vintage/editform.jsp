<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="board.vintage.dto.response.VintageBoardResponse" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/views/common/header_v2.jsp"%>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/board/vintage/vintagewriteform.css">
</head>
<body>
<%VintageBoardResponse vbr = (VintageBoardResponse)request.getAttribute("boarddetail"); %>
<div class="vwrite-container">
	<form action="<%=request.getContextPath() %>/controller/edit" method = "post" class="submit" enctype="multipart/form-data">
		<div class="container">
		<input type="hidden" name="boardId" value="<%=vbr.getBoardId() %>"></input>
      		<div class="col-25">
        	<label for="title">제목</label>
      		</div>
      		<div class="col-75">
        	<input type="text" id="title" name="title" placeholder="제목" value="<%=vbr.getTitle() %>"></input>
      		</div>
    	</div>
    	<div class="container">
   			<div class="col-25">
       			<label for="upload">파일 첨부</label>
    		</div>
    		<div class="col-75">
				<input type="file" name="uploadFile" accept="image/*" multiple></input>
			</div>
		</div>
		<div class="container">
      		<div class="col-25">
        		<label for="content">내용</label>
      		</div>
      		<div class="col-75">
        		<textarea id="contents" name="contents" placeholder="내용을 입력하세요"> <%=vbr.getContents() %></textarea>
    		</div>
    	</div>
    <div class="container">
      <input type="submit" value="글쓰기"></input>
    </div>
  </form>
</div>

</body>
</html>