package com.example.demo.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.cart.model.entity.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByUsername(String username);
	
}
