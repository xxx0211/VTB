package com.innowise.test.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
class UploadFileControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void init(){

    }

    @Test
    public void uploadTest() throws Exception {
        this.mockMvc.perform(get("/upload")).andExpect(MockMvcResultMatchers.status().isOk());
    }

}