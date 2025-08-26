// 陣列
function App() {
    const fruits = ['西瓜', '芒果', '荔枝', '龍眼', '椰子'];
    
    const fruits2 = [
        <li>西瓜</li>,
        <li>芒果</li>,
        <li>荔枝</li>,
        <li>龍眼</li>,
        <li>椰子</li>
    ];

    return(
        <>
            {fruits}
            {fruits2}
        </>
    )

}

export default App;
