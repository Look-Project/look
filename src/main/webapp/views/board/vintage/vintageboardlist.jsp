<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
    
<%@ page import="java.util.List" %>
<%@ page import="board.vintage.dto.response.VintageBoardListResponse" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/views/common/header_v2.jsp"%>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/board/vintage/vintageboardlist.css">
</head>
<body>

<%List<VintageBoardListResponse> list = (List<VintageBoardListResponse>)request.getAttribute("boardlist"); %>

<div class="vorderby-wrap-div">
	<div class="vorderby"><a href="#">최신순</a></div>
	<div class="vorderby"><a href="#">조회수</a></div>
</div>

<div class="vgallery">
	<div class="vgallery-line-frame">
<%
	//for 반복문으로 div에 태그 추가
	for(VintageBoardListResponse dto : list){
		//out.println("dto " + dto);
%>

		<div class="vimg-frame">
			<img src="<%=dto.getImgSrc() %>/<%=dto.getImgName() %>" class="vgallery-img">
			<div class="vcontent-frame">
				<h3 class="vcontent-title"><%=dto.getNickname()%></h3>
				<hr/>
				<p class="vgallery-content"><%=dto.getTitle()%></p>
			</div>
		</div>
<%
}
%>
	</div>
<button class="vwritebutton">
	<a href="<%= request.getContextPath() %>/vintage/write">
	<img src="<%= request.getContextPath() %>/resources/image/board/vintage/write_icon.jpg" class="vwritebutton-icon">
	</a>
</button>
</div>

</body>
</html>