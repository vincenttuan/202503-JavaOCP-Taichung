import { useState, useEffect } from 'react'
import './App.css'

function App() {
  const [books, setBooks] = useState([]);
  const [newBook, setNewBook] = useState({id:0, name:'', price:0.0, amount:0, pub:false});

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
    //alert(JSON.stringify(newBook));
    console.log("新增:", JSON.stringify(newBook));
    fetch("http://localhost:8080/api/book", {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify(newBook)
    })
    .then((response) => {
          if(!response.ok) {
            throw new Error("網路回應錯誤");
          }
          return response.json();
        }) // 網路回應
    .then((jsonData) => {
          console.log("新增回應:" + jsonData);
          console.log("新增回應:" + JSON.stringify(jsonData));
          if(jsonData.success) {
            console.log('新增成功');
            // 清空欄位資料
            setNewBook({id:0, name:'', price:0.0, amount:0, pub:false});
            // 重新查詢資料
            fetchBooks();
          } else {
            console.log('新增失敗:' + jsonData.message);
          }
        }) // 資料處理
    .catch((error) => {
          console.log(error);
          alert(error);
        }) // 錯誤處理
  }

  // 刪除書籍
  function deleteBook(book) {
    // 取得 book's id
    const id = book.id;
    //fetch('http://localhost:8080/api/book/' + id, { })
    fetch(`http://localhost:8080/api/book/${id}`, { 
      method: 'DELETE'
    })
    .then((response) => {
          if(!response.ok) {
            throw new Error("網路回應錯誤");
          }
          return response.json();
        }) // 網路回應
    .then((jsonData) => {
          console.log("刪除回應:" + jsonData);
          console.log("刪除回應:" + JSON.stringify(jsonData));
          if(jsonData.success) {
            console.log('刪除成功');
            // 重新查詢資料
            fetchBooks();
          } else {
            console.log('刪除失敗:' + jsonData.message);
          }
        }) // 資料處理
    .catch((error) => {
          console.log(error);
          alert(error);
        }) // 錯誤處理

  }

  // 編輯 book
  function editBook(book) {
    setNewBook({
      id: book.id,
      name: book.name,
      price: book.price,
      amount: book.amount,
      pub: book.pub
    });
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
              return (
                  <li key={book.id}>{book.name} ${book.price} {book.amount}本 {book.pub === true ? "出版中" : "已絕版"}
                    &nbsp;
                    <button onClick={() => editBook(book)}>修改</button>
                    &nbsp;
                    <button onClick={() => deleteBook(book)}>刪除</button>
                  </li>
                )
            })
          }
        </ul>
      </h2>
    </>  
  )
}

export default App
