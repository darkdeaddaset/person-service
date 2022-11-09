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

@Entity
@Table(name = "address", schema = "medical")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "country_id")
    @NotNull
    private long countryId;

    @Column(name = "city", length = 255)
    @NotNull
    private String city;

    @Column(name = "index")
    private int index;

    @Column(name = "street", length = 255)
    @NotNull
    private String street;

    @Column(name = "building", length = 32)
    @NotNull
    private String building;

    @Column(name = "flat", length = 32)
    private String flat;

    @NotNull
    @JoinColumn(name = "contact_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Contact contactId;
}
