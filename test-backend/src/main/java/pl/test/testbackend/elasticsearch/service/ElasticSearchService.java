package pl.test.testbackend.elasticsearch.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ElasticSearchService {

    public String randomString() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
}
