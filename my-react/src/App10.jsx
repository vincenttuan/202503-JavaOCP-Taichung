import { useState } from "react";

function App() {
    const [count, setCount] = useState(0);

    function clickMe() {
        setCount(count + 1); // 取代 count++
    }

    return(
        <>
            <div style={{fontSize: 50}}>{count}</div>
            <button onClick={clickMe}>按我一下可以 + 1</button>
        </>
    )
}

export default App;
