package ru.savin.personservice.core.model;

import lombok.*;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    private long id;
    private String last_name;
    private String first_name;
    private Date birth_dt;
    private int age;
    private char sex;
    private long parent_id;
    private long medical_card_id;
    private long contact_id;
}
