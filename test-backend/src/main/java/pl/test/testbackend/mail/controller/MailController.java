package pl.test.testbackend.mail.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.test.testbackend.mail.dto.EmailSendRequest;
import pl.test.testbackend.mail.model.EmailSendResponse;
import pl.test.testbackend.mail.service.MailService;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/api/mail")
public class MailController {

    private final MailService mailService;

    @PostMapping("/send")
    public ResponseEntity<EmailSendResponse> emailSendResponse(@RequestBody @Valid EmailSendRequest emailSendRequest) {
        return mailService.send(emailSendRequest);
    }
}
