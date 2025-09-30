import { useReducer, useState } from "react";

function reducer(state, action) {    //상태변화 함수
    switch(action.type) {
        case "INCREASE" :
            return state + action.data;
        case "DECREASE" :
            return state - action.data;
        case "INIT":
            state = action.data;
            return state;
        default:
            return state;
    }
}

function TestComp() {

    //const [count, setCount] = userState(0);
    const [count, dispatch] = useReducer(reducer, 0);

    return (
        <>
            <h3>테스트 컴포넌트</h3>
            <h2>{count}</h2>
            <div>
                {/*date가 위 reducer의 action값 */}
                <button onClick={()=>dispatch({type:"INCREASE", data:1})}>증가</button>
                <button onClick={()=>dispatch({type:"DECREASE", data:1})}>감소</button>
                <button onClick={()=>dispatch({type:"INIT", data:0})}>감소</button>
            </div>
        </>
    );
}

export default TestComp;