import { useState, useEffect } from 'react'
import './App.css'

function App() {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    fetchBooks();
  }, [])

  // 取得所有書籍
  function fetchBooks() {
    fetch("http://localhost:8080/api/books")
        .then((response) => {
          if(!response.ok) {
            throw new Error("網路回應錯誤");
          }
          return response.json();
        }) // 網路回應
        .then((jsonData) => {
          setBooks(jsonData.data); // 將資料透過 setBooks 注入
        }) // 資料處理
        .catch((error) => {
          console.log(error);
          alert(error);
        }) // 錯誤處理
  }

  return (
    <>
      <h1>My Book 書籍列表</h1>
      <h2>
        {books.length} 筆
        <ul>
          {
            books.map((book) => {
              return (<li key={book.id}>{book.name} ${book.price} {book.amount}本 {book.pub === true ? "出版中" : "已絕版"}</li>)
            })
          }
        </ul>
      </h2>
    </>  
  )
}

export default App
