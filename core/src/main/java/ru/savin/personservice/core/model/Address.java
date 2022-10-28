package ru.savin.personservice.core.model;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    private long id;
    private long country_id;
    private String city;
    private int index;
    private String street;
    private String building;
    private String flat;
    private long contact_id;
}
