<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
    
<%@ page import="java.util.List" %>
<%@ page import="board.workwear.dto.response.WorkwearResponse" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/views/common/header_v2.jsp"%>
<link rel="stylesheet" type="text/css" 
href="<%= request.getContextPath() %>/resources/css/board/workwear/workwear.css">
</head>
<body>

<%List<WorkwearResponse> list = (List<WorkwearResponse>)request.getAttribute("boardlist"); %>

<div class="worderby-wrap-div">
	<div class="worderby"><a href="#">최신순</a></div>
	<div class="worderby"><a href="#">조회수</a></div>
</div>

<div class="wgallery">
	<div class="wgallery-line-frame">
<%
	//for 반복문으로 div에 태그 추가
	for(WorkwearResponse dto : list){
		//out.println("dto " + dto);
%>

		<div class="wimg-frame">
			<img src="<%= request.getContextPath() %>/resources/image/board/workwear/03.jpg" class="wgallery-img">
			<div class="wcontent-frame">
				<h3 class="wcontent-title"><%=dto.getNickname()%></h3>
				<hr/>
				<p class="wgallery-content"><%=dto.getTitle()%></p>
			</div>
		</div>

<%
}
%>
	</div>
<button class="wwritebutton">
	<a href="<%=request.getContextPath() %>/workwear/write">
	<img src="<%= request.getContextPath() %>/resources/image/board/workwear/Writing.png" class="wwritebutton-icon">
	</a>
</button>
</div>

</body>
</html>