package pl.test.testbackend.elasticsearch.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "elasticsearch")
@Data
public class ElasticProperties {
    private String host;
    private String username;
    private String password;
}