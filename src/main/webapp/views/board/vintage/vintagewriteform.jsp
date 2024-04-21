<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/views/common/header_v2.jsp"%>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/board/vintage/vintagewriteform.css">
</head>
<body>
<div class="vwrite-container">
	<form action="<%=request.getContextPath() %>/vintage/write" method = "post" class="submit">
		<div class="container">
      		<div class="col-25">
        	<label for="title">제목</label>
      		</div>
      		<div class="col-75">
        	<input type="text" id="title" name="title" placeholder="제목">
      		</div>
    	</div>
    	<div class="container">
   			<div class="col-25">
       			<label for="upload">파일 첨부</label>
    		</div>
    		<div class="col-75">
				<input type="file" id="file" name="file">
			</div>
		</div>
		<div class="container">
      		<div class="col-25">
        		<label for="content">내용</label>
      		</div>
      		<div class="col-75">
        		<textarea id="contents" name="contents" placeholder="내용을 입력하세요" style="height:200px"></textarea>
    		</div>
    	</div>
    <div class="container">
      <input type="submit" value="Submit">
    </div>
  </form>
</div>

</body>
</html>