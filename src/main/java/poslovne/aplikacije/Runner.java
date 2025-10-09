package poslovne.aplikacije;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import poslovne.aplikacije.messaging.MessagingReportingService;

@Component
public class Runner implements CommandLineRunner {

	
	
	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Sending message...");
		//rabbitTemplate.convertAndSend(MessagingRabbitmqApplication.TOPIC_EXCHANGE_NAME, "foo.bar.baz", "Hello from RabbitMQ!");
		//receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
	}
	 
}
