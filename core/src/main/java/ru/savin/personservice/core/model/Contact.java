package ru.savin.personservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(schema = "public", name = "contact")
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "phone_number", length = 32)
    private String phone_number;

    @Column(name = "email", length = 128)
    private String email;

    @Lob
    @Column(name = "profile_link", columnDefinition = "text")
    private char[] profile_link;

    @OneToOne(mappedBy = "contact")
    private Address address;
}
