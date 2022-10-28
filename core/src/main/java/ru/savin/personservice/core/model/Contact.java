package ru.savin.personservice.core.model;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToOne;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    private long id;
    private String phoneNumber;
    private String email;
    private String profileLink;
}
