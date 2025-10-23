import React from "react";
import { Link } from "react-router-dom";
import "./Navbar.css"; // 引入樣式

function Navbar({ cartCount, isLoggedIn, onLogout}) {
  return (
    <nav className="navbar">
      <h2 className="navbar-title">購物車範例</h2>
      <ul className="navbar-links">
        <li>
          <Link to="/">首頁</Link>
        </li>
      </ul>
    </nav>
  );
}

export default Navbar;
