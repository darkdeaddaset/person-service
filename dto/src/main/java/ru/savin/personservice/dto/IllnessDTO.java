package ru.savin.personservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class IllnessDTO {
    private long typeId;
    private char heaviness;
    private Timestamp appearanceDttm;
}
