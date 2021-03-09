package com.innowise.test.services;

import com.innowise.test.dto.IncomeFileDto;
import com.innowise.test.mappers.IncomeFileMapper;
import com.innowise.test.repositories.IncomeFileRepository;
import com.innowise.test.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class IncomeFileService {
    private final IncomeFileRepository incomeFileRepository;

    private final IncomeFileMapper incomeFileMapper;


    public void process(List<IncomeFileDto> incomeFiles){
        incomeFiles.stream()
                .filter(s -> FileUtil.fileExtensionValidation(s.getExtension()))
                .map(incomeFileMapper::mapToFileIncomeEntity)
                .forEach(incomeFileRepository::save);
    }


}
