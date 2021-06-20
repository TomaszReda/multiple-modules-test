package pl.test.testbackend.elasticsearch.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.test.testbackend.elasticsearch.DtoBlogRequest;
import pl.test.testbackend.elasticsearch.model.Article;
import pl.test.testbackend.elasticsearch.model.Author;
import pl.test.testbackend.elasticsearch.repository.ArticleRepository;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public Page<Article> findArticleByTags(String tag, Pageable pageable) {
        return articleRepository.findArticleByTags(tag, pageable);
    }

    public Page<Article> findByAuthorsNameUsingCustomQuery(String name, Pageable pageable) {
        return articleRepository.findByAuthorsNameUsingCustomQuery(name, pageable);
    }

    public Page<Article> findByFilteredTagQuery(String tag, Pageable pageable) {
        return articleRepository.findByFilteredTagQuery(tag, pageable);

    }

    public Page<Article> findByAuthorsNameAndFilteredTagQuery(String name, String tag, Pageable pageable) {
        return articleRepository.findByAuthorsNameAndFilteredTagQuery(name, tag, pageable);
    }

    public Article save(DtoBlogRequest dtoBlogRequest) {
        Article article = new Article();
        Author author = new Author(dtoBlogRequest.getAuthor());
        article.setAuthors(Arrays.asList(author));
        article.setTags(dtoBlogRequest.getTags());
        article.setTitle(dtoBlogRequest.getTitle());
        return articleRepository.save(article);
    }

}
