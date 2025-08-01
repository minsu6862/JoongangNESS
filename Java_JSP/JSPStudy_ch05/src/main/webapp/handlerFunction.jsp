<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>핸들러 함수</title>
<script type="text/javascript">
	function checkFun() {
		if(document.gradeForm.book.value == "" || document.gradeForm.grade.value == "") {
			alert("추천 도서는 필수 입력사항입니다.");
		} else{
			alert("추천 도서 : " + document.gradeForm.book.value + ", 평점 : " + document.gradeForm.grade.value);
		}
	}
</script>
</head>
<body>
	<h2>추천 도서</h2>
	<hr>
	<form action="#" name="gradeForm">
		추천도서 : <input type="text" name="book"><br><br>
		평점 : 
		<hr>
		<input type="radio" name="grade" value="★★★★★" checked="checked">★★★★★<br>
		<input type="radio" name="grade" value="★★★★☆">★★★★☆<br>
		<input type="radio" name="grade" value="★★★☆☆">★★★☆☆<br>
		<input type="radio" name="grade" value="★★☆☆☆">★★☆☆☆<br>
		<input type="radio" name="grade" value="★☆☆☆☆">★☆☆☆☆<br>
		<hr>
		<input type="submit" value="추천하기" onclick="checkFun()">&nbsp;
		<input type="reset" value="다시작성">
	</form>
</body>
</html>