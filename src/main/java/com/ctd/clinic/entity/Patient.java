package com.ctd.clinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Patients")
@Getter @Setter
public class Patient {

    @Id
    @SequenceGenerator(name = "patient_sequence", sequenceName = "patient_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_sequence")
    private Long id;

    private String name;
    private String surname;
    private String email;
    private int dni;
    private LocalDate dateOfEntry;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private Set<Appointment> appointments;
}
