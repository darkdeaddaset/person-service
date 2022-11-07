package ru.savin.personservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalCard {
    @Id
    private long id;
    private char clientStatus;
    private char medStatus;
    private Date registryDt;
    private String comment;
}

