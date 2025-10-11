package poslovne.aplikacije.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poslovne.aplikacije.dto.AppointmentEvent;
import poslovne.aplikacije.model.Appointment;
import poslovne.aplikacije.repository.AppointmentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentConsumer {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @RabbitListener(queues = "appointments-queue")
    public void receiveAppointment(AppointmentEvent event) {
        System.out.println("Received appointment event: " + event);

        LocalDateTime time = LocalDateTime.parse(event.getAppointmentTime());

        List<Appointment> appointments = appointmentRepository.findByDoctorIdAndAppointmentTime(
            event.getDoctorId(),
            time
        );

        Optional<Appointment> opt = appointmentRepository.findById(event.getAppointmentId());
        if (!opt.isPresent()) {
            System.out.println("Appointment not found in database. Event: " + event);
            return;
        }
        Appointment appointment = opt.get();

        boolean doctorBusy = appointments.stream().anyMatch(a -> !a.getId().equals(appointment.getId()));

        if (!doctorBusy) {
            appointment.setStatus(Appointment.Status.CONFIRMED);
            System.out.println("Appointment confirmed: " + appointment.getId());
        } else {
            appointment.setStatus(Appointment.Status.REJECTED);
            System.out.println("Appointment rejected (doctor busy): " + appointment.getId());
        }

        appointmentRepository.save(appointment);
    }
}