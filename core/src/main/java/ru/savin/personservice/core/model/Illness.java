package ru.savin.personservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@Table(schema = "public", name = "illness")
@NoArgsConstructor
@AllArgsConstructor
public class Illness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type_id")
    private long type_id;

    @Column(name = "heaviness")
    private char heaviness;

    @Column(name = "appearance_dttm")
    @NotNull
    private Timestamp timestamp;

    @Column(name = "recovery_dt")
    private Date recovery_dt;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_card_id")
    private MedicalCard medicalCard;
}
