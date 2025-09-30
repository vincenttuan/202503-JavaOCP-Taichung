package com.example.demo.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.cart.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
