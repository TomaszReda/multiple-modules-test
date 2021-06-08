package pl.test.testbackend.elasticsearch.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.test.testbackend.elasticsearch.model.Article;
import pl.test.testbackend.elasticsearch.repository.ArticleRepository;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public Page<Article> findByAuthorsName(String name, Pageable pageable) {
        return articleRepository.findByAuthorsName(name, pageable);
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

    public Article save(Article article) {
        return articleRepository.save(article);
    }

}
