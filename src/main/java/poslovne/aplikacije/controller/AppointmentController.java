package poslovne.aplikacije.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poslovne.aplikacije.dto.CreateAppointmentRequest;
import poslovne.aplikacije.model.Appointment;
import poslovne.aplikacije.service.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody CreateAppointmentRequest request) {
        try {
            Appointment appointment = appointmentService.createAppointment(request);
            return ResponseEntity.ok(appointment);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments(
            @RequestParam(value = "status", required = false) Appointment.Status status) {
        if (status == null) {
            return ResponseEntity.ok(appointmentService.getAllAppointments());
        } else {
            return ResponseEntity.ok(appointmentService.getAppointmentsByStatus(status));
        }
    }
}