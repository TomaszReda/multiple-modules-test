package pl.test.testbackend.mail.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EmailSendResponse {
    private String sender;
    private String recipients;
    private String content;
    private String subject;
    private String error;
}
