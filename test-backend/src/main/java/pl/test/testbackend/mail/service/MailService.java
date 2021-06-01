package pl.test.testbackend.mail.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.test.testbackend.mail.dto.EmailSendRequest;
import pl.test.testbackend.mail.model.EmailSendResponse;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class MailService {


    private final JavaMailSender javaMailSender;

    public ResponseEntity<EmailSendResponse> send(EmailSendRequest emailSendRequest) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            mimeMessage.setText(emailSendRequest.getBody());
            mimeMessage.setFrom(emailSendRequest.getFrom());
            mimeMessage.setRecipients(Message.RecipientType.BCC, emailSendRequest.getTo());
            mimeMessage.setSubject(emailSendRequest.getSubject());

            javaMailSender.send(mimeMessage);
            return ResponseEntity.ok(EmailSendResponse.builder()
                    .sender(emailSendRequest.getFrom())
                    .subject(emailSendRequest.getSubject())
                    .recipients(emailSendRequest.getTo())
                    .content(emailSendRequest.getBody()).build()
            );
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(EmailSendResponse.builder().error(ex.getMessage()).build());
        }
    }
}
