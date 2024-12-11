package com.innowise.test.services;

import com.innowise.test.entities.IncomeFileEntity;
import com.innowise.test.repositories.IncomeFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class IncomeFileService {
    private final IncomeFileRepository incomeFileRepository;

    public void process(List<IncomeFileEntity> incomeFiles){
        incomeFileRepository.saveAll(incomeFiles);
    }


}
