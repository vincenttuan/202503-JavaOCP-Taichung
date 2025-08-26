// JSX = Javascrtipt + HTML
// App() 表示是一個 React 組件 (字首大寫)
// 組件有二種寫法
// 1. function
// 2. () => 函數式 
// return() <-- 裡面只能放單一標籤 
//              若要有多組標籤則必須使用<> .. </>或<div> .. </div>來圈住
function App() {
  return (
    <>
      <h1>Hello React 1</h1>
      <h1>Hello React 2</h1>
    </>
  )  
}

export const  PPA = () => {
  return (
    <h1>Hello PPA !</h1>
  )
}

export function APA() {
  return (
    <h1>Hello APA !</h1>
  )
}

export default App // 預設匯出(一個 jsx 檔最多只能有一個)
