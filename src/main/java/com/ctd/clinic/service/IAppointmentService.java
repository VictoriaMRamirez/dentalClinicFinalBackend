package com.ctd.clinic.service;

import com.ctd.clinic.dto.AppointmentDTO;
import com.ctd.clinic.exception.ResourceNotFoundException;

import java.util.Set;

public interface IAppointmentService {

    void create(AppointmentDTO appointmentDTO);
    AppointmentDTO find(Long id) throws ResourceNotFoundException;
    void update(AppointmentDTO appointmentDTO);
    void delete(Long id) throws ResourceNotFoundException;
    Set<AppointmentDTO> findAll();
}
