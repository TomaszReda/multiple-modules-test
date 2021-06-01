package pl.test.testbackend.mail.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.mail")
@Data
public class MailProperties {
    private String username;
    private int port;
    private String host;
    private String password;
    private String testConnection;
}
