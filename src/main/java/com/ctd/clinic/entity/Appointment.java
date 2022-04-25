package com.ctd.clinic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Appointments")
@Getter @Setter
public class Appointment {

    @Id
    @SequenceGenerator(name = "appointment_sequence", sequenceName = "appointment_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_sequence")
    private Long id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "dentist_id", referencedColumnName = "id", nullable = false)
    private Dentist dentist;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private Patient patient;
}
