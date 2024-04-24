<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="/views/common/header_v2.jsp"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/board/workwear/workwearWrite.css">
    <title></title>
</head>
<body>
<div class="wwrite-container">
	<form action="<%=request.getContextPath() %>/workwear/write" method = "post" class="submit" enctype="multipart/form-data">
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
				<input type="file" name="uploadFile" multiple>
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
