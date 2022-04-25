package com.ctd.clinic.controller;


import com.ctd.clinic.dto.AddressDTO;
import com.ctd.clinic.exception.ResourceNotFoundException;
import com.ctd.clinic.repository.IAddressRepository;
import com.ctd.clinic.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    IAddressService addressService;

    @PostMapping
    public ResponseEntity<?> createAddress(@RequestBody AddressDTO addressDTO) {
        addressService.create(addressDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> findAddress(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(addressService.find(id));
    }

    @PutMapping
    public ResponseEntity<?> updateAddress(@RequestBody AddressDTO addressDTO) {
        ResponseEntity<String> message = null;

        if (addressDTO.getId() == null) {
            message = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address ID " + addressDTO.getId() + " not found, try again.");
        } else {
            addressService.update(addressDTO);
            message = ResponseEntity.ok("Address with ID " + addressDTO.getId() + " was modified.");
        }

        return message;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Long id) throws ResourceNotFoundException{
        addressService.delete(id);
        return ResponseEntity.ok("ID " + id + " was deleted.");
    }

    @GetMapping
    public Collection<AddressDTO> findAllDentists() {
        return addressService.findAll();
    }
}
