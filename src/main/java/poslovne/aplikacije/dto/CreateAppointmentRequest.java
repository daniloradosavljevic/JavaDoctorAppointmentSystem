package poslovne.aplikacije.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

public class CreateAppointmentRequest {
	@NotNull(message = "Doctor ID is required")
    private Long doctorId;
	@NotNull(message = "Patient ID is required")
    private Long patientId;
	@NotNull(message = "Appointment time is required")
    @Future(message = "Appointment time must be in the future")
    private LocalDateTime appointmentTime;
	public CreateAppointmentRequest(Long doctorId, Long patientId, LocalDateTime appointmentTime) {
		super();
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.appointmentTime = appointmentTime;
	}
	/**
	 * @return the doctorId
	 */
	public Long getDoctorId() {
		return doctorId;
	}
	/**
	 * @param doctorId the doctorId to set
	 */
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	/**
	 * @return the patientId
	 */
	public Long getPatientId() {
		return patientId;
	}
	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
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
	
    
}