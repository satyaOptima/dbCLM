package com.test.dbCLM.service;

import com.test.dbCLM.entity.NaceData;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;

public interface FileService {

    public void save(Reader reader) throws IOException, InvocationTargetException, IllegalAccessException;

    public NaceData get(String order);
}
