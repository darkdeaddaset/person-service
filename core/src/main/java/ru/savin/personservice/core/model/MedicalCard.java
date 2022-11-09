package ru.savin.personservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "medical_card", schema = "medical")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "client_status")
    private String clientStatus;

    @Column(name = "med_status")
    private String medStatus;

    @NotNull
    @Column(name = "registry_dt")
    private Date registryDt;

    @Column(name = "comment")
    private String comment;

    @OneToOne(mappedBy = "medicalCard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Person person;

    @OneToMany(mappedBy = "medicalCard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Illness> illness;

}

