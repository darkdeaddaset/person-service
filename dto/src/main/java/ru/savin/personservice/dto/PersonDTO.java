package ru.savin.personservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDTO {
    private String lastName;
    private String firstName;
    private char sex;
}
