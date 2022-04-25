package com.ctd.clinic.service.impl;

import com.ctd.clinic.dto.AppointmentDTO;
import com.ctd.clinic.entity.Appointment;
import com.ctd.clinic.exception.ResourceNotFoundException;
import com.ctd.clinic.repository.IAppointmentRepository;
import com.ctd.clinic.service.IAppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AppointmentService implements IAppointmentService {

    @Autowired
    IAppointmentRepository appointmentRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void create(AppointmentDTO appointmentDTO) {
        Appointment appointment = objectMapper.convertValue(appointmentDTO, Appointment.class);
        appointmentRepository.save(appointment);
    }

    @Override
    public AppointmentDTO find(Long id) throws ResourceNotFoundException {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        AppointmentDTO appointmentDTO = null;

        if (appointment.isPresent()) {
            appointmentDTO = objectMapper.convertValue(appointment, AppointmentDTO.class);
            return appointmentDTO;
        } else {
            throw new ResourceNotFoundException("Appointment ID " + id + " not found, try again.");
        }
    }

    @Override
    public void update(AppointmentDTO appointmentDTO) {
        create(appointmentDTO);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        if (find(id) != null) {
            appointmentRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Appointment ID " + id + " not found, try again.");
        }
    }

    @Override
    public Set<AppointmentDTO> findAll() {
        List<Appointment> appointments = appointmentRepository.findAll();
        Set<AppointmentDTO> appointmentDTOS = new HashSet<>();

        for (Appointment appointment : appointments) {
            appointmentDTOS.add(objectMapper.convertValue(appointment, AppointmentDTO.class));
        }

        return appointmentDTOS;
    }
}
