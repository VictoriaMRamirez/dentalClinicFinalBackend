package com.ctd.clinic.service;

import com.ctd.clinic.dto.AddressDTO;
import com.ctd.clinic.exception.ResourceNotFoundException;

import java.util.Set;

public interface IAddressService {

    void create(AddressDTO addressDTO);
    AddressDTO find(Long id) throws ResourceNotFoundException;
    void update(AddressDTO addressDTO);
    void delete(Long id) throws ResourceNotFoundException;
    Set<AddressDTO> findAll();
}
