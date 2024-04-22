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
 <c:if test="${msg }">
<script>
	<script type="text/javascript">
	alert("수정시 비밀번호가 틀렸습니다.");
</script>
</c:if> 

<div class="content">
	<div class="divTop">
		<div class="divTopOrderby">최신순</div>
		<div class="divTopOrderby">조회수</div>
		<div class="divContents"><a href="<%=request.getContextPath() %>/controller/freecyclingWriteCon"> 
			 <img src="../resources/image/board/freecycling/freecyclingcontents.jpg" />
		</a></div>
	</div>

	
	<div class="line1">
	
	
	<c:forEach var="bdto" items="${listdto}">
	<a href="<%=request.getContextPath() %>/controller/FreecyclingOneContentCon?num=${bdto.boardId }">
	<div class="div1_1">
		
	
		<img src="../resources/image/board/freecycling/freecycling.png"/>
		<div class= "innerdiv1_1">${bdto.nickname}
		<hr/>
			<div class= "content1_1">${bdto.title}
			</div>
		</div>
	</div>
	</a>
	</c:forEach>

	
	
	<div class="divBottom_page"></div>



</div>
</body>
</html>