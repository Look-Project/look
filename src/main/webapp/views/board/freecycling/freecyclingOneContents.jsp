<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- LOOK 헤더 -->
	<%@ include file="/views/common/header_v2.jsp"%>	
	 <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/board/freecyclingCss/freecyclingOneContents.css">
</head>
<body>

<!-- FreecyclingOneContentCon 컨트롤러에 의해 모델을 받아옴
   List<FreecyclingBoardContentsViewDTO> resListOneCondto = bservice.freecyclingOneContentViewService();
   //3.model
	request.setAttribute("resListOneCondto", resListOneCondto);
 -->
 
 <div class="container">
            <c:set var="viewdto" value="${viewdto}" />
        <div class="image-section">
        	<img src="${viewdto.imgSrc}/${viewdto.imgName}" class="viewIMG">
        </div>
        <div class="content-section">
           
            <p>
            </p>
        <form method="post">
         <table width="600" bordercolor="skyblue" >
	<tr height="40">
		<td align="center" width="120">글번호</td>
		<td align="center" width="180">${viewdto.boardId }</td>
		<td align="center" width="120">조회수</td>
		<td align="center" width="180">${viewdto.views }
		</td>	
	</tr>
	<tr height="40">
		<td align="center" width="120">작성자</td>
		<td align="center" width="180">${viewdto.nickname }</td>
		<td align="center" width="120">작성일</td>
		<td align="center" width="180">${viewdto.createAt }
		</td>	
	</tr>
	<tr height="40">
		<td align="center" width="120">제목</td>
		<td align="center" colspan="3">${viewdto.title }
		</td>	
	</tr>
	<tr height="80">
		<td align="center" width="120">글내용</td>
		<td align="center" colspan="3">${viewdto.contents }
		</td>	
	</tr>
	<tr height="80">
		<td align="center" colspan="4">
		
		 <input type="button" value="수정하기" onclick="location.href='<%=request.getContextPath() %>/controller/FreeEditCon?num=${viewdto.boardId }'">
		 <input type="button" value="삭제하기" onclick="location.href='<%=request.getContextPath() %>/controller/FreeDeleteCon?num=${viewdto.boardId }'">
		 <input type="button" value="목록보기" onclick="location.href='<%=request.getContextPath() %>/controller/freecyclingListCon'">
	</tr>
	
</table>
</form>
        </div>
    </div>
</body>
</html>