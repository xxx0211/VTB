package com.innowise.test.mappers;

import com.innowise.test.dto.IncomeFileDto;
import com.innowise.test.enums.ArchiveFileType;
import com.innowise.test.exceptions.BadIncomeFileException;
import com.innowise.test.utils.FileUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public class MultipartFileMapper {

    public List<IncomeFileDto> mapToListIncomeFileDto(MultipartFile file)
            throws IOException, BadIncomeFileException {
        final byte[] fileContent = file.getBytes();
        List<IncomeFileDto> incomeFiles = null;

        if (FileUtil.fileExtensionValidation(FileUtil.getFileExtension(file.getName()))) {
            incomeFiles = List.of(mapToIncomeFileDto(file));
        } else {
            incomeFiles = ArchiveFileType.of(fileContent)
                    .map(s -> s.unzipToFileContentList(fileContent))
                    .orElseThrow(BadIncomeFileException::new);
        }

        return incomeFiles;
    }

    public IncomeFileDto mapToIncomeFileDto(MultipartFile file) throws IOException {
        return IncomeFileDto.builder()
                .name(file.getName())
                .extension(FileUtil.getFileExtension(file.getName()))
                .data(file.getBytes())
                .build();
    }

}
