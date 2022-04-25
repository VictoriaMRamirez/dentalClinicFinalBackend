package com.ctd.clinic.service.impl;

import com.ctd.clinic.dto.AddressDTO;
import com.ctd.clinic.entity.Address;
import com.ctd.clinic.exception.ResourceNotFoundException;
import com.ctd.clinic.repository.IAddressRepository;
import com.ctd.clinic.service.IAddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AddressService implements IAddressService {

    @Autowired
    IAddressRepository addressRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void create(AddressDTO addressDTO) {
        Address address = objectMapper.convertValue(addressDTO, Address.class);
        addressRepository.save(address);
    }

    @Override
    public AddressDTO find(Long id) throws ResourceNotFoundException {
        Optional<Address> address = addressRepository.findById(id);
        AddressDTO addressDTO = null;

        if (address.isPresent()) {
            addressDTO = objectMapper.convertValue(address, AddressDTO.class);
            return addressDTO;
        } else {
            throw new ResourceNotFoundException("Address ID " + id + " not found, try again.");
        }
    }

    @Override
    public void update(AddressDTO addressDTO) {
        create(addressDTO);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException{
        if (find(id) != null) {
            addressRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Address ID " + id + " not found, try again.");
        }
    }

    @Override
    public Set<AddressDTO> findAll() {
        List<Address> addresses = addressRepository.findAll();
        Set<AddressDTO> addressDTOS = new HashSet<>();

        for (Address address : addresses) {
            addressDTOS.add(objectMapper.convertValue(address, AddressDTO.class));
        }

        return addressDTOS;
    }
}
