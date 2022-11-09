package ru.savin.personservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicalCardDTO {
    private char clientStatus;
    private char medStatus;
    private long person;
}
