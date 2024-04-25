<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="../../common/common.jsp"%>
	<%@ include file="../../common/header_v2.jsp"%>
	<!-- 상대경로  -->
	<link href="../../../resources/css/board/street/street.css" rel="stylesheet" type="text/css"> 
	
	<!-- 절대경로  -->
	<!-- <link href="/resources/css/board_street/street.css" rel="stylesheet" type="text/css"> -->
	
	
<title>street 게시판</title>
  <script type="text/javascript">
   
  	const movedetail = () => {
  		
  		/* alert(1); */
  		
  		window.location.href = "<%= request.getContextPath() %>/views/board/street/street_info.jsp";
  	}
  
  	const mvCreate = () => {
	
  		//alert("글쓰기페이지로 이동합니다.")
  		//글쓰기 버튼 페이지 이동
  		window.location.href = "<%= request.getContextPath() %>/views/board/street/street_write.jsp";
  	}
  </script>
</head>
<body>	
				<!--  
					.img {
					}
					.imgbox > .subImageArea > .img {
					} 
				
				  -->
		<div class="imgbox">
			<div class="subImageArea">
				<img class = "img"  onclick="movedetail();"  src = "<%= request.getContextPath() %>/resources/image/board/street/street.jpg" alt= "이미지경로">
		         <div class="profileArea">
	              <img class="profile_img" src="https://i.pinimg.com/736x/93/a6/8b/93a68b57a54e4bdc73d43d1d049b94b3.jpg"/>
				  <p style="width: 100px">프로필 </p>
				  <div style="width: 100%; display: flex; justify-content: flex-end;">
				  	<img style="width: 22px; height: 22px; " src="<%= request.getContextPath() %>/resources/image/board/street/like_2.jpg"/>
				  </div>
	            </div>				
				  <p >#blahblahblahblahblahblah</p>
			  </div>
			<div class="subImageArea">
				<img class = "img" src = "<%= request.getContextPath() %>/resources/image/board/street/street_2.jpg" alt= "이미지경로">
		         <div class="profileArea">
	              <img class="profile_img" src="https://i.pinimg.com/736x/93/a6/8b/93a68b57a54e4bdc73d43d1d049b94b3.jpg"/>
				  <p style="width: 100px">프로필 </p>
				  <div style="width: 100%; display: flex; justify-content: flex-end;">
				 	<img style="width: 25px; height: 25px; " src="<%= request.getContextPath() %>/resources/image/board/street/like.jpg"/>
				  </div>
	            </div>				
				  <p >#blahblahblahblahblahblah</p>
			  </div>
			<div class="subImageArea">
				<img class = "img" src = "<%= request.getContextPath() %>/resources/image/board/street/street_3.jpg" alt= "이미지경로">
		         <div class="profileArea">
	              <img class="profile_img" src="https://i.pinimg.com/736x/93/a6/8b/93a68b57a54e4bdc73d43d1d049b94b3.jpg"/>
				  <p style="width: 100px">프로필 </p>
				  <div style="width: 100%; display: flex; justify-content: flex-end;">
					<img style="width: 25px; height: 25px; " src="<%= request.getContextPath() %>/resources/image/board/street/like.jpg"/>
				  </div>
	            </div>				
				  <p >#blahblahblahblahblahblah</p>
			  </div>
			<div class="subImageArea">
				<img class = "img" src = "<%= request.getContextPath() %>/resources/image/board/street/street_4.jpg" alt= "이미지경로">
		         <div class="profileArea">
	              <img class="profile_img" src="https://i.pinimg.com/736x/93/a6/8b/93a68b57a54e4bdc73d43d1d049b94b3.jpg"/>
				  <p style="width: 100px">프로필 </p>
				  <div style="width: 100%; display: flex; justify-content: flex-end;">
				 	<img style="width: 25px; height: 25px; " src="<%= request.getContextPath() %>/resources/image/board/street/like.jpg"/>
				  </div>
	            </div>				
				  <p >#blahblahblahblahblahblah</p>
			  </div>
			<div class="subImageArea">
				<img class = "img" src = "<%= request.getContextPath() %>/resources/image/board/street/street_5.jpg" alt= "이미지경로">
		         <div class="profileArea">
	              <img class="profile_img" src="https://i.pinimg.com/736x/93/a6/8b/93a68b57a54e4bdc73d43d1d049b94b3.jpg"/>
				  <p style="width: 100px">프로필 </p>
				  <div style="width: 100%; display: flex; justify-content: flex-end;">
				 	<img style="width: 25px; height: 25px; " src="<%= request.getContextPath() %>/resources/image/board/street/like.jpg"/>
				  </div>
	            </div>				
				  <p >#blahblahblahblahblahblah</p>
			  </div>
			<div class="subImageArea">
				<img class = "img" src = "<%= request.getContextPath() %>/resources/image/board/street/street_6.jpg" alt= "이미지경로">
		         <div class="profileArea">
	              <img class="profile_img" src="https://i.pinimg.com/736x/93/a6/8b/93a68b57a54e4bdc73d43d1d049b94b3.jpg"/>
				  <p style="width: 100px">프로필 </p>
				  <div style="width: 100%; display: flex; justify-content: flex-end;">
					<img style="width: 25px; height: 25px; " src="<%= request.getContextPath() %>/resources/image/board/street/like.jpg"/>
				  </div>
	            </div>				
				  <p >#blahblahblahblahblahblah</p>
			  </div>
		 </div>
			
		<div class="imgbox">
		<div class="subImageArea">
				<img class = "img" src = "<%= request.getContextPath() %>/resources/image/board/street/street_7.jpg" alt= "이미지경로">
		         <div class="profileArea">
	              <img class="profile_img" src="https://i.pinimg.com/736x/93/a6/8b/93a68b57a54e4bdc73d43d1d049b94b3.jpg"/>
				  <p style="width: 100px">프로필 </p>
				  <div style="width: 100%; display: flex; justify-content: flex-end;">
				  	<img style="width: 25px; height: 25px; " src="<%= request.getContextPath() %>/resources/image/board/street/like.jpg"/>
				  </div>
	            </div>				
				  <p >#blahblahblahblahblahblah</p>
			  </div>
		<div class="subImageArea">
				<img class = "img" src = "<%= request.getContextPath() %>/resources/image/board/street/street_8.jpg" alt= "이미지경로">
		         <div class="profileArea">
	              <img class="profile_img" src="https://i.pinimg.com/736x/93/a6/8b/93a68b57a54e4bdc73d43d1d049b94b3.jpg"/>
				  <p style="width: 100px">프로필 </p>
				  <div style="width: 100%; display: flex; justify-content: flex-end;">
					<img style="width: 25px; height: 25px; " src="<%= request.getContextPath() %>/resources/image/board/street/like.jpg"/>
				  </div>
	            </div>				
				  <p >#blahblahblahblahblahblah</p>
			  </div>
		<div class="subImageArea">
				<img class = "img" src = "<%= request.getContextPath() %>/resources/image/board/street/street_9.jpg" alt= "이미지경로">
		         <div class="profileArea">
	              <img class="profile_img" src="https://i.pinimg.com/736x/93/a6/8b/93a68b57a54e4bdc73d43d1d049b94b3.jpg"/>
				  <p style="width: 100px">프로필 </p>
				  <div style="width: 100%; display: flex; justify-content: flex-end;">
				  	<img style="width: 25px; height: 25px; " src="<%= request.getContextPath() %>/resources/image/board/street/like.jpg"/>
				  </div>
	            </div>				
				  <p >#blahblahblahblahblahblah</p>
			  </div>
		<div class="subImageArea">
				<img class = "img" src = "<%= request.getContextPath() %>/resources/image/board/street/street_10.jpg" alt= "이미지경로">
		         <div class="profileArea">
	              <img class="profile_img" src="https://i.pinimg.com/736x/93/a6/8b/93a68b57a54e4bdc73d43d1d049b94b3.jpg"/>
				  <p style="width: 100px">프로필 </p>
				  <div style="width: 100%; display: flex; justify-content: flex-end;">
				 	<img style="width: 25px; height: 25px; " src="<%= request.getContextPath() %>/resources/image/board/street/like.jpg"/>
				  </div>
	            </div>				
				  <p >#blahblahblahblahblahblah</p>
			  </div>
		<div class="subImageArea">
				<img class = "img" src = "<%= request.getContextPath() %>/resources/image/board/street/street_11.jpg" alt= "이미지경로">
		         <div class="profileArea">
	              <img class="profile_img" src="https://i.pinimg.com/736x/93/a6/8b/93a68b57a54e4bdc73d43d1d049b94b3.jpg"/>
				  <p style="width: 100px">프로필 </p>
				  <div style="width: 100%; display: flex; justify-content: flex-end;">
				 	<img style="width: 25px; height: 25px; " src="<%= request.getContextPath() %>/resources/image/board/street/like.jpg"/>
				  </div>
	            </div>				
				  <p >#blahblahblahblahblahblah</p>
			  </div>
		<div class="subImageArea">
				<img class = "img" src = "<%= request.getContextPath() %>/resources/image/board/street/street_12.jpg" alt= "이미지경로">
		         <div class="profileArea">
	              <img class="profile_img" src="https://i.pinimg.com/736x/93/a6/8b/93a68b57a54e4bdc73d43d1d049b94b3.jpg"/>
				  <p style="width: 100px">프로필 </p>
				  <div style="width: 100%; display: flex; justify-content: flex-end;">
				  	<img style="width: 25px; height: 25px; " src="<%= request.getContextPath() %>/resources/image/board/street/like.jpg"/>
				  </div>
	            </div>				
				  <p >#blahblahblahblahblahblah</p>
			  </div>
		</div>
		
		
<%--       <div class="imgbox">
         <c:forEach var="item" items="${boardlist}">
            <div class="subImageArea">
               <img onclick="mvStreetDetail("+${item.boardId}+");" class = "img" src = "<%= request.getContextPath() %>${item.imgSrc}" alt= "이미지경로">
                  <div class="profileArea">
                      <img class="profile_img" src="https://i.pinimg.com/736x/93/a6/8b/93a68b57a54e4bdc73d43d1d049b94b3.jpg"/>
                 <p style="width: 100px">프로필 </p>
                 <div style="width: 100%; display: flex; justify-content: flex-end;">
                    <img style="width: 20px; height: 20px; " src="https://media.istockphoto.com/id/1439973042/ko/%EB%B2%A1%ED%84%B0/%EB%A0%88%EB%93%9C-%ED%95%98%ED%8A%B8-%ED%94%8C%EB%9E%AB-%EC%95%84%EC%9D%B4%EC%BD%98-%EC%82%AC%EB%9E%91%EC%9D%98-%EC%83%81%EC%A7%95-%EB%B2%A1%ED%84%B0-%EC%9D%BC%EB%9F%AC%EC%8A%A4%ED%8A%B8-%EB%A0%88%EC%9D%B4-%EC%85%98.jpg?s=612x612&w=0&k=20&c=-w5fVBQmIea4ztvJ8MeJmET87GAKsK291Yurm2kFVAE="/>
                 </div>
                    </div>            
                 <p >${item.title }</p>
              </div>
         </c:forEach>
      </div>
 --%>

		<div>
		<img class = "write" onclick="mvCreate();" src = "<%= request.getContextPath() %>/resources/image/board/vintage/write_icon.jpg" alt= "이미지경로"">
		</div>
   			
</body>
</html>










