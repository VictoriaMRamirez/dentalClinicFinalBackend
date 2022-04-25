package com.ctd.clinic.dto;

import com.ctd.clinic.entity.Dentist;
import com.ctd.clinic.entity.Patient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class AppointmentDTO {

    private Long id;
    private LocalDate date;
    private Dentist dentist;
    private Patient patient;
}
