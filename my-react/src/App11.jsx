/*
    一杯水 250cc
    每按一次杯數 +1
    顯示目前的喝水量與目標

* */
import { useState } from "react";

function App() {
    const maxCC = 3000; // 目標 cc
    const cupCC = 250; // 一杯 cc
    const [cups, setCups] = useState(0); // 紀錄喝了幾杯
    
    // 已喝水量
    const drankCC = cups * cupCC;
    // 已喝趴數
    const percent = (drankCC / maxCC * 100).toFixed(1);

    function drinkWater() {
        if(drankCC >= maxCC) return;
        setCups(cups + 1);
    }

    function drawWater() {
        
    }

    function reset() {
        setCups(0);
    }

    return(
        <div className="pure-form">
            <h1>飲水記錄</h1>
            <div style={{fontSize: 30}}>
                已喝了 {drankCC} / {maxCC}cc
            </div>
            
            {/* 進度條 */}
            <progress value={drankCC} max={maxCC} /> {percent} %<p />

            <button onClick={drinkWater} className="button-success pure-button">
                喝一杯水 (250cc)
            </button>
            <button onClick={drawWater} className="button-warning pure-button">
                吐一杯水 (250cc)
            </button>
            <button onClick={reset} className="button-error pure-button">
                清除記錄
            </button>
        </div>
    )
}

export default App;

