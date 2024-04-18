<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>freecycling</title>
  <%@ include file="../../common/header.jsp"%> 
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/board/freecyclingCss/freecyclingMainCss.css">

</head>
<body>
<%-- <c:set var="number" value="${number }"/>
<c:forEach var="bdto" items="${v}">
</c:forEach> --%>


<div class="content">
	<div class="divTop">
		<div class="divTopOrderby">최신순</div>
		<div class="divTopOrderby">조회수</div>
		<div><a href="<%=request.getContextPath() %>/controller/freecyclingWriteCon">글쓰기</a></div>
	</div>

	
	<div class="line1">
	
	
	<c:forEach var="bdto" items="${bdto}">
	<div class="div1_1">${bean.contents}
		<div class= "innerdiv1_1">${bean.userId}
			<div class= "content1_1">${bean.title}
			</div>
		</div>
	</div>
	</c:forEach>

	
	<div class="div1_2">
		<div class= "innerdiv1_2">
		
		</div>
	</div>
	<div class="div1_3">
		<div class= "innerdiv1_3">
		
		</div>
	</div>
	<div class="div1_4">
		<div class= "innerdiv1_4">
		
		</div>
	</div>
	</div>
	
	<div class="line2">
	<div class="div2_1">
		<div class= "innerdiv2_1">
		
		</div>
	</div>
	<div class="div2_2">
		<div class= "innerdiv2_2">
			
		</div>
	</div>
	<div class="div2_3">
		<div class= "innerdiv2_3">
		
		</div>
	</div>
	<div class="div2_4">
		<div class= "innerdiv2_4">
		
		</div>
	</div>
	</div>
	
	<div class="line3">
	<div class="div3_1">
		<div class= "innerdiv3_1">
		
		</div>
	</div>
	<div class="div3_2">
		<div class= "innerdiv3_2">
		
		</div>
	</div>
	<div class="div3_3">
		<div class= "innerdiv3_3">
		
		</div>	
	</div>
	<div class="div3_4">
		<div class= "innerdiv3_4">
		
		</div>	
	</div>
	</div>
	
	
	<div class="divBottom_page"></div>



</div>
</body>
</html>