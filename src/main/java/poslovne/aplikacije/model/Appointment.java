package poslovne.aplikacije.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    /**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	public Appointment(Long id, Doctor doctor, Patient patient, LocalDateTime appointmentTime, Status status) {
		super();
		this.id = id;
		this.doctor = doctor;
		this.patient = patient;
		this.appointmentTime = appointmentTime;
		this.status = status;
	}

	public Appointment() {
		super();
	}

	public Appointment(Doctor doctor, Patient patient, LocalDateTime appointmentTime, Status status) {
		super();
		this.doctor = doctor;
		this.patient = patient;
		this.appointmentTime = appointmentTime;
		this.status = status;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the doctor
	 */
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 * @param doctor the doctor to set
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * @param patient the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * @return the appointmentTime
	 */
	public LocalDateTime getAppointmentTime() {
		return appointmentTime;
	}

	/**
	 * @param appointmentTime the appointmentTime to set
	 */
	public void setAppointmentTime(LocalDateTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	private LocalDateTime appointmentTime;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        PENDING, CONFIRMED, REJECTED
    }

}