/*
    一杯水 250cc
    每按一次杯數 +1
    顯示目前的喝水量與目標

* */

function App() {
    return(
        <div className="pure-form">
            <h1>飲水記錄</h1>
            <div style={{fontSize: 30}}>
                已喝了 0 / 3000cc
            </div>
            <button className="button-success pure-button">
                喝一杯水 (250cc)
            </button>
            <button className="button-error pure-button">
                清除記錄
            </button>
        </div>
    )
}

export default App;

