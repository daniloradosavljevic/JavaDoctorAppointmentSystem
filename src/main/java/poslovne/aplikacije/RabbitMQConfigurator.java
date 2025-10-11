package poslovne.aplikacije;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfigurator {
    public static final String APPOINTMENTS_QUEUE = "appointments-queue";
    public static final String APPOINTMENTS_EXCHANGE = "appointments-exchange";
    public static final String ROUTING_KEY = "appointments.create";

    @Bean
    public Queue appointmentQueue() {
        return new Queue(APPOINTMENTS_QUEUE, false);
    }

    @Bean
    public TopicExchange appointmentExchange() {
        return new TopicExchange(APPOINTMENTS_EXCHANGE);
    }

    @Bean
    public Binding appointmentBinding(Queue appointmentQueue, TopicExchange appointmentExchange) {
        return BindingBuilder.bind(appointmentQueue).to(appointmentExchange).with(ROUTING_KEY);
    }
}