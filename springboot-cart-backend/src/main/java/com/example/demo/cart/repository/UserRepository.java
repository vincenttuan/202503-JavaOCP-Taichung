package com.example.demo.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.cart.model.entity.User;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByUsername(String username); // 屬於多筆查詢
	
	Optional<User> findFirstByUsername(String username); // 屬於單筆查詢
	
}
