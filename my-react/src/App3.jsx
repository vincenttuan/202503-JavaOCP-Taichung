// 按鈕事件
function App() {
    function clickMe() {
        alert('按我一下');
    }

    return(
        <>
            <button onClick={clickMe}>好好按我</button>
        </>
    )
}

export default App;

