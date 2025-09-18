package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.dto.BookDTO;
import com.example.demo.model.entity.Book;
import com.example.demo.repository.BookDao;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<BookDTO> findAllBooks() {
		List<Book> books = bookDao.findAll();
		// 逐筆 Book 轉 BookDTO
		List<BookDTO> bookDTOs = books.stream()
									  .map(book -> modelMapper.map(book, BookDTO.class))
									  .toList();
		return bookDTOs;
	}

	@Override
	public BookDTO findBookById(Integer id) throws BookNotFoundException {
		Optional<Book> optBook = bookDao.findById(id);
		if(optBook.isEmpty()) {
			throw new BookNotFoundException("查無書籍. id=" + id);
		}
		// 取得 book 物件
		Book book = optBook.get();
		// Book 轉 BookDTO
		BookDTO bookDTO = modelMapper.map(book, BookDTO.class);
		return bookDTO;
	}

	@Override
	public BookDTO addBook(BookDTO bookDTO) {
		// 1.BookDTO 轉 Book
		Book book = modelMapper.map(bookDTO, Book.class);
		// 2.新增
		bookDao.save(book);
		return bookDTO;
	}

	@Override
	public BookDTO updateBook(Integer id, BookDTO bookDTO) throws BookNotFoundException {
		// 1.將 id 注入到 bookDTO 物件中
		bookDTO.setId(id);
		// 2.BookDTO 轉 Book
		Book book = modelMapper.map(bookDTO, Book.class);
		// 3.修改
		bookDao.update(book);
		return bookDTO;
	}

	@Override
	public void deleteBook(Integer id) throws BookNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
