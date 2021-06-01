package pl.test.testbackend.mail.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class EmailSendRequest {
    @NotEmpty
    private String from;
    @NotEmpty
    private String to;
    @NotEmpty
    private String body;
    @NotEmpty
    private String subject;
}
