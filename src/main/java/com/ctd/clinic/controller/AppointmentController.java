package com.ctd.clinic.controller;

import com.ctd.clinic.dto.AppointmentDTO;
import com.ctd.clinic.exception.ResourceNotFoundException;
import com.ctd.clinic.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    IAppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        appointmentService.create(appointmentDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> findAppointment(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(appointmentService.find(id));
    }

    @PutMapping
    public ResponseEntity<?> updateAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        ResponseEntity<String> message = null;

        if (appointmentDTO.getId() == null) {
            message = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment ID " + appointmentDTO.getId() + " not found, try again.");
        } else {
            appointmentService.update(appointmentDTO);
            message = ResponseEntity.ok("Appointment with ID " + appointmentDTO.getId() + " was modified.");
        }

        return message;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable Long id) throws ResourceNotFoundException {
        appointmentService.delete(id);
        return ResponseEntity.ok("Appointment ID " + id + " was deleted.");
    }

    @GetMapping
    public Collection<AppointmentDTO> findAllAppointments() {
        return appointmentService.findAll();
    }
}
