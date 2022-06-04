package com.test.dbCLM.controller;

import com.test.dbCLM.entity.NaceData;
import com.test.dbCLM.handler.FileHandler;
import com.test.dbCLM.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/nace")
public class NaceController {



    @Autowired
    private FileService fileService;

    @RequestMapping("/health")
    public String health(){
        return "up";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<String> putNaceDetails(@RequestParam("file") MultipartFile file) throws IOException, InvocationTargetException, IllegalAccessException {

        if(file.isEmpty() ){
            return ResponseEntity.badRequest().build();
        }
        Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        fileService.save(reader);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<NaceData> getNaceDetails(@RequestParam("order") String order){
        NaceData naceData = fileService.get(order);
        if(naceData == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(naceData);
    }


}
