package com.ctd.clinic.controller;

import com.ctd.clinic.dto.PatientDTO;
import com.ctd.clinic.exception.ResourceNotFoundException;
import com.ctd.clinic.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    IPatientService patientService;

    @PostMapping
    public ResponseEntity<?> createPatient(@RequestBody PatientDTO patientDTO) {
        patientService.create(patientDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> findPatient(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(patientService.find(id));
    }

    @PutMapping
    public ResponseEntity<?> updatePatient(@RequestBody PatientDTO patientDTO) {
        ResponseEntity<String> message = null;

        if (patientDTO.getId() == null) {
            message = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient ID " + patientDTO.getId() + " not found, try again.");
        } else {
            patientService.update(patientDTO);
            message = ResponseEntity.ok("Patient with ID " + patientDTO.getId() + " was modified.");
        }

        return message;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) throws ResourceNotFoundException {
        patientService.delete(id);
        return ResponseEntity.ok("ID " + id + " was deleted.");
    }

    @GetMapping
    public Collection<PatientDTO> findAllDentists() {
        return patientService.findAll();
    }
}
