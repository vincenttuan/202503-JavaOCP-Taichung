package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Book;

@Repository
public class BookDaoImpl implements BookDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(Book book) {
		String sql = "insert into book(title, price, stock, published) values (?, ?, ?, ?)";
		int rowcount = jdbcTemplate.update(sql, book.getTitle(), book.getPrice(), book.getStock(), book.getPublished());
		return rowcount;
	}

	@Override
	public int update(Book book) {
		String sql = "update book set title=?, price=?, stock=?, published=? where id=?";
		int rowcount = jdbcTemplate.update(sql, book.getTitle(), book.getPrice(), book.getStock(), book.getPublished(), book.getId());
		return rowcount;
	}

	@Override
	public int deleteById(Integer id) {
		String sql = "delete from book where id=?";
		int rowcount = jdbcTemplate.update(sql, id);
		return rowcount;
	}

	@Override
	public Optional<Book> findById(Integer id) {
		String sql = "select id, title, price, stock, published from book where id=?";
		try {
			Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
			return Optional.of(book);
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	@Override
	public List<Book> findAll() {
		String sql = "select id, title, price, stock, published from book";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
	}

	@Override
	public List<Book> findByPage(int start, int size) {
		String sql = "select id, title, price, stock, published from book limit ? offset ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class), size, start);
	}

}
