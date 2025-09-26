import { useState } from "react";

function Join() {

    // const [name, setName] = useState("");
    // const [gender, setGender] = useState("");
    // const [birth, setBirth] = useState("");
    // const [bio, setBio] = useState("");

    const [state, setState] = useState({
        name : "",
        gender : "",
        birth : "",
        bio : "",
    });


    // function onChangeName(e) {
    //     setName(e.target.value);
    // }
    // function onChangeGender(e) {
    //     setGender(e.target.value);
    // }
    // function onChangeBirth(e) {
    //     setBirth(e.target.value);
    // }
    // function onChangeBio(e) {
    //     setBio(e.target.value);
    // }

    function handleOnChange(e) {
        setState({
            ...state,
            [e.target.name]: e.target.value,            
        });
    }

    return(
        <div>
            <div>
                <input placeholder="이름" name="name" value={state.name} onChange={handleOnChange} />
            </div>
            <div>
                <select name="gender" value={state.gender} onChange={handleOnChange}>
                    <option key={""}></option>
                    <option key={"남성"}>남성</option>
                    <option key={"여성"}>여성</option>
                </select>
            </div>
            <div>
                <input name="birth" type="date" value={state.birth} onChange={handleOnChange} />
            </div>
            <div>
                <textarea name="bio" value={state.bio} onChange={handleOnChange} />
            </div>
        </div>
    );
}

export default Join;