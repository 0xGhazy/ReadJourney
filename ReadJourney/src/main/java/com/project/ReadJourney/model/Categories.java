package com.project.ReadJourney.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@Table(name = "Categories")
@NoArgsConstructor
public class Categories {

    @Id
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;

}
