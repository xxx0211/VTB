package com.innowise.test.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Builder(toBuilder = true)
public class MessageRequest implements Serializable {

    private String sender;
    private LocalDateTime date;
    private List<MultipartFile> files;

}
