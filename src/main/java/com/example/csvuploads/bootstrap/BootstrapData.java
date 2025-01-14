package com.example.csvuploads.bootstrap;

import com.example.csvuploads.entities.Student;
import com.example.csvuploads.model.StudentCsvRecords;
import com.example.csvuploads.repositories.StudentRepository;
import com.example.csvuploads.service.StudentCsvService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {
    private final StudentRepository studentRepository;
    private final StudentCsvService studentCsvService;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        loadCsvData ();
    }

    private void loadCsvData() throws FileNotFoundException {
        File file = ResourceUtils.getFile ("classpath:csvdata/students.csv");
        List<StudentCsvRecords> recs = studentCsvService.convertCsv (file);

        for(StudentCsvRecords record : recs) {
            studentRepository.save (Student.builder ()
                    .name (StringUtils.abbreviate (record.getName (), 50))
                    .email (record.getEmail ())
                    .age (record.getAge ())
                    .build ());
        }
    }
}
