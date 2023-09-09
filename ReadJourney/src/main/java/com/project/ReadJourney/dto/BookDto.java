package com.project.ReadJourney.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String isbn;
    private String title;
    private Integer publicationYear;
    private double price;
    private double rating;
    private String description;
    private String edition;
    private String language;
    private String publisher;
    private int numberOfPages;
    private Date dateAdded;


    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", price=" + price +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", edition='" + edition + '\'' +
                ", language='" + language + '\'' +
                ", publisher='" + publisher + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
