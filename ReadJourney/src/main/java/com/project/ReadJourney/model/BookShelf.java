package com.project.ReadJourney.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import java.util.List;

@Data
@Table(name = "BookShelf")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BookShelf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long userId;
//    private List<Book> currentlyReadingBooks;
    @Transient private long lastUpdate;
}
