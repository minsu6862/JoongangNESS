import {useState, useRef} from 'react';

function Body4() {

    const [text, setText] = useState("");
    const textRef = useRef();   //useRef 함수가 ref 객체를 생성 -> textRef에 저장

    function alertOnEvent() {
        if(text.length < 5) {
            alert(text + "는 5글자 이하입니다. 다시 입력해주십시오");
            textRef.current.focus();
        } else {
            alert(text);
            setText("");
        }
    }

    function inputOnChange(e) {
        setText(e.target.value);
    }

    return(
        <>
            <input ref={textRef} value={text} onChange={inputOnChange} />
            <button onClick={alertOnEvent}>작성완료</button>
        </>
    );
}

export default Body4;