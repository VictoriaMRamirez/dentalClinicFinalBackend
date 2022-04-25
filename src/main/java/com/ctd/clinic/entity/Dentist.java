package com.ctd.clinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Dentists")
@Getter @Setter
public class Dentist {

    @Id
    @SequenceGenerator(name = "dentist_sequence", sequenceName = "dentist_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dentist_sequence")
    private Long id;

    private String name;
    private String surname;
    private int registrationNumber;

    @OneToMany(mappedBy = "dentist")
    @JsonIgnore
    private Set<Appointment> appointments;
}
