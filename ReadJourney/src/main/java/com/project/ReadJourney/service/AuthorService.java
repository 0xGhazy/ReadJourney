package com.project.ReadJourney.service;

import com.project.ReadJourney.dto.AuthorDto;
import com.project.ReadJourney.dto.BookDto;
import com.project.ReadJourney.exception.InvalidDateFormatException;
import com.project.ReadJourney.exception.ResourceNotFoundException;
import com.project.ReadJourney.model.Author;
import com.project.ReadJourney.model.Book;
import com.project.ReadJourney.repository.AuthorRepository;
import com.project.ReadJourney.utils.Response;
import com.project.ReadJourney.utils.ResponseMetadata;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.project.ReadJourney.utils.Helpers.isValidDateFormat;

@Component
public class AuthorService {

    @Autowired
    private AuthorRepository repository;
    @Autowired
    private ModelMapper modelMapper;


    public Response getAuthorById(Long id){
        Author author = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        Response response = new Response.ResponseBuilder()
                .data(mapToDto(author))
                .message("Author retrieved successfully")
                .status(HttpStatus.FOUND)
                .build();
        return response;
    }

    public Response getAllAuthors(int pageNo, int pageSize,  String sortBy, String order){
        Sort sort = order.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Author> authors = repository.findAll(pageable);
        List<Author> listOfAuthors = authors.getContent();
        List<AuthorDto> result = listOfAuthors.stream().map(author -> mapToDto(author)).collect(Collectors.toList());
        ResponseMetadata metadata = new ResponseMetadata();
        metadata.setIsLast(authors.isLast());
        metadata.setPageNo(authors.getNumber());
        metadata.setPageSize(authors.getSize());
        metadata.setTotalPages(authors.getTotalPages());
        metadata.setTotalRecords(authors.getTotalElements());
        Response response = new Response.ResponseBuilder()
                .status(HttpStatus.OK)
                .message("Authors retrieved successfully")
                .data(result)
                .metadata(metadata)
                .build();
        return response;
    }

    public Response updateAuthorById(Long id, AuthorDto authorDto){
        Author _author = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        // check for date
        String authorDob = authorDto.getDob();
        if(isValidDateFormat(authorDob, "^(?:\\d{4}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[1-2]\\d|3[0-1]))$")) {
            _author.setBiography(authorDto.getBiography());
            _author.setDob(authorDto.getDob());
            _author.setFirstName(authorDto.getFirstName());
            _author.setLastName(authorDto.getLastName());
            repository.save(_author);
            Response response = new Response.ResponseBuilder()
                    .data(mapToDto(_author))
                    .message("Author updated successfully")
                    .status(HttpStatus.OK)
                    .build();
            return response;
        }
        throw new InvalidDateFormatException("dob", authorDob);
    }
    public Response deleteAuthorById(Long id){
        Author _author = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        repository.deleteById(id);
        Response response = new Response.ResponseBuilder()
                .data(mapToDto(_author))
                .message("Author deleted successfully")
                .status(HttpStatus.OK)
                .build();
        return response;
    }


    public Response insertAuthor(AuthorDto authorDto){
        String authorDob = authorDto.getDob();
        if(isValidDateFormat(authorDob, "^(?:\\d{4}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[1-2]\\d|3[0-1]))$")){
            Author author = repository.save(mapToEntity(authorDto));
            Response response = new Response.ResponseBuilder()
                    .data(author)
                    .message("Author added successfully")
                    .status(HttpStatus.CREATED)
                    .build();
            return response;
        }
        throw new InvalidDateFormatException("dob", authorDob);
    }

    public Author mapToEntity(AuthorDto authorDto){
        Author author = modelMapper.map(authorDto, Author.class);
        return author;
    }

    public AuthorDto mapToDto(Author author){
        AuthorDto authorDto = modelMapper.map(author, AuthorDto.class);
        return authorDto;
    }




}
