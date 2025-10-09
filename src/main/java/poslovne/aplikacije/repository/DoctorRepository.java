package poslovne.aplikacije.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poslovne.aplikacije.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {}