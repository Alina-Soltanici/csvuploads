package com.example.csvuploads.service;

import com.example.csvuploads.model.StudentCsvRecords;

import java.io.File;
import java.util.List;

public interface StudentCsvService {

    List<StudentCsvRecords> convertCsv(File csvFile);

}
