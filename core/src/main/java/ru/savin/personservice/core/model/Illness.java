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

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Illness {
    @Id
    private long id;
    private long typeId;
    private long medicalCardId;
    private char heaviness;
    private Timestamp appearanceDttm;
    private Date recoveryDt;
}
