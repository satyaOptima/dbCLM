package com.test.dbCLM.handler;

import com.test.dbCLM.entity.NaceData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@SpringBootTest
public class FileHandlerTest {

    private static final String SAMPLE_CSV_FILE_PATH = "./WorksheetProgrammingExercise.csv";

    @Autowired
    private FileHandler fileHandler;

    private static Reader reader;

    @BeforeAll
    public static void loadFile() throws IOException {
        reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
    }

    @Test
    public void testFileParsing() throws IOException, InvocationTargetException, IllegalAccessException {
        List<NaceData> naceDataList = fileHandler.convertCsvToNaceData(reader);
        Assertions.assertNotNull(naceDataList);
    }
}
