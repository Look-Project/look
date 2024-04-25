<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>freecycling</title>
  <%@ include file="/views/common/header_v2.jsp"%>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/board/freecyclingCss/freecyclingMainCss.css">


</head>
<body>
 
<div class="content">
	<div class="divTop">
		<div class="divTopOrderby">최신순</div>
		<div class="divTopOrderby">조회수</div>
		<div class="divContents"><a href="<%=request.getContextPath() %>/controller/FreeInsertCon"> 
			 <img src="../resources/image/board/freecycling/freecyclingcontents.jpg" />
		</a></div>
	</div>

	
	<div class="line1">
	
	
	<c:forEach var="listdto" items="${listdto}">
	<a href="<%=request.getContextPath() %>/controller/FreecyclingOneContentCon?num=${listdto.boardId }">
	<div class="div1_1">
		<img src="${listdto.imgSrc}/${listdto.imgName}" class="listIMG">
	
		
		<div class= "innerdiv1_1">${listdto.nickname}
		<hr/>
			<div class= "content1_1">${listdto.title}
			</div>
		</div>
	</div>
	</a>
	</c:forEach>

	
	
	<div class="divBottom_page"></div>



</div>
</body>
</html>