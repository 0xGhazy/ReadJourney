package com.project.ReadJourney.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMetadata {
    private Integer pageNo;
    private Integer pageSize;
    private Long totalRecords;
    private Integer totalPages;
    private Boolean isLast;
}
