package com.innowise.test.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Builder(toBuilder = true)
@Entity
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sender;

    private LocalDateTime date;

    @OneToMany
    // add link to incomeFile
    private List<IncomeFileEntity> files;


}
