package com.innowise.test.controllers;

import com.innowise.test.services.MessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
class UploadFileControllerTest {


    @Autowired
    private MockMvc mockMvc;

    private MockMultipartFile mockMultipartFile;

    @Autowired
    private MessageService messageService;

    @Test
    public void validationMessageRequest(){

    }

}