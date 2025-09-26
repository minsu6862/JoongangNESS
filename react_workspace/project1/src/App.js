import { useEffect, useState, useRef } from 'react';
import './App.css';
import Controller from './component/Controller';
import Viewer from './component/Viewer';
import Even from './component/Even';

function App() {
  const [count, setCount] = useState(0);
  const [text, setText] = useState("");
  
  function handleSetCount (num) {
    setCount(count + num);
  }

  function handleSetText(e) {
    setText(e.target.value);
  }

  const didMountRef = useRef(false);

  //useEffect -> 랜더링 후에 발생하는 부작용(side effect)를 처리하는 함수
  //useEffect -> 랜더링 후에 무조건 실행되는 함수
  useEffect(() => {
    if(!didMountRef.current) {
      didMountRef.current = true; //마운트 단계 실행x
      return;
    } else {
      console.log("count 또는 text 값 업데이트 됨! -> "); //업데이트 단계 제어
    }
  });
  //의존성 배열을 생략하면 랜더링 발생 시 무조건 실행
  //useEffect의 두번째 인수 -> 의존성 배열

  useEffect(() => { //최초로 마운트 될 때만 1번 실행되는 함수
    console.log("컴포넌트 마운트 됨!");
  }, []); //의존성 배열을 빈 배열로 입력하면 -> 마운트 시점에서만 콜백함수를 실행

  useEffect(() => {
    const intervalID = setInterval(() => {
      console.log("깜빡");
    }, 1000);
    return () => {
      console.log("클린업");
      clearInterval(intervalID);
    }
  }); //의존성 배열 전달 없음 -> 랜더링 될 때마다 실행

  return (
    <div className="App">
      <h1>Simple Count</h1>
      <section>
        <input value={text} onChange={handleSetText} />
      </section>
      <section>
        <Viewer count={count}></Viewer>
        {count % 2 === 0 && <Even/>}
      </section>
      <section>
        <Controller handleSetCount={handleSetCount} ></Controller>
      </section>
    </div>
  );
}

export default App;
