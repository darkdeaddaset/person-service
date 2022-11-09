package ru.savin.personservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "signals", schema = "medical")
@AllArgsConstructor
@NoArgsConstructor
public class Signal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "person_data_id")
    private long person;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;
}
