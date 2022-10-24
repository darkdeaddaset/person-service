package ru.savin.personservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(schema = "public", name = "medical_card")
@NoArgsConstructor
@AllArgsConstructor
public class MedicalCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "client_status")
    private char client_status;

    @Column(name = "med_status")
    private char med_status;

    @NotNull
    @Column(name = "registry_dt")
    private Date registry_dt;

    @Lob
    @Column(name = "comment", columnDefinition = "text")
    private char[] comment;

    @OneToOne(mappedBy = "medicalCard", cascade = CascadeType.ALL, orphanRemoval = true)
    private Person person;

    @OneToMany(mappedBy = "medicalCard", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Illness> illnesses;
}

