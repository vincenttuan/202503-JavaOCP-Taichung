// 變數的應用
function App() {
    const text = 'Hello React';

    return(
        <>
            <h1>text</h1>
            <h1>{text}</h1>
            <h1>{text} {text}</h1>
            <h1>{text.toUpperCase()}</h1>
            <h1 style={{backgroundColor: 'red'}}>{text}</h1>
            <form>
                <fieldset>
                    <legend>表單</legend>
                    訊息: <input type="text" value={text} /> <p />
                    <button>傳送</button>
                </fieldset>
            </form>
        </>
    )

}

export default App;
