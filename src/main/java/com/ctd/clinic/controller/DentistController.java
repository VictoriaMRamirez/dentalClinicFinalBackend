package com.ctd.clinic.controller;

import com.ctd.clinic.dto.DentistDTO;
import com.ctd.clinic.exception.ResourceNotFoundException;
import com.ctd.clinic.service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/dentists")
public class DentistController {

    @Autowired
    IDentistService dentistService;

    @PostMapping
    public ResponseEntity<?> createDentist(@RequestBody DentistDTO dentistDTO) {
        dentistService.create(dentistDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DentistDTO> findDentist(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(dentistService.find(id));
    }

    @PutMapping
    public ResponseEntity<?> updateDentist(@RequestBody DentistDTO dentistDTO) {
        ResponseEntity<String> message = null;

        if (dentistDTO.getId() == null) {
            message = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dentist ID " + dentistDTO.getId() + " not found, try again.");
        } else {
            dentistService.update(dentistDTO);
            message = ResponseEntity.ok("Dentist with ID " + dentistDTO.getId() + " was modified.");
        }

        return message;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDentist(@PathVariable Long id) throws ResourceNotFoundException{
        dentistService.delete(id);
        return ResponseEntity.ok("ID " + id + " was deleted.");
    }

    @GetMapping
    public Collection<DentistDTO> findAllDentists() {
        return dentistService.findAll();
    }
}
