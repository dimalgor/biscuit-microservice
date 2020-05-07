package com.biscuit.microservice.web.controller;

import com.biscuit.microservice.services.CustomerService;
import com.biscuit.microservice.web.model.CustomerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @MockBean
    CustomerService customerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    CustomerDto validCustomer;

    @Before
    public void setUp() throws Exception {
        validCustomer = CustomerDto.builder()
                .id(1L)
                .name("Dmitriy Gorban")
                .build();
    }

    @Test
    public void getCustomer() throws Exception {
        // given
        given(customerService.getCustomer(anyLong())).willReturn(validCustomer);
        // when
        mockMvc.perform(get("/api/v1/customer/" + validCustomer.getId()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Dmitriy Gorban")));
        // then
        then(customerService).should().getCustomer(anyLong());
    }

    @Test
    public void handlePost() throws Exception {
        // given
        given(customerService.saveNewCustomer(any(CustomerDto.class))).willReturn(validCustomer);
        // when
        mockMvc.perform(post("/api/v1/customer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(validCustomer)))
                .andExpect(status().isCreated());
        // then
        then(customerService).should().saveNewCustomer(any(CustomerDto.class));
    }

    @Test
    public void handlePut() throws Exception {
        // when
        mockMvc.perform(put("/api/v1/customer/" + validCustomer.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(validCustomer)))
                .andExpect(status().isNoContent());
        // then
        then(customerService).should().updateCustomer(anyLong(), any(CustomerDto.class));
    }

    @Test
    public void deleteCustomer() throws Exception {
        // when
        mockMvc.perform(delete("/api/v1/customer/" + validCustomer.getId()))
                .andExpect(status().isNoContent());
        // then
        then(customerService).should().deleteCustomer(anyLong());
    }
}