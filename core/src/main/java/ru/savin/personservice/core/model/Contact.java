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

@Entity
@Table(name = "contact", schema = "medical")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "phone_number", length = 32)
    private String phoneNumber;

    @Column(name = "email", length = 128)
    private String email;

    @Column(name = "profile_link")
    private String profileLink;

    @OneToOne(mappedBy = "contactId")
    private Address address;
}
