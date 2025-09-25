import {useState} from 'react';
import "./body.css";

//App.js에서 보낸 name이 매개변수 props로 들어옴
function Body ({name, age, favorList = [], children}) { //헤더 컴포넌트
    function handleOnClick() {
        alert("button Click!");
    }

    function handleOnClick2(e) {
        alert(e.target.name + "으로 눌러짐!");
    }

    const [count, setCount] = useState(0);

    function onIncrease() {
        setCount(count + 1);
        console.log(count);
    }
    
    //useState를 써야만 하는 이유
    let countTest = 0;  //일반 변수로 선언해서 사용할경우 실시간 변동이 되지 않음
    function onIncrease2() {
        countTest++;
        console.log("contTest값 : " + countTest);
    }

    const number = 1;
    const number1 = 10;
    const number2 = 20;
    const str1 = "hello";
    const str2 = "world";
    const bool1 = true;
    const bool2 = false;
    const obj1 = {
        name : "홍길동",
        age : 25
    };
    //const {name, age, favorList} = props; //구조 분해 할당
    return (
        <>
            <div className="test">
                <h1>body : 우리 회사는 세계 제일 회사</h1>
            </div>
            <h2>{number}</h2>
            <h2>{number1 + number2}</h2>
            <h2>{str1 + str2}</h2>
            <h2>{String(bool1)}</h2>
            {/* 부울린 타입은 true, false 랜더링이 인식되지 않아 형변환해야 출력됨 */}
            <h2>{String(bool2)}</h2>
            <h3>{obj1.name}</h3>
            <h3>{obj1.age}</h3>
            <h3>
                {number}는 {number % 2 === 0 ? "짝수":"홀수"}입니다.
            </h3>
            <h1>전달받은 props : {name}, age : {age}</h1>
            <h1>내가 좋아하는 음식의 개수는 {favorList.length}개 입니다.</h1>
            <h1>{children}</h1>
            
            <button onClick={handleOnClick}>클릭</button>
            <button name="버튼1" onClick={handleOnClick2}>버튼1</button>
            <button name="버튼2" onClick={handleOnClick2}>버튼2</button>
            <br/>

            <h1>count값 : {count}</h1>
            <button onClick={onIncrease}>증가</button>
            <h1>countTest값 : {countTest}</h1>
            <button onClick={onIncrease2}>증가</button>
        </>
    );
}

export default Body;