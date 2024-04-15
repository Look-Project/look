<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
	<%@ include file="./common.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <link rel="stylesheet" href="../../resources/css/common/Mainpage.css">
    <script src="../../resources/js/common/Mainpage_slideshow.js"></script>
        
    <style>
 
    </style>
    <body>


      <!-- 상단메뉴 영역 -->
      <div class="top_body">
        <div class="top_base">
          <!-- 마이메뉴 영역 -->
          <div class="personal_menu">
            <div class="tMenu">고객센터</div>
            <div class="tMenu">로그인</div>
            <div class="tMenu">마이페이지</div>
          </div>
          <!-- 로고 + 영역 -->
          <div class="logo_board">
            <img class="logo" src="../../resources/image/common/Logo.png" />
            <div><a href="" class="bMenu">Formal</a></div>
            <div><a href="" class="bMenu">Street</a></div>
            <div><a href="" class="bMenu">Workwear</a></div>
            <div><a href="" class="bMenu">Vintage</a></div>
            <div><a href="" class="bMenu">Freecycling</a></div>
            </div>
          </div>	 
          <!-- 게시판 이미지로 작성할 때 사용될것 -->
          <!-- <div class="logo_board">
            <img class="logo" src="../../resources/image/common/Logo.png" />
            <img class="boardselect"   src="../../resources/image/common/Formal_T.jpg" alt="Formal">
            <img class="boardselect"   src="../../resources/image/common/Street_T.jpg" alt="Street">
            <img class="boardselect"  src="../../resources/image/common/Workwear_T.jpg" alt="Workwear">
            <img class="boardselect"  src="../../resources/image/common/Vintage_T.jpg" alt="Activewear">
            <img class="boardselect"  src="../../resources/image/common/Free_T.jpg" alt="Freecycling">
          </div>  -->
        </div>
      </div>


      <!-- 메인 컨텐츠 영역 -->
      <div class="main_body">
        <div class="main_contents">
        <!-- 메인 슬라이드쇼 영역 -->
          <div class="mainbanner">
            <div class="slideshow-container">
              
              <div class="mySlides fade">
                <div class="numbertext">1 / 4</div>
                <img src="../../resources/image/common/main0_slideshow.jpg" style="display:block; width:100%">
              </div>
              
              <div class="mySlides fade">
                <div class="numbertext">2 / 5</div>
                <img src="../../resources/image/common/main1_slideshow.jpg" style="width:100%">
              </div>
              
              <div class="mySlides fade">
                <div class="numbertext">3 / 5</div>
                <img src="../../resources/image/common/main2_slideshow.jpg" style="width:100%">
              </div>
              
              <div class="mySlides fade">
                <div class="numbertext">4 / 5</div>
                <img src="../../resources/image/common/main3_slideshow.jpg" style="width:100%">
              </div>
              
                <div class="mySlides fade">
                <div class="numbertext">5 / 5</div>
                <img src="../../resources/image/common/main4_slideshow.jpg" style="width:100%">
              </div>

              <a class="prev" onclick="plusSlides(-1)">❮</a>
              <a class="next" onclick="plusSlides(1)">❯</a>
              </div>
              <div style="width:1440px;text-align:center">
                <span class="dot" onclick="currentSlide(1)"></span> 
                <span class="dot" onclick="currentSlide(2)"></span> 
                <span class="dot" onclick="currentSlide(3)"></span> 
                <span class="dot" onclick="currentSlide(4)"></span> 
                <span class="dot" onclick="currentSlide(5)"></span> 
              </div>
              
              <script>
                showSlides(slideIndex);
              </script>
            <!-- <img class="bannerimg" src="../../resources/image/common/Main.jpg" alt=""> -->
          </div>
          <!--메인 게시판 아이콘 영역 -->
          <div class="main_board">
            <!-- 개별 -->
            <img class="boardimg" id="img1" src="../../resources/image/common/Formal.jpg" alt="Formal" onmouseover="changeImage('img1', '../../resources/image/common/Formal_T.jpg')" onmouseout="resetImage('img1', '../../resources/image/common/Formal.jpg')">
            <img class="boardimg" id="img2" src="../../resources/image/common/Street.jpg" alt="Street" onmouseover="changeImage('img2', '../../resources/image/common/Street_T.jpg')" onmouseout="resetImage('img2', '../../resources/image/common/Street.jpg')">
            <img class="boardimg" id="img3" src="../../resources/image/common/Workwear.jpg" alt="Workwear" onmouseover="changeImage('img3', '../../resources/image/common/Workwear_T.jpg')" onmouseout="resetImage('img3', '../../resources/image/common/Workwear.jpg')">
            <img class="boardimg" id="img4" src="../../resources/image/common/Vintage.jpg" alt="Activewear" onmouseover="changeImage('img4', '../../resources/image/common/Vintage_T.jpg')" onmouseout="resetImage('img4', '../../resources/image/common/Vintage.jpg')">
            <img class="boardimg" id="img5" src="../../resources/image/common/Free.jpg" alt="Freecycling" onmouseover="changeImage('img5', '../../resources/image/common/Free_T.jpg')" onmouseout="resetImage('img5', '../../resources/image/common/Free.jpg')">
        
          </div>
        </div>
      </div>

    </body>
</html>