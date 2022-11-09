package ru.savin.personservice.core.model;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "illness", schema = "medical")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Illness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type_id")
    private long typeId;

    @Column(name = "heaviness")
    private char heaviness;

    @NotNull
    @Column(name = "appearance_dttm")
    private Timestamp appearanceDttm;

    @Column(name = "recovery_dt")
    private Date recoveryDt;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_card_id")
    private MedicalCard medicalCard;
}
