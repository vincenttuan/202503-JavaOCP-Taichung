// 傳統資料渲染與更新
function App() {
    var count = 0;

    function clickMe() {
        count++; // 更新 count 相當於 setCount()
        document.getElementById("count").textContent = count; // 資料重新渲染更新
    }

    return(
        <>
            <div style={{fontSize: 50}} id="count">0</div>
            <button onClick={clickMe}>按我一下可以 + 1</button>
        </>
    )

}

export default App;
