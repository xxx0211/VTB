package com.innowise.test.services;

import com.innowise.test.dto.IncomeFileDto;
import com.innowise.test.dto.MessageRequest;
import com.innowise.test.entities.IncomeFileEntity;
import com.innowise.test.entities.MessageEntity;
import com.innowise.test.exceptions.BadIncomeFileException;
import com.innowise.test.mappers.IncomeFileMapper;
import com.innowise.test.mappers.MultipartFileMapper;
import com.innowise.test.repositories.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    private final IncomeFileService incomeFileService;

    private final MultipartFileMapper multipartFileMapper;

    private final IncomeFileMapper incomeFileMapper;

    public void process(MessageRequest messageRequest)
            throws IOException, BadIncomeFileException {

        Map<MultipartFile, List<IncomeFileDto>> map = new HashMap<>();
        List<IncomeFileDto> incomeFiles = new LinkedList<>();
        for (MultipartFile file : messageRequest.getFiles()) {
            map.put(file, multipartFileMapper.mapToListIncomeFileDto(file));
        }

        map.values().stream().map(incomeFiles::addAll).close();

        List<IncomeFileEntity> incomeFileEntities = incomeFiles.stream()
                .map(incomeFileMapper::mapToFileIncomeEntity)
                .collect(Collectors.toList());

        incomeFileService.process(incomeFileEntities);

        MessageEntity messageEntity = MessageEntity.builder()
                .sender(messageRequest.getSender())
                .date(messageRequest.getDate())
                .files(incomeFileEntities)
                .build();

        messageRepository.save(messageEntity);

    }


}
