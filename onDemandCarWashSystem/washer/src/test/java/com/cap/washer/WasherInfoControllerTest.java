package com.cap.washer;

import com.cap.washer.controller.WasherInfoController;
import com.cap.washer.models.WasherInfo;
import com.cap.washer.services.WasherInfoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;

import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class WasherInfoControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private WasherInfoService washerInfoService;

    @InjectMocks
    private WasherInfoController washerInfoController;

    WasherInfo washer_1 = new WasherInfo(1,"nandini","nandini@gmail.com","nandu");
    WasherInfo washer_2 = new WasherInfo(2,"satya","satya@gmail.com","satya");
    WasherInfo washer_3 = new WasherInfo(3,"siva","siva@gmail.com","siva");


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(washerInfoController).build();
    }

    @Test
    public void getAllWashers_Test() throws Exception {
        List<WasherInfo> records = new ArrayList<>(Arrays.asList(washer_1,washer_2,washer_3));

        Mockito.when(washerInfoService.getAllWashers()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/washer/view")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].washerEmail",is("siva@gmail.com")));
    }

    @Test
    public void insertWasherInfo_Test() throws Exception {
        WasherInfo washer_1 = new WasherInfo(1,"nandini","nandini@gmail.com","nandu");


        Mockito.when(washerInfoService.insertWasherInfo(washer_1)).thenReturn(washer_1);

        String content = objectWriter.writeValueAsString(washer_1);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/washer/add")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);
        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",notNullValue()))
                .andExpect(jsonPath("$.washerName", is("nandini")));
    }

    @Test
    public void updateWasherInfo_Test() throws Exception {

        WasherInfo updateRecord = new WasherInfo(3, "padmavati", "padmavati@gmail.com", "1234");

        Mockito.when(washerInfoService.updateWasherInfo(updateRecord, updateRecord.getWasherId())).thenReturn(updateRecord);

        String updateContent = objectWriter.writeValueAsString(updateRecord);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/washer/update/3")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(updateContent);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.washerEmail", is("padmavati@gmail.com")));

    }

    @Test
    public void deleteWasherInfo_Test() throws Exception {

        willDoNothing().given(washerInfoService).deleteWasherInfo(washer_3.getWasherId());

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(delete("/washer/delete/" + washer_3.getWasherId()));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print());
    }
}



