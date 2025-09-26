import { useState } from "react";

function Viewer({number}) { //Body3 컴포넌트의 하위 컴포넌트 ->props 전달 -> props = state 변수
    return (
        <>
            {number % 2 === 0 ? <h1>짝수</h1>:<h1>홀수</h1>}
        </>
    );
}

function Viewer2() {
    console.log("뷰어2 컴포넌트 업데이트!!");
    return (
        <>
            Viewer컴포넌트 입니다!
        </>
    );
}

function Body3() {
    const [number, setNumber] = useState(0);

    function onIncrease() {
        setNumber(number + 1);
    }

    function onMinus() {
        setNumber(number - 1);
    }


    return (
        <>
            <h1>{number}</h1>
            <Viewer number={number} />
            <hr></hr>
            <Viewer2/>
            <hr></hr>
            <div>
                <button onClick={onIncrease}>증가</button>
                <button onClick={onMinus}>감소</button>
            </div>
        </>
    );
}

export default Body3;