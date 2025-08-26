// JSX = Javascrtipt + HTML
// App() 表示是一個 React 組件 (字首大寫)

function App() {
  return (
    <>
      <h1>Hello React 1</h1>
      <h1>Hello React 2</h1>
    </>
  )  
}

export function PPA() {
  return (
    <>
      <h1>Hello PPA !</h1>
    </>
  )
}

export function APA() {
  return (
    <>
      <h1>Hello APA !</h1>
    </>
  )
}

export default App // 預設匯出(一個 jsx 檔最多只能有一個)
