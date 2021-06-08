package pl.test.testbackend.elasticsearch.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.test.testbackend.elasticsearch.service.ElasticSearchService;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/elasticsearch")
public class ElasticSearchController {

    private final ElasticSearchService elasticSearchService;

    @GetMapping("/warm")
    public void warm(){
      log.warn("warm: " + elasticSearchService.randomString());
    }

    @GetMapping("/error")
    public void error(){
        log.error("error: " + elasticSearchService.randomString());
    }

    @GetMapping("/info")
    public void info(){
        log.info("info: " + elasticSearchService.randomString());
    }

    @GetMapping("/debug")
    public void debug(){
        log.debug("debug: " + elasticSearchService.randomString());
    }

    @GetMapping("/trace")
    public void trace(){
        log.trace("trace: " + elasticSearchService.randomString());
    }
}
