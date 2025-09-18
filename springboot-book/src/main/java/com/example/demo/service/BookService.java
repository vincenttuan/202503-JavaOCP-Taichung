package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.dto.BookDTO;

public interface BookService {
	// 查詢所有書籍
	List<BookDTO> findAllBooks();
	// 查詢單筆書籍
	BookDTO findBookById(Integer id);
	// 新增書籍
	BookDTO addBook(BookDTO bookDTO);
	// 修改書籍
	BookDTO updateBook(Integer id, BookDTO bookDTO) throws BookNotFoundException;
	// 刪除書籍
	void deleteBook(Integer id) throws BookNotFoundException;
	
}
