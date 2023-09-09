package com.project.ReadJourney.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "Books")
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique=true)
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
}
