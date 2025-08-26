// 按鈕事件
function App() {
    function clickMe() {
        alert('按我一下');
    }

    const touchMe = () => {
        alert('碰到我了')
    }

    function handleMouseDown(event) {
        if(event.button == 0) {
            alert('你按了左鍵');
        } else if(event.button == 2) {
            alert('你按了右鍵');
        }
    }

    return(
        <>
            <button onClick={clickMe}>好好按我</button>
            <button onClick={touchMe}>不要碰我</button>
            <button onMouseDown={handleMouseDown} onContextMenu={e => e.preventDefault()}>判斷按鍵</button>
        </>
    )
}

export default App;

