package pl.test.testbackend.elasticsearch.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.test.testbackend.elasticsearch.model.Article;
import pl.test.testbackend.elasticsearch.service.ArticleService;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/elasticsearch/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/find/tags")
    public Page<Article> findArticleByTags(@RequestParam String tag, Pageable pageable) {
        return articleService.findArticleByTags(tag, pageable);
    }

    @GetMapping("/find/author/customer/query")
    public Page<Article> findByAuthorsNameUsingCustomQuery(@RequestParam String name, Pageable pageable) {
        return articleService.findByAuthorsNameUsingCustomQuery(name, pageable);
    }

    @GetMapping("/find/filter/tag")
    public Page<Article> findByFilteredTagQuery(@RequestParam String tag, Pageable pageable) {
        return articleService.findByFilteredTagQuery(tag, pageable);
    }

    @GetMapping("/find/author/filter/tag")
    public Page<Article> findByAuthorsNameAndFilteredTagQuery(@RequestParam String name, String tag, Pageable pageable) {
        return articleService.findByAuthorsNameAndFilteredTagQuery(name, tag, pageable);
    }

    @PostMapping("/save")
    public Article saveArticle(@RequestBody Article article) {
        return articleService.save(article);
    }


}
