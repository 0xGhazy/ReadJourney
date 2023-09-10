package com.project.ReadJourney.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;
    @NotEmpty
    private String isbn;
    @NotEmpty(message = "Title can not be empty")
    @Size(min = 10, max = 13)
    private String title;

    @Min(1930)
    @Max(2023)
    private Integer publicationYear;

    @Min(0)
    @Max(3000)
    private double price;

    @Min(1)
    @Max(5)
    private double rating;

    @Size(min = 120, max=5000)
    @NotEmpty
    private String description;

    @NotEmpty
    @Size(min = 3, max = 3, message = "Edition must be 3 letters")
    private String edition;
    private String language;
    private String publisher;
    @Min(20)
    @Max(3000)
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
