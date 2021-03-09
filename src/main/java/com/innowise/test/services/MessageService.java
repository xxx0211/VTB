package com.innowise.test.services;

import com.innowise.test.dto.MessageRequest;
import com.innowise.test.exceptions.BadIncomeFileException;
import com.innowise.test.mappers.MessageMapper;
import com.innowise.test.repositories.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    private final MessageMapper messageMapper;

    private final IncomeFileService incomeFileService;

    private final MultipartFileMapper multipartFileMapper;

    public void process(MessageRequest messageRequest) throws IOException, BadIncomeFileException {
        for (MultipartFile file : messageRequest.getFiles()) {
            incomeFileService.process(multipartFileMapper.mapToListIncomeFileDto(file));
        }

    }


}
