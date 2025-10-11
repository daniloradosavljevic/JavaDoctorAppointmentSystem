package poslovne.aplikacije.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poslovne.aplikacije.RabbitMQConfigurator;
import poslovne.aplikacije.config.RabbitMQConfig;
import poslovne.aplikacije.dto.AppointmentEvent;

@Service
public class AppointmentMessagingService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendAppointmentEvent(AppointmentEvent event) {
        rabbitTemplate.convertAndSend(
            RabbitMQConfigurator.APPOINTMENTS_EXCHANGE,
            RabbitMQConfigurator.ROUTING_KEY,
            event
        );
    }
}