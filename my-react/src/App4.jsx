// 陣列
function App() {
    const fruits = ['西瓜', '芒果', '荔枝', '龍眼', '椰子'];
    //                0       1       2      3       4
    const fruits2 = [
        <li key="0">西瓜</li>,
        <li key="1">芒果</li>,
        <li key="2">荔枝</li>,
        <li key="3">龍眼</li>,
        <li key="4">椰子</li>
    ];

    const fruits3 = fruits.map((fruit, index) => (<li key={index}>{index} : {fruit}</li>))

    return(
        <>
            {fruits}
            {fruits2}
            {fruits3}
        </>
    )

}

export default App;
