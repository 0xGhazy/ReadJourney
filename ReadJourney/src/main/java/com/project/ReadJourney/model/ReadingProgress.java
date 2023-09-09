package com.project.ReadJourney.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "Reading_Progress")
@AllArgsConstructor
@NoArgsConstructor
public class ReadingProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    private long bookId;
    private int currentPage;
    private double completionRatio;
    private String status;
    private Date lastUpdated;
}
