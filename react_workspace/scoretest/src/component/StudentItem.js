import "./StudentItem.css";

function StudentItem({ id, name, math, eng, sci, avg, onDelete }) {
    return (
        <tr className="StudentItem">
            <td>{name}</td>
            <td>{math}</td>
            <td>{eng}</td>
            <td>{sci}</td>
            <td>{avg}</td>
            <td>
                <button onClick={() => onDelete(id)}>삭제</button>
            </td>
        </tr>
    );
}

export default StudentItem;