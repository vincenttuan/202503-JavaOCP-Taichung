import { useState, useEffect } from 'react'
import './App.css'

function App() {
  const [books, setBooks] = useState([]);
  const [newBook, setNewBook] = useState({name:'', price:0.0, amount:0, pub:false});

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

  // 新增書籍
  function addBook() {
    alert(JSON.stringify(newBook));
    

  }

  return (
    <>
      <h1>My Book 書籍新增</h1>
      書名: <input type="text" value={newBook.name} onChange={e => setNewBook({...newBook, name:e.target.value})} /><p />
      價格: <input type="number" value={newBook.price} onChange={e => setNewBook({...newBook, price:e.target.value})} /><p />
      數量: <input type="number" value={newBook.amount} onChange={e => setNewBook({...newBook, amount:e.target.value})} /><p />
      出版: <select value={newBook.pub ? "true" : "false"} onChange={e => setNewBook({...newBook, pub:e.target.value === "true"})} >
              <option value="true">已出版</option>
              <option value="false">已絕版</option>
           </select><p />
      <button onClick={addBook}>新增書籍</button><p />

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
