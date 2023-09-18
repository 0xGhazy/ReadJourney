package com.project.ReadJourney.service;


import com.project.ReadJourney.dto.BookDto;
import com.project.ReadJourney.exception.ResourceNotFoundException;
import com.project.ReadJourney.model.Book;
import com.project.ReadJourney.repository.BookRepository;
import com.project.ReadJourney.utils.Response;
import com.project.ReadJourney.utils.ResponseMetadata;
import jakarta.persistence.Column;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class BookService {

	@Autowired
	private BookRepository repository;
    @Autowired
    private ModelMapper modelMapper;

	public Response insertBook(BookDto bookDto){
        Book book = mapToEntity(bookDto);
		Book tempBook = repository.save(book);
        Response response = new Response.ResponseBuilder()
                .data(mapToDto(tempBook))
                .message("Book inserted successfully")
                .status(HttpStatus.CREATED)
                .build();
		return response;
	}

	public Response getBookById(Long id){
		Book book = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
        Response response = new Response.ResponseBuilder()
                .data(mapToDto(book))
                .message("Book retrieved successfully")
                .status(HttpStatus.FOUND)
                .build();
        return response;
	}

    private BookDto mapToDto(Book book){
        BookDto bookDto = modelMapper.map(book, BookDto.class);
        return bookDto;
    }

    private Book mapToEntity(BookDto bookDto){
        Book book = modelMapper.map(bookDto, Book.class);
        return book;
    }

	public Response getAllBooks(int pageNo, int pageSize, String sortBy, String order){
        Sort sort = order.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Book> books = repository.findAll(pageable);
        List<Book> listOfBooks = books.getContent();
        List<BookDto> result = listOfBooks.stream().map(book -> mapToDto(book)).collect(Collectors.toList());
        ResponseMetadata metadata = new ResponseMetadata();
        metadata.setIsLast(books.isLast());
        metadata.setPageNo(books.getNumber());
        metadata.setPageSize(books.getSize());
        metadata.setTotalPages(books.getTotalPages());
        metadata.setTotalRecords(books.getTotalElements());
        Response response = new Response.ResponseBuilder()
                .status(HttpStatus.OK)
                .message("books retrieved successfully")
                .data(result)
                .metadata(metadata)
                .build();
        System.out.println(result);
		return response;
	}

	public Response updateBook(Long id, BookDto bookDto){
		Book _book = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
          _book.setDateAdded(bookDto.getDateAdded());
          _book.setPublisher(bookDto.getPublisher());
          _book.setPublicationYear(bookDto.getPublicationYear());
			_book.setRating(bookDto.getRating());
			_book.setDescription(bookDto.getDescription());
			_book.setEdition(bookDto.getEdition());
			_book.setIsbn(bookDto.getIsbn());
			_book.setTitle(bookDto.getTitle());
			_book.setLanguage(bookDto.getLanguage());
			_book.setPrice(bookDto.getPrice());
			_book.setNumberOfPages(bookDto.getNumberOfPages());
        repository.save(_book);
            // create response object
        Response response = new Response.ResponseBuilder()
                            .data(mapToDto(_book))
                            .message("Book updated successfully")
                            .status(HttpStatus.OK)
                            .build();
		return response;
	}

	public Response deleteBookById(Long id){
		Book _book = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
        repository.deleteById(id);
        Response response = new Response.ResponseBuilder()
                .data(_book)
                .status(HttpStatus.OK)
                .message("Book deleted successfully")
                .build();
        return response;
	}
}
