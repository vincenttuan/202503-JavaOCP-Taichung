package com.example.demo.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.cart.model.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	// 取得用戶訂單紀錄
	List<Order> findByUserId(Long userId);
}
