/**
 * 
 */


function joinCheck() {
	
	var f = document.joinForm;
	
	var regex1 = /^[가-힣]+$/
	var regex2 = /^[a-z|A-Z]+$/
	
	if(document.joinForm.memId.value.length == 0) {
		alert("아이디는 필수 입력사항입니다.");
		document.joinForm.memId.focus();
		return;
	}
	if(document.joinForm.memId.value.length < 4 || document.joinForm.memPw.value.length > 12 ) {
		alert("아이디는 4~12 사이로 입력하셔야 합니다.");
		document.joinForm.memId.focus();
		return;
	}
	
	if(document.joinForm.memPw.value.length == 0) {
		alert("비밀번호는 필수 입력사항입니다.");
		document.joinForm.memPw.focus();
		return;
	}
	if(document.joinForm.memPw.value.length < 4 || document.joinForm.memPw.value.length > 12 ) {
		alert("비밀번호는 4~12 사이로 입력하셔야 합니다.");
		document.joinForm.memPw.focus();
		return;
	}
	
	if(document.joinForm.memPw.value == document.joinForm.memPwCheck.value) {
		alert("비밀번호와 비밀번호 확인이 다릅니다.");
		document.joinForm.memPw.focus();
		return;
	}
	if(document.joinForm.memName.value.length == 0) {
		alert("이름은 필수 입력사항입니다.");
		document.joinForm.memName.focus();
		return;
	}
	if(document.joinForm.memEmail.value.length == 0) {
		alert("이메일은 필수 입력사항입니다.");
		document.joinForm.memEmail.focus();
		return;
	}
	if(document.joinForm.memAddr.value.length == 0) {
		alert("주소는 필수 입력사항입니다.");
		document.joinForm.memAddr.focus();
		return;
	}
	
	document.joinForm.submit();
}