package com.cap.customerservice;

import com.cap.customerservice.controller.CustomerInfoController;
import com.cap.customerservice.model.CustomerInfo;
import com.cap.customerservice.services.CustomerInfoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
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

public class CustomerInfoControllerTest {
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private CustomerInfoService customerInfoService;

    @InjectMocks
    private CustomerInfoController customerInfoController;

    CustomerInfo customer_1 = new CustomerInfo(1, "nandini", "nandu@gmail.com", "1234", "kakinada");

    CustomerInfo customer_2 = new CustomerInfo(1, "satya", "satya@gmail.com", "3456", "rjy");

    CustomerInfo customer_3 = new CustomerInfo(1, "siva", "siva@gmail.com", "1234", "vizag");

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(customerInfoController).build();
    }

    @Test
    public void getAllWashers_Test() throws Exception {
        List<CustomerInfo> records = new ArrayList<>(Arrays.asList(customer_1, customer_2, customer_3));

        Mockito.when(customerInfoService.getAllCustomers()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/customer/view")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].customerEmail", is("siva@gmail.com")));
    }

    @Test
    public void insertWasherInfo_Test() throws Exception {
        CustomerInfo customer_1 = new CustomerInfo(1, "nandini", "nandini@gmail.com", "nandu", "kakinada");
        //Product(9,"kidsSpecial","joggers","Clothing",null,null,null,999,"Its a very good",null);

        Mockito.when(customerInfoService.insertCustomerInfo(customer_1)).thenReturn(customer_1);

        String content = objectWriter.writeValueAsString(customer_1);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/customer/add")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);
        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.customerName", is("nandini")));
    }

    @Test
    public void updateWasherInfo_Test() throws Exception {

        CustomerInfo updateRecord = new CustomerInfo(3, "padmavati", "padmavati@gmail.com", "1234", "kakinada");


        Mockito.when(customerInfoService.updateCustomerInfo(updateRecord, updateRecord.getCustomerId())).thenReturn(updateRecord);

        String updateContent = objectWriter.writeValueAsString(updateRecord);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/customer/update/3")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(updateContent);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.customerEmail", is("padmavati@gmail.com")));

    }

    @Test
    public void deleteWasherInfo_Test() throws Exception {

        willDoNothing().given(customerInfoService).deleteCustomerInfo(customer_3.getCustomerId());

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(delete("/customer/delete/" + customer_3.getCustomerId()));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print());
    }

}
