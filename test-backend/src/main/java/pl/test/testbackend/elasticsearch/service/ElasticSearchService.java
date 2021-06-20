package pl.test.testbackend.elasticsearch.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.test.testbackend.elasticsearch.DtoBlogRequest;
import pl.test.testbackend.elasticsearch.model.Article;
import pl.test.testbackend.elasticsearch.model.Author;
import pl.test.testbackend.elasticsearch.model.LogType;

import java.util.Arrays;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class ElasticSearchService {

    private final LoggingService loggingService;

    public String randomString() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public void createArticle(DtoBlogRequest dtoBlogRequest) {
        Article article = new Article();
        Author author = new Author(dtoBlogRequest.getAuthor());
        article.setAuthors(Arrays.asList(author));
        article.setTags(dtoBlogRequest.getTag());
        article.setTitle(dtoBlogRequest.getTitle());
        loggingService.log(LogType.BLOG, article);
    }
}
