<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<%@ include file="../../common/common.jsp"%>
		<%@ include file="../../common/header_v2.jsp"%>

<link href="../../../resources/css/board/street/street_write.css" rel="stylesheet" type="text/css"> 

<title></title>
</head>
<body>

<div class ="box">
<div class="container">
  <form action="action_page.php">

    <label for="fname">제목</label>
    <input type="text" id="fname" name="firstname" placeholder="제목을 입력해주세요.">

    <label for="subject">내용</label>
    <textarea id="subject" name="subject" placeholder="내용을 입력해주세요." style="height:200px"></textarea>


	<input type="file" name="file" id="file"><br/><br/><br/>
    <input type="submit" value="완료">
  </form>
</div>

</div>




</body>
</html>