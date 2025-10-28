// 需安裝 npm install react-router-dom
import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";

// 登入相關 API
import {checkLoginStatus, login, logout} from "./services/authService";

// 導航列相關模組
import Navbar from "./components/Navbar"

// 首頁相關模組
import Home from "./pages/Home"

// 頁尾相關模組
import Footer from "./components/Footer"

// 登入相關模組
import LoginPage from "./pages/LoginPage"

// 商品相關模組
import Products from "./pages/Products";

// 購物車模組
import Cart from "./pages/Cart";

// 結帳模組
import Checkout from "./pages/Checkout";

function App() {
  // 登入狀態
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  // 定義購物中內容
  const [cartItems, setCartItems] = useState([]);

  // 登入處理
  const handleLogin = async(username, password) => {
    console.log("username:", username);
    console.log("password:", password);
    try {
      const data = await login(username, password); // 使用登入服務方法
      console.log(JSON.stringify(data)); // 登入結果
      if(data.status === 200) {
        setIsLoggedIn(true); // 修改登入狀態
        //window.location.href = "/"; // 回到首頁
        alert("登入成功");
      } else {
        setIsLoggedIn(false); // 修改登入狀態
        alert("登入失敗: " + data.message);
      }
    } catch(e) {
      setIsLoggedIn(false); // 修改登入狀態
      alert(e);
      console.error("登入錯誤:", e);
    }
  };

  // 登出處理
  const handleLogout = async() => {
    try {
      const data = await logout();
      setIsLoggedIn(false); // 修改登入狀態
      console.log(data);
    } catch(e) {
      setIsLoggedIn(false); // 修改登入狀態
      console.log(e);
      alert(e);
    }
  };

  // 加入購物車
  const addToCart = (product) => {
    const item = {
      product: product,
      qty: 1
    }
    console.log(item);
    setCartItems([... cartItems, item])
  }

  return (
    <Router>
      {/* 導航列-位於最上方 */}
      <Navbar isLoggedIn={isLoggedIn} onLogout={handleLogout} />

      {/* 主要內容區-位於中間部分 */}
      <div className='content'>
        <Routes>
          {/* 首頁路由 */}
          <Route path="/" element={<Home />} />

          {/* 商品路由 */}
          <Route path="/products" element={<Products addToCart={addToCart} isLoggedIn={isLoggedIn} />} />

          {/* 購物車路由 */}

          {/* 登入路由 */}
          <Route path='/login' element={<LoginPage onLogin={handleLogin} isLoggedIn={isLoggedIn} />} />

        </Routes>
      </div>

      {/* 頁尾-位於最下方 */}
      <Footer />

    </Router>
  )
}

export default App
