// 需安裝 npm install react-router-dom
import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Navbar from "./components/Navbar"
import Home from "./pages/Home"
import Footer from "./components/Footer"
import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";

function App() {

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

        </Routes>
      </div>

      {/* 頁尾-位於最下方 */}
      <Footer />

    </Router>
  )
}

export default App
