package com.example.csvuploads.model;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCsvRecords {
    @CsvBindByName
    private Integer id;
    @CsvBindByName
    private String name;
    @CsvBindByName
    private String email;
    @CsvBindByName
    private Integer age;
}
