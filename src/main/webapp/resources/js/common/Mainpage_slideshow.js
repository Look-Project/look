let slideIndex = 1;


function showSlides(n) {
  let i;
  let slides = document.getElementsByClassName("mySlides");
  let dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
}

// Next/previous controls
function plusSlides(n) {
  showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
  showSlides(slideIndex = n);
}
// -----------------------------------------------------
function changeImage(id, newSrc) {
  // 해당 ID를 가진 이미지의 src 속성을 변경하여 다른 이미지로 바꿉니다.
  document.getElementById(id).style.opacity = 0; // 이미지를 투명하게 만듭니다.
  setTimeout(function() {
      document.getElementById(id).src = newSrc; // 새 이미지로 변경합니다.
      document.getElementById(id).style.opacity = 1; // 이미지를 다시 보이게 합니다.
  }, 300); // 0.3초 후에 이미지를 변경합니다. (transition duration과 동일)
}

function resetImage(id, originalSrc) {
  // 마우스가 이미지를 벗어나면 다시 원래 이미지로 돌아갑니다.
  document.getElementById(id).style.opacity = 0; // 이미지를 투명하게 만듭니다.
  setTimeout(function() {
      document.getElementById(id).src = originalSrc; // 원래 이미지로 변경합니다.
      document.getElementById(id).style.opacity = 1; // 이미지를 다시 보이게 합니다.
  }, 300); // 0.3초 후에 이미지를 변경합니다. (transition duration과 동일)
}