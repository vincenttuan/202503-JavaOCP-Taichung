package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.entity.Book;

public interface BookDao {
	int save(Book book);
	int update(Book book);
	int deleteById(Integer id);
	Optional<Book> findById(Integer id);
	List<Book> findAll();
	List<Book> findByPage(int start, int size);
}
