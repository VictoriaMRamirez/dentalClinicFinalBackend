package com.ctd.clinic.dto;

import com.ctd.clinic.entity.Address;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class PatientDTO {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private int dni;
    private LocalDate dateOfEntry;
    private Address address;
}
