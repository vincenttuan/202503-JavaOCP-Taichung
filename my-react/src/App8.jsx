// React 組件間參數的傳遞
// 子組件
function CircleArea({r}) {
    const pi = 3.1415926;
    const area = pi * r * r;
    return(<div>{area} 平方單位</div>)
}

// 子組件
function BMI({h, w}) {
    h = h / 100;
    const bmi = w / (h*h);
    return(<div>BMI = {bmi}</div>)
}

// 子組件
function BMI2(props) {
    var h = props.h; // 從 props 中取出 h 值
    var w = props.w; // 從 props 中取出 w 值
    //-----------------
    h = h / 100;
    const bmi = w / (h*h);
    return(<div>BMI = {bmi}</div>) 
}

// 父組件
function App() {
    const r = 123;
    return(
        <>
            <CircleArea r="10" />
            <CircleArea r={r} />
            <BMI h="170" w="60" />
            <BMI2 h="170" w="60" />
        </>
    )
}

export default App;
