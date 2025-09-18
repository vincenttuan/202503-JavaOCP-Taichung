package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.dto.BookDTO;

@Service
public class BookServiceImpl implements BookService {

	@Override
	public List<BookDTO> findAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookDTO findBookById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookDTO addBook(BookDTO bookDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookDTO updateBook(Integer id, BookDTO bookDTO) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBook(Integer id) throws BookNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
