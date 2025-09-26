import './App.css';
import Body from './component/body';
import Body2 from './component/Body2';
import Body3 from './component/Body3';
import Body4 from './component/Body4';
import Footer from './component/footer';
import Header from './component/header';

function ChildComp() {
  return <div>child component</div>;
}

function App() {
  const BodyProps = {
    name : "김유신",
    age : 37
    //favorList : ["파스타", "빵", "떡볶이"]
  };
  return (
    <div className="App">
      <Header/>
      {/* <Body name = {name} age = {age} /> props내에 속성이 여러개면 불편 */}
      {/*<Body {...BodyProps}>
        <ChildComp />
      </Body>*/}
      {/*<Body2></Body2>*/}
      {/*<Join/>*/}
      {/*<Body3></Body3>*/}
      <Body4></Body4>
      <Footer/>
    </div>
  );
}

export default App;
