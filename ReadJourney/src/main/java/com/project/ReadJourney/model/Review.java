package com.project.ReadJourney.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Entity
@Table(name = "Reviews")
@AllArgsConstructor
@NoArgsConstructor

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long bookId;
    private String reviewerName;
    private Date reviewDate;
    private int rating;
    private String comment;

    @Override
    public String toString() {
        return "BookReview{" +
                "id= " + id +
                ", bookId= " + bookId +
                ", reviewerName= '" + reviewerName + '\'' +
                ", reviewDate= " + reviewDate +
                ", rating= " + rating +
                ", comment= '" + comment + '\'' +
                '}';
    }
}
