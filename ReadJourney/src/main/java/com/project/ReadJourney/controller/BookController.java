package com.project.ReadJourney.controller;

import com.project.ReadJourney.dto.BookDto;
import com.project.ReadJourney.service.BookService;
import com.project.ReadJourney.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/books")
public class BookController {

	@Autowired
	private BookService service;

	@PostMapping("")
	public ResponseEntity<?> insertBook(@RequestBody BookDto bookDto) {
		Response response = service.insertBook(bookDto);
		return new ResponseEntity<>(response.jsonfy(), response.getStatusCode());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> retrieveBook (@PathVariable("id") Long id) {
		Response response = service.getBookById(id);
		//TODO: change book to General Response format.
		return new ResponseEntity<>(response.jsonfy(), response.getStatusCode());
	}

	@GetMapping("")
	public ResponseEntity<?> retrieveAllBooks (
			@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "0", required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
			@RequestParam(value = "order", defaultValue = "asc", required = false) String order
	){
		Response books = service.getAllBooks(pageNo, pageSize, sortBy, order);
		return new ResponseEntity<>(books.jsonfy(), books.getStatusCode());
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateBook(@PathVariable("id") Long id, @RequestBody BookDto bookDto) {
		Response book = service.updateBook(id, bookDto);
		return new ResponseEntity<>(book.jsonfy(), book.getStatusCode());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
		Response result = service.deleteBookById(id);
		return new ResponseEntity<>(result.jsonfy(), result.getStatusCode());
	}
}
