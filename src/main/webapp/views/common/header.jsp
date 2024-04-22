<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="./common.jsp"%>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/common/header.css">
</head>
<body>
	 <header>
	 	<div id="header-top">
 		 	<div id="header-top-logo">
	 			<img src="<%= request.getContextPath() %>/resources/image/common/Logo.png" class="logoimg">
	 		</div>
	 		<div id="header-top-menulist">
 		        <div><a href="" class="tMenu">고객센터</a>&nbsp;|</div>
		        <div><a href="" class="tMenu">마이페이지</a>&nbsp;|</div>
		        <div><a href="" class="tMenu">로그인</a></div>
	 		</div>
	 	</div>
	 	<div id="header-bottom">
	 		<div id="header-bottom-menulist" class="container">
		 	    <div><a href="" class="bMenu">Formal</a></div>
			    <div><a href="" class="bMenu">Street</a></div>
			    <div><a href="" class="bMenu">Workwear</a></div>
			    <div><a href="<%= request.getContextPath() %>/vintage/boardlist" class="bMenu">Vintage</a></div>
			    <div><a href="" class="bMenu">Freecycling</a></div>
		    </div>
	 	</div>	 
		<hr/>
	</header>
</body>
</html>