package com.project.ReadJourney.controller;


import com.project.ReadJourney.dto.AuthorDto;
import com.project.ReadJourney.service.AuthorService;
import com.project.ReadJourney.utils.Response;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/authors")
public class AuthorController {


    @Autowired
    private AuthorService service;


    @PostMapping("")
    public ResponseEntity<?> postAuthor(@Valid @RequestBody AuthorDto authorDto) {
        Response response = service.insertAuthor(authorDto);
        return new ResponseEntity<>(response.jsonfy(), response.getStatusCode());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable("id") Long id){
        Response response = service.getAuthorById(id);
        return new ResponseEntity<>(response.jsonfy(), response.getStatusCode());
    }

    @GetMapping("")
    public ResponseEntity<?> getAllAuthors(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "1", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "order", defaultValue = "asc", required = false) String order
    ){
        Response response = service.getAllAuthors(pageNo, pageSize, sortBy, order);
        return new ResponseEntity<>(response.jsonfy(), response.getStatusCode());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthorById(@PathVariable("id") Long id, @RequestBody AuthorDto author)
    {
        Response response = service.updateAuthorById(id, author);
        return new ResponseEntity<>(response.jsonfy(), response.getStatusCode());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthorById(@PathVariable("id") Long id)
    {
        Response response = service.deleteAuthorById(id);
        return new ResponseEntity<>(response.jsonfy(), response.getStatusCode());
    }



}
