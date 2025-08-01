<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkFun() {
		if(document.gradeForm.kor.value == "" || document.gradeForm.eng.value == "" || document.gradeForm.mat.value == "") {
			alert("점수는 필수 입력사항입니다.");
			return false;
		}
	}
</script>
</head>
<body>
	<form action="scoreOk.jsp" name="gradeForm" onsubmit="return checkFun()">
		국어 : <input type="text" name="kor"><br><br>
		영어 : <input type="text" name="eng"><br><br>
		수학 : <input type="text" name="mat"><br><br>
		<input type="submit" value="제출">
		<input type="reset" value="리셋">
	</form>
</body>
</html>