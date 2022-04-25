package com.ctd.clinic.service.impl;

import com.ctd.clinic.dto.PatientDTO;
import com.ctd.clinic.entity.Patient;
import com.ctd.clinic.exception.ResourceNotFoundException;
import com.ctd.clinic.repository.IPatientRepository;
import com.ctd.clinic.service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PatientService implements IPatientService {

    @Autowired
    IPatientRepository patientRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void create(PatientDTO patientDTO) {
        Patient patient = objectMapper.convertValue(patientDTO, Patient.class);
        patientRepository.save(patient);
    }

    @Override
    public PatientDTO find(Long id) throws ResourceNotFoundException {
        Optional<Patient> patient = patientRepository.findById(id);
        PatientDTO patientDTO = null;

        if (patient.isPresent()) {
            patientDTO = objectMapper.convertValue(patient, PatientDTO.class);
            return patientDTO;
        } else {
            throw new ResourceNotFoundException("Patient ID " + id + " not found, try again.");
        }
    }

    @Override
    public void update(PatientDTO patientDTO) {
        create(patientDTO);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        if (find(id) != null) {
            patientRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Patient ID " + id + " not found, try again.");
        }
    }

    @Override
    public Set<PatientDTO> findAll() {
        List<Patient> patients = patientRepository.findAll();
        Set<PatientDTO> patientDTOS = new HashSet<>();

        for (Patient patient : patients) {
            patientDTOS.add(objectMapper.convertValue(patient, PatientDTO.class));
        }

        return patientDTOS;
    }
}
