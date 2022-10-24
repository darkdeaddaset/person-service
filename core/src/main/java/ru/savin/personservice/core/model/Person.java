package ru.savin.personservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "person_data", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "last_name")
    private String last_name;

    @NotNull
    @Column(name = "first_name")
    private String first_name;

    @NotNull
    @Column(name = "birth_dt")
    private Date date;

    @Column(name = "age")
    private int age;

    @NotNull
    @Column(name = "sex")
    private char sex;

    @Column(name = "parent_id")
    private Long parent;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medical_card_id")
    private MedicalCard medicalCard;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private Contact contact;
}
