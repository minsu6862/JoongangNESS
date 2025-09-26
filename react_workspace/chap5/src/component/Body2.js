import {useState} from "react";

function Body2() {
    const [count , setCount] = useState(0); 
    //[state 변수, state 업데이트 함수(setter)] = useState(state변수 초기값)
    const [text , setText] = useState(""); 
    const [date , setDate] = useState(""); 
    const [fruit , setFruit] = useState(""); 
    const [textarea , setTextarea] = useState(""); 
    const [outputText , setOutputText] = useState("글 입력대기"); 

    function onIncrease() {
           setCount(count + 1);
           //setCount->count값을 변화시키는 함수
           //()내에 들어온 값(연산된 값)을 count에 다시 저장하는 함수
    }

    function inputOnChange(e) {
        setText(e.target.value);//input 에 유저가 입력한 값을 콘솔창에 출력
    }

    function dateOnChange(e) {
        console.log(e.target.value);
        setDate(e.target.value);
    }

    function fruitOnChange(e) {
        console.log(e.target.value);
        setFruit(e.target.value);
    }

    //let outputText = "글 입력대기";

    function textareaOnChange(e) {
        console.log(e.target.value);
        setTextarea(e.target.value);
        setOutputText("글 입력 중");
        console.log(outputText);
    }

    return (
        <div>
            <hr></hr>
            <h1>저는 Body2 컴포넌트 입니다.</h1>
            <h1>{count}</h1>
            <button onClick={onIncrease}>카운트 증가</button>
            <br />
            <input onChange={inputOnChange} value={text} />
            <div>input에 입력된 값 : {text}</div>
            <hr></hr>
            <input type="date" value={date} onChange={dateOnChange} />
            <div>변경된 날짜 : {date}</div>
            <hr></hr>
            <select value={fruit} onChange={fruitOnChange}>
                <option key={"apple"}>사과</option>
                <option key={"watermelon"}>수박</option>
                <option key={"grape"}>포도</option>
            </select>
            <br />
            <div>내가 좋아하는 과일 : {fruit}</div>
            <hr></hr>
            <textarea value={textarea} onChange={textareaOnChange} />
            <br></br>
            <div>{textarea}</div>
            <div>{outputText}</div>
            <hr></hr>
        </div>
    );
}

export default Body2;