package pl.test.testbackend.rabbitmq.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.test.testbackend.rabbitmq.service.Receiver;
import pl.test.testbackend.rabbitmq.service.Sender;

@RequestMapping("/api/rabbitmq")
@RestController
@AllArgsConstructor
public class RabbitController {

    private final Sender sender;
    private final Receiver receiver;

    @PostMapping("/send")
    public ResponseEntity send(@RequestBody String message) {
        sender.send(message);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/receive")
    public ResponseEntity<String> receive() {
        return receiver.receiveMessage();
    }
}
