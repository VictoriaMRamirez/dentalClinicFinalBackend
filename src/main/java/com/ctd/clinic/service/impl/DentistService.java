package com.ctd.clinic.service.impl;

import com.ctd.clinic.dto.DentistDTO;
import com.ctd.clinic.entity.Dentist;
import com.ctd.clinic.exception.ResourceNotFoundException;
import com.ctd.clinic.repository.IDentistRepository;
import com.ctd.clinic.service.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DentistService implements IDentistService {

    @Autowired
    IDentistRepository dentistRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void create(DentistDTO dentistDTO) {
        Dentist dentist = objectMapper.convertValue(dentistDTO, Dentist.class);
        dentistRepository.save(dentist);
    }

    @Override
    public DentistDTO find(Long id) throws ResourceNotFoundException {
        Optional<Dentist> dentist = dentistRepository.findById(id);
        DentistDTO dentistDTO = null;

        if (dentist.isPresent()) {
            dentistDTO = objectMapper.convertValue(dentist, DentistDTO.class);
            return dentistDTO;
        } else {
            throw new ResourceNotFoundException("Dentist ID " + id + " not found, try again.");
        }
    }

    @Override
    public void update(DentistDTO dentistDTO) {
        create(dentistDTO);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        if (find(id) != null) {
            dentistRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Dentist ID " + id + " not found, try again.");
        }
    }

    @Override
    public Set<DentistDTO> findAll() {
        List<Dentist> dentists = dentistRepository.findAll();
        Set<DentistDTO> dentistDTOS = new HashSet<>();

        for (Dentist dentist : dentists) {
            dentistDTOS.add(objectMapper.convertValue(dentist, DentistDTO.class));
        }

        return dentistDTOS;
    }
}
