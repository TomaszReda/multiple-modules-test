package pl.test.testbackend.elasticsearch.service;

import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.argument.StructuredArgument;
import org.springframework.stereotype.Service;
import pl.test.testbackend.elasticsearch.model.Article;
import pl.test.testbackend.elasticsearch.model.LogType;

import java.util.ArrayList;
import java.util.List;

import static net.logstash.logback.argument.StructuredArguments.kv;

@Service
@Slf4j
public class LoggingService {

    public void log(LogType logType, Article article) {
        List<StructuredArgument> structuredArguments = structuredArguments(logType, article);
        log.info("info", structuredArguments.toArray());
    }

    private List<StructuredArgument> structuredArguments(LogType logType, Article article) {
        List<StructuredArgument> structuredArguments = new ArrayList<>();
        if (logType.equals(LogType.BLOG)) {
            structuredArguments.add(kv("log_type", "blog"));
        }

        structuredArguments.add(kv("authors", article.getAuthors()));
        structuredArguments.add(kv("tags", article.getTags()));
        structuredArguments.add(kv("title", article.getTitle()));
        return structuredArguments;
    }
}
