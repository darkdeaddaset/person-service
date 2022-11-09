package ru.savin.personservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private long countryId;
    private String city;
    private int index;
    private String street;
    private long contactId;
}
