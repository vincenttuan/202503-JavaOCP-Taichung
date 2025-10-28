import React, { useState, useEffect } from "react";
import "./Checkout.css";
import { fetchOrderHistory } from "../services/cartService";

function Checkout() {
  const [orderHistory, setOrderHistory] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const loadOrderHistory = async () => {
      
    };
  
    loadOrderHistory ();
  }, []);

  return (
    <div className="checkout-container">
      
      請自行完成 !

    </div>
  );
}

export default Checkout;
