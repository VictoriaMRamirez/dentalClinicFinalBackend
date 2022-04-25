package com.ctd.clinic.service;

import com.ctd.clinic.dto.DentistDTO;
import com.ctd.clinic.exception.ResourceNotFoundException;

import java.util.Set;

public interface IDentistService {

    void create(DentistDTO dentistDTO);
    DentistDTO find(Long id) throws ResourceNotFoundException;
    void update(DentistDTO dentistDTO);
    void delete(Long id) throws ResourceNotFoundException;
    Set<DentistDTO> findAll();
}
