package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.dto.BookDTO;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.BookService;

/**
* CRUD 現代設計風格(Rest):
* GET    /api/books   查詢所有書籍 @GetMapping   (value = "/books",     produces = "application/json;charset=utf-8")
* GET    /api/book/1  查詢單筆書籍 @GetMapping   (value = "/book/{id}", produces = "application/json;charset=utf-8")
* POST   /api/book    新增單筆書籍 @PostMapping  (value = "/book",      produces = "application/json;charset=utf-8")
* PUT    /api/book/1  修改單筆書籍 @PutMapping   (value = "/book/{id}", produces = "application/json;charset=utf-8")
* DELETE /api/book/1  刪除單筆書籍 @DeleteMapping(value = "/book/{id}", produces = "application/json;charset=utf-8")
*/

@RestController
@RequestMapping("/api")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping(value = "/books", produces = "application/json;charset=utf-8")
	public ApiResponse<List<BookDTO>> getAllBooks() {
		List<BookDTO> bookDTOs = bookService.findAllBooks();
		return new ApiResponse<>(true, bookDTOs, "多筆查詢成功");
	}
	
	@GetMapping(value = "/book/{id}", produces = "application/json;charset=utf-8")
	public ApiResponse<BookDTO> getBookById(@PathVariable Integer id) {
		try {
			BookDTO bookDTO = bookService.findBookById(id);
			return new ApiResponse<>(true, bookDTO, "單筆查詢成功");
		} catch (BookNotFoundException e) {
			return new ApiResponse<>(false, null, e.getMessage());
		}
	}
	
	@PostMapping(value = "/book", produces = "application/json;charset=utf-8")
	public ApiResponse<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
		BookDTO createBookDTO = bookService.addBook(bookDTO);
		return new ApiResponse<>(true, createBookDTO, "單筆新增成功");
	}
	
	
	
}







