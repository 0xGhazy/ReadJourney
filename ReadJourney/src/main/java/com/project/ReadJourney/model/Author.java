package com.project.ReadJourney.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String dob;
    private String biography;

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName= '" + firstName + '\'' +
                ", lastName= '" + lastName + '\'' +
                ", birthDate= " + dob +
                ", biography= '" + biography + '\'' +
                '}';
    }
}
