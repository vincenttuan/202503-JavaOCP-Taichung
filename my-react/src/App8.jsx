// React 組件間參數的傳遞
// 子組件
function CircleArea({r}) {
    const pi = 3.1415926;
    const area = pi * r * r;
    return(<div>{area} 平方單位</div>)
}

// 父組件
function App() {
    return(
        <>
            <CircleArea r="10" />
            <CircleArea r="123" />
        </>
    )
}

export default App;
