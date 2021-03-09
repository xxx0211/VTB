package com.innowise.test.controllers;

import com.innowise.test.dto.MessageRequest;
import com.innowise.test.exceptions.BadIncomeFileException;
import com.innowise.test.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class UploadFileController {

    private final MessageService messageService;

    @PostMapping
    public void uploadFile(@RequestBody MessageRequest messageRequest)
            throws IOException, BadIncomeFileException {
        messageService.process(messageRequest);

    }

}
