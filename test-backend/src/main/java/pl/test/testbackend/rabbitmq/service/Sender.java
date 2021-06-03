package pl.test.testbackend.rabbitmq.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import pl.test.testbackend.rabbitmq.config.RabbitConfig;

import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
@Slf4j
public class Sender {
    private final RabbitTemplate rabbitTemplate;

    public void send(String message) {
        try {
            rabbitTemplate.convertAndSend(RabbitConfig.topicExchangeName, "foo.bar.baz", message);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }
}
