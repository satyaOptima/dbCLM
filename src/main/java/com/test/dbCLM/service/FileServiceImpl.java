package com.test.dbCLM.service;

import com.test.dbCLM.entity.NaceData;
import com.test.dbCLM.handler.FileHandler;
import com.test.dbCLM.repository.NaceDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Component
public class FileServiceImpl implements FileService{

    @Autowired
    private FileHandler fileHandler;

    @Autowired
    private NaceDataRepository naceDataRepository;

    @Override
    public void save(Reader reader) throws IOException, InvocationTargetException, IllegalAccessException {
        List<NaceData> naceDataList = fileHandler.convertCsvToNaceData(reader);
        naceDataRepository.saveAll(naceDataList);
    }

    @Override
    public NaceData get(String order) {
        return naceDataRepository.findByOrder(order);
    }
}
