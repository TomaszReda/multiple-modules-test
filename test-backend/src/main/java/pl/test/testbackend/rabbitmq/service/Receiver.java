package pl.test.testbackend.rabbitmq.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class Receiver {

    private final RabbitTemplate rabbitTemplate;

    public ResponseEntity<String> receiveMessage() {
        String message = (String) rabbitTemplate.receiveAndConvert("spring-boot");
        return ResponseEntity.ok(message);
    }

}