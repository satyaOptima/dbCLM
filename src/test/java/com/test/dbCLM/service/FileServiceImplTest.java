package com.test.dbCLM.service;

import com.test.dbCLM.entity.NaceData;
import com.test.dbCLM.repository.NaceDataRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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
public class FileServiceImplTest {

    private static final String SAMPLE_CSV_FILE_PATH = "./WorksheetProgrammingExercise.csv";

    private static Reader reader;


    @Autowired
    private FileServiceImpl fileService;

    @Autowired
    private NaceDataRepository naceDataRepository;


    @BeforeAll
    public static void loadFile() throws IOException {
        reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
    }
    @Test
    public void testSave() throws IOException, InvocationTargetException, IllegalAccessException {
        fileService.save(reader);
        List<NaceData> naceDataList = naceDataRepository.findAll();
        Assertions.assertEquals(naceDataList.size(),996);
    }

    @Test
    public void testGet(){
        NaceData naceData = new NaceData();
        naceData.setOrder("1111");
        naceDataRepository.save(naceData);

        NaceData found = fileService.get(naceData.getOrder());
        Assertions.assertEquals(naceData.getOrder(),found.getOrder());
        naceDataRepository.delete(naceData);
    }
}
