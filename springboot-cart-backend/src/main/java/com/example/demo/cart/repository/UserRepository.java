package com.example.demo.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.cart.model.entity.User;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByUsername(String username); // 屬於多筆查詢
	
	Optional<User> findFirstByUsername(String username); // 屬於單筆查詢
	
	// 利用原生 sql
	@Query(value = "select * from user where username = :username", nativeQuery = true)
	Optional<User> findByUsernameNative(@Param("username") String username);
	
	@Modifying
	@Transactional
	@Query(value = "update user set password = :password where id = :id", nativeQuery = true)
	int updatePasswordByIdNative(@Param("id") Long id, @Param("password") String password);
	
}
