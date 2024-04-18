<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <%@ include file="../../common/header.jsp"%> 
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/board/freecyclingCss/freecyclingWriteFormCSS.css">

</head>
<body>
<form action="<%=request.getContextPath() %>/controller/freecyclingWriteCon" method="post">
	<div class="container">
    <label for="userId">글쓴이</label>
    <input type="text" id="uesrId" name="uesrId" >

	<label for="title">글제목</label>
    <input type="text" id="title" name="title" >

    <label for="contents">contents</label>
    <textarea id="contents" name="contents" style="height:100px"></textarea>

    <input type="file" id="myFile" name="filename">
  
	<button onclick="location.href='<%=request.getContextPath()%>/controller/freecyclingListCon'">전체 게시글보기</button>
    <input type="submit" value="Submit" align = "right">

	</div>
</form>
</body>
</html>