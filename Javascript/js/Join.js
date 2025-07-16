// 회원가입 양식 유효성 체크 memberJoin.html 

function checkJoin() {
    if(document.joinForm.memId.value == "") {
        alert("id를 입력해주세요");
        document.joinForm.memId.focus();
        return false;
    }
    if(document.joinForm.memId.value.length < 5 || document.joinForm.memId.value.length > 16) {
        alert("id가 너무 길거나 짧습니다. 5~16 사이로 만들어주세요");
        document.joinForm.memId.focus();
        return false;
    }

    var idcheck = /^[ㄱ-ㅎ|가-힣]+$/;
    if(idcheck.test(document.joinForm.memId.value)) {
        alert("아이디는 영어로만 입력해주세요");
        document.joinForm.memId.focus();
        return false;
    }

    if(document.joinForm.memPw.value == "") {
        alert("password를 입력해주세요");
        document.joinForm.memPw.focus();
        return false;
    }

    if(document.joinForm.memName.value == "") {
        alert("이름을 입력해주세요");
        document.joinForm.memName.focus();
        return false;
    }

    if(document.joinForm.memEmail.value == "") {
        alert("Email을 입력해주세요");
        document.joinForm.memEmail.focus();
        return false;
    }
    
    return true;
}