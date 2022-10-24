package ru.savin.personservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(schema = "public", name = "address")
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "country_id")
    @NotNull
    private long country_id;

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
    private Contact contact;
}
