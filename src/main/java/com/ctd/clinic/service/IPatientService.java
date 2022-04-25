package com.ctd.clinic.service;

import com.ctd.clinic.dto.PatientDTO;
import com.ctd.clinic.exception.ResourceNotFoundException;

import java.util.Set;

public interface IPatientService {

    void create(PatientDTO patientDTO);
    PatientDTO find(Long id) throws ResourceNotFoundException;
    void update(PatientDTO patientDTO);
    void delete(Long id) throws ResourceNotFoundException;
    Set<PatientDTO> findAll();
}
