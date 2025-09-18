package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
	
	
}
