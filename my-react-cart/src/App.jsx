// 需安裝 npm install react-router-dom
import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Navbar from "./components/Navbar"
import Home from "./pages/Home"
import Footer from "./components/Footer"
import LoginPage from "./pages/LoginPage"
import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";


// 登入相關 API
import {checkLoginStatus, login, logout} from "./services/authService"

// 商品相關服務 API

// 購物車相關 API

// 結帳相關 API

function App() {

  const handleLogin = async(username, password) => {
    console.log("username:", username);
    console.log("password:", password);
    try {
      const data = await login(username, password); // 使用登入服務方法
      console.log(JSON.stringify(data)); // 登入結果
      if(data.status === 200) {
        //setIsLoggedIn(true); // 修改登入狀態
        window.location.href = "/"; // 回到首頁
        alert("登入成功");
      } else {
        alert("登入失敗: " + data.message);
      }
    } catch(e) {
      alert(e);
      console.error("登入錯誤:", e);
    }
  };

  return (
    <Router>
      {/* 導航列-位於最上方 */}
      <Navbar />

      {/* 主要內容區-位於中間部分 */}
      <div className='content'>
        <Routes>
          {/* 首頁路由 */}
          <Route path="/" element={<Home />} />

          {/* 商品路由 */}

          {/* 購物車路由 */}

          {/* 登入路由 */}
          <Route path='/login' element={<LoginPage onLogin={handleLogin} />} />

        </Routes>
      </div>

      {/* 頁尾-位於最下方 */}
      <Footer />

    </Router>
  )
}

export default App
