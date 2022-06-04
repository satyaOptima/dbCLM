package com.test.dbCLM.controller;

import com.test.dbCLM.entity.NaceData;
import com.test.dbCLM.service.FileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.io.Reader;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NaceController.class)
public class NaceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FileService fileService;

    @Test
    public void givenMultiPartData_whenContainsData_returnCreated() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "filename.csv", "text/csv","some, csv".getBytes());
        doNothing().when(fileService).save(isA(Reader.class));
        mockMvc.perform(MockMvcRequestBuilders.multipart("/nace/")
                        .file(file))
                .andExpect(status().isCreated());
    }

    @Test
    public void givenMultiPartData_whenContainsNoData_returnBadRequest() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "filename.csv", "text/csv","".getBytes());
        doNothing().when(fileService).save(isA(Reader.class));
        mockMvc.perform(MockMvcRequestBuilders.multipart("/nace/")
                        .file(file))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void givenNaceData_whenDataFound_returnData() throws Exception {

        NaceData naceData = new NaceData();
        naceData.setOrder("22222");
        given(fileService.get("22222")).willReturn(naceData);
        mockMvc.perform(get("/nace/")
                        .param("order", "22222")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void givenNaceData_whenDataNotFound_returnNotFound() throws Exception {
        NaceData naceData = null;
        given(fileService.get("22222")).willReturn(naceData);
        mockMvc.perform(get("/nace/")
                        .param("order", "22222")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
