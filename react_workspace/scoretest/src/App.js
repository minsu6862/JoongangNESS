import { useRef, useState } from 'react';
import './App.css';
import StudentInput from './component/StudentInput';
import StudentList from './component/StudentList';
import TestComp from './component/TestConponent';

function App() {
  const [students, setStudents] = useState([]);
  const idRef = useRef(0);

  function onCreateStudent(name, math, eng, sci) {
    if (!name || !math || !eng || !sci) {
      alert("이름과 모든 과목의 점수는 필수입력사항 입니다.");
      return;
    }

    const avg = ((Number(math) + Number(eng) + Number(sci)) / 3).toFixed(2);

    const newStudent = {
      id: idRef.current,
      name,
      math: Number(math),
      eng: Number(eng),
      sci: Number(sci),
      avg: Number(avg)
    };

    setStudents([...students, newStudent]);
    idRef.current += 1;
  }

  function onDeleteStudent(id) {
    setStudents(students.filter(student => student.id !== id));
  }

  return (
    <div className="App">
      <h2>학생 성적 관리</h2>
      <StudentInput onCreateStudent={onCreateStudent} />
      <StudentList students={students} onDelete={onDeleteStudent} />
      <TestComp></TestComp>
    </div>
  );
}

export default App;