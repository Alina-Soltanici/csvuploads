package com.example.csvuploads.service;

import com.example.csvuploads.model.StudentCsvRecords;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class StudentCsvServiceImpl implements StudentCsvService {
    private static final Logger logger = Logger.getLogger (StudentCsvServiceImpl.class.getName ());
    @Override
    public List<StudentCsvRecords> convertCsv(File csvFile) {
        try(FileReader fileReader = new FileReader (csvFile)) {
            List<StudentCsvRecords> studentCsvRecords = new CsvToBeanBuilder<StudentCsvRecords> (fileReader)
                    .withType (StudentCsvRecords.class)
                    .build ().parse ();
            return studentCsvRecords;
        } catch(FileNotFoundException fileNotFoundException) {
            logger.log (Level.SEVERE, "File " + csvFile.getName () + " not found", fileNotFoundException);
        } catch (IOException ioException) {
            logger.log (Level.SEVERE, "Error when reading from the file " + csvFile.getName (), ioException );
        } catch (Exception exception) {
            logger.log (Level.SEVERE, "Unexpected error occurred while processing the CSV file" + exception);
        }

        logger.log (Level.INFO,csvFile.getName () + " file processing failed");
        return Collections.emptyList ();
    }
}
