package com.biscuit.microservice.web.controller;


import com.biscuit.microservice.services.ChocolateService;
import com.biscuit.microservice.web.model.ChocolateDto;
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
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ChocolateController.class)
public class ChocolateControllerTest {

    @MockBean
    ChocolateService chocolateService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    ChocolateDto validChocolate;

    @Before
    public void setUp() {
        validChocolate = ChocolateDto.builder()
                .id(15L)
                .name("Old collection")
                .description("Milk Chocolate with nuts")
                .capacity(0.2f)
                .quantityInBox(16)
                .boxWeight(3.2f)
                .boxesOnPlatformQuantity(84)
                .expirationDate("7 months")
                .build();
    }

    @Test
    public void getChocolate() throws Exception {
        // given
        given(chocolateService.getChocolateById(any(Long.class))).willReturn(validChocolate);
        // when
        mockMvc.perform(get("/api/v1/chocolate/" + validChocolate.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(15)))
                .andExpect(jsonPath("$.name", is("Old collection")))
                .andExpect(jsonPath("$.description", is("Milk Chocolate with nuts")))
                .andExpect(jsonPath("$.capacity", is(0.2)))
                .andExpect(jsonPath("$.quantityInBox", is(16)))
                .andExpect(jsonPath("$.boxWeight", is(3.2)))
                .andExpect(jsonPath("$.boxesOnPlatformQuantity", is(84)))
                .andExpect(jsonPath("$.expirationDate", is("7 months")));
    }

    @Test
    public void handlePost() throws Exception {
        // given
        given(chocolateService.saveNewChocolate(any(ChocolateDto.class))).willReturn(validChocolate);
        // when
        mockMvc.perform(post("/api/v1/chocolate/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(validChocolate)))
                .andExpect(status().isCreated());
    }

    @Test
    public void handlePut() throws Exception {
        // when
        mockMvc.perform(put("/api/v1/chocolate/" + validChocolate.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(validChocolate)))
                .andExpect(status().isNoContent());
        // then
        then(chocolateService).should().updateChocolate(any(Long.class), any(ChocolateDto.class));
    }

    @Test
    public void deleteChocolate() throws Exception{
        // when
        mockMvc.perform(delete("/api/v1/chocolate/" + validChocolate.getId()))
                .andExpect(status().isNoContent());
        // then
        then(chocolateService).should().deleteChocolate(any(Long.class));
    }
}