package poslovne.aplikacije.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poslovne.aplikacije.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {}