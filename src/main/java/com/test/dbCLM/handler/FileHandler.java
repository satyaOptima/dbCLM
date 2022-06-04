package com.test.dbCLM.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.test.dbCLM.entity.NaceData;
import com.test.dbCLM.model.CsvData;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class FileHandler {

    public List<NaceData> convertCsvToNaceData(Reader reader) throws IOException, InvocationTargetException, IllegalAccessException {
        //Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        //Reader reader = Files.newBufferedReader();
        CsvToBean<CsvData> csvToBean = new CsvToBeanBuilder(reader)
                .withType(CsvData.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        Iterator<CsvData> csvUserIterator = csvToBean.iterator();
        List<NaceData> naceDataList = new ArrayList<>();
        while (csvUserIterator.hasNext()) {
            CsvData csvData = csvUserIterator.next();
            System.out.println("CvsData : " + csvData);
            System.out.println("==========================");
            NaceData naceData = new NaceData();
            BeanUtils.copyProperties(naceData,csvData);
            naceDataList.add(naceData);
        }
        System.out.println("=======Parsing completed=======");
        return naceDataList;
    }
}
