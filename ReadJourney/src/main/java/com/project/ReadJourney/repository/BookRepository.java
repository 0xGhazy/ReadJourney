package com.project.ReadJourney.repository;

import com.project.ReadJourney.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookById(Long id);
}
