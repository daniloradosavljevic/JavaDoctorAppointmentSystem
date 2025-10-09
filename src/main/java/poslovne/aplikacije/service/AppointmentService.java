package poslovne.aplikacije.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poslovne.aplikacije.dto.CreateAppointmentRequest;
import poslovne.aplikacije.model.Appointment;
import poslovne.aplikacije.model.Doctor;
import poslovne.aplikacije.model.Patient;
import poslovne.aplikacije.repository.AppointmentRepository;
import poslovne.aplikacije.repository.DoctorRepository;
import poslovne.aplikacije.repository.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    public Appointment createAppointment(CreateAppointmentRequest request) {
        Optional<Doctor> doctorOpt = doctorRepository.findById(request.getDoctorId());
        Optional<Patient> patientOpt = patientRepository.findById(request.getPatientId());

        if (!doctorOpt.isPresent() || !patientOpt.isPresent()) {
            throw new IllegalArgumentException("Doctor or Patient not found");
        }

        Appointment appointment = new Appointment();
        appointment.setDoctor(doctorOpt.get());
        appointment.setPatient(patientOpt.get());
        appointment.setAppointmentTime(request.getAppointmentTime());
        appointment.setStatus(Appointment.Status.PENDING);

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public List<Appointment> getAppointmentsByStatus(Appointment.Status status) {
        return appointmentRepository.findByStatus(status);
    }
}