package ru.savin.personservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDTO {
    private String phoneNumber;
    private String email;
    private String profileLink;
}
