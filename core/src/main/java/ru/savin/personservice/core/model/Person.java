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
    private String lastName;
    private String firstName;
    private Date birthDt;
    private int age;
    private char sex;
    private long parentId;
    private long medicalCardId;
    private long contactId;
}
