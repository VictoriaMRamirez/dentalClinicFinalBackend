package com.ctd.clinic.service.impl;

import com.ctd.clinic.dto.DentistDTO;
import com.ctd.clinic.exception.ResourceNotFoundException;
import com.ctd.clinic.service.IDentistService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class DentistServiceTest {

    @Autowired
    IDentistService dentistService;

    @Test
    @Order(1)
    public void createDentist() {
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setName("Daniel");
        dentistDTO.setSurname("Ricciardo");
        dentistDTO.setRegistrationNumber(123456);

        dentistService.create(dentistDTO);

        Assertions.assertEquals(dentistDTO.getSurname(), "Ricciardo");
    }

    @Test
    @Order(2)
    public void findDentistById() throws ResourceNotFoundException {
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setName("Lewis");
        dentistDTO.setSurname("Hamilton");
        dentistDTO.setRegistrationNumber(456789);

        dentistService.create(dentistDTO);
        DentistDTO dentistDTO1 = dentistService.find(2L);

        Assertions.assertNotNull(dentistDTO1);
    }

    @Test
    @Order(3)
    public void updateDentist() {
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setName("Charles");
        dentistDTO.setSurname("Leclerc");
        dentistDTO.setRegistrationNumber(357159);
        dentistService.create(dentistDTO);

        dentistDTO.setId(dentistDTO.getId());
        dentistDTO.setName("Max");
        dentistDTO.setSurname("Verstappen");
        dentistDTO.setRegistrationNumber(951753);
        dentistService.update(dentistDTO);

        Assertions.assertEquals(dentistDTO.getName(), "Max");
    }

    @Test
    @Order(4)
    public void expectedExceptionForSearchingDeletedDentist() {
        try {
            dentistService.delete(3L);
            dentistService.find(3L);
        } catch(ResourceNotFoundException ex) {
            String message = "Dentist ID 3 not found, try again.";
            Assertions.assertEquals(message, ex.getMessage());
        }
    }

    @Test
    @Order(5)
    public void findAllDentists() {
        Set<DentistDTO> dentists = dentistService.findAll();

        Assertions.assertFalse(dentists.isEmpty());
        Assertions.assertTrue(dentists.size() >= 2);
    }
}