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
<%-- <c:set var="number" value="${number }"/>
<c:forEach var="bdto" items="${v}">
</c:forEach> --%>

<!-- freecyclingListCon 컨트롤러에 의해 모델을 받아옴
     List<FreecyclingBoardListViewDTO> listdto = bservice.freecyclingListViewService();
	 request.setAttribute("listdto", listdto);
 -->



<div class="content">
	<div class="divTop">
		<div class="divTopOrderby">최신순</div>
		<div class="divTopOrderby">조회수</div>
		<div><a href="<%=request.getContextPath() %>/controller/freecyclingWriteCon">글쓰기</a></div>
	</div>

	
	<div class="line1">
	
	
	<c:forEach var="bdto" items="${listdto}">
	<div class="div1_1">
		<img src="../resources/image/board/freecycling/freecycling.png"/>
		<div class= "innerdiv1_1">${bdto.nickname}
			<div class= "content1_1">${bdto.title}
			</div>
		</div>
	</div>
	</c:forEach>

	
	
	<div class="divBottom_page"></div>



</div>
</body>
</html>