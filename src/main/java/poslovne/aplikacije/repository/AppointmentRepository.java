package poslovne.aplikacije.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poslovne.aplikacije.model.Appointment;
import poslovne.aplikacije.model.Doctor;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctorAndAppointmentTime(Doctor doctor, LocalDateTime appointmentTime);
    List<Appointment> findByStatus(Appointment.Status status);
    boolean existsByDoctorIdAndAppointmentTime(Long doctorId, LocalDateTime appointmentTime);
    List<Appointment> findByDoctorIdAndAppointmentTime(Long doctorId, LocalDateTime appointmentTime);
}