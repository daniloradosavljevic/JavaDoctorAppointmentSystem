package poslovne.aplikacije;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import poslovne.aplikacije.model.Doctor;
import poslovne.aplikacije.model.Patient;
import poslovne.aplikacije.repository.DoctorRepository;
import poslovne.aplikacije.repository.PatientRepository;

@Configuration
public class InitialLoad {
    @Bean
    public CommandLineRunner demo(DoctorRepository doctorRepo, PatientRepository patientRepo) {
        return (args) -> {
            Doctor doctor = new Doctor();
            doctor.setFirstName("Sasa");
            doctor.setLastName("Obradovic");
            doctor.setSpecialization("Opsta medicina");
            doctorRepo.save(doctor);

            Patient patient = new Patient();
            patient.setFirstName("Zoran");
            patient.setLastName("Simic");
            patient.setContact("0601234567");
            patientRepo.save(patient);
        };
    }
}