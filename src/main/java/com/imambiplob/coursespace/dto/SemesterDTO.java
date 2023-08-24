package com.imambiplob.coursespace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SemesterDTO {
    private String semesterName;
    private String semesterFee;
    private double creditLimit;
}
