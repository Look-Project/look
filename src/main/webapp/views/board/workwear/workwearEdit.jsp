<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- LOOK 헤더 -->
	<%@ include file="/views/common/header_v2.jsp"%>	
	 <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/board/workwear/workwearBoard.css">
</head>
<body>

<!-- FreecyclingOneContentCon 컨트롤러에 의해 모델을 받아옴
   List<FreecyclingBoardContentsViewDTO> resListOneCondto = bservice.freecyclingOneContentViewService();
   //3.model
	request.setAttribute("resListOneCondto", resListOneCondto);
			
 -->
 <form action="<%=request.getContextPath() %>/controller/WorkwearEditController" method="post" enctype="multipart/form-data" >

 <div class="container">
            <c:set var="onecondto" value="${onecondto}" />
        <div class="image-section">
            
        </div>
        <div class="content-section">
           
            <p>
            </p>
         <table width="600" bordercolor="gray" >
	<tr height="40">
		<td align="center" width="120">글번호</td>
		<td align="center" width="180">${onecondto.boardId }</td>
		<td align="center" width="120">조회수</td>
		<td align="center" width="180">${onecondto.views }
		</td>	
	</tr>
	<tr height="40">
		<td align="center" width="120">작성자</td>
		<td align="center" width="180">${onecondto.nickname }</td>
		<td align="center" width="120">작성일</td>
		<td align="center" width="180">${onecondto.createAt }
		</td>	
	</tr>
	<tr height="40">
		<td align="center" width="120">제목</td>
		<td align="center" colspan="3" width="400"><input type="text" id="title" name="title" value="${onecondto.title}" style="height: 30px; width: 400px;">
		</td>	
	</tr>
	<tr height="80">
		<td align="center" width="120">글내용</td>
		<td align="center" colspan="3" width="400"><textarea id="contents" name="contents" style="height: 300px; width: 400px;">${onecondto.contents}</textarea>
		</td>	
	</tr>
	<tr height="80">
		<td align="center" colspan="4">
		 <input type="hidden" name="boardId" id="boardId" value="${onecondto.boardId }">
		 <input type="submit" value="수정하기">
		 <input type="button" value="목록보기" onclick="location.href='<%=request.getContextPath() %>/workwear/boardlist'">
	</tr>
	
</table>
        </div>
    </div>
    </form>
</body>
</html>